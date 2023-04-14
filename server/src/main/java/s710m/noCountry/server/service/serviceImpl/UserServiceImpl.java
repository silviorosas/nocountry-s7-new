package s710m.noCountry.server.service.serviceImpl;

import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import s710m.noCountry.server.mapper.UserMapper;
import s710m.noCountry.server.model.Authority;
import s710m.noCountry.server.model.Client;
import s710m.noCountry.server.model.ServiceProvider;
import s710m.noCountry.server.model.User;
import s710m.noCountry.server.model.dto.LoginClientResponseDto;
import s710m.noCountry.server.model.dto.LoginRequestDto;
import s710m.noCountry.server.model.dto.LoginServiceProviderResponseDto;
import s710m.noCountry.server.model.enums.NameAuthority;
import s710m.noCountry.server.repository.*;
import s710m.noCountry.server.security.filter.JWTService;
import s710m.noCountry.server.service.ReviewService;
import s710m.noCountry.server.service.ServiceCategoryService;
import s710m.noCountry.server.service.UserService;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Locale;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService, UserDetailsService {

    private final UserRepository repository;
    private final AuthorityRepository authorityRepository;
    private final ClientRepository clientRepository;
    private final ServiceProviderRepository serviceProviderRepository;
    private final ServiceCategoryService serviceCategoryService;
    private final AuthenticationManager authenticationManager;
    private final JWTService jwtService;
    private final UserMapper mapper;


    @Override
    public Object login(LoginRequestDto dto) {
        authenticationManager.authenticate( new UsernamePasswordAuthenticationToken(
                        dto.getEmail(),
                        dto.getPassword()
                )
        );
        User user = repository.findByEmail(dto.getEmail()).orElseThrow();
        String authority = user.getAuthorities().stream().map(Authority::getAuthority).collect(Collectors.toList()).get(0);
        if (authority.equals(NameAuthority.ROLE_CLIENT.name())){
            String token = jwtService.generateToken(user);
            return mapper.toClientDto(user, user.getClient(),token);
        }
        String token = jwtService.generateToken(user);
        return mapper.toServiceProviderDto(user,user.getServiceProvider(),token);
    }

    @Override
    public void dataServiceProviderLoad(String fullName, String country, String experienceYears, String kmAround, String profileDescription, Long idCategory, String email, String password) {
        User userServiceProvider = new User(email,password);
        userServiceProvider.getAuthorities().add(authorityRepository.findById(2L).get());
        User savedUserServiceProvider = repository.save(userServiceProvider);
        ServiceProvider serviceProvider = new ServiceProvider(fullName,country, experienceYears, kmAround, profileDescription,savedUserServiceProvider);
        serviceProvider.getServiceCategories().add(serviceCategoryService.getById(idCategory));
        ServiceProvider savedServiceProvider = serviceProviderRepository.save(serviceProvider);
        savedUserServiceProvider.setServiceProvider(savedServiceProvider);
        repository.save(savedUserServiceProvider);
        serviceCategoryService.addServiceProvider(savedServiceProvider,idCategory);
    }

    @Override
    public void dataClientLoad(String fullName, String country, String email, String password) {
        User userClient = new User(email,password);
        userClient.getAuthorities().add(authorityRepository.findById(1L).get());
        User savedUserClient = repository.save(userClient);
        Client client = new Client(fullName,country);
        client.setUser(savedUserClient);
        Client savedClient = clientRepository.save(client);
        savedUserClient.setClient(savedClient);
        repository.save(savedUserClient);
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = repository.findByEmail(email).orElseThrow(() -> new UsernameNotFoundException("User not found."));
        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
        user.getAuthorities().forEach((authority) -> {
            authorities.add(new SimpleGrantedAuthority(authority.getAuthority()));
        });

        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), authorities);
    }
}

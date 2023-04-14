package s710m.noCountry.server.util;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import s710m.noCountry.server.model.Authority;
import s710m.noCountry.server.model.enums.NameAuthority;
import s710m.noCountry.server.repository.AuthorityRepository;
import s710m.noCountry.server.repository.ClientRepository;
import s710m.noCountry.server.repository.ServiceProviderRepository;
import s710m.noCountry.server.repository.UserRepository;
import s710m.noCountry.server.service.UserService;

@Component
@RequiredArgsConstructor
public class UserDataLoader implements CommandLineRunner {

    private final UserRepository userRepository;
    private final AuthorityRepository authorityRepository;
    private final ClientRepository clientRepository;
    private final ServiceProviderRepository serviceProviderRepository;
    private final UserService service;
    private final PasswordEncoder encoder;
    @Override
    public void run(String... args) throws Exception {
        loadRoles();
        loadUserClient();
        loadUserServiceProvider();
    }

    private void loadRoles(){
        if(authorityRepository.findAll().isEmpty()){
            Authority client = new Authority(1L, NameAuthority.ROLE_CLIENT,"");
            Authority serviceProvider = new Authority(2L, NameAuthority.ROLE_SERVICE_PROVIDER,"");
            authorityRepository.save(client);
            authorityRepository.save(serviceProvider);
        }
    }

    @Transactional
    private void loadUserClient(){
        if(clientRepository.findAll().isEmpty()){
            service.dataClientLoad(
                    "Pedro",
                    "Buenos Aires",
                    "usertestclient1@ht.cuak",
                    encoder.encode("1234"));
            service.dataClientLoad(
                    "Martina",
                    "Salta",
                    "usertestclient2@ht.cuak",
                    encoder.encode("1234"));
        }
    }

    @Transactional
    private void loadUserServiceProvider(){
        if(serviceProviderRepository.findAll().isEmpty()){
            service.dataServiceProviderLoad(
                    "Russell",
                    "Buenos Aires",
                    "3",
                    "23",
                    "Hi my name is Russell and I have been an air conditioning technician for over 3 years. " +
                            "I started my career as an apprentice, learning from experienced air conditioning technicians " +
                            "and gradually developing my skills and knowledge.",
                    1L,
                    "usertest1@htm.cuak",
                    encoder.encode("1234")

            );
            service.dataServiceProviderLoad(
                    "Eleanor",
                    "Santa Fe",
                    "10",
                    "50",
                    "Hi my name is Eleanor and I have been an air conditioning technician for over 10 years. " +
                            "I started my career as an apprentice, learning from experienced air conditioning technicians " +
                            "and gradually developing my skills and knowledge.",
                    1L,
                    "usertest2@htm.cuak",
                    encoder.encode("1234")

            );
            service.dataServiceProviderLoad(
                    "Marcos",
                    "Córdoba",
                    "6",
                    "20",
                    "Hi my name is Marcos and I have been a carpenter for over 6 years. " +
                            "I started my career as an apprentice, learning from experienced carpenters " +
                            "and gradually developing my skills and knowledge.",
                    2L,
                    "usertest3@htm.cuak",
                    encoder.encode("1234")

            );
            service.dataServiceProviderLoad(
                    "Morgan",
                    "Mendoza",
                    "4",
                    "10",
                    "Hi my name is Morgan and I have been a carpenter for over 4 years. " +
                            "I started my career as an apprentice, learning from experienced carpenters " +
                            "and gradually developing my skills and knowledge.",
                    2L,
                    "usertest4@htm.cuak",
                    encoder.encode("1234")

            );
            service.dataServiceProviderLoad(
                    "Simon",
                    "Corrientes",
                    "6",
                    "50",
                    "Hi my name is Simon and I have been a construction worker for over 6 years. " +
                            "I started my career as an apprentice, learning from experienced construction workers " +
                            "and gradually developing my skills and knowledge.",
                    3L,
                    "usertest5@htm.cuak",
                    encoder.encode("1234")

            );
            service.dataServiceProviderLoad(
                    "Aurelia",
                    "Santiado del Estero",
                    "2",
                    "30",
                    "Hi my name is Aurelia and I have been a construction worker for over 2 years. " +
                            "I started my career as an apprentice, learning from experienced construction workers " +
                            "and gradually developing my skills and knowledge.",
                    3L,
                    "usertest6@htm.cuak",
                    encoder.encode("1234")

            );
            service.dataServiceProviderLoad(
                    "Laurel",
                    "San Luis",
                    "4",
                    "45",
                    "Hi my name is Laurel and I have been a worker for over 4 years. " +
                            "I started my career as an apprentice, learning from experienced workers " +
                            "and gradually developing my skills and knowledge.",
                    4L,
                    "usertest7@htm.cuak",
                    encoder.encode("1234")

            );
            service.dataServiceProviderLoad(
                    "Benedict",
                    "Catamarca",
                    "8",
                    "15",
                    "Hi my name is Benedict and I have been a worker for over 8 years. " +
                            "I started my career as an apprentice, learning from experienced workers " +
                            "and gradually developing my skills and knowledge.",
                    4L,
                    "usertest8@htm.cuak",
                    encoder.encode("1234")

            );
            service.dataServiceProviderLoad(
                    "Russell",
                    "Buenos Aires",
                    "3",
                    "23",
                    "Hi my name is Russell and I have been an elderly caregiver for over 3 years. " +
                            "I started my career as an apprentice, learning from experienced elderly caregivers " +
                            "and gradually developing my skills and knowledge.",
                    5L,
                    "usertest1@htm.cuak",
                    encoder.encode("1234")

            );
            service.dataServiceProviderLoad(
                    "Eleanor",
                    "Misiones",
                    "10",
                    "50",
                    "Hi my name is Eleanor and I have been an elderly caregiver for over 10 years. " +
                            "I started my career as an apprentice, learning from experienced elderly caregivers " +
                            "and gradually developing my skills and knowledge.",
                    5L,
                    "usertest2@htm.cuak",
                    encoder.encode("1234")

            );
            service.dataServiceProviderLoad(
                    "Marcos",
                    "San Juan",
                    "6",
                    "20",
                    "Hi my name is Marcos and I have been an electrician for over 6 years. " +
                            "I started my career as an apprentice, learning from experienced electricians " +
                            "and gradually developing my skills and knowledge.",
                    6L,
                    "usertest3@htm.cuak",
                    encoder.encode("1234")

            );
            service.dataServiceProviderLoad(
                    "Morgan",
                    "Tucumán",
                    "2",
                    "10",
                    "Hi my name is Morgan and I have been an electrician for over 2 years. " +
                            "I started my career as an apprentice, learning from experienced electricians " +
                            "and gradually developing my skills and knowledge.",
                    6L,
                    "usertest4@htm.cuak",
                    encoder.encode("1234")

            );
            service.dataServiceProviderLoad(
                    "Simon",
                    "Corrientes",
                    "6",
                    "50",
                    "Hi my name is Simon and I have been a floor worker for over 6 years. " +
                            "I started my career as an apprentice, learning from experienced floor workers " +
                            "and gradually developing my skills and knowledge.",
                    7L,
                    "usertest5@htm.cuak",
                    encoder.encode("1234")

            );
            service.dataServiceProviderLoad(
                    "Aurelia",
                    "Buenos Aires",
                    "2",
                    "30",
                    "Hi my name is Aurelia and I have been a floor worker for over 2 years. " +
                            "I started my career as an apprentice, learning from experienced floor workers " +
                            "and gradually developing my skills and knowledge.",
                    7L,
                    "usertest6@htm.cuak",
                    encoder.encode("1234")

            );
            service.dataServiceProviderLoad(
                    "Laurel",
                    "Entre Ríos",
                    "4",
                    "45",
                    "Hi my name is Laurel and I have been a glazier for over 4 years. " +
                            "I started my career as an apprentice, learning from experienced glaziers " +
                            "and gradually developing my skills and knowledge.",
                    8L,
                    "usertest7@htm.cuak",
                    encoder.encode("1234")

            );
            service.dataServiceProviderLoad(
                    "Benedict",
                    "San Juan",
                    "2",
                    "15",
                    "Hi my name is Benedict and I have been a glazier for over 2 years. " +
                            "I started my career as an apprentice, learning from experienced glaziers " +
                            "and gradually developing my skills and knowledge.",
                    8L,
                    "usertest8@htm.cuak",
                    encoder.encode("1234")

            );
            service.dataServiceProviderLoad(
                    "Russell",
                    "Neuquén",
                    "3",
                    "23",
                    "Hi my name is Russell and I have been a heater repairman for over 3 years. " +
                            "I started my career as an apprentice, learning from experienced heater repairmen " +
                            "and gradually developing my skills and knowledge.",
                    9L,
                    "usertest1@htm.cuak",
                    encoder.encode("1234")

            );
            service.dataServiceProviderLoad(
                    "Eleanor",
                    "San Luis",
                    "5",
                    "50",
                    "Hi my name is Eleanor and I have been a heater repairman for over 5 years. " +
                            "I started my career as an apprentice, learning from experienced heater repairmen " +
                            "and gradually developing my skills and knowledge.",
                    9L,
                    "usertest2@htm.cuak",
                    encoder.encode("1234")

            );
            service.dataServiceProviderLoad(
                    "Marcos",
                    "Córdoba",
                    "6",
                    "20",
                    "Hi my name is Marcos and I have been a home repairman for over 6 years. " +
                            "I started my career as an apprentice, learning from experienced home repairmen " +
                            "and gradually developing my skills and knowledge.",
                    10L,
                    "usertest3@htm.cuak",
                    encoder.encode("1234")

            );
            service.dataServiceProviderLoad(
                    "Morgan",
                    "Santa Cruz",
                    "3",
                    "10",
                    "Hi my name is Morgan and I have been a home repairman for over 3 years. " +
                            "I started my career as an apprentice, learning from experienced home repairmen " +
                            "and gradually developing my skills and knowledge.",
                    10L,
                    "usertest4@htm.cuak",
                    encoder.encode("1234")

            );
            service.dataServiceProviderLoad(
                    "Simon",
                    "Corrientes",
                    "6",
                    "50",
                    "Hi my name is Simon and I have been a worker for over 6 years. " +
                            "I started my career as an apprentice, learning from experienced workers " +
                            "and gradually developing my skills and knowledge.",
                    11L,
                    "usertest5@htm.cuak",
                    encoder.encode("1234")

            );
            service.dataServiceProviderLoad(
                    "Aurelia",
                    "Buenos Aires",
                    "2",
                    "30",
                    "Hi my name is Aurelia and I have been a worker for over 2 years. " +
                            "I started my career as an apprentice, learning from experienced workers " +
                            "and gradually developing my skills and knowledge.",
                    11L,
                    "usertest6@htm.cuak",
                    encoder.encode("1234")

            );
            service.dataServiceProviderLoad(
                    "Laurel",
                    "Misiones",
                    "4",
                    "45",
                    "Hi my name is Laurel and I have been a nanny for over 4 years. " +
                            "I started my career as an apprentice, learning from experienced nannies " +
                            "and gradually developing my skills and knowledge.",
                    12L,
                    "usertest7@htm.cuak",
                    encoder.encode("1234")

            );
            service.dataServiceProviderLoad(
                    "Benedict",
                    "San Juan",
                    "2",
                    "15",
                    "Hi my name is Benedict and I have been a nanny for over 2 years. " +
                            "I started my career as an apprentice, learning from experienced nannies " +
                            "and gradually developing my skills and knowledge.",
                    12L,
                    "usertest8@htm.cuak",
                    encoder.encode("1234")

            );
            service.dataServiceProviderLoad(
                    "Russell",
                    "La Rioja",
                    "3",
                    "23",
                    "Hi my name is Russell and I have been a painter for over 3 years. " +
                            "I started my career as an apprentice, learning from experienced painters " +
                            "and gradually developing my skills and knowledge.",
                    13L,
                    "usertest1@htm.cuak",
                    encoder.encode("1234")

            );
            service.dataServiceProviderLoad(
                    "Eleanor",
                    "San Luis",
                    "10",
                    "50",
                    "Hi my name is Eleanor and I have been a painter for over 10 years. " +
                            "I started my career as an apprentice, learning from experienced painters " +
                            "and gradually developing my skills and knowledge.",
                    13L,
                    "usertest2@htm.cuak",
                    encoder.encode("1234")

            );
            service.dataServiceProviderLoad(
                    "Marcos",
                    "Córdoba",
                    "6",
                    "20",
                    "Hi my name is Marcos and I have been a plumber for over 6 years. " +
                            "I started my career as an apprentice, learning from experienced plumbers " +
                            "and gradually developing my skills and knowledge.",
                    14L,
                    "usertest3@htm.cuak",
                    encoder.encode("1234")

            );
            service.dataServiceProviderLoad(
                    "Morgan",
                    "Santa Cruz",
                    "10",
                    "10",
                    "Hi my name is Morgan and I have been a plumber for over 10 years. " +
                            "I started my career as an apprentice, learning from experienced plumbers " +
                            "and gradually developing my skills and knowledge.",
                    14L,
                    "usertest4@htm.cuak",
                    encoder.encode("1234")

            );
            service.dataServiceProviderLoad(
                    "Simon",
                    "Salta",
                    "6",
                    "50",
                    "Hi my name is Simon and I have been a tiler for over 6 years. " +
                            "I started my career as an apprentice, learning from experienced tilers " +
                            "and gradually developing my skills and knowledge.",
                    15L,
                    "usertest5@htm.cuak",
                    encoder.encode("1234")

            );
            service.dataServiceProviderLoad(
                    "Aurelia",
                    "Buenos Aires",
                    "2",
                    "30",
                    "Hi my name is Aurelia and I have been a tiler for over 2 years. " +
                            "I started my career as an apprentice, learning from experienced tilers " +
                            "and gradually developing my skills and knowledge.",
                    15L,
                    "usertest6@htm.cuak",
                    encoder.encode("1234")

            );
            service.dataServiceProviderLoad(
                    "Laurel",
                    "Salta",
                    "4",
                    "45",
                    "Hi my name is Laurel and I have been a wall covering for over 4 years. " +
                            "I started my career as an apprentice, learning from experienced wall coverings " +
                            "and gradually developing my skills and knowledge.",
                    16L,
                    "usertest7@htm.cuak",
                    encoder.encode("1234")

            );
            service.dataServiceProviderLoad(
                    "Benedict",
                    "San Juan",
                    "2",
                    "15",
                    "Hi my name is Benedict and I have been a wall covering for over 2 years. " +
                            "I started my career as an apprentice, learning from experienced wall coverings " +
                            "and gradually developing my skills and knowledge.",
                    16L,
                    "usertest8@htm.cuak",
                    encoder.encode("1234")

            );
            service.dataServiceProviderLoad(
                    "Russell",
                    "La Pampa",
                    "3",
                    "23",
                    "Hi my name is Russell and I have been a wallpaper worker for over 3 years. " +
                            "I started my career as an apprentice, learning from experienced wallpaper workers " +
                            "and gradually developing my skills and knowledge.",
                    17L,
                    "usertest1@htm.cuak",
                    encoder.encode("1234")

            );
            service.dataServiceProviderLoad(
                    "Eleanor",
                    "La Rioja",
                    "2",
                    "50",
                    "Hi my name is Eleanor and I have been a wallpaper worker for over 2 years. " +
                            "I started my career as an apprentice, learning from experienced wallpaper workers " +
                            "and gradually developing my skills and knowledge.",
                    17L,
                    "usertest2@htm.cuak",
                    encoder.encode("1234")

            );
            service.dataServiceProviderLoad(
                    "Marcos",
                    "Córdoba",
                    "6",
                    "20",
                    "Hi my name is Marcos and I have been a washer technician for over 6 years. " +
                            "I started my career as an apprentice, learning from experienced washer technicians " +
                            "and gradually developing my skills and knowledge.",
                    18L,
                    "usertest3@htm.cuak",
                    encoder.encode("1234")

            );
            service.dataServiceProviderLoad(
                    "Morgan",
                    "Rio Negro",
                    "10",
                    "10",
                    "Hi my name is Morgan and I have been a washer technician for over 10 years. " +
                            "I started my career as an apprentice, learning from experienced washer technicians " +
                            "and gradually developing my skills and knowledge.",
                    18L,
                    "usertest4@htm.cuak",
                    encoder.encode("1234")

            );
        }
    }

}

package s710m.noCountry.server.service.serviceImpl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import s710m.noCountry.server.configException.EntityNotFoundException;
import s710m.noCountry.server.mapper.ServiceProviderMapper;
import s710m.noCountry.server.model.ServiceProvider;
import s710m.noCountry.server.model.dto.ServiceProviderDetailsDto;
import s710m.noCountry.server.repository.ServiceProviderRepository;
import s710m.noCountry.server.service.ReviewService;
import s710m.noCountry.server.service.ServiceProviderService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ServiceProviderServiceImpl implements ServiceProviderService {

    private final ServiceProviderRepository repository;
    private final ServiceProviderMapper mapper;
    private final ReviewService reviewService;

    @Override
    public ServiceProvider getById(Long id) {
        return repository.findById(id).orElseThrow( () ->
                new EntityNotFoundException("Service Provider not found.")
        );
    }

    @Override
    public ServiceProviderDetailsDto getDetails(Long id) {
        ServiceProviderDetailsDto dto = mapper.toDetailDto(getById(id));
        dto.setReviews(reviewService.getAllReviewsByServiceProvider(id));
        return dto;
    }

    @Override
    public List<ServiceProvider> getAllServiceProviders() {
        return repository.findAll();
    }
}

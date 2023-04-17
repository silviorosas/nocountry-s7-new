package s710m.noCountry.server.service;

import s710m.noCountry.server.model.ServiceProvider;
import s710m.noCountry.server.model.dto.ServiceProviderDetailsDto;

import java.util.List;

public interface ServiceProviderService {

    ServiceProvider getById(Long id);
    ServiceProviderDetailsDto getDetails(Long id);
    List<ServiceProvider> getAllServiceProviders();
}

package s710m.noCountry.server.mapper;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import s710m.noCountry.server.model.ServiceProvider;
import s710m.noCountry.server.model.dto.ServiceProviderResponseDto;

import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class ServiceProviderMapper {

    private final ServiceCategoryMapper mapper;

    public ServiceProviderResponseDto toDto(ServiceProvider serviceProvider){
        ServiceProviderResponseDto dto = new ServiceProviderResponseDto();
        dto.setIdUser(serviceProvider.getUser().getId());
        dto.setEmail(serviceProvider.getUser().getUsername());
        dto.setFullName(serviceProvider.getFullName());
        dto.setCountry(serviceProvider.getCountry());
        dto.setExperienceYears(serviceProvider.getExperienceYears());
        dto.setProfileDescription(serviceProvider.getProfileDescription());
        dto.setScore(serviceProvider.getScore());
        dto.setCategories(serviceProvider.getServiceCategories()
                .stream()
                .map(mapper::toDto)
                .collect(Collectors.toList()));
        dto.setProfilePhoto(serviceProvider.getProfilePhoto());
        return dto;
    }

}

package s710m.noCountry.server.mapper;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import s710m.noCountry.server.configException.EntityNotFoundException;
import s710m.noCountry.server.model.Review;
import s710m.noCountry.server.model.dto.ReviewRequestDto;
import s710m.noCountry.server.model.dto.ReviewResponseDto;
import s710m.noCountry.server.model.dto.ReviewResponseProfileDto;
import s710m.noCountry.server.model.dto.ReviewUpdateDto;
import s710m.noCountry.server.repository.ClientRepository;
import s710m.noCountry.server.repository.ReviewRepository;
import s710m.noCountry.server.repository.ServiceProviderRepository;

import java.util.Objects;

@Component
@RequiredArgsConstructor
public class ReviewMapper {

    private final ClientRepository clientRepository;
    private final ServiceProviderRepository serviceProviderRepository;
    private final ReviewRepository reviewRepository;

    public Review toEntity(ReviewRequestDto dto){
        Review review = new Review();
        review.setComment(dto.getComment());
        review.setRating(dto.getRating());
        review.setClient(clientRepository
                .findById(dto.getIdClient())
                .orElseThrow( () -> new EntityNotFoundException("Client not found.")));
        review.setServiceProvider(serviceProviderRepository
                .findById(dto.getIdServiceProvider())
                .orElseThrow( () -> new EntityNotFoundException("Service Provider not found.")));
        return review;
    }

    public ReviewResponseDto toDto(Review review){
        ReviewResponseDto dto = new ReviewResponseDto();
        dto.setId(review.getId());
        dto.setComment(review.getComment());
        dto.setRating(review.getRating());
        return dto;
    }

    public Review toUpdate(ReviewUpdateDto dto, Long id){
        Review review = reviewRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Review not found"));
        if(!Objects.isNull(dto.getComment()) && !dto.getComment().isEmpty())
            review.setComment(dto.getComment());
        if(!Objects.isNull(dto.getRating()) && dto.getRating()!=0.0)
            review.setRating(dto.getRating());
        return review;
    }

    public ReviewResponseProfileDto toDtoProfile(Review review){
        ReviewResponseProfileDto dto = new ReviewResponseProfileDto();
        dto.setComment(review.getComment());
        dto.setRating(review.getRating());
        dto.setNameClient(review.getClient().getFullName());
        dto.setCreationDate(review.getCreationDate());
        return dto;
    }

}

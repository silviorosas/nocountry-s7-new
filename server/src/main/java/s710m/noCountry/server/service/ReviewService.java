package s710m.noCountry.server.service;

import s710m.noCountry.server.model.Review;
import s710m.noCountry.server.model.ServiceProvider;
import s710m.noCountry.server.model.dto.ReviewRequestDto;
import s710m.noCountry.server.model.dto.ReviewResponseDto;
import s710m.noCountry.server.model.dto.ReviewResponseProfileDto;
import s710m.noCountry.server.model.dto.ReviewUpdateDto;

import java.util.List;

public interface ReviewService {

    ReviewResponseDto addReview(ReviewRequestDto dto);
    void addRatingProm(ServiceProvider serviceProvider);
    ReviewResponseDto updateReview(ReviewUpdateDto dto, Long id);
    Review getById(Long id);
    List<ReviewResponseProfileDto> getAllReviewsByServiceProvider(Long id);
    ReviewResponseDto getByIdDto(Long id);
    void deleteReview (Long id);

}

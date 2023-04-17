package s710m.noCountry.server.service.serviceImpl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import s710m.noCountry.server.configException.EntityNotFoundException;
import s710m.noCountry.server.configException.ForbiddenException;
import s710m.noCountry.server.mapper.ReviewMapper;
import s710m.noCountry.server.model.Review;
import s710m.noCountry.server.model.ServiceProvider;
import s710m.noCountry.server.model.User;
import s710m.noCountry.server.model.dto.ReviewRequestDto;
import s710m.noCountry.server.model.dto.ReviewResponseDto;
import s710m.noCountry.server.model.dto.ReviewResponseProfileDto;
import s710m.noCountry.server.model.dto.ReviewUpdateDto;
import s710m.noCountry.server.repository.ClientRepository;
import s710m.noCountry.server.repository.ReviewRepository;
import s710m.noCountry.server.repository.ServiceProviderRepository;
import s710m.noCountry.server.service.ReviewService;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ReviewServiceImpl implements ReviewService {

    private final ReviewRepository repository;
    private final ServiceProviderRepository serviceProviderRepository;
    private final ReviewMapper mapper;


    @Override
    @Transactional
    public ReviewResponseDto addReview(ReviewRequestDto dto, User loggedUser) {
        Review review = mapper.toEntity(dto);
        if(!loggedUser.getUsername().equals(review.getClient().getUser().getUsername()))
            throw new ForbiddenException("You do not have authorization");
        Review savedReview = repository.save(review);
        addRatingProm(review.getServiceProvider());
        serviceProviderRepository.save(review.getServiceProvider());
        return mapper.toDto(savedReview);
    }

    @Override
    @Transactional
    public void reviewDataLoad(ReviewRequestDto dto) {
        Review review = repository.save(mapper.toEntity(dto));
        addRatingProm(review.getServiceProvider());
        serviceProviderRepository.save(review.getServiceProvider());
    }

    @Override
    public void addRatingProm(ServiceProvider serviceProvider) {
        List<Double> ratings = serviceProvider.getReviews().stream().map(Review::getRating).collect(Collectors.toList());
        Integer totalReviews = ratings.size();
        Double plusRatings = ratings.stream().mapToDouble(p -> p.doubleValue()).sum();
        serviceProvider.setScore(plusRatings/totalReviews);
    }

    @Override
    public ReviewResponseDto updateReview(ReviewUpdateDto dto, Long id, User loggedUser) {
        Review review = mapper.toUpdate(dto, id);
        if(!loggedUser.getUsername().equals(review.getClient().getUser().getUsername()))
            throw new ForbiddenException("You do not have authorization");
        return mapper.toDto(repository.save(review));
    }

    @Override
    public Review getById(Long id) {
        return repository.findById(id).orElseThrow( () -> new EntityNotFoundException("Review not found."));
    }

    @Override
    public List<ReviewResponseProfileDto> getAllReviewsByServiceProvider(Long id) {
        ServiceProvider serviceProvider = serviceProviderRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Service Provider not found."));
        return serviceProvider.getReviews()
                .stream()
                .map(mapper::toDtoProfile)
                .collect(Collectors.toList());
    }

    @Override
    public List<Review> getAllReviews() {
        return repository.findAll();
    }

    @Override
    public ReviewResponseDto getByIdDto(Long id, User loggedUser) {
        Review review = getById(id);
        if(!loggedUser.getUsername().equals(review.getClient().getUser().getUsername()))
            throw new ForbiddenException("You do not have authorization");
        return mapper.toDto(review);
    }

    @Override
    public void deleteReview(Long id, User loggedUser) {
        Review review = getById(id);
        if(!loggedUser.getUsername().equals(review.getClient().getUser().getUsername()))
            throw new ForbiddenException("You do not have authorization");
        repository.deleteById(id);
    }

}

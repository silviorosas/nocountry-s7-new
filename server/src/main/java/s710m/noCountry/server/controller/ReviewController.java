package s710m.noCountry.server.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import s710m.noCountry.server.model.User;
import s710m.noCountry.server.model.dto.ReviewRequestDto;
import s710m.noCountry.server.model.dto.ReviewResponseDto;
import s710m.noCountry.server.model.dto.ReviewResponseProfileDto;
import s710m.noCountry.server.model.dto.ReviewUpdateDto;
import s710m.noCountry.server.service.ReviewService;

import java.util.List;

import static org.springframework.http.HttpStatus.*;

@RestController
@RequestMapping("api/review")
@RequiredArgsConstructor
public class ReviewController {

    private final ReviewService service;

    @PostMapping
    public ResponseEntity<ReviewResponseDto> addReview(@RequestBody ReviewRequestDto dto, @AuthenticationPrincipal User user){
        return ResponseEntity.status(CREATED).body(service.addReview(dto, user));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<ReviewResponseDto> updateReview(@PathVariable Long id, @RequestBody ReviewUpdateDto dto, @AuthenticationPrincipal User user){
        return ResponseEntity.status(OK).body(service.updateReview(dto, id, user));
    }

    @GetMapping("/service-provider/{id}")
    public ResponseEntity<List<ReviewResponseProfileDto>> getAllReviewsByIdServiceProvider(@PathVariable Long id){
        return ResponseEntity.status(OK).body(service.getAllReviewsByServiceProvider(id));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReviewResponseDto> getById(@PathVariable Long id, @AuthenticationPrincipal User user){
        return ResponseEntity.status(OK).body(service.getByIdDto(id, user));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id, @AuthenticationPrincipal User user){
        return ResponseEntity.status(OK).build();
    }
}

package s710m.noCountry.server.util;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import s710m.noCountry.server.model.dto.ReviewRequestDto;
import s710m.noCountry.server.service.ReviewService;

@Component
@RequiredArgsConstructor
public class UserReviewDataLoader implements CommandLineRunner {

    private final ReviewService service;
    private static String comment1 = "I highly recommend this service. They are knowledgeable, " +
            "trustworthy and provide excellent customer service. " +
            "I will definitely contact them again in the future.";
    private static String comment2 = "They were polite, professional, " +
            "and took the time to listen to my concerns and explain what needed to be done. " +
            "They were able to quickly diagnose the problem and provide me with a quote, which was very reasonable.";

    @Override
    public void run(String... args) throws Exception {
        dataLoad();
    }

    private void dataLoad(){
        if(service.getAllReviews().isEmpty()){
            service.reviewDataLoad(
                    new ReviewRequestDto(
                            comment1,
                            4.5,
                            1L,
                            1L));
            service.reviewDataLoad(
                    new ReviewRequestDto(
                            comment2,
                            4.0,
                            2L,
                            1L));
            service.reviewDataLoad(
                    new ReviewRequestDto(
                            comment1,
                            5.0,
                            1L,
                            2L));
            service.reviewDataLoad(
                    new ReviewRequestDto(
                            comment2,
                            4.5,
                            2L,
                            2L));
            service.reviewDataLoad(
                    new ReviewRequestDto(
                            comment1,
                            4.5,
                            1L,
                            3L));
            service.reviewDataLoad(
                    new ReviewRequestDto(
                            comment2,
                            3.5,
                            2L,
                            3L));
            service.reviewDataLoad(
                    new ReviewRequestDto(
                            comment1,
                            4.0,
                            1L,
                            4L));
            service.reviewDataLoad(
                    new ReviewRequestDto(
                            comment2,
                            3.0,
                            2L,
                            4L));
            service.reviewDataLoad(
                    new ReviewRequestDto(
                            comment1,
                            4.5,
                            1L,
                            5L));
            service.reviewDataLoad(
                    new ReviewRequestDto(
                            comment2,
                            4.5,
                            2L,
                            5L));
            service.reviewDataLoad(
                    new ReviewRequestDto(
                            comment1,
                            4.5,
                            1L,
                            6L));
            service.reviewDataLoad(
                    new ReviewRequestDto(
                            comment2,
                            5.0,
                            2L,
                            6L));
            service.reviewDataLoad(
                    new ReviewRequestDto(
                            comment1,
                            4.5,
                            1L,
                            7L));
            service.reviewDataLoad(
                    new ReviewRequestDto(
                            comment2,
                            4.0,
                            2L,
                            7L));
            service.reviewDataLoad(
                    new ReviewRequestDto(
                            comment1,
                            3.5,
                            1L,
                            8L));
            service.reviewDataLoad(
                    new ReviewRequestDto(
                            comment2,
                            4.0,
                            2L,
                            8L));
            service.reviewDataLoad(
                    new ReviewRequestDto(
                            comment1,
                            5.0,
                            1L,
                            9L));
            service.reviewDataLoad(
                    new ReviewRequestDto(
                            comment2,
                            4.5,
                            2L,
                            9L));
            service.reviewDataLoad(
                    new ReviewRequestDto(
                            comment1,
                            4.5,
                            1L,
                            10L));
            service.reviewDataLoad(
                    new ReviewRequestDto(
                            comment2,
                            4.0,
                            2L,
                            10L));
            service.reviewDataLoad(
                    new ReviewRequestDto(
                            comment1,
                            3.5,
                            1L,
                            11L));
            service.reviewDataLoad(
                    new ReviewRequestDto(
                            comment2,
                            3.0,
                            2L,
                            11L));
            service.reviewDataLoad(
                    new ReviewRequestDto(
                            comment1,
                            4.5,
                            1L,
                            12L));
            service.reviewDataLoad(
                    new ReviewRequestDto(
                            comment2,
                            5.0,
                            2L,
                            12L));
            service.reviewDataLoad(
                    new ReviewRequestDto(
                            comment1,
                            4.0,
                            1L,
                            13L));
            service.reviewDataLoad(
                    new ReviewRequestDto(
                            comment2,
                            4.5,
                            2L,
                            13L));
            service.reviewDataLoad(
                    new ReviewRequestDto(
                            comment1,
                            3.5,
                            1L,
                            14L));
            service.reviewDataLoad(
                    new ReviewRequestDto(
                            comment2,
                            4.5,
                            2L,
                            14L));
            service.reviewDataLoad(
                    new ReviewRequestDto(
                            comment1,
                            4.0,
                            1L,
                            15L));
            service.reviewDataLoad(
                    new ReviewRequestDto(
                            comment2,
                            4.0,
                            2L,
                            15L));
            service.reviewDataLoad(
                    new ReviewRequestDto(
                            comment1,
                            4.0,
                            1L,
                            16L));
            service.reviewDataLoad(
                    new ReviewRequestDto(
                            comment2,
                            4.5,
                            2L,
                            16L));
            service.reviewDataLoad(
                    new ReviewRequestDto(
                            comment1,
                            5.0,
                            1L,
                            17L));
            service.reviewDataLoad(
                    new ReviewRequestDto(
                            comment2,
                            3.5,
                            2L,
                            17L));
            service.reviewDataLoad(
                    new ReviewRequestDto(
                            comment1,
                            5.0,
                            1L,
                            18L));
            service.reviewDataLoad(
                    new ReviewRequestDto(
                            comment2,
                            4.5,
                            2L,
                            18L));
            service.reviewDataLoad(
                    new ReviewRequestDto(
                            comment1,
                            4.5,
                            1L,
                            19L));
            service.reviewDataLoad(
                    new ReviewRequestDto(
                            comment2,
                            4.0,
                            2L,
                            19L));
            service.reviewDataLoad(
                    new ReviewRequestDto(
                            comment1,
                            5.0,
                            1L,
                            20L));
            service.reviewDataLoad(
                    new ReviewRequestDto(
                            comment2,
                            4.5,
                            2L,
                            20L));
            service.reviewDataLoad(
                    new ReviewRequestDto(
                            comment1,
                            4.5,
                            1L,
                            21L));
            service.reviewDataLoad(
                    new ReviewRequestDto(
                            comment2,
                            3.5,
                            2L,
                            21L));
            service.reviewDataLoad(
                    new ReviewRequestDto(
                            comment1,
                            4.0,
                            1L,
                            22L));
            service.reviewDataLoad(
                    new ReviewRequestDto(
                            comment2,
                            3.0,
                            2L,
                            22L));
            service.reviewDataLoad(
                    new ReviewRequestDto(
                            comment1,
                            4.5,
                            1L,
                            23L));
            service.reviewDataLoad(
                    new ReviewRequestDto(
                            comment2,
                            4.5,
                            2L,
                            23L));
            service.reviewDataLoad(
                    new ReviewRequestDto(
                            comment1,
                            4.5,
                            1L,
                            24L));
            service.reviewDataLoad(
                    new ReviewRequestDto(
                            comment2,
                            5.0,
                            2L,
                            24L));
            service.reviewDataLoad(
                    new ReviewRequestDto(
                            comment1,
                            4.5,
                            1L,
                            25L));
            service.reviewDataLoad(
                    new ReviewRequestDto(
                            comment2,
                            4.0,
                            2L,
                            25L));
            service.reviewDataLoad(
                    new ReviewRequestDto(
                            comment1,
                            3.5,
                            1L,
                            26L));
            service.reviewDataLoad(
                    new ReviewRequestDto(
                            comment2,
                            4.0,
                            2L,
                            26L));
            service.reviewDataLoad(
                    new ReviewRequestDto(
                            comment1,
                            5.0,
                            1L,
                            27L));
            service.reviewDataLoad(
                    new ReviewRequestDto(
                            comment2,
                            4.5,
                            2L,
                            27L));
            service.reviewDataLoad(
                    new ReviewRequestDto(
                            comment1,
                            4.5,
                            1L,
                            28L));
            service.reviewDataLoad(
                    new ReviewRequestDto(
                            comment2,
                            4.0,
                            2L,
                            28L));
            service.reviewDataLoad(
                    new ReviewRequestDto(
                            comment1,
                            3.5,
                            1L,
                            29L));
            service.reviewDataLoad(
                    new ReviewRequestDto(
                            comment2,
                            3.0,
                            2L,
                            29L));
            service.reviewDataLoad(
                    new ReviewRequestDto(
                            comment1,
                            4.5,
                            1L,
                            30L));
            service.reviewDataLoad(
                    new ReviewRequestDto(
                            comment2,
                            5.0,
                            2L,
                            30L));
            service.reviewDataLoad(
                    new ReviewRequestDto(
                            comment1,
                            4.0,
                            1L,
                            31L));
            service.reviewDataLoad(
                    new ReviewRequestDto(
                            comment2,
                            4.5,
                            2L,
                            31L));
            service.reviewDataLoad(
                    new ReviewRequestDto(
                            comment1,
                            3.5,
                            1L,
                            32L));
            service.reviewDataLoad(
                    new ReviewRequestDto(
                            comment2,
                            4.5,
                            2L,
                            32L));
            service.reviewDataLoad(
                    new ReviewRequestDto(
                            comment1,
                            4.0,
                            1L,
                            33L));
            service.reviewDataLoad(
                    new ReviewRequestDto(
                            comment2,
                            4.0,
                            2L,
                            33L));
            service.reviewDataLoad(
                    new ReviewRequestDto(
                            comment1,
                            4.0,
                            1L,
                            34L));
            service.reviewDataLoad(
                    new ReviewRequestDto(
                            comment2,
                            4.5,
                            2L,
                            34L));
            service.reviewDataLoad(
                    new ReviewRequestDto(
                            comment1,
                            5.0,
                            1L,
                            35L));
            service.reviewDataLoad(
                    new ReviewRequestDto(
                            comment2,
                            3.5,
                            2L,
                            35L));
            service.reviewDataLoad(
                    new ReviewRequestDto(
                            comment1,
                            5.0,
                            1L,
                            36L));
            service.reviewDataLoad(
                    new ReviewRequestDto(
                            comment2,
                            4.5,
                            2L,
                            36L));

        }
    }
}

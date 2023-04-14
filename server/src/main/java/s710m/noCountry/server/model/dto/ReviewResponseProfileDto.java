package s710m.noCountry.server.model.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ReviewResponseProfileDto {
    private String comment;
    private Double rating;
    private String nameClient;
    @JsonFormat(pattern="yyyy-MM-dd")
    private LocalDateTime creationDate;
}

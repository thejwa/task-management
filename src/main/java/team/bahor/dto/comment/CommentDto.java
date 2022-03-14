package team.bahor.dto.comment;

import lombok.Getter;
import lombok.Setter;
import team.bahor.dto.GenericDto;

import javax.persistence.Column;
import java.time.LocalDateTime;

@Setter
@Getter
public class CommentDto extends GenericDto {
    private String title;

    private Long createdBy;

    private LocalDateTime createdAt;

    private String userName;
}

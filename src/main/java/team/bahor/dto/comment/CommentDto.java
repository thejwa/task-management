package team.bahor.dto.comment;

import lombok.Getter;
import lombok.Setter;
import team.bahor.dto.GenericDto;

import javax.persistence.Column;
@Setter
@Getter
public class CommentDto extends GenericDto {
    private String title;

    private Long createdBy;

}

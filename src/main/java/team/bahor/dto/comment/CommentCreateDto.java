package team.bahor.dto.comment;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import team.bahor.dto.BaseGenericDto;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CommentCreateDto implements BaseGenericDto {
    private String title;

    private Long taskId;

    private Long createdBy;
}

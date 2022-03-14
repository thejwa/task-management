package team.bahor.dto.comment;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import team.bahor.dto.GenericDto;
@Getter
@Setter
public class CommentUpdateDto extends GenericDto {
    private String title;
    @Builder(builderMethodName = "childBuilder")
    public CommentUpdateDto(Long id, String title) {
        super(id);
        this.title = title;
    }
}

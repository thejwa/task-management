package team.bahor.dto.action;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import team.bahor.dto.GenericDto;

@Getter
@Setter
public class ActionUpdateDto extends GenericDto {
    private String title;
    @Builder(builderMethodName = "childBuilder")
    public ActionUpdateDto(Long id, String title) {
        super(id);
        this.title = title;
    }
}

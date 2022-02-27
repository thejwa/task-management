package team.bahor.dto.action;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import team.bahor.dto.GenericDto;

@Getter
@Setter
public class ActionDto extends GenericDto {
    private String title;

    private Long taskId;
    @Builder(builderMethodName = "childBuilder")
    public ActionDto(Long id, String title, Long taskId) {
        super(id);
        this.title = title;
        this.taskId = taskId;
    }
}

package team.bahor.dto.task;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import team.bahor.dto.GenericDto;
@Getter
@Setter
public class TaskMemberUpdateDto extends GenericDto {
    private Long userId;

    private Long taskId;

    private Integer status;
    @Builder(builderMethodName = "childBuilder")
    public TaskMemberUpdateDto(Long id, Long userId, Long taskId, Integer status) {
        super(id);
        this.userId = userId;
        this.taskId = taskId;
        this.status = status;
    }
}

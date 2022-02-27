package team.bahor.dto.task;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import team.bahor.dto.GenericDto;

@Setter
@Getter
@NoArgsConstructor
public class TaskMemberDto extends GenericDto {
    private String username;

    private Long taskId;

    private Integer status;

    @Builder(builderMethodName = "childBuilder")
    public TaskMemberDto(Long id, String username, Long taskId, Integer status) {
        super(id);
        this.username = username;
        this.taskId = taskId;
        this.status = status;
    }
}

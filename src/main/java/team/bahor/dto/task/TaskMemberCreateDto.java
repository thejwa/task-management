package team.bahor.dto.task;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import team.bahor.dto.BaseGenericDto;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class TaskMemberCreateDto implements BaseGenericDto {
    private String username;

    private Long taskId;

    public TaskMemberCreateDto(Long taskId) {
        this.taskId = taskId;
    }
}

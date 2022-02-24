package team.bahor.dto.task;

import lombok.Getter;
import lombok.Setter;
import team.bahor.dto.GenericDto;
import team.bahor.entity.task.TaskComment;
import team.bahor.enums.task.Level;
import team.bahor.enums.task.Priority;

import java.time.LocalDateTime;
import java.util.List;
@Setter
@Getter
public class TaskUpdateDto extends GenericDto {
    private LocalDateTime updatedAt;

    private Long updatedBy;

    private Integer status;

    private String name;

    private String description;

    private Level level;

    private Priority priority;

    private Long taskOrder;


    private Long projectId;
}

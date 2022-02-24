package team.bahor.dto.task;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import team.bahor.dto.BaseGenericDto;
import team.bahor.entity.task.TaskComment;
import team.bahor.enums.task.Level;
import team.bahor.enums.task.Priority;

import java.time.LocalDateTime;
import java.util.List;

@Setter
@Getter
@Builder
public class TaskCreateDto implements BaseGenericDto {

    private Long createdBy;

    private String name;

    private String description;

    private Level level;

    private Priority priority;

    private Long taskOrder;

    public TaskCreateDto(Long createdBy, String name, String description, Level level, Priority priority, Long taskOrder) {
        this.createdBy = createdBy;
        this.name = name;
        this.description = description;
        this.level = level;
        this.priority = priority;
        this.taskOrder = taskOrder;
    }
}

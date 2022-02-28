package team.bahor.dto.task;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import team.bahor.dto.BaseGenericDto;
import team.bahor.enums.task.Level;
import team.bahor.enums.task.Priority;

@Setter
@Getter
@NoArgsConstructor
public class TaskCreateDto implements BaseGenericDto {
    public TaskCreateDto(Long columnId) {
        this.columnId = columnId;
    }

    private Long createdBy;

    private String name;

    private String description;

    private String deadline;

    private Level level;

    private Priority priority;

    private Long taskOrder;

    private Long columnId;

    public TaskCreateDto(Long createdBy, String name, String description, String deadline, Level level, Priority priority, Long taskOrder, Long columnId) {
        this.createdBy = createdBy;
        this.name = name;
        this.description = description;
        this.deadline = deadline;
        this.level = level;
        this.priority = priority;
        this.taskOrder = taskOrder;
        this.columnId = columnId;
    }
}

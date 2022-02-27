package team.bahor.dto.task;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import team.bahor.dto.GenericDto;
import team.bahor.entity.task.TaskComment;
import team.bahor.enums.task.Level;
import team.bahor.enums.task.Priority;

import java.time.LocalDateTime;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
public class TaskUpdateDto extends GenericDto {
    private LocalDateTime updatedAt;

    private Long updatedBy;

    private Integer status;

    private String name;

    private String description;

    private Level level;

    private Priority priority;

    private String deadline;

    private Long taskOrder;

    private Long columnId;

    @Builder(builderMethodName = "childBuilder")
    public TaskUpdateDto(Long id, LocalDateTime updatedAt, Long updatedBy, Integer status, String name, String description, Level level, Priority priority, String deadline, Long taskOrder, Long columnId) {
        super(id);
        this.updatedAt = updatedAt;
        this.updatedBy = updatedBy;
        this.status = status;
        this.name = name;
        this.description = description;
        this.level = level;
        this.priority = priority;
        this.deadline = deadline;
        this.taskOrder = taskOrder;
        this.columnId = columnId;
    }
}

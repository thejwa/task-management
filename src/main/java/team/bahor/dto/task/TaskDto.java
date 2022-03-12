package team.bahor.dto.task;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import team.bahor.dto.GenericDto;
import team.bahor.dto.comment.CommentDto;
import team.bahor.entity.task.Action;
import team.bahor.enums.task.Level;
import team.bahor.enums.task.Priority;

import java.time.LocalDateTime;
import java.util.List;

@Setter
@Getter
public class TaskDto extends GenericDto {

    private String code;

    private LocalDateTime createdAt;

    private Long createdBy;

    private LocalDateTime updatedAt;

    private Long updatedBy;

    private LocalDateTime deadline;

    private Integer status;

    private String name;

    private String description;

    private Level level;

    private Priority priority;

    private Long taskOrder;

    private Long columnId;

    private List<CommentDto> taskComments;

    private Integer commentCount;

    private List<Action> actions;


    @Builder(builderMethodName = "childBuilder")
    public TaskDto(Long id, String code, LocalDateTime createdAt, Long createdBy, LocalDateTime updatedAt, Long updatedBy, LocalDateTime deadline, Integer status, String name, String description, Level level, Priority priority, Long taskOrder, Long columnId) {
        super(id);
        this.code = code;
        this.createdAt = createdAt;
        this.createdBy = createdBy;
        this.updatedAt = updatedAt;
        this.updatedBy = updatedBy;
        this.deadline = deadline;
        this.status = status;
        this.name = name;
        this.description = description;
        this.level = level;
        this.priority = priority;
        this.taskOrder = taskOrder;
        this.columnId = columnId;
    }
}

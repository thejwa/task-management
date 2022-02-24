package team.bahor.dto.task;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import team.bahor.dto.GenericDto;
import team.bahor.entity.project.ProjectColumn;
import team.bahor.entity.task.TaskComment;
import team.bahor.enums.task.Level;
import team.bahor.enums.task.Priority;

import javax.persistence.*;
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

    private Integer status;

    private String name;

    private String description;

    private Level level;

    private Priority priority;

    private Long taskOrder;


    private Long projectId;

    private List<TaskComment> taskComments;

    @Builder(builderMethodName = "childBuilder")
    public TaskDto(Long id, String code, LocalDateTime createdAt, Long createdBy, LocalDateTime updatedAt, Long updatedBy, Integer status, String name, String description, Level level, Priority priority, Long taskOrder, Long projectId, List<TaskComment> taskComments) {
        super(id);
        this.code = code;
        this.createdAt = createdAt;
        this.createdBy = createdBy;
        this.updatedAt = updatedAt;
        this.updatedBy = updatedBy;
        this.status = status;
        this.name = name;
        this.description = description;
        this.level = level;
        this.priority = priority;
        this.taskOrder = taskOrder;
        this.projectId = projectId;
        this.taskComments = taskComments;
    }
}

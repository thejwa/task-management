package team.bahor.entity.task;

import lombok.Getter;
import lombok.Setter;
import team.bahor.entity.Auditable;
import team.bahor.entity.project.ProjectColumn;
import team.bahor.enums.task.Level;
import team.bahor.enums.task.Priority;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "tasks")
public class Task extends Auditable {

    private String name;

    private String description;

    private Level level;

    private Priority priority;

    private LocalDateTime deadline;

    @Column(nullable = false)
    private Integer taskOrder;

    @Column(nullable = false)
    private Long projectColumnId;


}

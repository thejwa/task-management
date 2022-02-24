package team.bahor.entity.task;

import lombok.Getter;
import lombok.Setter;
import team.bahor.entity.Auditable;
import team.bahor.entity.project.ProjectColumn;
import team.bahor.enums.task.Level;
import team.bahor.enums.task.Priority;

import javax.persistence.*;
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

    @javax.persistence.Column(nullable = false)
    private Long taskOrder;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "column_id")
    private ProjectColumn projectColumn;

    @OneToMany(mappedBy = "task",fetch = FetchType.LAZY)
    private List<TaskComment> taskComments;

}

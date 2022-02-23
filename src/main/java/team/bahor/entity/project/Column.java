package team.bahor.entity.project;

import lombok.Getter;
import lombok.Setter;
import team.bahor.entity.Auditable;
import team.bahor.entity.task.Task;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "columns")
public class Column extends Auditable {
    private String name;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "project_id", nullable = false)
    private Project project;

    private Integer order;

    @OneToMany(mappedBy = "column", fetch = FetchType.LAZY)
    private List<Task> tasks;
}

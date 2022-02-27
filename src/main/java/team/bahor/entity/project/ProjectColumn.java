package team.bahor.entity.project;

import lombok.Getter;
import lombok.Setter;
import team.bahor.entity.Auditable;
import team.bahor.entity.project.Project;
import team.bahor.entity.task.Task;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "columns")
public class ProjectColumn extends Auditable {
    private String name;

    @Column(nullable = false)
    private Long projectId;

    private Integer columnOrder;

}

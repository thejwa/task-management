package team.bahor.entity.project;

import lombok.Getter;
import lombok.Setter;
import team.bahor.entity.Auditable;
import team.bahor.entity.organization.Organization;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "projects")
public class Project extends Auditable {
    private String name;

    private LocalDateTime deadline;

    private String description;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "organization_id", referencedColumnName = "id")
    private Organization organization;

    @OneToMany(mappedBy = "project", fetch = FetchType.LAZY)
    private List<ProjectColumn> projectProjectColumns;
}

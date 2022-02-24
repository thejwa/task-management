package team.bahor.entity.organization;

import lombok.Getter;
import lombok.Setter;
import team.bahor.entity.Auditable;
import team.bahor.entity.project.Project;

import javax.persistence.*;
import java.util.List;

@Setter
@Getter
@Entity
@Table(name="organizations")
public class Organization extends Auditable {

    private String name;

    private String website;

    private String logo;

    private String email;

    private String location;

    private Long ownerId;

    @Column(columnDefinition = "integer default 0")
    private Integer memberCount;

    @Column(columnDefinition = "integer default 0")
    private Integer projectCount;

    @OneToMany(mappedBy = "organization", fetch = FetchType.LAZY)
    private List<Project> projects;
}

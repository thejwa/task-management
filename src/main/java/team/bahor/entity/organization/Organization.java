package team.bahor.entity.organization;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import team.bahor.entity.Auditable;
import team.bahor.entity.project.Project;

import javax.persistence.*;
import java.util.List;

@SuperBuilder
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "organizations")
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

}

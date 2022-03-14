package team.bahor.entity.project;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import team.bahor.entity.Auditable;
import team.bahor.entity.organization.Organization;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@SuperBuilder
@NoArgsConstructor
@ToString
@Entity
@Getter
@Setter
@Table(name = "projects")
public class Project extends Auditable {
    @Column(nullable = false)
    private String name;

    private LocalDateTime deadline;

    private String description;

    private String tz;

    @Column(nullable = false)
    private Long organizationId;

}

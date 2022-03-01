package team.bahor.entity.project;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import javax.persistence.Column;

@SuperBuilder
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "project_member")
public class ProjectMember {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @javax.persistence.Column(nullable = false)
    private Long userId;

    @javax.persistence.Column(nullable = false)
    private Long projectId;

    @Column(nullable = false, columnDefinition = "int default 0")
    private Integer status;

    @Column(columnDefinition = "boolean default false")
    private boolean lead;

    @Column(columnDefinition = "boolean default false")
    private boolean deleted;
}

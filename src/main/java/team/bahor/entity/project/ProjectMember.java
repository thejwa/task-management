package team.bahor.entity.project;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.persistence.Column;

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

    @Column(nullable = false,columnDefinition = "int default 0")
    private Integer status;

    private boolean isLead;

    private boolean isDeleted;
}

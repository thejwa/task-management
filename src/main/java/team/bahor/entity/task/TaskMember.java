package team.bahor.entity.task;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "task_member")
public class TaskMember {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long userId;

    @Column(nullable = false)
    private Long taskId;

    @Column(nullable = false,columnDefinition = "int default 0")
    private Integer status;

    private boolean isDeleted;
}

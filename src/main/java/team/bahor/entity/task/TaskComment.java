package team.bahor.entity.task;

import lombok.Getter;
import lombok.Setter;
import team.bahor.entity.Auditable;
import team.bahor.entity.user.User;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "comments")
public class TaskComment extends Auditable {
    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private Long order_comment;

    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "task_id",referencedColumnName = "id")
    private Task task;

    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id",referencedColumnName = "id")
    private User user;


}

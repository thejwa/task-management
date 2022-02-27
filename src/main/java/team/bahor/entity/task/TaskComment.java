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
    private Long taskId;



}

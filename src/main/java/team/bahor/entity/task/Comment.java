package team.bahor.entity.task;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import team.bahor.entity.Auditable;
import team.bahor.entity.user.User;

import javax.persistence.*;

@SuperBuilder
@NoArgsConstructor
@Entity
@Getter
@Setter
@Table(name = "comments")
public class Comment extends Auditable {
    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private Long taskId;


}

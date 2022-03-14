package team.bahor.entity.task;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import team.bahor.entity.Auditable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@SuperBuilder
@NoArgsConstructor
@Entity
@Getter
@Setter
@Table(name = "actions")
public class Action extends Auditable {
    @Column(nullable = false)
    private String title;

    @Column(nullable = true)
    private Long taskId;
}

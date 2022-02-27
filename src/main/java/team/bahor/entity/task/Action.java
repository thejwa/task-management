package team.bahor.entity.task;

import lombok.Getter;
import lombok.Setter;
import team.bahor.entity.Auditable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;


@Entity
@Getter
@Setter
@Table(name = "actions")
public class Action extends Auditable {
    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private Long projectId;
}

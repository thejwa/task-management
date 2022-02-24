package team.bahor.entity.user;


import lombok.Getter;
import lombok.Setter;
import team.bahor.entity.BaseGenericEntity;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "permissions")
public class UserPermission implements BaseGenericEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String code;


}

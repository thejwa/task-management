package team.bahor.entity.user;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import team.bahor.entity.BaseGenericEntity;

import javax.persistence.*;

@SuperBuilder
@NoArgsConstructor
@Entity
@Getter
@Setter
@Table(name = "permissions")
public class UserPermission implements BaseGenericEntity {

    public UserPermission(String name, String code) {
        this.name = name;
        this.code = code;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String code;


//    @ManyToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "role_id")
//    private UserRole role;

}

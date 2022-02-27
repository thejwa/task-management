package team.bahor.entity.user;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import team.bahor.entity.BaseGenericEntity;

import javax.persistence.*;
import java.util.List;

@SuperBuilder
@NoArgsConstructor
@Entity
@Getter
@Setter
@Table(name = "roles")
public class UserRole implements BaseGenericEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String code;

//    @ManyToMany(fetch = FetchType.EAGER)
//    @JoinTable(
//            name = "role_permission",
//            joinColumns = @JoinColumn(name = "role_id"),
//            inverseJoinColumns = @JoinColumn(name = "permission_id")
//    )

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<UserPermission> permissions;


}

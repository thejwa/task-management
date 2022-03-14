package team.bahor.entity.user;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import team.bahor.entity.Auditable;
import team.bahor.entity.organization.Organization;

import javax.persistence.*;

@SuperBuilder
@NoArgsConstructor
@Entity
@Getter
@Setter
@Table(name = "users")
public class User extends Auditable {

    private String firstName;

    private String lastName;

    @Column(unique = true, nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    private boolean blocked;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "role_id", nullable = false)
    private UserRole userRole;

    private String profilePhoto;

    @Column(nullable = false)
    private Long organizationId;


}

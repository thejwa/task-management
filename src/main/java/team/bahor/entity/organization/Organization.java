package team.bahor.entity.organization;

import lombok.Getter;
import lombok.Setter;
import team.bahor.entity.Auditable;

import javax.persistence.Entity;

@Entity
@Setter
@Getter
public class Organization extends Auditable {

    private String name;

    private String website;

    private String logo;

    private String email;

    private String location;

    private Long ownerId;

    private Integer memberCount = 0;

    private Integer projectCount = 0;
}

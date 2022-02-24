package team.bahor.dto.organization;

import lombok.Getter;
import lombok.Setter;
import team.bahor.dto.BaseGenericDto;
import team.bahor.entity.project.Project;

import java.util.List;

@Setter
@Getter
public class OrganizationCreatoDto implements BaseGenericDto {
    private String name;

    private String website;

    private String logo;

    private String email;

    private String location;

    private Long ownerId;

}

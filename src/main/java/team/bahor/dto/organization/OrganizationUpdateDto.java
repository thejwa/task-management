package team.bahor.dto.organization;

import team.bahor.dto.GenericDto;
import team.bahor.entity.project.Project;

import java.util.List;

public class OrganizationUpdateDto extends GenericDto {
    private String name;

    private String website;

    private String logo;

    private String email;

    private String location;

    private Long ownerId;

    private Integer memberCount;

    private Integer projectCount;

    private List<Project> projects;
}

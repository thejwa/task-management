package team.bahor.dto.organization;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import team.bahor.dto.GenericDto;
import team.bahor.dto.project.ProjectDto;
import team.bahor.entity.project.Project;

import java.util.List;

@Setter
@Getter
public class OrganizationDto extends GenericDto {
    private String name;

    private String website;

    private String logo;

    private String email;

    private String location;

    private Long ownerId;

    private Integer memberCount;

    private Integer projectCount;

    private List<ProjectDto> projects;
    @Builder(builderMethodName = "childBuilder")
    public OrganizationDto(Long id, String name, String website, String logo, String email, String location, Long ownerId, Integer memberCount, Integer projectCount, List<ProjectDto> projects) {
        super(id);
        this.name = name;
        this.website = website;
        this.logo = logo;
        this.email = email;
        this.location = location;
        this.ownerId = ownerId;
        this.memberCount = memberCount;
        this.projectCount = projectCount;
        this.projects = projects;
    }
}

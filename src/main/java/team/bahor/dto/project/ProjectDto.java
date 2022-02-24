package team.bahor.dto.project;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import team.bahor.dto.GenericDto;
import team.bahor.entity.organization.Organization;
import team.bahor.entity.project.ProjectColumn;

import java.time.LocalDateTime;
import java.util.List;

@Setter
@Getter
public class ProjectDto extends GenericDto {
    private String name;

    private LocalDateTime deadline;

    private String description;

    private Organization organization;

    private List<ProjectColumn> projectColumns;
    @Builder(builderMethodName = "childBuilder")
    public ProjectDto(Long id, String name, LocalDateTime deadline, String description, Organization organization, List<ProjectColumn> projectColumns) {
        super(id);
        this.name = name;
        this.deadline = deadline;
        this.description = description;
        this.organization = organization;
        this.projectColumns = projectColumns;
    }
}

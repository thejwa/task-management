package team.bahor.dto.project;

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
}

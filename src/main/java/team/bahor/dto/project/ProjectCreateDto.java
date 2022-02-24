package team.bahor.dto.project;

import lombok.*;
import team.bahor.dto.BaseGenericDto;
import team.bahor.entity.organization.Organization;
import team.bahor.entity.project.ProjectColumn;

import java.time.LocalDateTime;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProjectCreateDto implements BaseGenericDto {
    private String name;

    private LocalDateTime deadline;

    private String description;

    private Organization organization;

    private List<ProjectColumn> projectColumns;
}

package team.bahor.dto.project;

import lombok.*;
import team.bahor.dto.BaseGenericDto;
import team.bahor.entity.organization.Organization;
import team.bahor.entity.project.ProjectColumn;

import java.time.LocalDateTime;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProjectCreateDto implements BaseGenericDto {

    public ProjectCreateDto(Long organizationId) {
        this.organizationId = organizationId;
    }

    private String name;

    private String tz;

    private String deadline;

    private String description;

    private Long organizationId;
}

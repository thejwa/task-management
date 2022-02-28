package team.bahor.dto.project;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import team.bahor.dto.GenericDto;
import team.bahor.dto.column.ColumnDto;
import team.bahor.entity.organization.Organization;
import team.bahor.entity.project.ProjectColumn;

import javax.persistence.Column;
import java.time.LocalDateTime;
import java.util.List;

@Setter
@Getter
public class ProjectDto extends GenericDto {

    private String name;

    private String  tz;

    private LocalDateTime createdAt;

    private LocalDateTime deadline;

    private String description;

    private Long organizationId;

    private List<ColumnDto> projectColumns;

    @Builder(builderMethodName = "childBuilder")

    public ProjectDto(Long id, String name, String tz, LocalDateTime createdAt, LocalDateTime deadline, String description, Long organizationId, List<ColumnDto> projectColumns) {
        super(id);
        this.name = name;
        this.tz = tz;
        this.createdAt = createdAt;
        this.deadline = deadline;
        this.description = description;
        this.organizationId = organizationId;
        this.projectColumns = projectColumns;
    }
}

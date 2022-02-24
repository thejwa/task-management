package team.bahor.dto.project;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import team.bahor.dto.GenericDto;
import team.bahor.entity.project.ProjectColumn;

import java.time.LocalDateTime;
import java.util.List;

@Setter
@Getter
public class ProjectUpdateDto extends GenericDto {

    private String name;

    private LocalDateTime deadline;

    private String description;

    private List<ProjectColumn> projectColumns;

    @Builder(builderMethodName = "childBuilder")
    public ProjectUpdateDto(Long id, String name, LocalDateTime deadline, String description, List<ProjectColumn> projectColumns) {
        super(id);
        this.name = name;
        this.deadline = deadline;
        this.description = description;
        this.projectColumns = projectColumns;
    }
}

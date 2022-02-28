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

    private String tz;

    private String deadline;

    private String description;

    private Long organizationId;


    @Builder(builderMethodName = "childBuilder")
    public ProjectUpdateDto(Long id, String name, String tz, String deadline, String description, Long organization) {
        super(id);
        this.name = name;
        this.tz = tz;
        this.deadline = deadline;
        this.description = description;
        this.organizationId = organization;
    }
}

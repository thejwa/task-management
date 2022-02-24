package team.bahor.dto.column;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import team.bahor.dto.BaseGenericDto;
import team.bahor.entity.project.Project;

import java.time.LocalDateTime;
@Setter
@Getter
@ToString
public class ColumnCreateDto implements BaseGenericDto {
    private String name;
    private Long projectId;
    private Long createdBy;
}

package team.bahor.dto.column;

import lombok.*;
import team.bahor.dto.BaseGenericDto;
import team.bahor.entity.project.Project;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class ColumnCreateDto implements BaseGenericDto {
    private String name;

    private Project project;

    private Long createdBy;

}

package team.bahor.dto.column;

import team.bahor.dto.GenericDto;
import team.bahor.entity.project.Project;

import java.time.LocalDateTime;

public class ColumnDto extends GenericDto {
    private Long id;
    private String code;
    private String name;
    private Integer columnOrder;
    private LocalDateTime createdAt;
    private Long createdBy;
    private LocalDateTime updatedAt;
    private Long updatedBy;
    private Integer status;
}

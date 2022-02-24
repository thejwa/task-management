package team.bahor.dto.column;

import team.bahor.dto.GenericDto;

import java.time.LocalDateTime;

public class ColumnUpdateDto extends GenericDto {
    private Long id;
    private String name;
    private Integer columnOrder;
    private Long updatedBy;
}

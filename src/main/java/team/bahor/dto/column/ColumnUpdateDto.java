package team.bahor.dto.column;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import team.bahor.dto.GenericDto;


@Getter
@Setter
public class ColumnUpdateDto extends GenericDto {

    private String name;

    private Integer columnOrder;

    private Long updatedBy;

    private Integer status;

    @Builder(builderMethodName = "childBuilder")
    public ColumnUpdateDto(Long id, String name, Integer columnOrder, Long updatedBy, Integer status) {
        super(id);
        this.name = name;
        this.columnOrder = columnOrder;
        this.updatedBy = updatedBy;
        this.status = status;
    }
}

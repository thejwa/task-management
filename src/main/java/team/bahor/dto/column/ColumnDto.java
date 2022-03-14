package team.bahor.dto.column;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import team.bahor.dto.GenericDto;
import team.bahor.dto.task.TaskDto;
import team.bahor.entity.task.Task;

import java.util.List;


@Getter
@Setter
public class ColumnDto extends GenericDto {
    private String code;

    private String name;

    private Integer columnOrder;

    private List<TaskDto> tasks;

    private Integer status;


    @Builder(builderMethodName = "childBuilder")
    public ColumnDto(Long id, String code, String name, Integer columnOrder, List<TaskDto> tasks, Integer status) {
        super(id);
        this.code = code;
        this.name = name;
        this.columnOrder = columnOrder;
        this.tasks = tasks;
        this.status = status;
    }
}

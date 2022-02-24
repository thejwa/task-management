package team.bahor.service.column;

import team.bahor.dto.column.ColumnCreateDto;
import team.bahor.dto.column.ColumnDto;
import team.bahor.dto.column.ColumnUpdateDto;
import team.bahor.service.base.GenericCrudService;

public interface ColumnService extends GenericCrudService<
        ColumnDto,
        ColumnCreateDto,
        ColumnUpdateDto,
        String> {
}

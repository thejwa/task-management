package team.bahor.mapper.column;

import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;
import team.bahor.dto.column.ColumnCreateDto;
import team.bahor.dto.column.ColumnDto;
import team.bahor.dto.column.ColumnUpdateDto;
import team.bahor.entity.column.Column;
import team.bahor.mapper.base.AbstractMapper;

import java.util.List;

@Component
@Mapper(componentModel = "spring")
public interface ColumnMapper extends AbstractMapper<
        Column,
        ColumnDto,
        ColumnCreateDto,
        ColumnUpdateDto> {

    @Override
    ColumnDto toDto(Column entity);

    @Override
    List<ColumnDto> toDto(List<Column> entities);

    @Override
    Column fromCreateDto(ColumnCreateDto createDto);

    @Override
    Column fromUpdateDto(ColumnUpdateDto updateDto);
}

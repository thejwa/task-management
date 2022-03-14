package team.bahor.mapper.column;

import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;
import team.bahor.dto.column.ColumnCreateDto;
import team.bahor.dto.column.ColumnDto;
import team.bahor.dto.column.ColumnUpdateDto;
import team.bahor.entity.project.ProjectColumn;
import team.bahor.mapper.base.AbstractMapper;

import java.util.List;

@Component
@Mapper(componentModel = "spring")
public interface ColumnMapper extends AbstractMapper<
        ProjectColumn,
        ColumnDto,
        ColumnCreateDto,
        ColumnUpdateDto> {

    @Override
    ColumnDto toDto(ProjectColumn entity);

    @Override
    List<ColumnDto> toDto(List<ProjectColumn> entities);

    @Override
    ProjectColumn fromCreateDto(ColumnCreateDto createDto);

    @Override
    ProjectColumn fromUpdateDto(ColumnUpdateDto updateDto);

    ColumnUpdateDto toUpdateDto(ProjectColumn byIdAndDeletedTrue);
}

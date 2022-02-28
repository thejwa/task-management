package team.bahor.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;
import team.bahor.dto.project.ProjectCreateDto;
import team.bahor.dto.project.ProjectDto;
import team.bahor.dto.project.ProjectUpdateDto;
import team.bahor.entity.project.Project;
import team.bahor.mapper.base.AbstractMapper;

import java.util.List;

@Component
@Mapper(componentModel = "spring")
public interface ProjectMapper extends AbstractMapper<Project,ProjectDto,ProjectCreateDto,ProjectUpdateDto> {
    @Override
    ProjectDto toDto(Project entity);

    @Override
    List<ProjectDto> toDto(List<Project> entities);

    @Override
    @Mapping(target = "deadline",ignore = true)
    Project fromCreateDto(ProjectCreateDto createDto);

    @Override
    @Mapping(target = "deadline",ignore = true)
    Project fromUpdateDto(ProjectUpdateDto updateDto);
}

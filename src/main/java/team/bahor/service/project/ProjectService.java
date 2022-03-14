package team.bahor.service.project;

import team.bahor.dto.project.ProjectCreateDto;
import team.bahor.dto.project.ProjectDto;
import team.bahor.dto.project.ProjectUpdateDto;
import team.bahor.service.base.GenericCrudService;

public interface ProjectService extends GenericCrudService<ProjectDto, ProjectCreateDto, ProjectUpdateDto,Long> {
}

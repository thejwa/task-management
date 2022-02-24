package team.bahor.service;

import org.springframework.stereotype.Service;
import team.bahor.dto.project.ProjectCreateDto;
import team.bahor.dto.project.ProjectDto;
import team.bahor.dto.project.ProjectUpdateDto;
import team.bahor.entity.project.Project;
import team.bahor.mapper.ProjectMapper;
import team.bahor.repository.project.ProjectRepository;
import team.bahor.service.base.AbstractService;
import team.bahor.validator.ProjectValidator;
import team.bahor.validator.base.BaseGenericValidator;

@Service
public class ProjectService extends AbstractService<ProjectRepository,ProjectMapper, ProjectValidator> {
    protected ProjectService(ProjectMapper mapper, ProjectValidator validator, ProjectRepository repository) {
        super(mapper, validator, repository);
    }

    public void create(ProjectCreateDto dto){
        Project project=mapper.fromCreateDto(dto);
        repository.save(project);
    }

    public ProjectDto get(Long id){
        Project project=repository.getById(id);
        return mapper.toDto(project);
    }

    public void update(ProjectUpdateDto dto){
        Project project=mapper.fromUpdateDto(dto);
        repository.save(project);
    }
}

package team.bahor.service.project;

import org.springframework.stereotype.Service;
import team.bahor.dto.project.ProjectCreateDto;
import team.bahor.dto.project.ProjectDto;
import team.bahor.dto.project.ProjectUpdateDto;
import team.bahor.entity.project.Project;
import team.bahor.mapper.ProjectMapper;
import team.bahor.repository.project.ProjectRepository;
import team.bahor.service.base.AbstractService;
import team.bahor.validator.ProjectValidator;

import java.util.List;

@Service
public class ProjectServiceImpl extends AbstractService<ProjectRepository,ProjectMapper, ProjectValidator> implements ProjectService{
    protected ProjectServiceImpl(ProjectMapper mapper, ProjectValidator validator, ProjectRepository repository) {
        super(mapper, validator, repository);
    }

    public Long create(ProjectCreateDto dto){
        Project project=mapper.fromCreateDto(dto);
        repository.save(project);
        return null;
    }

    public ProjectDto get(Long id){
        Project project=repository.getById(id);
        return mapper.toDto(project);
    }

    @Override
    public List<ProjectDto> getAll(Long id) {
        return null;
    }

    public Void update(ProjectUpdateDto dto){
        Project project=mapper.fromUpdateDto(dto);
        repository.save(project);
        return null;
    }
    public Void delete(Long id){
        repository.deleteById(id);
        return null;
    }
}

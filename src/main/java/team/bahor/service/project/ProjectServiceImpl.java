package team.bahor.service.project;

import org.springframework.stereotype.Service;
import team.bahor.dto.project.ProjectCreateDto;
import team.bahor.dto.project.ProjectDto;
import team.bahor.dto.project.ProjectUpdateDto;
import team.bahor.entity.project.Project;
import team.bahor.mapper.ProjectMapper;
import team.bahor.repository.project.ProjectRepository;
import team.bahor.service.base.AbstractService;
import team.bahor.service.column.ColumnService;
import team.bahor.validator.ProjectValidator;

import java.util.List;
import java.util.UUID;

@Service
public class ProjectServiceImpl extends AbstractService<ProjectRepository,ProjectMapper, ProjectValidator> implements ProjectService{

    private final ColumnService columnService;

    protected ProjectServiceImpl(ProjectMapper mapper, ProjectValidator validator, ProjectRepository repository, ColumnService columnService) {
        super(mapper, validator, repository);
        this.columnService = columnService;
    }

    public Long create(ProjectCreateDto dto){
        Project project=mapper.fromCreateDto(dto);
        project.setCode(UUID.randomUUID().toString());
        System.out.println(project);
        repository.save(project);
        return null;
    }

    public ProjectDto get(Long id){
        ProjectDto projectDto= mapper.toDto(repository.getById(id));
        projectDto.setProjectColumns(columnService.getAll(projectDto.getId()));
        return projectDto;
    }

    @Override
    public List<ProjectDto> getAll(Long id) {
//       return mapper.toDto(repository.findProjectsByOrganization(id));
        return null;
    }

    public void update(ProjectUpdateDto dto){
        Project project=mapper.fromUpdateDto(dto);
        repository.save(project);
    }
    public void delete(Long id){
        repository.deleteById(id);
    }
}

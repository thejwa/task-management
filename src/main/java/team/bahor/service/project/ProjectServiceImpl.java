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
import java.util.UUID;

@Service
public class ProjectServiceImpl extends AbstractService<ProjectRepository,ProjectMapper, ProjectValidator> implements ProjectService{
    public ProjectServiceImpl(ProjectMapper mapper, ProjectValidator validator, ProjectRepository repository) {
        super(mapper, validator, repository);
    }
//    private final ColumnService columnService;


    public Long create(ProjectCreateDto dto){
        Project project=mapper.fromCreateDto(dto);
        project.setCode(UUID.randomUUID().toString());
        System.out.println(project);
        repository.save(project);
        return null;
    }

    public ProjectDto get(Long id){
        ProjectDto projectDto= mapper.toDto(repository.getById(id));
//        projectDto.setProjectColumns(columnService.getAll(projectDto.getId()));
        return projectDto;
    }

    @Override
    public List<ProjectDto> getAll(Long id) {
      return mapper.toDto(repository.findProjectsByOrganizationId(id));
    }

    public void update(ProjectUpdateDto dto){
        Project project=mapper.fromUpdateDto(dto);
        repository.save(project);
    }
    public void delete(Long id){
        repository.deleteById(id);
    }
}

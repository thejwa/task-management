package team.bahor.service.organization;

import org.springframework.stereotype.Service;
import team.bahor.dto.organization.OrganizationCreatoDto;
import team.bahor.dto.organization.OrganizationDto;
import team.bahor.dto.organization.OrganizationUpdateDto;
import team.bahor.dto.project.ProjectDto;
import team.bahor.entity.organization.Organization;
import team.bahor.entity.project.Project;
import team.bahor.mapper.OrganizationMapper;
import team.bahor.repository.organization.OrganizationRepository;
import team.bahor.service.base.AbstractService;
import team.bahor.service.project.ProjectServiceImpl;
import team.bahor.validator.OrganizationValidator;

import java.util.List;
import java.util.UUID;

@Service
public class OrganizationServiceImpl extends AbstractService<OrganizationRepository, OrganizationMapper, OrganizationValidator> implements OrganizationService {

    private final ProjectServiceImpl projectService;

    public OrganizationServiceImpl(OrganizationMapper mapper, OrganizationValidator validator, OrganizationRepository repository, ProjectServiceImpl projectService) {
        super(mapper, validator, repository);
        this.projectService = projectService;
    }

    public Long create(OrganizationCreatoDto dto) {
        Organization org = mapper.fromCreateDto(dto);
        org.setCode(UUID.randomUUID().toString());
//        org.setCreatedBy(dto.getCreatedBy());
        repository.save(org);
        return null;
    }

    public OrganizationDto get(Long id) {
        OrganizationDto organizationDto = mapper.toDto(repository.getByIdOrganization(id));
        List<ProjectDto> projectDto = projectService.getAllProjectForOrganization(id);
        organizationDto.setProjects(projectDto);
        return organizationDto;
    }



    public OrganizationDto getOrg(Long id) {
       final OrganizationDto organizationDto = mapper.toDto(repository.getByUserIdOrganization(id));
       final List<ProjectDto> projectDto = projectService.getAllProjectsForUser(id);
        organizationDto.setProjects(projectDto);
        return organizationDto;
    }

    @Override
    public List<OrganizationDto> getAll(Long id) {
        repository.getById(id);
        return null;
    }

    public List<OrganizationDto> getAll() {
        return mapper.toDto(repository.findAll());
    }

    public void update(OrganizationUpdateDto org) {
        repository.save(mapper.fromUpdateDto(org));
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    public void addProject(Long oId, Project project) {
        Organization org = repository.getById(oId);
//        List<Project> projects = org.getProjects();
//        projects.add(project);
        org.setProjectCount(org.getProjectCount() + 1);
        repository.save(org);
    }

    public void removeProject(Long oId, Project project) {
        Organization org = repository.getById(oId);
//        List<Project> projects = org.getProjects();
//        projects.remove(project);
        org.setProjectCount(org.getProjectCount() - 1);
        repository.save(org);
    }

    public void addMember(Long oid, int i) {
        Organization org = repository.getById(oid);
        org.setMemberCount(org.getMemberCount() + i);
    }

}

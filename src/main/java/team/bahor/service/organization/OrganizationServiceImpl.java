package team.bahor.service.organization;

import org.springframework.stereotype.Service;
import team.bahor.dto.organization.OrganizationCreatoDto;
import team.bahor.dto.organization.OrganizationDto;
import team.bahor.dto.organization.OrganizationUpdateDto;
import team.bahor.entity.organization.Organization;
import team.bahor.entity.project.Project;
import team.bahor.mapper.OrganizationMapper;
import team.bahor.repository.organization.OrganizationRepository;
import team.bahor.service.base.AbstractService;
import team.bahor.validator.OrganizationValidator;

import java.util.List;
import java.util.UUID;

@Service
public class OrganizationServiceImpl extends AbstractService<OrganizationRepository,OrganizationMapper, OrganizationValidator> implements OrganizationService{

    protected OrganizationServiceImpl(OrganizationMapper mapper, OrganizationValidator validator, OrganizationRepository repository) {
        super(mapper, validator, repository);
    }

    public Long create(OrganizationCreatoDto dto){
        Organization org=mapper.fromCreateDto(dto);
        Long ownerId=1L;
        org.setOwnerId(ownerId);
        org.setCode(UUID.randomUUID().toString());
        repository.save(org);
        return null;
    }

    public OrganizationDto get(Long id){
        return mapper.toDto(repository.getById(id));
    }

    @Override
    public List<OrganizationDto> getAll(Long id) {
        return null;
    }

    public void update(OrganizationUpdateDto org){
        repository.save(mapper.fromUpdateDto(org));
    }

    public void delete(Long id){
        repository.deleteById(id);
    }

    public void addProject(Long oId,Project project){
        Organization org=repository.getById(oId);
        List<Project> projects=org.getProjects();
        projects.add(project);
        org.setProjectCount(org.getProjectCount()+1);
        repository.save(org);
    }

    public void removeProject(Long oId, Project project){
        Organization org=repository.getById(oId);
        List<Project> projects=org.getProjects();
        projects.remove(project);
        org.setProjectCount(org.getProjectCount()-1);
        repository.save(org);
    }

    public void addMember(Long oid, int i){
        Organization org=repository.getById(oid);
        org.setMemberCount(org.getMemberCount()+i);
    }

}

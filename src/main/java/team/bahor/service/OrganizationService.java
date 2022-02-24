package team.bahor.service;

import org.springframework.stereotype.Service;
import team.bahor.dto.organization.OrganizationCreatoDto;
import team.bahor.entity.organization.Organization;
import team.bahor.entity.project.Project;
import team.bahor.mapper.OrganizationMapper;
import team.bahor.repository.organization.OrganizationRepository;
import team.bahor.service.base.AbstractService;
import team.bahor.validator.base.BaseGenericValidator;

import java.util.List;

@Service
public class OrganizationService extends AbstractService<OrganizationRepository,OrganizationMapper, BaseGenericValidator> {

    protected OrganizationService(OrganizationMapper mapper, BaseGenericValidator validator, OrganizationRepository repository) {
        super(mapper, validator, repository);
    }

    public void create(OrganizationCreatoDto dto){
        Organization org=mapper.fromCreateDto(dto);
        Long ownerId=1L;
        org.setOwnerId(ownerId);
        repository.save(org);
    }

    public Organization get(Long id){
        return repository.getById(id);
    }

    public void update(Organization org){
        repository.save(org);
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

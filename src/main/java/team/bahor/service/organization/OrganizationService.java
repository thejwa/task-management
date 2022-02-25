package team.bahor.service.organization;

import team.bahor.dto.organization.OrganizationCreatoDto;
import team.bahor.dto.organization.OrganizationDto;
import team.bahor.dto.organization.OrganizationUpdateDto;
import team.bahor.service.base.GenericCrudService;

public interface OrganizationService extends GenericCrudService<OrganizationDto, OrganizationCreatoDto, OrganizationUpdateDto, Long> {
}

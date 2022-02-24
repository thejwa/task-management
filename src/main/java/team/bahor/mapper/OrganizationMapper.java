package team.bahor.mapper;

import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;
import team.bahor.dto.organization.OrganizationCreatoDto;
import team.bahor.dto.organization.OrganizationDto;
import team.bahor.entity.organization.Organization;

@Component
@Mapper(componentModel = "spring")
public interface OrganizationMapper {
    OrganizationDto toDto(Organization organization);

    Organization fromCreateDto(OrganizationCreatoDto dto);
}

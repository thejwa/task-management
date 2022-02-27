package team.bahor.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;
import team.bahor.dto.organization.OrganizationCreatoDto;
import team.bahor.dto.organization.OrganizationDto;
import team.bahor.dto.organization.OrganizationUpdateDto;
import team.bahor.entity.organization.Organization;
import team.bahor.mapper.base.AbstractMapper;

import java.util.List;

@Component
@Mapper(componentModel = "spring")
public interface OrganizationMapper extends AbstractMapper<Organization,OrganizationDto,OrganizationCreatoDto, OrganizationUpdateDto> {

 @Override
 OrganizationDto toDto(Organization entity);

 @Override
 Organization fromCreateDto(OrganizationCreatoDto createDto);

 @Override
 List<OrganizationDto> toDto(List<Organization> entities);

 @Override
 Organization fromUpdateDto(OrganizationUpdateDto updateDto);
}

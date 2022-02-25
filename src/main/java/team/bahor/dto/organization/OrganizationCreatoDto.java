package team.bahor.dto.organization;

import lombok.*;
import team.bahor.dto.BaseGenericDto;
import team.bahor.entity.project.Project;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class OrganizationCreatoDto implements BaseGenericDto {

    private String name;

    private String website;

    private String logo;

    private String email;

    private String location;

    private Long ownerId;

}

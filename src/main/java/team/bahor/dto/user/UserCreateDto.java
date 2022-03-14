package team.bahor.dto.user;

import lombok.*;
import team.bahor.dto.BaseGenericDto;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserCreateDto implements BaseGenericDto {
    @org.hibernate.validator.constraints.NotBlank
    private String firstName;

    private String lastName;

    @NotBlank
//    @Pattern(regexp = "")
    private String password;

    private String role;

    private String profilePhoto;

    @NotBlank
    private String username;

    private Long organizationId;
}

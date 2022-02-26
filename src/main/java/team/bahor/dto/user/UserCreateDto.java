package team.bahor.dto.user;

import lombok.*;
import team.bahor.dto.BaseGenericDto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserCreateDto implements BaseGenericDto {
    @NotBlank
    private String first_name;

    private String last_name;

    @NotBlank
    @Pattern(regexp = "")
    private String password;

    private String role;

    private String profile_photo;

    @NotBlank
    private String username;

    private Long organization_id;
}

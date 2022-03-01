package team.bahor.dto.user;

import team.bahor.dto.BaseGenericDto;

public class UserDtoForProjectMember implements BaseGenericDto {
    public Long id;

    public String username;

    public UserDtoForProjectMember(Long id, String username) {
        this.id = id;
        this.username = username;
    }
}

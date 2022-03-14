package team.bahor.dto.user;

import team.bahor.dto.BaseGenericDto;

public class UserDtoForMember implements BaseGenericDto {
    public Long id;

    public String username;

    public UserDtoForMember(Long id, String username) {
        this.id = id;
        this.username = username;
    }
}

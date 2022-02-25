package team.bahor.service.user;

import team.bahor.dto.user.UserCreateDto;
import team.bahor.dto.user.UserDto;
import team.bahor.dto.user.UserUpdateDto;
import team.bahor.service.base.GenericCrudService;

public interface UserService extends GenericCrudService<UserDto, UserCreateDto, UserUpdateDto, Long> {
}

package team.bahor.mapper.user;

import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;
import team.bahor.dto.user.UserCreateDto;
import team.bahor.dto.user.UserDto;
import team.bahor.dto.user.UserUpdateDto;
import team.bahor.entity.user.User;
import team.bahor.mapper.base.AbstractMapper;

@Component
@Mapper(componentModel = "spring")
public interface UserMapper extends AbstractMapper<User, UserDto, UserCreateDto, UserUpdateDto> {

}

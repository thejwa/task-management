package team.bahor.service.user;

import org.springframework.stereotype.Service;
import team.bahor.dto.user.UserCreateDto;
import team.bahor.dto.user.UserDto;
import team.bahor.dto.user.UserUpdateDto;
import team.bahor.mapper.user.UserMapper;
import team.bahor.repository.user.UserRepository;
import team.bahor.service.base.AbstractService;
import team.bahor.validator.user.UserValidator;

import java.util.List;

@Service
public class UserServiceImpl extends AbstractService<UserRepository, UserMapper, UserValidator> implements UserService{
    protected UserServiceImpl(UserMapper mapper, UserValidator validator, UserRepository repository) {
        super(mapper, validator, repository);
    }

    @Override
    public Long create(UserCreateDto createDto) {
        return null;
    }

    @Override
    public void delete(Long id) {
    }

    @Override
    public void update(UserUpdateDto updateDto) {
    }

    @Override
    public UserDto get(Long id) {
        return null;
    }

    @Override
    public List<UserDto> getAll(Long id) {
        return null;
    }
}

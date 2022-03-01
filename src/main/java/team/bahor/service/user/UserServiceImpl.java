package team.bahor.service.user;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import team.bahor.dto.user.UserCreateDto;
import team.bahor.dto.user.UserDto;
import team.bahor.dto.user.UserDtoForProjectMember;
import team.bahor.dto.user.UserUpdateDto;
import team.bahor.entity.user.User;
import team.bahor.entity.user.UserPermission;
import team.bahor.entity.user.UserRole;
import team.bahor.enums.user.Roles;
import team.bahor.mapper.user.UserMapper;
import team.bahor.repository.user.UserRepository;
import team.bahor.service.base.AbstractService;
import team.bahor.validator.user.UserValidator;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl extends AbstractService<UserRepository, UserMapper, UserValidator> implements UserService {
    private final PasswordEncoder passwordEncoder;

    protected UserServiceImpl(UserMapper mapper, UserValidator validator, UserRepository repository, PasswordEncoder passwordEncoder) {
        super(mapper, validator, repository);
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public Long create(UserCreateDto dto) {
        User user = mapper.fromCreateDto(dto);
        user.setCode(UUID.randomUUID().toString());
        user.setCreatedAt(LocalDateTime.now());
        user.setStatus(0);
        user.setPassword(passwordEncoder.encode(dto.getPassword()));

        Roles role = Roles.getRoleByCode(dto.getRole());
        UserRole userRole = new UserRole(role.name(), role.getCode());
        userRole.setPermissions(role.getPermissions().stream()
                .map(permission -> new UserPermission(permission.name(), permission.getCode()))
                .collect(Collectors.toList()));
        user.setUserRole(userRole);

        user = repository.save(user);
        return user.getId();
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
    public List<UserDto> getAllTasksForColumn(Long id) {
        return null;
    }

    public List<UserDtoForProjectMember> getAllMemberForProject(Long id) {
        return mapper.toUserDtoForProjectMember(repository.getAllMemberForProject(id));
    }

    public void projectAddMember(Long id,Long projectId) {
        repository.projectAddMember(id,projectId);
    }

    public List<UserDtoForProjectMember> getProjectAllMember(Long id) {
        return mapper.toUserDtoForProjectMember(repository.getProjectAllMember(id));
    }
}

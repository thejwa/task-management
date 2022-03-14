package team.bahor.service.user;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import team.bahor.dto.user.UserCreateDto;
import team.bahor.dto.user.UserDto;
import team.bahor.dto.user.UserDtoForMember;
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
    public List<UserDto> getAll(Long id) {
        return null;
    }

    public List<UserDtoForMember> getAllMemberForProject(Long id) {
        return mapper.toUserDtoForMember(repository.getAllMemberForProject(id));
    }

    public void projectAddMember(Long id,Long projectId) {
        repository.projectAddMember(id,projectId);
    }

    public List<UserDtoForMember> getProjectAllMember(Long id) {
        return mapper.toUserDtoForMember(repository.getProjectAllMember(id));
    }

    public void deletedprojectmember(Long id,Long projectId) {
        repository.deletedprojectmember(id,projectId);

    }

    public void blockProjectmember(Long id, Long projectId) {
    }

    public List<UserDtoForMember> getTaskMembers(Long id) {
      return   mapper.toUserDtoForMember(repository.getTaskMembers(id));
    }

    public List<UserDtoForMember> taskCanMembersList(Long id) {
        return mapper.toUserDtoForMember(repository.taskCanMembersList(id));
    }
}

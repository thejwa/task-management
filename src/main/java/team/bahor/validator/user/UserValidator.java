package team.bahor.validator.user;

import org.springframework.stereotype.Component;
import team.bahor.dto.user.UserCreateDto;
import team.bahor.dto.user.UserUpdateDto;
import team.bahor.entity.user.User;
import team.bahor.enums.user.Roles;
import team.bahor.exeptions.ValidationException;
import team.bahor.repository.user.UserRepository;
import team.bahor.utils.BaseUtils;
import team.bahor.validator.base.AbstractValidator;


@Component
public class UserValidator extends AbstractValidator<UserCreateDto, UserUpdateDto, Long> {
    private final UserRepository userRepository;

    public UserValidator(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void validateKey(Long id) throws ValidationException {

    }

    @Override
    public void validOnCreate(UserCreateDto dto) throws ValidationException {
        Roles role = Roles.getRoleByCode(dto.getRole());
        User user = userRepository.findById(BaseUtils.sessionUserId()).get();
        Roles sessionRole = Roles.getRoleByCode(user.getUserRole().getCode());
        if (sessionRole.getOrder() < role.getOrder()) throw new ValidationException("PERMISSION_DENIED");
    }

    @Override
    public void validOnUpdate(UserUpdateDto cd) throws ValidationException {

    }


}

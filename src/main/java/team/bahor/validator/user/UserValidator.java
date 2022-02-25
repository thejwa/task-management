package team.bahor.validator.user;

import org.springframework.stereotype.Component;
import team.bahor.dto.user.UserCreateDto;
import team.bahor.dto.user.UserUpdateDto;
import team.bahor.exeptions.ValidationException;
import team.bahor.validator.base.AbstractValidator;


@Component
public class UserValidator extends AbstractValidator<UserCreateDto, UserUpdateDto, Long> {
    @Override
    public void validateKey(Long id) throws ValidationException {

    }

    @Override
    public void validOnCreate(UserCreateDto userCreateDto) throws ValidationException {

    }

    @Override
    public void validOnUpdate(UserUpdateDto cd) throws ValidationException {

    }
}

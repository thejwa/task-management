package team.bahor.validator.column;

import org.springframework.stereotype.Component;
import team.bahor.dto.column.ColumnCreateDto;
import team.bahor.dto.column.ColumnUpdateDto;
import team.bahor.exeptions.ValidationException;
import team.bahor.validator.base.AbstractValidator;

import javax.persistence.Column;

@Component
public class ColumnValidator extends AbstractValidator<ColumnCreateDto, ColumnUpdateDto, Long> {


    @Override
    public void validateKey(Long id) throws ValidationException {

    }

    @Override
    public void validOnCreate(ColumnCreateDto columnCreateDto) throws ValidationException {

    }

    @Override
    public void validOnUpdate(ColumnUpdateDto cd) throws ValidationException {

    }
}

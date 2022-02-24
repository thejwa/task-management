package team.bahor.service.column;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import team.bahor.dto.column.ColumnCreateDto;
import team.bahor.dto.column.ColumnDto;
import team.bahor.dto.column.ColumnUpdateDto;
import team.bahor.entity.column.Column;
import team.bahor.mapper.column.ColumnMapper;
import team.bahor.repository.column.ColumnRepository;
import team.bahor.service.base.AbstractService;
import team.bahor.validator.column.ColumnValidator;

import java.util.List;

@Service
public class ColumnServiceImp extends AbstractService<ColumnRepository, ColumnMapper, ColumnValidator>
implements ColumnService{

    @Autowired
    protected ColumnServiceImp(ColumnMapper mapper, ColumnValidator validator, ColumnRepository repository) {
        super(mapper, validator, repository);
    }

    @Override
    public String create(ColumnCreateDto createDto) {
        Column column = mapper.fromCreateDto(createDto);
        return null;
    }

    @Override
    public Void delete(String id) {
        return null;
    }

    @Override
    public Void update(ColumnUpdateDto updateDto) {
        return null;
    }

    @Override
    public ColumnDto get(String id) {
        return null;
    }

    @Override
    public List<ColumnDto> getAll(String id) {
        return null;
    }
}

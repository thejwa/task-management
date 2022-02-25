package team.bahor.service.column;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import team.bahor.dto.column.ColumnCreateDto;
import team.bahor.dto.column.ColumnDto;
import team.bahor.dto.column.ColumnUpdateDto;
import team.bahor.entity.project.ProjectColumn;
import team.bahor.mapper.column.ColumnMapper;
import team.bahor.repository.column.ColumnRepository;
import team.bahor.service.base.AbstractService;
import team.bahor.validator.column.ColumnValidator;

import javax.validation.constraints.NotNull;
import java.util.List;

@Service
public class ColumnServiceImp extends AbstractService<ColumnRepository, ColumnMapper, ColumnValidator>
        implements ColumnService {

    @Autowired
    protected ColumnServiceImp(ColumnMapper mapper, ColumnValidator validator, ColumnRepository repository) {
        super(mapper, validator, repository);
    }


    @Override
    public Long create(ColumnCreateDto createDto) {
        ProjectColumn projectColumn = mapper.fromCreateDto(createDto);
        repository.save(projectColumn);
        return null;
    }


    @Override
    public ColumnDto get(@NotNull Long id) {
        return mapper.toDto(repository.getById(id));
    }


    @Override
    public List<ColumnDto> getAll(@NotNull Long id) {
        List<ProjectColumn> columns = repository.getAllProjectForProjectColumn(id);
        return mapper.toDto(columns);
    }

    @Override
    public void update(ColumnUpdateDto updateDto) {
        repository.update(updateDto);
    }


    @Override
    public void delete(Long id) {
        ProjectColumn projectColumn = repository.getById(id);
        projectColumn.setDeleted(true);
        repository.save(projectColumn);
    }
}

package team.bahor.service.column;

import org.hibernate.mapping.Column;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import team.bahor.dto.column.ColumnCreateDto;
import team.bahor.dto.column.ColumnDto;
import team.bahor.dto.column.ColumnUpdateDto;
import team.bahor.dto.task.TaskDto;
import team.bahor.entity.project.ProjectColumn;
import team.bahor.mapper.column.ColumnMapper;
import team.bahor.repository.column.ColumnRepository;
import team.bahor.service.base.AbstractService;
import team.bahor.service.task.TaskService;
import team.bahor.service.task.TaskServiceImpl;
import team.bahor.validator.column.ColumnValidator;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.UUID;

@Service
public class ColumnServiceImp extends AbstractService<ColumnRepository, ColumnMapper, ColumnValidator>
        implements ColumnService {

    private final TaskServiceImpl taskService;

    public ColumnServiceImp(ColumnMapper mapper, ColumnValidator validator, ColumnRepository repository, TaskServiceImpl taskService) {
        super(mapper, validator, repository);
        this.taskService = taskService;
    }





    public Long create(ColumnCreateDto createDto) {
        ProjectColumn projectColumn = mapper.fromCreateDto(createDto);
        projectColumn.setCode(UUID.randomUUID().toString());
        repository.save(projectColumn);
        return null;
    }


    @Override
    public ColumnDto get(@NotNull Long id) {
        return mapper.toDto(repository.getById(id));
    }


    @Override
    public List<ColumnDto> getAllTasksForColumn(@NotNull Long id) {
        List<ColumnDto> columns = mapper.toDto(repository.getAllProjectForProjectColumn(id));
        for (ColumnDto column : columns) {
            final List<TaskDto> all = taskService.getAllTasksForColumn(column.getId());
            column.setTasks(all);
        }
        return columns;
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


    public List<ColumnDto> getAllColumnForPproject(Long id) {
        List<ProjectColumn> columns = repository.findAllColumn(id);
        List<ColumnDto> columnDtos = mapper.toDto(columns);
        for (ColumnDto columnDto : columnDtos) {
            columnDto.setTasks(taskService.getAllTasksForColumn(columnDto.getId()));
        }
        return columnDtos;
    }
}

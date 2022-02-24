package team.bahor.service.task;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import team.bahor.config.security.UserDetails;
import team.bahor.dto.task.TaskCreateDto;
import team.bahor.dto.task.TaskDto;
import team.bahor.dto.task.TaskUpdateDto;
import team.bahor.entity.task.Task;
import team.bahor.mapper.task.TaskMapper;
import team.bahor.repository.task.TaskRepository;
import team.bahor.service.base.AbstractService;
import team.bahor.validator.base.BaseGenericValidator;

import java.util.List;

@Service
public class TaskServiceImpl extends AbstractService<TaskRepository, TaskMapper, BaseGenericValidator> implements TaskService {
    public TaskServiceImpl(TaskMapper mapper, BaseGenericValidator validator, TaskRepository repository) {
        super(mapper, validator, repository);
    }

    @Override
    public Long create(TaskCreateDto createDto) {
        Task task = mapper.fromCreateDto(createDto);
        Long id = ((UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getId();
        task.setCreatedBy(id);
        repository.save(task);
        return null;
    }

    @Override
    public Void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Void update(TaskUpdateDto updateDto) {
        repository.update(updateDto);
    }


    @Override
    public TaskDto get(Long id) {
        return mapper.toDto(repository.getById(id));
    }

    @Override
    public List<TaskDto> getAll(Long id) {
        List<Task> tasks = repository.getAllTaskForProjectColumn(id);
        return mapper.toDto(tasks);
    }
}

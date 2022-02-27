package team.bahor.service.task;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import team.bahor.config.security.UserDetails;
import team.bahor.dto.task.*;
import team.bahor.entity.task.Task;
import team.bahor.mapper.task.TaskMapper;
import team.bahor.repository.column.ColumnRepository;
import team.bahor.repository.task.TaskRepository;
import team.bahor.service.base.AbstractService;
import team.bahor.validator.TaskValidator;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Service
public class TaskServiceImpl extends AbstractService<TaskRepository, TaskMapper, TaskValidator> implements TaskService {
    private final ColumnRepository columnRepository;

    public TaskServiceImpl(TaskMapper mapper, TaskValidator validator, TaskRepository repository, ColumnRepository columnRepository) {
        super(mapper, validator, repository);
        this.columnRepository = columnRepository;
    }

    @Override
    public Long create(TaskCreateDto dto) {
        Task endTaskOrder = repository.getEndTaskOrder(dto.getColumnId());
        dto.setCreatedBy(((UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getId());
        dto.setTaskOrder((long) (Objects.isNull(endTaskOrder) ? 1 : endTaskOrder.getTaskOrder() + 1));
        Task task = mapper.fromCreateDto(dto);
        task.setDeadline(LocalDateTime.parse(dto.getDeadline(),DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm")));
        task.setCode(UUID.randomUUID().toString());
        task.setColumnId(dto.getColumnId());
        task.setStatus(0);
        repository.save(task);
        return null;

    }

    @Override
    public void delete(Long id) {
        repository.delete(id);
    }

    @Override
    public void update(TaskUpdateDto dto) {
        repository.update(dto);
    }


    @Override
    public TaskDto get(Long id) {
        Task task = (Task) repository.findByIdOfTask(id).orElseThrow(() -> new IllegalArgumentException("invalid task id" + id));
        return mapper.toDto(task);
    }

    @Override
    public List<TaskDto> getAllTasksForColumn(Long id) {
        List<Task> tasks = repository.getAllTasksForColumn(id);
        return mapper.toDto(tasks);
    }

    public TaskUpdateDto getUpdateDto(Long id) {
        Task task = (Task) repository.findByIdOfTask(id).orElseThrow(() -> new IllegalArgumentException("invalid task id" + id));
        return mapper.toUpdateDto(task);
    }
}

package team.bahor.service.taskMember;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import team.bahor.dto.task.TaskMemberCreateDto;
import team.bahor.dto.task.TaskMemberDto;
import team.bahor.dto.task.TaskMemberUpdateDto;
import team.bahor.entity.task.TaskMember;
import team.bahor.entity.user.User;
import team.bahor.mapper.taskMember.TaskMemberMapper;
import team.bahor.repository.taskMember.TaskMemberRepository;
import team.bahor.service.base.AbstractService;
import team.bahor.validator.TaskMemberValidator;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class TaskMemberServiceImp extends AbstractService<
        TaskMemberRepository,
        TaskMemberMapper,
        TaskMemberValidator
        > implements TaskMemberService {


    @Autowired
    public TaskMemberServiceImp(TaskMemberMapper mapper, TaskMemberValidator validator, TaskMemberRepository repository) {
        super(mapper, validator, repository);
    }

    //
    @Override
    public Long create(TaskMemberCreateDto createDto) {
        User user = repository.findByUsernameOfUser(createDto.getUsername());
        TaskMember taskMember = new TaskMember();
        taskMember.setTaskId(createDto.getTaskId());
        taskMember.setUserId(user.getId());
        repository.save(taskMember);
        return null;
    }

    @Override
    public void delete(Long id) {
        repository.delete(id);
    }

    @Override
    public void update(TaskMemberUpdateDto updateDto) {
//        this.updateDto = updateDto;
    }

    @Override
    public TaskMemberDto get(Long id) {
        TaskMember taskMember = repository.getByIdParam(id);
        if (Objects.isNull(taskMember)) {
            throw new IllegalArgumentException("not fond taskMember");
        }
        return getTaskMemberDto(id, taskMember);
    }
//
    private TaskMemberDto getTaskMemberDto(Long id, TaskMember taskMember) {
        User user = (User) repository.findByIdOfUser(id).orElseThrow(() -> new IllegalArgumentException("not found user"));
        TaskMemberDto taskMemberDto = new TaskMemberDto();
        taskMemberDto.setTaskId(id);
        taskMemberDto.setStatus(taskMemberDto.getStatus());
        taskMemberDto.setId(taskMember.getId());
        taskMemberDto.setUsername(user.getUsername());
        return taskMemberDto;
    }

    //
//    @Override
    public List<TaskMemberDto> getAll(Long task_id) {
        List<TaskMemberDto> dtos = new ArrayList<>();
        for (TaskMember taskMember : repository.getAllTaskMember(task_id))
            dtos.add(getTaskMemberDto(task_id, taskMember));
        return dtos;
    }

}

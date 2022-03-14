package team.bahor.service.taskMember;

import team.bahor.dto.task.TaskMemberCreateDto;
import team.bahor.dto.task.TaskMemberDto;
import team.bahor.dto.task.TaskMemberUpdateDto;
import team.bahor.service.base.GenericCrudService;

public interface TaskMemberService extends GenericCrudService<
        TaskMemberDto,
        TaskMemberCreateDto,
        TaskMemberUpdateDto,
        Long> {
}

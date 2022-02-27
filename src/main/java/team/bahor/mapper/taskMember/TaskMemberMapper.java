package team.bahor.mapper.taskMember;

import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;
import team.bahor.dto.task.TaskMemberCreateDto;
import team.bahor.dto.task.TaskMemberDto;
import team.bahor.dto.task.TaskMemberUpdateDto;
import team.bahor.entity.task.TaskMember;
import team.bahor.mapper.base.AbstractMapper;

import java.util.List;

@Component
@Mapper(componentModel = "spring")
public interface TaskMemberMapper extends AbstractMapper<
        TaskMember,
        TaskMemberDto,
        TaskMemberCreateDto,
        TaskMemberUpdateDto
        > {

}

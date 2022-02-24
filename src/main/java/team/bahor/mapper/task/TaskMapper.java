package team.bahor.mapper.task;

import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;
import team.bahor.dto.task.TaskCreateDto;
import team.bahor.dto.task.TaskDto;
import team.bahor.dto.task.TaskUpdateDto;
import team.bahor.entity.task.Task;
import team.bahor.mapper.base.AbstractMapper;
import team.bahor.mapper.base.BaseGenericMapper;

import java.util.List;

@Component
@Mapper(componentModel = "spring")
public interface TaskMapper extends AbstractMapper<
        Task,
        TaskDto,
        TaskCreateDto,
        TaskUpdateDto
        > {
}
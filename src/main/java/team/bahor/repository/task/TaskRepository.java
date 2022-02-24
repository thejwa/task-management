package team.bahor.repository.task;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import team.bahor.dto.task.TaskUpdateDto;
import team.bahor.entity.task.Task;
import team.bahor.repository.base.AbstractRepository;

import java.util.List;

public interface TaskRepository extends AbstractRepository<Task, Long> {

    @Query(value = "update Task  set updatedAt = :#{#dto.updatedAt}," +
            "updatedBy = :#{#dto.updatedBy}," +
            " description = :#{#dto.description} ," +
            " status = :#{#dto.status}" +
            ", name = :#{#dto.name}" +
            ", level = :#{#dto.level}" +
            ", priority = :#{#dto.priority}" +
            ", taskOrder = :#{#dto.taskOrder} where id = :#{#dto.id} ",
            nativeQuery = true)
    void update(@Param("dto") TaskUpdateDto dto);


    @Query(value = "select * from Task where not isDeleted and id=column_id",nativeQuery = true)
    List<Task> getAllTaskForProjectColumn(Long id);
}

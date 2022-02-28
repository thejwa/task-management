package team.bahor.repository.task;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import team.bahor.dto.task.TaskUpdateDto;
import team.bahor.entity.project.ProjectColumn;
import team.bahor.entity.task.Task;
import team.bahor.repository.base.AbstractRepository;
import team.bahor.repository.base.BaseGenericRepository;

import java.util.List;
import java.util.Optional;

public interface TaskRepository extends AbstractRepository<Task, Long>, BaseGenericRepository {

    @Modifying
    @Query(value = "update tasks  set updatedAt = dto.updatedAt," +
            "updatedBy = dto.updatedBy," +
            " description = dto.description ," +
            " status = dto.status" +
            ", name = dto.name" +
            ", level = dto.level" +
            ", priority = dto.priority" +
            ", taskOrder = dto.taskOrder where not deleted and id =: dto.id",nativeQuery = true)
    void update(@Param("dto") TaskUpdateDto dto);

    @Query(value = "select * from tasks where not deleted and column_id = ?1",nativeQuery = true)
    List<Task> getAllTasksForColumn(Long id);

    @Query(value = "select * from tasks where not deleted and  column_id = ?1  order by task_order desc limit 1",nativeQuery = true)
    Task getEndTaskOrder(Long id);

    @Modifying
    @Query(value = "update tasks set deleted = true where id= ?1",nativeQuery = true)
    void delete(Long id);

    @Query(value = "select * from tasks where not deleted and  id = ?1",nativeQuery = true)
    Optional<Task> findByIdOfTask(Long id);

    @Query(value = "select c.project_id from columns c where not c.deleted and c.id= ?1 limit 1",nativeQuery = true)
    Long getProjectIdByColumnId(Long id);

}

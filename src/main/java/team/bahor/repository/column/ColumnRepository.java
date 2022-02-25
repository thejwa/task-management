package team.bahor.repository.column;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import team.bahor.dto.column.ColumnUpdateDto;
import team.bahor.dto.task.TaskUpdateDto;
import team.bahor.entity.project.ProjectColumn;
import team.bahor.entity.task.Task;
import team.bahor.repository.base.BaseGenericRepository;

import javax.validation.constraints.NotNull;
import java.util.List;

public interface ColumnRepository extends JpaRepository<ProjectColumn,Long>, BaseGenericRepository {

    @Query(value = "update ProjectColumn  set name = :#{#dto.name}," +
            " columnOrder = :#{#dto.columnOrder} ," +
            "updatedBy = :#{#dto.updatedBy}," +
            "status = :#{#dto.status} where id = :#{#dto.id}")
    void update(@Param("dto") ColumnUpdateDto dto);


    @Query(value = "select * from ProjectColumn pc where not pc.isDeleted and pc.project_id = id",nativeQuery = true)
    List<ProjectColumn> getAllProjectForProjectColumn(Long id);

    @Query(value = "select * from ProjectColumn pc where not isDeleted and pc.id=id", nativeQuery = true)
    ProjectColumn getById(Long id);
}

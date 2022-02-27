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

    @Query(value = "update columns mns set mns.name = #{#dto.name}," +
            " mns.column_order = #{#dto.columnOrder} ," +
            "mns.updated_by = #{#dto.updatedBy}," +
            "mns.status = #{#dto.status} where mns.id = :#{#dto.id}", nativeQuery = true)
    void update(@Param("dto") ColumnUpdateDto dto);


    @Query(value = "select * from ProjectColumn pc where not pc.isDeleted and pc.project_id = id",nativeQuery = true)
    List<ProjectColumn> getAllProjectForProjectColumn(Long id);

    @Query(value = "select * from ProjectColumn pc where not isDeleted and pc.id=id", nativeQuery = true)
    ProjectColumn getById(Long id);
}

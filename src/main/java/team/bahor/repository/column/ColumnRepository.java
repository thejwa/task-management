package team.bahor.repository.column;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import team.bahor.dto.column.ColumnUpdateDto;
import team.bahor.dto.task.TaskUpdateDto;
import team.bahor.entity.project.ProjectColumn;
import team.bahor.entity.task.Task;
import team.bahor.repository.base.BaseGenericRepository;

import javax.transaction.Transactional;
import javax.validation.constraints.NotNull;
import java.util.List;

public interface ColumnRepository extends JpaRepository<ProjectColumn,Long>, BaseGenericRepository {
    @Transactional
    @Modifying
    @Query(value = "update ProjectColumn mns set mns.name = :#{#dto.name}," +
            " mns.columnOrder = :#{#dto.columnOrder} " +
            " where mns.id = :#{#dto.id}")
    void update(@Param("dto") ColumnUpdateDto dto);


    @Query(value = "select * from columns c where not c.deleted and c.project_id = id",nativeQuery = true)
    List<ProjectColumn> getAllProjectForProjectColumn(Long id);

    @Query(value = "select * from columns c where not c.deleted and c.id=id", nativeQuery = true)
    ProjectColumn getById(Long id);

    @Query(value = "select * from columns where not deleted and project_id= ?1",nativeQuery = true)
    List<ProjectColumn> findAllColumn(Long id);

    @Transactional
    @Modifying
    @Query(value = "update columns set deleted='true' where id = ?1",nativeQuery = true)
    void deleteByIdForColumn(Long id);

    @Query(value = "select c.* from columns c where  c.id= ?1",nativeQuery =true)
    ProjectColumn getProjectIdOfColumnByColumnId(Long id);

    @Query(value = "select * from columns c where not c.deleted and c.id= ?1",nativeQuery = true)
    ProjectColumn getByIdAndDeletedTrue(Long id);

    @Query(value = "select c.project_id from columns c where not deleted and id= ?1",nativeQuery = true)
    Long getProjectIdByColumnId(Long id);
}

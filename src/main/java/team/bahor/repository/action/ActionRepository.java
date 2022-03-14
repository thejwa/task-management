package team.bahor.repository.action;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import team.bahor.entity.task.Action;
import team.bahor.repository.base.BaseGenericRepository;

import java.util.List;

public interface ActionRepository extends JpaRepository<Action, Long>, BaseGenericRepository {

    @Query(value = "select * from actions where not deleted and task_id = ?1",nativeQuery = true)
    List<Action> findAllByTaskId(Long id);
}

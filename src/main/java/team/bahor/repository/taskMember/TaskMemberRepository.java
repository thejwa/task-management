package team.bahor.repository.taskMember;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import team.bahor.entity.task.TaskMember;
import team.bahor.entity.user.User;
import team.bahor.repository.base.AbstractRepository;
import team.bahor.repository.base.BaseGenericRepository;

import java.util.List;
import java.util.Optional;

public interface TaskMemberRepository extends AbstractRepository<TaskMember,Long>, BaseGenericRepository {

    @Query(value = "select * from users where not is_deleted and username = ?1;",nativeQuery = true)
    User findByUsernameOfUser(String username);

    @Modifying
    @Query(value = "update taskMembers set is_deleted = true where id = ?1",nativeQuery = true)
    Void delete(Long id);

    @Query(value = "select * from taskMembers  t where not t.is_deleted and t.task_id = ?1",nativeQuery = true)
    TaskMember getByIdParam(Long id);

    @Query(value = "select * from users where not is_deleted and id= ?1",nativeQuery = true)
    Optional<Object> findByIdOfUser(Long id);

    @Query(value = "select * from taskMembers where not is_deleted and task_id= ?1",nativeQuery = true)
    List<TaskMember> getAllTaskMember(Long id);
}

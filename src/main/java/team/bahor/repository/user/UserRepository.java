package team.bahor.repository.user;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import team.bahor.entity.user.User;
import team.bahor.repository.base.AbstractRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

public interface UserRepository extends AbstractRepository<User, Long> {
    Optional<User> findUserByUsername(String username);

    @Query(value = "select u.*\n" +
            "from users u\n" +
            "where id not in (\n" +
            "    select pm.user_id\n" +
            "    from project_member pm\n" +
            "    where not pm.deleted\n" +
            "       and pm.project_id = ?1) and u.organization_id in (select p.organization_id from projects p where not p.deleted and p.id= ?1)\n" +
            "  and not u.deleted", nativeQuery = true)
    List<User> getAllMemberForProject(Long id);

    @Transactional
    @Modifying
    @Query(value = "insert into project_member (project_id,user_id ) values ( ?2, ?1)", nativeQuery = true)
    void projectAddMember(Long id, Long projectId);

    @Query(value = "select u.* from main.users u inner join project_member pm on u.id = pm.user_id where not u.deleted and not pm.deleted and pm.project_id= ?1",nativeQuery = true)
    List<User> getProjectAllMember(Long id);

    @Transactional
    @Modifying
    @Query(value = "update project_member set deleted=true  where user_id= ?1 and project_id= ?2",nativeQuery = true)
    void deletedprojectmember(Long id,Long projectId);

    @Query(value = "select * from main.users u inner join task_member tm on u.id = tm.user_id where not u.deleted and not tm.deleted and tm.task_id= ?1",nativeQuery = true)
    List<User> getTaskMembers(Long id);


}

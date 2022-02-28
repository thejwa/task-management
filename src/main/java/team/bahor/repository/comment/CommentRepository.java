package team.bahor.repository.comment;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import team.bahor.entity.task.Comment;
import team.bahor.repository.base.BaseGenericRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment,Long> , BaseGenericRepository {
     @Query(value = "select * from comments where not deleted and task_id=?1",nativeQuery = true)
     List<Comment> getByIdForTask(Long id);
}

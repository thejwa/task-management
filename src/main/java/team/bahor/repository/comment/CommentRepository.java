package team.bahor.repository.comment;

import org.springframework.data.jpa.repository.JpaRepository;
import team.bahor.entity.task.TaskComment;

public interface CommentRepository extends JpaRepository<TaskComment,Long> {

}

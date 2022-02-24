package team.bahor.repository.column;

import org.springframework.data.jpa.repository.JpaRepository;
import team.bahor.entity.project.ProjectColumn;
import team.bahor.repository.base.BaseGenericRepository;

public interface ColumnRepository extends JpaRepository<ProjectColumn,Long>, BaseGenericRepository {
}

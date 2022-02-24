package team.bahor.repository.column;

import org.springframework.data.jpa.repository.JpaRepository;
import team.bahor.entity.column.Column;
import team.bahor.repository.base.AbstractRepository;
import team.bahor.repository.base.BaseGenericRepository;

public interface ColumnRepository extends JpaRepository<Column,Long>, BaseGenericRepository {
}

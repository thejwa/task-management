package team.bahor.repository.base;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;
import team.bahor.entity.BaseGenericEntity;

import java.io.Serializable;


@NoRepositoryBean
public interface AbstractRepository<
        E extends BaseGenericEntity,
        K extends Serializable
        > extends JpaRepository<E, K>, BaseGenericRepository {
}

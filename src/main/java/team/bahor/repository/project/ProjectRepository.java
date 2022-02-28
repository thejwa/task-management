package team.bahor.repository.project;

import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.FluentQuery;
import team.bahor.dto.project.ProjectUpdateDto;
import team.bahor.entity.project.Project;
import team.bahor.entity.project.ProjectColumn;
import team.bahor.repository.base.BaseGenericRepository;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

public interface ProjectRepository extends JpaRepository<Project, Long>, BaseGenericRepository {
    @Override
    List<Project> findAll();

    List<Project> findProjectsByOrganizationId(Long id);

    @Override
    <S extends Project> List<S> saveAll(Iterable<S> entities);

    Project getById(Long id);

    @Override
    <S extends Project> S save(S entity);

    @Override
    Optional<Project> findById(Long aLong);

    @Override
    void deleteById(Long aLong);




    //////
    @Transactional
    @Modifying
    @Query(value = "update projects set deleted=true where id=?1",nativeQuery = true)
    void setDeleted(Long id);

    @Transactional
    @Modifying
    @Query(value = "update projects set status=101 where id=?1",nativeQuery = true)
    void setBlocked(Long id);

    @Transactional
    @Modifying
    @Query(value = "update projects set status=100 where id=?1",nativeQuery = true)
    void setUnBlocked(Long id);



    @Override
    void delete(Project entity);

    @Override
    void deleteAllById(Iterable<? extends Long> longs);

    @Override
    void deleteAll();

    @Override
    <S extends Project> Optional<S> findOne(Example<S> example);

    @Override
    <S extends Project, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction);

    @Query(value = "select * from projects where not deleted and organization_id= ?1",nativeQuery = true)
    List<Project> getByOrgId(Long id);
    @Query(value = "select * from projects where  not deleted and id= ?1",nativeQuery = true)
    Project findByIdProject(Long id);

    @Query(value = "select ps.* from project_member pm  inner join projects ps on ps.id = pm.project_id where not ps.deleted  and not pm.deleted   and pm.user_id = ?1",nativeQuery = true)
    List<Project> getAllProjectsForUser(Long id);

    @Transactional
    @Modifying
    @Query(value = "update Project set name=:#{#dto.name},tz=:#{#dto.tz},description=:#{#dto.description},deadline=:localDateTime where id=:#{#dto.id}")
    void update(ProjectUpdateDto dto, LocalDateTime localDateTime);

//    @Query(value = "select * from columns pc where not pc.is_deleted and pc.project_id = id",nativeQuery = true)
//    List<ProjectColumn> getAllProjectForProjectColumn(Long id);
}

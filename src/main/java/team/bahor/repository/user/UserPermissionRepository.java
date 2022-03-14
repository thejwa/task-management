package team.bahor.repository.user;

import team.bahor.entity.user.UserPermission;
import team.bahor.repository.base.AbstractRepository;

import java.util.Optional;

public interface UserPermissionRepository extends AbstractRepository<UserPermission, Long> {
    Optional<UserPermission> findUserPermissionByCode(String code);
}

package team.bahor.repository.user;

import team.bahor.entity.user.User;
import team.bahor.repository.base.AbstractRepository;

import java.util.Optional;

public interface UserRepository extends AbstractRepository<User, Long> {
    Optional<User> findUserByUsername(String username);
}

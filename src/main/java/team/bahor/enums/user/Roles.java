package team.bahor.enums.user;

import com.google.common.collect.Sets;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Set;

@Getter
@AllArgsConstructor
public enum Roles {
    SUPER_ADMIN("SUPER_ADMIN", 10,
            Sets.newHashSet(
                    Permissions.ADMIN_CREATE,
                    Permissions.ADMIN_UPDATE,
                    Permissions.ADMIN_DELETE,
                    Permissions.ADMIN_LIST,
                    Permissions.MANAGER_CREATE,
                    Permissions.MANAGER_UPDATE,
                    Permissions.MANAGER_DELETE,
                    Permissions.MANAGER_LIST
            )),
    ADMIN("ADMIN", 6,
            Sets.newHashSet(
                    Permissions.MANAGER_CREATE,
                    Permissions.MANAGER_UPDATE,
                    Permissions.MANAGER_DELETE,
                    Permissions.MANAGER_LIST
            )),
    MANAGER("MANAGER", 3, Sets.newHashSet()),
    USER("USER", 1, Sets.newHashSet());

    private final String code;

    private final int order;

    private final Set<Permissions> permissions;
}

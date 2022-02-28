package team.bahor.enums.user;

import com.google.common.collect.Sets;
import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.management.relation.Role;
import java.util.Arrays;
import java.util.Set;

@Getter
@AllArgsConstructor
public enum Roles {
    SUPER_ADMIN("SUPER_ADMIN", 10,
            Sets.newHashSet(
                    Permissions.values()
            )),
    ADMIN("ADMIN", 6,
            Sets.newHashSet(
                    Permissions.MANAGER_CREATE,
                    Permissions.MANAGER_UPDATE,
                    Permissions.MANAGER_DELETE,
                    Permissions.MANAGER_LIST,
                    Permissions.USER_CREATE,
                    Permissions.USER_UPDATE,
                    Permissions.USER_DELETE,
                    Permissions.USER_LIST,
                    Permissions.PROJECT_CREATE,
                    Permissions.PROJECT_UPDATE,
                    Permissions.PROJECT_DELETE,
                    Permissions.PROJECT_LIST
            )),
    MANAGER("MANAGER", 3,
            Sets.newHashSet(
                    Permissions.PROJECT_CREATE,
                    Permissions.PROJECT_UPDATE,
                    Permissions.PROJECT_DELETE,
                    Permissions.PROJECT_LIST
            )),
    USER("USER", 1, Sets.newHashSet());

    private final String code;

    private final int order;

    private final Set<Permissions> permissions;

    public static Roles getRoleByCode(String code) {
        for (Roles role : Roles.values()) {
            if (role.getCode().equals(code)) {
                return role;
            }
        }
        return null;
    }
}

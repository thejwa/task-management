package team.bahor.enums.user;


import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Permissions {
    ADMIN_CREATE("ADMIN_CREATE"),
    ADMIN_UPDATE("ADMIN_UPDATE"),
    ADMIN_DELETE("ADMIN_DELETE"),
    ADMIN_LIST("ADMIN_LIST"),
    MANAGER_CREATE("MANAGER_CREATE"),
    MANAGER_UPDATE("MANAGER_UPDATE"),
    MANAGER_DELETE("MANAGER_DELETE"),
    MANAGER_LIST("MANAGER_LIST");

    private final String code;


}

package team.bahor.enums.user;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Roles {
    SUPER_ADMIN("SUPER_ADMIN", 10),
    ADMIN("ADMIN", 6),
    MANAGER("MANAGER", 3),
    USER("USER", 1);

    private final String code;

    private final int order;
}

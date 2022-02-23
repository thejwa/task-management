package team.bahor.enums.task;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Priority {
    HIGH(9),
    MEDIUM(6),
    LOW(3),
    DEFAULT(0);
    private final int power;
}

package team.bahor.utils;

import org.springframework.security.core.context.SecurityContextHolder;
import team.bahor.config.security.UserDetails;

public class BaseUtils {
    public static long sessionUserId() {
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return userDetails.getId();
    }


}

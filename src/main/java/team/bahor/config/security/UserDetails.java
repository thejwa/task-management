package team.bahor.config.security;

import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import team.bahor.entity.user.User;
import team.bahor.entity.user.UserRole;

import java.util.Collection;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class UserDetails implements org.springframework.security.core.userdetails.UserDetails {

    @Getter
    private Long id;
    private String username;
    private String password;
    private String code;
    private boolean blocked;
    private boolean active;
    private boolean deleted;
    private Set<GrantedAuthority> authorities;

    public UserDetails(User user) {
        this.id = user.getId();
        this.username = user.getUsername();
        this.password = user.getPassword();
        this.code = user.getCode();
        this.blocked = user.isBlocked();
        this.deleted = user.isDeleted();
        this.active = user.getStatus() == 0;
        processAuthorities(user);
    }

    private void processAuthorities(User user) {
        authorities = new HashSet<>();
        UserRole role = user.getUserRole();

        if (Objects.isNull(role)) return;
        authorities.add(new SimpleGrantedAuthority("ROLE_" + role.getCode()));

        if (Objects.isNull(role.getPermissions())) return;
        role.getPermissions().forEach(permission -> authorities.add(new SimpleGrantedAuthority(permission.getCode())));
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return !this.blocked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return (this.active && !this.deleted);
    }


}

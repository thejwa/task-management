package team.bahor.config.security;

import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import team.bahor.entity.organization.Organization;
import team.bahor.entity.user.User;
import team.bahor.repository.organization.OrganizationRepository;
import team.bahor.repository.user.UserRepository;

import java.util.Optional;

@Service
public class UserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {
    private final OrganizationRepository organizationRepository;
    private final UserRepository repository;

    public UserDetailsService(OrganizationRepository organizationRepository, UserRepository repository) {
        this.organizationRepository = organizationRepository;
        this.repository = repository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = repository.findUserByUsername(username).
                orElseThrow(() -> new UsernameNotFoundException("USERNAME NOT FOUND"));
        Optional<Organization> organizationOptional = organizationRepository.findById(user.getOrganizationId());
        Organization organization = null;
        if (organizationOptional.isEmpty()) {
            organization = new Organization();
            organization.setId(0L);
            organization.setStatus(0);
            organization.setDeleted(false);
        } else {
            organization = organizationOptional.get();
        }
        return new UserDetails(organization, user);
    }
}

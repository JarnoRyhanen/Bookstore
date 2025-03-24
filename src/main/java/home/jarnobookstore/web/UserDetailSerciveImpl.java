package home.jarnobookstore.web;

import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import home.jarnobookstore.domain.AppUser;
import home.jarnobookstore.domain.AppUserRepository;

@Service
public class UserDetailSerciveImpl implements UserDetailsService {

    private final AppUserRepository repository;

    public UserDetailSerciveImpl(AppUserRepository userRepository) {
    this.repository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AppUser curruser = repository.findByUsername(username);
        UserDetails user = new org.springframework.security.core.userdetails.User(username,
                curruser.getPasswordHash(),
                AuthorityUtils.createAuthorityList(curruser.getRole()));
        return user;
    }
}

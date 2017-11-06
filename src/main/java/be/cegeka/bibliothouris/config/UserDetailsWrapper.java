package be.cegeka.bibliothouris.config;

import be.cegeka.bibliothouris.domain.users.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class UserDetailsWrapper implements UserDetails {

    private User user;

    public UserDetailsWrapper(User user) {
        this.user = user;
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<SimpleGrantedAuthority> authorityList = new ArrayList<>();
        if (user.getRole().equals("USER") || user.getRole().equals("LIBRARIAN")) {
            authorityList.add(new SimpleGrantedAuthority("USER"));
        }
        if (user.getRole().equals("LIBRARIAN")) {
            authorityList.add(new SimpleGrantedAuthority("LIBRARIAN"));
        }
        return authorityList;

    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getName();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}

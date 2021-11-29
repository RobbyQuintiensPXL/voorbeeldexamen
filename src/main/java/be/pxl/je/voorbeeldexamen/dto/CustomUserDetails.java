package be.pxl.je.voorbeeldexamen.dto;

import be.pxl.je.voorbeeldexamen.entity.Doctor;
import be.pxl.je.voorbeeldexamen.entity.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class CustomUserDetails implements UserDetails {

    private final User user;

    public CustomUserDetails(User user) {
        this.user = user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return user.getAuthorities().stream()
                .map(a -> new SimpleGrantedAuthority(a.getRole()))
                .collect(Collectors.toList());
//        final List<SimpleGrantedAuthority> authorities = new LinkedList<>();
//        if(user.getRole().getLabel().equals("DOCTOR")){
//            authorities.add(new SimpleGrantedAuthority("ROLE_DOCTOR"));
//        }
//        authorities.add(new SimpleGrantedAuthority("ROLE_PATIENT"));
//        return authorities;
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getUsername();
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

    public final User getUser(){
        return user;
    }
}

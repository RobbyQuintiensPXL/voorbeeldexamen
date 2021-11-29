package be.pxl.je.voorbeeldexamen.service;

import be.pxl.je.voorbeeldexamen.dto.CustomUserDetails;
import be.pxl.je.voorbeeldexamen.entity.Doctor;
import be.pxl.je.voorbeeldexamen.entity.User;
import be.pxl.je.voorbeeldexamen.repository.DoctorRepository;
import be.pxl.je.voorbeeldexamen.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.function.Supplier;

@Service
public class JPAUserDetailService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public CustomUserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Supplier<UsernameNotFoundException> s =
                () -> new UsernameNotFoundException("Problem during authentication");

        User d = userRepository.findByUsername(username).orElseThrow(s);

        return new CustomUserDetails(d);
    }
}

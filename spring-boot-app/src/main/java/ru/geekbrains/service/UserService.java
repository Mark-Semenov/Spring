package ru.geekbrains.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        ru.geekbrains.entities.User user = userRepository.findByName(username);
        return new User(user.getName(), user.getPassword(), user.getRoles());
    }

    @Transactional
    public void saveOrUpdate(ru.geekbrains.entities.User user) {
        userRepository.save(user);
    }

    public List<ru.geekbrains.entities.User> getAllUsers() {
        return userRepository.findAll();
    }
}

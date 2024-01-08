package org.sparta.hanghae99lv4.security;

import lombok.RequiredArgsConstructor;
import org.sparta.hanghae99lv4.entity.User;
import org.sparta.hanghae99lv4.message.ErrorMessage;
import org.sparta.hanghae99lv4.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(email);
        if (user == null) {
            throw new UsernameNotFoundException(ErrorMessage.EXIST_USER_ERROR_MESSAGE.getErrorMessage());
        }

        return new UserDetailsImpl(user);
    }
}
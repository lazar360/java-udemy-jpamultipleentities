package org.ng.javaudemyjpamultipleentities.services;

import org.ng.javaudemyjpamultipleentities.models.SocialUser;
import org.ng.javaudemyjpamultipleentities.repositories.SocialUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.HandlerExceptionResolver;

import java.util.List;
import java.util.Objects;

@Service
public class SocialService {

    @Autowired
    private SocialUserRepository socialUserRepository;

    public List<SocialUser> getAllUsers() {
        return socialUserRepository.findAll();
    }

    public SocialUser saveUser(SocialUser socialUser) {
        return socialUserRepository.save(socialUser);
    }

    public void deleteUser(Long userId) {
        socialUserRepository
                .findById(userId)
                .ifPresentOrElse(socialUser -> socialUserRepository.delete(socialUser), this::throwException);
    }

    // TODO : create a UserNotFoundException Class
    private void throwException() {
        throw new RuntimeException("Social user not found");
    }


}

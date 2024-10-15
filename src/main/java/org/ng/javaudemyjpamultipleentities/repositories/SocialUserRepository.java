package org.ng.javaudemyjpamultipleentities.repositories;

import org.ng.javaudemyjpamultipleentities.models.SocialUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SocialUserRepository extends JpaRepository<SocialUser, Long> {
}

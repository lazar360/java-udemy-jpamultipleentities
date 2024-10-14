package org.ng.javaudemyjpamultipleentities.models;

import jakarta.persistence.*;
import org.springframework.context.annotation.Profile;

@Entity
public class SocialUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(mappedBy = "user")
    //@JoinColumn(name = "social_profile_id")
    private SocialProfile socialProfile;

}

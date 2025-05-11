package com.codewithmosh.store.repository;

import com.codewithmosh.store.entities.Profile;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProfileRepository extends CrudRepository<Profile, Long> {

    @Query("select p from Profile p where p.loyaltyPoints > :loyaltyPoints")
    List<Profile> findProfiles(@Param("loyaltyPoints") int loyaltyPoints);

    @Query("select u.email from User u join u.profile p where p.loyaltyPoints > :loyaltyPoints")
    List<String> findEmailsOfProfiles(@Param("loyaltyPoints") int loyaltyPoints);
}

package com.frankmoley.security.app;

import com.frankmoley.security.app.domain.Guest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<Guest,Integer> {
    Optional<Guest> findByUsername(String username) ;

    @Transactional
    @Modifying(clearAutomatically = true)
    @Query("update Guest u set u.country = :country where u.id = :id")
    int setCountry(@Param("country") String country,@Param("id") int id);

    @Transactional
    @Modifying(clearAutomatically = true)
    @Query("update Guest u set u.id = :value where u.id = :id")
    int setId(@Param("value") int value,@Param("id") int id);

}

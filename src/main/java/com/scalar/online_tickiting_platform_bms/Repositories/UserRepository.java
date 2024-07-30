package com.scalar.online_tickiting_platform_bms.Repositories;

import com.scalar.online_tickiting_platform_bms.models.User;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    // select queries will come
    // spring data jpa

    Optional<User> findByEmail(String emailId);

    @Override
    Optional<User> findById(Long userId); // finding user using UserID
    // internally it is writing select* from user where user_id =
    @Override
    User save(User user);
    //  Optional<User> findByEmailandId(Long userId);
}

/*
To create any repository follow steps
1. create repository as an interface
2. make the repository interface extends the JPA Repository interface.

 */
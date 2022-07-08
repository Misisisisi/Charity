package pl.coderslab.charity.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.charity.entity.UserEntity;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

    Optional<UserEntity> findByFirstNameAndLastName (String firstName, String lastName);

    Optional<UserEntity> findByUsernameIgnoreCase(String username);

    Optional<UserEntity> findById(Long id);

    UserEntity findUserByUsername(String username);

    UserEntity findUserByEmail(String email);
}

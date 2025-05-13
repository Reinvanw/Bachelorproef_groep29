package no_wire.no_wire.user.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import no_wire.no_wire.user.model.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    public User findById(long id);

    public List<User> findAll();

    Optional<User> findByEmail(String email);

}

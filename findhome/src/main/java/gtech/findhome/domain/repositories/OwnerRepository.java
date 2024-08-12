package gtech.findhome.domain.repositories;

import gtech.findhome.domain.entities.Owner;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface OwnerRepository extends JpaRepository<Owner, String> {
    Optional<Owner> findByLogin(String login);
}

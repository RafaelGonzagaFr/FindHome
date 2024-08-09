package gtech.findhome.domain.repositories;

import gtech.findhome.domain.entities.Owner;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OwnerRepository extends JpaRepository<Owner, String> {
}

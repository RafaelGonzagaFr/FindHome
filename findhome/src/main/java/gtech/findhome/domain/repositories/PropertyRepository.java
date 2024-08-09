package gtech.findhome.domain.repositories;

import gtech.findhome.domain.entities.Property;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PropertyRepository extends JpaRepository<Property, String> {
}

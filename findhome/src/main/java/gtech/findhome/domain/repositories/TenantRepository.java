package gtech.findhome.domain.repositories;

import gtech.findhome.domain.entities.Tenant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TenantRepository extends JpaRepository<Tenant, String> {
    Optional<Tenant> findByLogin(String login);

}

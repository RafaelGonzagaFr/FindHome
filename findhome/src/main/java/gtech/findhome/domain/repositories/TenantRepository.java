package gtech.findhome.domain.repositories;

import gtech.findhome.domain.entities.Tenant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TenantRepository extends JpaRepository<Tenant, String> {
}

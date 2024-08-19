package gtech.findhome.services;

import gtech.findhome.domain.DTOs.PropertyDTO;
import gtech.findhome.domain.DTOs.TenantDTO;
import gtech.findhome.domain.entities.Owner;
import gtech.findhome.domain.entities.Tenant;
import gtech.findhome.domain.repositories.OwnerRepository;
import gtech.findhome.domain.repositories.PropertyRepository;
import gtech.findhome.domain.repositories.TenantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class TenantService {

    @Autowired
    private TenantRepository tenantRepository;

    @Autowired
    private OwnerRepository ownerRepository;

    @Autowired
    private PropertyRepository propertyRepository;

    public List<TenantDTO> getAllTenants() {
        return tenantRepository.findAll().stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    public TenantDTO createTenant(TenantDTO tenantDTO) {
        Tenant tenant = new Tenant();
        tenant.setTenantName(tenantDTO.name());
        tenant.setLogin(tenantDTO.login());
        tenant.setPassword(new BCryptPasswordEncoder().encode("defaultPassword")); // Defina uma senha padrão ou trate o cadastro de senha de outra forma
        tenantRepository.save(tenant);
        return toDTO(tenant);
    }

    public TenantDTO updateTenant(String idTenant, TenantDTO tenantDTO) {
        Tenant tenant = tenantRepository.findById(idTenant)
                .orElseThrow(() -> new RuntimeException("Inquilino não encontrado"));

        tenant.setTenantName(tenantDTO.name());
        tenant.setLogin(tenantDTO.login());
        // Atualize a senha somente se ela estiver presente no DTO
        // tenant.setPassword(new BCryptPasswordEncoder().encode(tenantDTO.password()));

        tenantRepository.save(tenant);
        return toDTO(tenant);
    }

    public List<TenantDTO> getTenantsByOwner(String ownerId) {
        Owner owner = ownerRepository.findById(ownerId)
                .orElseThrow(() -> new RuntimeException("Proprietário não encontrado"));
        return owner.getProperties().stream()
                .map(Property::getTenant)
                .filter(Objects::nonNull)
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    private TenantDTO toDTO(Tenant tenant) {
        Set<PropertyDTO> propertiesDTO = tenant.getProperties().stream()
                .map(property -> new PropertyDTO(property.getIdProperty(), property.getAddress()))
                .collect(Collectors.toSet());
        return new TenantDTO(tenant.getIdTenant(), tenant.getTenantName(), tenant.getLogin(), propertiesDTO);
    }
}

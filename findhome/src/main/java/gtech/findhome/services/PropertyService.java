package gtech.findhome.services;

import gtech.findhome.domain.DTOs.PropertyDTO;
import gtech.findhome.domain.entities.Owner;
import gtech.findhome.domain.entities.Property;
import gtech.findhome.domain.entities.Tenant;
import gtech.findhome.domain.repositories.OwnerRepository;
import gtech.findhome.domain.repositories.PropertyRepository;
import gtech.findhome.domain.repositories.TenantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PropertyService {

    @Autowired
    private PropertyRepository propertyRepository;

    @Autowired
    private OwnerRepository ownerRepository;

    @Autowired
    private TenantRepository tenantRepository;

    public List<PropertyDTO> getAllProperties() {
        return propertyRepository.findAll().stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    public List<PropertyDTO> getPropertiesByOwner(String ownerId) {
        Owner owner = ownerRepository.findById(ownerId)
                .orElseThrow(() -> new RuntimeException("Proprietário não encontrado"));
        return owner.getProperties().stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    public List<PropertyDTO> getPropertiesByTenant(String tenantId) {
        Tenant tenant = tenantRepository.findById(tenantId)
                .orElseThrow(() -> new RuntimeException("Inquilino não encontrado"));
        return tenant.getProperties().stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    public PropertyDTO createProperty(PropertyDTO propertyDTO) {
        Property property = new Property();
        property.setAddress(propertyDTO.address());
        propertyRepository.save(property);
        return toDTO(property);
    }

    public PropertyDTO updateProperty(String idProperty, PropertyDTO propertyDTO) {
        Property property = propertyRepository.findById(idProperty)
                .orElseThrow(() -> new RuntimeException("Propriedade não encontrada"));

        property.setAddress(propertyDTO.address());
        propertyRepository.save(property);
        return toDTO(property);
    }

    private PropertyDTO toDTO(Property property) {
        return new PropertyDTO(property.getIdProperty(), property.getAddress());
    }
}

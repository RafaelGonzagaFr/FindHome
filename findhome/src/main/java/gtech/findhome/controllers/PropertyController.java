package gtech.findhome.controllers;

import gtech.findhome.domain.DTOs.PropertyDTO;
import gtech.findhome.services.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/properties")
public class PropertyController {

    @Autowired
    private PropertyService propertyService;

    @GetMapping
    public List<PropertyDTO> getAllProperties() {
        return propertyService.getAllProperties();
    }

    @GetMapping("/owner/{ownerId}")
    public List<PropertyDTO> getPropertiesByOwner(@PathVariable String ownerId) {
        return propertyService.getPropertiesByOwner(ownerId);
    }

    @GetMapping("/tenant/{tenantId}")
    public List<PropertyDTO> getPropertiesByTenant(@PathVariable String tenantId) {
        return propertyService.getPropertiesByTenant(tenantId);
    }

    @PostMapping
    public PropertyDTO createProperty(@RequestBody PropertyDTO propertyDTO) {
        return propertyService.createProperty(propertyDTO);
    }

    @PutMapping("/{idProperty}")
    public PropertyDTO updateProperty(@PathVariable String idProperty, @RequestBody PropertyDTO propertyDTO) {
        return propertyService.updateProperty(idProperty, propertyDTO);
    }
}

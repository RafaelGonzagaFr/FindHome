package gtech.findhome.controllers;

import gtech.findhome.domain.DTOs.TenantDTO;
import gtech.findhome.services.TenantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tenants")
public class TenantController {

    @Autowired
    private TenantService tenantService;

    @GetMapping
    public List<TenantDTO> getAllTenants() {
        return tenantService.getAllTenants();
    }

    @PostMapping
    public TenantDTO createTenant(@RequestBody TenantDTO tenantDTO) {
        return tenantService.createTenant(tenantDTO);
    }

    @PutMapping("/{idTenant}")
    public TenantDTO updateTenant(@PathVariable String idTenant, @RequestBody TenantDTO tenantDTO) {
        return tenantService.updateTenant(idTenant, tenantDTO);
    }

    @GetMapping("/owner/{ownerId}")
    public List<TenantDTO> getTenantsByOwner(@PathVariable String ownerId) {
        return tenantService.getTenantsByOwner(ownerId);
    }
}

package gtech.findhome.controllers;

import gtech.findhome.domain.DTOs.OwnerDTO;
import gtech.findhome.services.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/owners")
public class OwnerController {

    @Autowired
    private OwnerService ownerService;

    @GetMapping
    public List<OwnerDTO> getAllOwners() {
        return ownerService.getAllOwners();
    }

    @PostMapping
    public OwnerDTO createOwner(@RequestBody OwnerDTO ownerDTO) {
        return ownerService.createOwner(ownerDTO);
    }

    @PutMapping("/{idOwner}")
    public OwnerDTO updateOwner(@PathVariable String idOwner, @RequestBody OwnerDTO ownerDTO) {
        return ownerService.updateOwner(idOwner, ownerDTO);
    }
}

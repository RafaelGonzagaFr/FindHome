package gtech.findhome.services;

import gtech.findhome.domain.DTOs.OwnerDTO;
import gtech.findhome.domain.DTOs.PropertyDTO;
import gtech.findhome.domain.entities.Owner;
import gtech.findhome.domain.repositories.OwnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class OwnerService {

    @Autowired
    private OwnerRepository ownerRepository;

    public List<OwnerDTO> getAllOwners() {
        return ownerRepository.findAll().stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    public OwnerDTO createOwner(OwnerDTO ownerDTO) {
        Owner owner = new Owner();
        owner.setOwnerName(ownerDTO.name());
        owner.setLogin(ownerDTO.login());
        owner.setPassword(new BCryptPasswordEncoder().encode("defaultPassword")); // Defina uma senha padrão ou trate o cadastro de senha de outra forma
        ownerRepository.save(owner);
        return toDTO(owner);
    }

    public OwnerDTO updateOwner(String idOwner, OwnerDTO ownerDTO) {
        Owner owner = ownerRepository.findById(idOwner)
                .orElseThrow(() -> new RuntimeException("Proprietário não encontrado"));

        owner.setOwnerName(ownerDTO.name());
        owner.setLogin(ownerDTO.login());
        // Atualize a senha somente se ela estiver presente no DTO
        // owner.setPassword(new BCryptPasswordEncoder().encode(ownerDTO.password()));

        ownerRepository.save(owner);
        return toDTO(owner);
    }

    private OwnerDTO toDTO(Owner owner) {
        Set<PropertyDTO> propertiesDTO = owner.getProperties().stream()
                .map(property -> new PropertyDTO(property.getIdProperty(), property.getAddress()))
                .collect(Collectors.toSet());
        return new OwnerDTO(owner.getIdOwner(), owner.getOwnerName(), owner.getLogin(), propertiesDTO);
    }
}

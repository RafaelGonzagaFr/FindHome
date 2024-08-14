package gtech.findhome.domain.DTOs;

import java.util.Set;

public record OwnerDTO(
        String idOwner,
        String name,
        String login,
        Set<PropertyDTO> properties
) {
}

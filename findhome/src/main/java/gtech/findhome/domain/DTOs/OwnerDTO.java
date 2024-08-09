package gtech.findhome.domain.DTOs;

import java.util.Set;

public record OwnerDTO(
        String id,
        String name,
        String login,
        Set<PropertyDTO> properties
) {
}

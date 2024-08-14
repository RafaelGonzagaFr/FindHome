package gtech.findhome.domain.DTOs;

import java.util.Set;

public record TenantDTO(
        String idTenant,
        String name,
        String login,
        Set<PropertyDTO> properties
) {
}

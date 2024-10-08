package gtech.findhome.domain.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Table(name = "tenant")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Tenant {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String idTenant;
    private String tenantName;
    private String login;
    private String password;

    @OneToMany(mappedBy = "tenant", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Property> properties;
}

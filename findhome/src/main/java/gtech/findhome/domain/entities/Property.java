package gtech.findhome.domain.entities;

import jakarta.persistence.*;
import lombok.*;

@Table(name = "id")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Property {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String idProperty;
    private String address;

    @ManyToOne
    @JoinColumn(name = "id_owner", referencedColumnName = "idOwner", nullable = true, insertable = false, updatable = false)
    private Owner owner;

    @ManyToOne
    @JoinColumn(name = "id_tenant", referencedColumnName = "idTenant", nullable = true, insertable = false, updatable = false)
    private Tenant tenant;
}

package gtech.findhome.domain.entities;
import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Table(name = "owner")
@Entity(name = "owner")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Owner {
    @Id @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String name;
    private String login;
    private String password;

    @OneToMany(mappedBy = "owner", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Property> properties;
}

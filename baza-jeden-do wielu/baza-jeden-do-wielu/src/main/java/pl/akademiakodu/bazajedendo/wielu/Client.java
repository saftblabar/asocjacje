package pl.akademiakodu.bazajedendo.wielu;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String firstname;
    private String lastname;
    private String username;

    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL) //pamiętać, że mappedBy client tutaj musi matchować z nazwą z Zamowienie
    private Set<Zamowienie> orders = new HashSet<>(); //w secie nie doda dwa razy tego samego zamówienia

    public void addOrder(Zamowienie zamowienie) {
        zamowienie.setClient(this);
        orders.add(zamowienie);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return Objects.equals(username, client.username);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username);
    }
}

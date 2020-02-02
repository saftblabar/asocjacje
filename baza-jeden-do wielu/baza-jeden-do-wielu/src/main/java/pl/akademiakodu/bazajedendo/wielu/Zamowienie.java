package pl.akademiakodu.bazajedendo.wielu;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@Table(name="client_order")
public class Zamowienie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;



    @ManyToOne
    @JoinColumn(name="client_id") //odpowiednik Column, jak mamy do czynienia z powiązaniem (asocjacją) - to samo co agregacja. Asocjacja w SQL a agregacja w Javie.
    private Client client;
    //jedno zamówienie do danego klienta, ale klient może mieć wiele zmaówień.
    private String productName;
    private Double price;



}

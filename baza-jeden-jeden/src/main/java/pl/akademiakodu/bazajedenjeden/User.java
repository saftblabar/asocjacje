package pl.akademiakodu.bazajedenjeden;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/*
Bean: muszą być gettery i settery oraz pusty konstruktor.
Bean to klasa javowa, która ma gettery i setter i pusty konstruktor.
 */

//tutaj tworzymy jakby jadną tabelę w bazie danych (czyli "plik" w "folderze")
//@Entity tworzy tabele w bazie danych
@Table(name = "users") // nazwa tabelki w bazie to users.
@Entity
@Data // tworzy gettery settery, equals, hashcode, toString, raz konstruktory 1-argumentowe z każdym polem
@NoArgsConstructor // konstruktor domyślny, potrzebna ze względu na klasę Bean
public class User {

    @GeneratedValue(strategy = GenerationType.IDENTITY) //sprawia, że id będą generowane automatycznie 1,2,3,4,5...
    @Id //sprawia, że id będzie kluczem głónym w bazie danych.
    //klucz główny to numer, którzy w sposób jednoznaczny identyfikuje rekolr w bazie danych.
    private Integer id;

    @Column(name = "user_name") //gdy chcemy zmienić nazwę kolumny to używamy adnotacji @Column
    private String username;

    //kolumna nazywa się email. Jakby domyślnie robi adnotację @Column. @Column(name="email)
    private String email;

    //@OnetoOne  //gdy jeden uzytkownik ma dokładnie jeden wpis. jeden do jednego.
    //persist - jeśli jest robiony save, to ma też działac save na powiązaym rekordzie.
    //@CascadeType.All - kaskadowść działa wszędzie, takżę przy usunięciu.
    @OneToOne(cascade = CascadeType.PERSIST)
    private UserDetails userDetails;

}

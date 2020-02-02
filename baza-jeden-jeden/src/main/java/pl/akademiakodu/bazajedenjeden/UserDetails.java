package pl.akademiakodu.bazajedenjeden;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
public class UserDetails {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id

    private Integer id; //user details id to klucz obcy (numerek, jest on obcy, jest z innej tabeli)
    private String address;
    private String pesel;

    @OneToOne(mappedBy = "userDetails")
    private User user;
}

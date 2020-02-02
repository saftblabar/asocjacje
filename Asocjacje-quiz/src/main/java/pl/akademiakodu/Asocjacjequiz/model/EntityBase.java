package pl.akademiakodu.Asocjacjequiz.model;


import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@Data
@MappedSuperclass //mapowanie przez dziecko. Nie działa do końca jak w javie, że properties od rodzica są przejmowane, musimy pomóc dając adnotację MappedSuperclass.
public class EntityBase {

    @Id // to do id w bazie danych
    @GeneratedValue(strategy = GenerationType.IDENTITY) //strategia generowana
    private Long id;

}

package pl.akademiakodu.bazajedenjeden;

import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {

    /*
    generuje metody takie jak save(), findAll(), count()
    te wszystkie elementy które odpytują o dane w bazie danych. Wiersze w excelu, rekord w bazie danych.

    tutaj w tym intefesjie odpytujemy bazę danych, w User tworzyliśmy dane.
     */

}

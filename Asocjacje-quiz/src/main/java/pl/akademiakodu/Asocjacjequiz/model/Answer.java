package pl.akademiakodu.Asocjacjequiz.model;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@NoArgsConstructor
@Data
@Entity

//klasy dziedziczą po EntityBase bo muszą mieć id. Tam stworzyliśmy id do bazy danych
public class Answer extends EntityBase{
    //treść i bool prawidłowa czy nie

    private String name; //treść odp

    private boolean isCorrect;

    @JoinColumn(name="question_id")
    @ManyToOne
    private Question question;



    public Answer(String name, boolean isCorrect) {
        this.name = name;
        this.isCorrect = isCorrect;
    }

    public boolean isCorrect() {
        return isCorrect;
    }

}

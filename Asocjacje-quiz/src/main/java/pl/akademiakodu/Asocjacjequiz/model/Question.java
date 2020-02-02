package pl.akademiakodu.Asocjacjequiz.model;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.swing.text.StringContent;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
public class Question extends EntityBase {

    @JoinColumn(name = "test_id")
    @ManyToOne //
    private Test test;

    private String content; //treść odpowiedzi


    @OneToMany(mappedBy = "question", cascade = CascadeType.ALL) //relacja jedno pytanie - wiele odpowiedzi
    private List<Answer> answers = new ArrayList<>();

    public Question(String content) {
        this.content = content;
    }

    public void addAnswer(Answer answer) {
        answers.add(answer);
        answer.setQuestion(this);
    }

}

package pl.akademiakodu.Asocjacjequiz.DTO;


import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data

public class QuestionDTO {

    private Long id; //id zapytania do bazy
    private String content;
    private List<String> options = new ArrayList<>(); //lista niepoprawnych odp
    private String answer; //poprawna odp

    public QuestionDTO(String content) {
        this.content = content;
    }
}

package pl.akademiakodu.Asocjacjequiz.DTO;


import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class TestDTO {
private String name;
private List<QuestionDTO> questions = new ArrayList<>();

//stworzyć w QuestionDTO:
//id, contect, options, answer

}

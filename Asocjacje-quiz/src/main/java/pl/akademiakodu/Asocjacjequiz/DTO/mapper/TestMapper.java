package pl.akademiakodu.Asocjacjequiz.DTO.mapper;


import org.springframework.stereotype.Component;
import pl.akademiakodu.Asocjacjequiz.DTO.TestDTO;
import pl.akademiakodu.Asocjacjequiz.model.Question;
import pl.akademiakodu.Asocjacjequiz.model.Test;

@Component
public class TestMapper {
    private QuestionMapper questionMapper = new QuestionMapper();

    public TestDTO mapToTestDTO(Test test) { //metoda przyjmuje obiekt Test
        TestDTO testDTO = new TestDTO();
        testDTO.setName(test.getName()); //w obieckie test już jest nazwa
        testDTO.setQuestions(questionMapper.mapToListQuestionDto(test.getQuestions()));

        return testDTO;
    }
}

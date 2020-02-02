package pl.akademiakodu.Asocjacjequiz.DTO.mapper;


import org.springframework.stereotype.Component;
import pl.akademiakodu.Asocjacjequiz.DTO.QuestionDTO;
import pl.akademiakodu.Asocjacjequiz.model.Answer;
import pl.akademiakodu.Asocjacjequiz.model.Question;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class QuestionMapper {
    //wynik zapytania, które chcemy wstrzyknąć w DTO
  //  chcemy przyjąć question i oddać dto (dlatego (Question question))
    public QuestionDTO mapToQuestionDto(Question question) {
      //  nie jest to bean, więc musimy go stworzyć sami
        QuestionDTO questionDTO = new QuestionDTO(question.getContent());
        questionDTO.setId(question.getId());
        List<Answer> answers = question.getAnswers();

        List<String> answersName = new ArrayList<>();
        for (int i = 0; i < answersName.size(); i++) {
            answersName.add(answers.get(i).getName());
        }
        //drugi sposób:
        List<String>answersName2 = answers.stream()
                .map(x->x.getName())
                .collect(Collectors.toList());


        questionDTO.setOptions(answersName2);


      String correctAnswer = "";
        for (int i = 0; i < answers.size(); i++) {
            if(answers.get(i).isCorrect()) {
                correctAnswer = answers.get(i).getName();
            }
        }

        questionDTO.setAnswer(correctAnswer);
        return questionDTO;
    }
public List<QuestionDTO> mapToListQuestionDto(List<Question> questions) {
        return questions.stream()
                .map(question -> mapToQuestionDto(question))
                .collect(Collectors.toList());
}
}

package pl.akademiakodu.Asocjacjequiz.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.akademiakodu.Asocjacjequiz.DTO.TestDTO;
import pl.akademiakodu.Asocjacjequiz.DTO.mapper.TestMapper;
import pl.akademiakodu.Asocjacjequiz.model.TestRepository;

@RestController //klasa która zwraca odpowiedź Jsonową
//@Controller
@CrossOrigin //odblokowanie ruchu z zewnątrz (Na razie się nie przydaje)
@RequestMapping("/test") //każde zapytanie które będzie szło z tego adresu, trafi do tej klasy
public class TestController {

    @Autowired //wstrzykujemy beana, obiekty tej klasy są zarządzane przez springa, nie trzbea robić
    // TestMapper testMapper = new testmapper, bo spring sam tworzy i niszczy obiekty kiedy potrzebuje. Ta klasa
    //testconroller jest beanem.

    private TestMapper testMapper;
    @Autowired
    private TestRepository testRepository;


        @GetMapping("/{id}") //endpoint przyjmuje requesty typu get. typu long, bo ustawiliśmy id jako long.
//    @ResponseBody //sprawdzić co robi
    public TestDTO sayHello(@PathVariable Long id) {
        return testMapper.mapToTestDTO((testRepository.findById(id).get()));

    }
}

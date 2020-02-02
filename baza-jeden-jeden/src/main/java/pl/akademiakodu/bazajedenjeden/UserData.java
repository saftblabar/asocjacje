package pl.akademiakodu.bazajedenjeden;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

//gdy nie ma adnotacji Component, to mówi, że ta klasa jest beanem (jeśli ktoś ma beana i interfejs command line runner, to wiadoom gdzie to wstrzyknąć.
//Bez tej adnotacji Spring ignoruje tę klasę.
//jeśli chcemy wyłąćzyć generowanie tych przykłądowych danych, to usuwamy adnotację @Component.
//
@Component
public class UserData implements CommandLineRunner {

    /*
    ta metoda odpali się bezpośrednio po starcie serwera, pod warunkiem, że klasa będzie miała adnotację
    @Component
     */

    //dzieje się automagia, dependency injection
    //generowana jest klasa, która implementuje interfejs i robi SQLe
    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception{
        User user = new User();
        user.setEmail(("michalos@gmail.com"));
        user.setUsername("michalos");

        UserDetails userDetails = new UserDetails();
        userDetails.setAddress("Warszawa Wola");
        userDetails.setPesel("12345678");
        user.setUserDetails(userDetails);
        userRepository.save(user);

        UserDetails userDetails2 = new UserDetails();
        userDetails2.setAddress("Opole");
        userDetails2.setPesel("7890");

        User user2 = new User();
        user2.setEmail("placki@gmail.com");
        user2.setUsername("Johnny Bravo");
        user2.setUserDetails(userDetails2);
        userRepository.save(user2);
    }


}

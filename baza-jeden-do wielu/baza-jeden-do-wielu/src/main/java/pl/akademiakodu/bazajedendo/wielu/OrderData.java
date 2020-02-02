package pl.akademiakodu.bazajedendo.wielu;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class OrderData implements CommandLineRunner {

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private OrderRepository orderRepository;
    @Override
    public void run(String... args) throws Exception {
        Client client = new Client();
        client.setFirstname("Adam");
        client.setLastname("Kowalski");

        Zamowienie zamowienie = new Zamowienie();
        zamowienie.setPrice(2000.53);
        zamowienie.setProductName("Pralka");

        Zamowienie zamowienie2 = new Zamowienie();
        zamowienie2.setPrice(5000.99);
        zamowienie2.setProductName("Telewizor");

        client.addOrder(zamowienie);
        client.addOrder(zamowienie2);

        clientRepository.save(client);
    }


}

package com.listek.bookstore.loaders;

import com.listek.bookstore.models.Client;
import com.listek.bookstore.models.OrderHistory;
import com.listek.bookstore.repositories.ClientRepository;
import com.listek.bookstore.repositories.OrderHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(3)
public class ClientsLoader implements CommandLineRunner {

    @Autowired
    ClientRepository clientRepository;
    @Autowired
    OrderHistoryRepository orderHistoryRepository;

    @Override
    public void run(String... args) throws Exception {
        loadUserData();
    }

    private void loadUserData() {
        if (clientRepository.count() == 0) {
            Client user1 = new Client("Paulina", "Drzazga", "paudrza@gmail.com", "723242716", "paulinamapsa");
            Client user2 = new Client("Maria", "Markowiak", "m.a.markowiak@gmail.com", "123456789", "mariamakota");
            user1 = clientRepository.save(user1);
            user2 = clientRepository.save(user2);

            //#TODO Czemu nie działa dodawanie historii zamówień??

            OrderHistory orderHistory1 = new OrderHistory();
            orderHistory1.setClient(user1);
            orderHistoryRepository.save(orderHistory1);
            OrderHistory orderHistory2 = new OrderHistory();
            orderHistory2.setClient(user2);
            orderHistoryRepository.save(orderHistory2);
        }
        System.out.println("Users: " + clientRepository.count());
    }
}

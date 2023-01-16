package com.listek.bookstore.loaders;

import com.listek.bookstore.models.Client;
import com.listek.bookstore.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(3)
public class ClientsLoader implements CommandLineRunner {

    @Autowired
    ClientRepository clientRepository;

    @Override
    public void run(String... args) throws Exception {
        loadUserData();
    }

    private void loadUserData() {
        if (clientRepository.count() == 0) {
            Client user1 = new Client("Paulina", "Drzazga", "paudrza@gmail.com", "723242716", "paulinamapsa");
            Client user2 = new Client("Maria", "Markowiak", "m.a.markowiak@gmail.com", "123456789", "mariamakota");
            clientRepository.save(user1);
            clientRepository.save(user2);
        }
        System.out.println("Users: " + clientRepository.count());
    }
}

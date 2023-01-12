package com.listek.bookstore.loaders;

import com.listek.bookstore.models.UserAccount;
import com.listek.bookstore.repositories.UserAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class UserAccountsLoader implements CommandLineRunner {

    @Autowired
    UserAccountRepository userRepository;

    @Override
    public void run(String... args) throws Exception {
        loadUserData();
    }

    private void loadUserData() {
        if (userRepository.count() == 0) {
            UserAccount user1 = new UserAccount("Paulina", "Drzazga", "paudrza@gmail.com", "723242716", "paulinamapsa");
            UserAccount user2 = new UserAccount("Maria", "Markowiak", "m.a.markowiak@gmail.com", "123456789", "mariamakota");
            userRepository.save(user1);
            userRepository.save(user2);
        }
        System.out.println(userRepository.count());
    }
}

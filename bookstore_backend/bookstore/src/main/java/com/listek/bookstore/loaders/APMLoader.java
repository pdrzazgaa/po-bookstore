package com.listek.bookstore.loaders;

import com.listek.bookstore.models.APM;
import com.listek.bookstore.repositories.APMRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;


@Component
@Order(1)
public class APMLoader implements CommandLineRunner {
    @Autowired
    APMRepository apmRepository;

    @Override
    public void run(String... args) throws Exception {
        loadAPMsData();
    }

    private void loadAPMsData() {
        if (apmRepository.count() == 0) {

            APM apm1 = new APM( "WRO12B", "Curie-Skłodowskiej 64");
            APM apm2 = new APM( "WRO24C", "Norwida 5");
            APM apm3 = new APM( "WRO34D", "Krakowska 5");
            APM apm4 = new APM( "WRO12F", "Tadeusza Olszewskiego 17");
            APM apm5 = new APM( "WRO98R", "Drzymały 89");
            APM apm6 = new APM( "WRO111", "Tadeusza Kościuszki 123");
            APM apm7 = new APM( "WRO222", "Powstańców Wielkopolskich 32");
            APM apm8 = new APM( "WRO12F", "Koszarowa 1");
            APM apm9 = new APM( "WRO13B", "Pauliny Drzazgi 1");
            APM apm10 = new APM( "WRO33B", "Tramwajowa 19");
            apmRepository.save(apm1);
            apmRepository.save(apm2);
            apmRepository.save(apm3);
            apmRepository.save(apm4);
            apmRepository.save(apm5);
            apmRepository.save(apm6);
            apmRepository.save(apm7);
            apmRepository.save(apm8);
            apmRepository.save(apm9);
            apmRepository.save(apm10);

        }
        System.out.println("APMs: "+ apmRepository.count());
    }
}

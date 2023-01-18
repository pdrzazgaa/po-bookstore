package com.listek.bookstore.loaders;

import com.listek.bookstore.models.Book;
import com.listek.bookstore.models.Category;
import com.listek.bookstore.models.CoverType;
import com.listek.bookstore.repositories.BookRepository;
import com.listek.bookstore.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Class creates default data
 */
@Component
@Order(4)
public class BooksLoader implements CommandLineRunner {

    @Autowired
    BookRepository bookRepository;
    @Autowired
    CategoryRepository categoryRepository;

    @Override
    public void run(String... args) throws Exception {
        loadBooksData();
    }

    /**
     * Class creates books
     */

    private void loadBooksData() {

        if (bookRepository.count() == 0) {

            List<Category> categories = categoryRepository.findAll();

            Book book1 = new Book(9.99, 10, "Kubuś Puchatek",
                    "Wzruszające, pełne liryzmu przygody Krzysia i jego przyjaciół w Stumilowym Lesie. " +
                            "Obdarzone ludzkimi cechami charakteru zwierzątka śmieszą i bawią z jednej strony naiwnością, z drugiej-" +
                            "filozoficznym podejściem do życia. Niezwykłe ilustracje Ernesta H. Sheparda oraz doskonały przekład Ireny Tuwim " +
                            "sprawiają, że od wielu lat książki o Krzysiu, Puchatku, Kłapouchym i Prosiaczku należą do ulubionych lektur dzieci i młodzieży.",
                    "Kubuś puchatek", "A.A. Milne", "NASZA KSIĘGARNIA",
                    LocalDateTime.of(2002, 9, 1, 0, 0),
                    367, "polski", "12345", CoverType.HardCover);
            book1.addCategory(categories.get(8));
            Book book2 = new Book(19.99, 5, "Pan Tadeusz",
                    "Wyjątkowe, luksusowe wydanie, wielkiego dzieła pióra Adama Mickiewicza, Pana Tadeusza, z ilustracjami E. M. Andriollego. Prezentowana publikacja jest wzorowana na reprincie i naśladuje pierwsze wydanie epopei. Edycja została wydana z ogromną dbałością: duży format, elegancki papier, ekskluzywna okładka sprawiają, że pozycja jest znakomitą propozycją na prezent lub nagrodę.",
                    "Pan Tadeusz - Ostatni zajazd na Litwie", "Adam Mickiewicz",
                    "NASZA KSIĘGARNIA",
                    LocalDateTime.of(1997, 5, 23, 0, 0),
                    578, "polski", "12346", CoverType.SoftCover);
            book2.addCategory(categories.get(23));
            Book book3 = new Book(9.99, 10, "Kordian",
                    "Wydanie Kordiana kompletne bez skrótów i cięć w treści. W tym wydaniu znajdziesz odpowiedzi na pytania z podręcznika - pewniak na teście , czyli wskazanie zagadnień, które zwykle pojawiają się w pytaniach z danej lektury we wszelkich testach sprawdzających wiedzę, a także w podręcznikach i na klasówkach. Książka zawiera pełen tekst lektury. Na końcu książki zamieszczono opracowanie, w którym znajduje się bardzo szczegółowe streszczenie oraz drugie skrócone, ułatwiające szybkie przygotowanie się przed lekcją. Opracowanie zawiera ponadto plan wydarzeń, wnikliwie wyjaśnioną problematykę oraz szerokie charakterystyki bohaterów." +
                            "Polska pod jarzmem cara - zbrodniarza. Patrioci planują na niego zamach. Jeden z nich, tajemniczy młodzieniec w masce, podejmuje się zabić znienawidzonego tyrana. Wpisuje się tym samym w krąg działań, które zaplanował szatan u progu kolejnego stulecia. Czy mu się powiedzie? Czy ma na tyle odwagi, by działać na rzecz własnego, zniewolonego i upokorzonego narodu? A może Kordian, bo o nim tu mowa, jest zbyt słaby?",
                    "Kordian. Lektura z opracowaniem", "Juliusz Słowacki", "NASZA KSIĘGARNIA",
                    LocalDateTime.of(2000, 8, 30, 0, 0),
                    635, "polski", "12347", CoverType.HardCover);
            book3.addCategory(categories.get(23));
            Book book4 = new Book(59.99, 20, "Harry Potter i Komnata Tajemnic",
                    "Komnata tajemnic znów została otwarta. " +
                            "Słowa te prędzej czy później pojawiają się na kartach powieści J.K. Rowling. Zanim jednak do tego dojdzie, Harry ponownie pojedzie do Hogwartu, " +
                            "co wydarzy się w ciekawych okolicznościach. Zobacz, co tym razem stanie na przeszkodzie, kiedy będzie chciał udać się na pociąg do szkoły magii i czarodziejstwa. " +
                            "Z pewnością i Tobie w związku z drugim tomem cyklu Harry`ego Pottera nasuwa " +
                            "się wiele pytań: Czym jest Komnata Tajemnic? Czym grozi jej ponowne otwarcie? Gdzie można ją znaleźć? Odpowiedzi - wraz ze sporą dawką emocji - znajdziesz w książce.",
                    "Harry Potter i Komnata Tajemnic", "J.K. Rowling", "NOWA ERA",
                    LocalDateTime.of(2007, 1, 1, 0, 0),
                    426, "polski", "12320", CoverType.SoftCover);
            book4.addCategory(categories.get(12));
            Book book5 = new Book(49.99, 20, "Chołod",
                    "Nowa powieść Szczepana Twardocha, inspirowana polarnymi wyprawami autora. " +
                            "Wielka podróż przez Arktykę - ocean, łagry, miłość i przemoc. " +
                            "Pochodzący z Górnego Śląska Konrad Widuch jest weteranem Wielkiej Wojny, komunistą całym sercem oddanym rewolucji. " +
                            "Po wojnie razem z Karolem Radkiem wyjeżdża do sowieckiej Rosji i wciela w życie " +
                            "proletariacki porządek, walcząc w szeregach Konarmii w wojnie 1920 roku. " +
                            "Rewolucja jednak pożera własne dzieci. Podczas czystek 1937 roku towarzysz Widuch jako stary bolszewik " +
                            "zostaje aresztowany, skazany i wysłany do łagru, z którego jednak ucieka i tak zaczyna się jego podróż przez śniegi, lody i tundrę.",
                    "Chołod", "Twardoch Szczepan", "NASZA KSIĘGARNIA",
                    LocalDateTime.of(1997, 12, 20, 0, 0),
                    875, "polski", "76243", CoverType.HardCover);
            book5.addCategory(categories.get(19));
            book5.addCategory(categories.get(16));
            Book book6 = new Book(69.99, 100, "Empuzjon",
                    "Najnowsza powieść Olgi Tokarczuk - pierwsza po otrzymaniu Literackiej Nagrody Nobla! " +
                            "Najciekawsze pozostaje zawsze w cieniu, w tym, co niewidoczne. " +
                            "Wrzesień 1913 roku, uzdrowisko Görbersdorf (dzisiejsze Sokołowsko na Dolnym Śląsku). " +
                            "Właśnie tutaj, u podnóża gór, od przeszło pół wieku działa jedno z pierwszych na świecie i słynne w " +
                            "całej Europie specjalistyczne sanatorium leczące choroby piersiowe i gardlane." +
                            "Mieczysław Wojnicz, student ze Lwowa, przyjeżdża do uzdrowiska z nadzieją, że nowatorskie metody " +
                            "i krystalicznie czyste powietrze powstrzymają rozwój jego choroby, a może nawet całkowicie go uleczą. " +
                            "Diagnoza nie pozostawia jednak złudzeń - tuberculosis. Gruźlica." +
                            "W Pensjonacie dla Panów, gdzie zamieszkuje, poznaje innych kuracjuszy. Chorzy z Wiednia, Królewca, Breslau i Berlina przy nalewce Schwärmerei niestrudzenie " +
                            "omawiają najważniejsze sprawy tego świata. Czy Europie grozi wojna? Monarchia czy demokracja? " +
                            "Czy demony istnieją? Czy oddając się lekturze, da się rozpoznać, czyją ręką tekst został napisany - kobiety czy mężczyzny?",
                    "Empuzjon", "Tokarczuk Olga", "NOWA ERA",
                    LocalDateTime.of(1992, 7, 11, 0, 0),
                    234, "polski", "23456", CoverType.SoftCover);
            book6.addCategory(categories.get(22));
            book6.addCategory(categories.get(16));
            Book book7 = new Book(19.99, 6, "Bez cukru da się żyć, czyli ketoza po mojemu",
                    "Jeśli ciągle słyszysz:" +
                            "Dieta keto jest nudna i wyklucza naprawdę pyszne składniki." +
                            "Nie da się smacznie jeść bez cukru." +
                            "Dieta ketogeniczna jest tłusta i ciężka." +
                            "To potrzymaj mi awokado!" +
                            "Napisałam tę książkę, by opowiedzieć ci o moim doświadczeniu i wspaniałej zmianie stylu życia, a także po to, żeby obalić te mity. " +
                            "Dieta ketogeniczna to nie wyrok - to wspaniała przygoda i nowa jakość życia. " +
                            "Daj się przekonać, że można zrobić kilka wersji panierki do schabowego, kanapki niekoniecznie muszą być z chleba, a cukier da się zastąpić innymi, równie słodkimi składnikami. ",
                    "Bez cukru da się żyć, czyli ketoza po mojemu", "Katarzyna Puławska", "WIELKA SOWA",
                    LocalDateTime.of(2023, 1, 1, 0, 0),
                    765, "polski", "87765", CoverType.HardCover);
            book7.addCategory(categories.get(20));
            Book book8 = new Book(49.99, 9, "Do cna",
                    "Spowite mrokiem miasto budzi zwierzęce instynkty. Bez śladu znika młody mężczyzna, a w parku porzucono reklamówki pełne ugotowanych ludzkich kości. " +
                            "Kim jest grasujący w Żyrardowie psychopata? Zabija dla mięsa czy dla rozrywki? Jeśli detektyw " +
                            "Jakub Sobieski chce być dla niego godnym przeciwnikiem, będzie musiał sporo zaryzykować...",
                    "Do cna", "Bonda Katarzyna", "PIÓRKO",
                    LocalDateTime.of(2019, 2, 14, 0, 0),
                    455, "polski", "56752", CoverType.SoftCover);
            book8.addCategory(categories.get(21));
            Book book9 = new Book(89.99, 22, "Nim dojrzeją maliny",
                    "Trzy siostry, jedno miejsce na ziemi. Kojąca opowieść o powrocie do domu. " +
                            "Mijka właśnie się zaręczyła, ale wciąż kocha innego mężczyznę. Lilka pragnie spędzić na ukraińskiej wsi " +
                            "ostatnie lato przed wyjazdem na drugi koniec świata. " +
                            "Marta niebawem urodzi bliźniaki i nie chce zdradzić, kto jest ojcem. " +
                            "Wszystkie trzy pragną schronić się przed światem. Marzą o tym, by wziąć oddech przed kolejnym skokiem na głęboką wodę życia.",
                    "Nim dojrzeją maliny", "Eugenia Kuzniecowa", "WIELKA SOWA",
                    LocalDateTime.of(2020, 9, 27, 0, 0),
                    876, "polski", "23336", CoverType.HardCover);
            book9.addCategory(categories.get(2));
            book9.addCategory(categories.get(6));
            Book book10 = new Book(49.99, 5, "Spaleni w ogniu",
                    "Barcelończyk Ismael nie miał łatwego dzieciństwa, " +
                            "ale udało mu się zdobyć wykształcenie i podjął pracę jako nauczyciel języka i literatury. " +
                            "Pewnego dnia, szukając guzików, zagląda do pasmanterii, gdzie natyka się na koleżankę z dzieciństwa. " +
                            "Powoli zaczyna się rozwijać między nimi uczucie. Jednak przypadkowe spotkanie z woźnym ze szkoły wywraca jego życie do góry nogami. " +
                            "Ismael budzi się w dziwnym miejscu i nie wie nie tylko, kim są dziwni lekarze, ale także jak on sam ma na imię. " +
                            "Jedynie odzyskanie pamięci pozwoli mi zrozumieć, w jakich się znalazł opałach, ale okaże się ono niezwykle trudnym zadaniem.",
                    "Spaleni w ogniu", "Cabre Jaume", "PIÓRKO",
                    LocalDateTime.of(2022, 5, 4, 0, 0),
                    243, "francuski", "87524", CoverType.SoftCover);
            book10.addCategory(categories.get(13));
            Book book11 = new Book(69.99, 20, "Ten drugi",
                    "Wyczekiwana autobiografia Harryego, księcia Sussex." +
                            "Ten drugi przenosi czytelników z powrotem do jednego z najbardziej przejmujących obrazów XX wieku: dwóch młodych chłopców, " +
                            "dwoje książąt idących za trumną matki. Świat patrzył w smutku - i przerażeniu. " +
                            "Kiedy Diana, księżna Walii, spoczęła w grobie, miliardy ludzi zastanawiały się, co " +
                            "książęta muszą myśleć i czuć - i jak potoczy się ich życie." +
                            "Teraz Harry w końcu opowiada swoją historię.",
                    "Ten drugi", "Książę Harry", "NASZA KSIĘGARNIA",
                    LocalDateTime.of(2011, 12, 1, 0, 0),
                    111, "angielski", "76431", CoverType.HardCover);
            book11.addCategory(categories.get(12));
            Book book12 = new Book(39.99, 10, "Zanim wystygnie kawa",
                    "To jest książka o wycinaniu drzew." +
                            "Są takie momenty, kiedy trzeba uciekać. I są takie miejsca, do których uciec można. " +
                            "Zrządzeniem losu trzy siostry w tym samym czasie uciekają do domu swej blisko stuletniej " +
                            "babci, gdzie kiedyś, dawno temu, były naprawdę szczęśliwe. Życiowe zawirowania nie odpuszczają " +
                            "jednak łatwo i idą za trójką młodych kobiet krok w krok. I wiele się wydarzy, nim dojrzeją maliny. " +
                            "Pięknie napisana opowieść rozrasta się jak jabłoniowy sad. Przede wszystkim jednak stawia pytanie, co należy wyciąć, a co pozostawić.",
                    "Zanim wystygnie kawa", "Kawaguchi Toshikazu", "PIÓRKO",
                    LocalDateTime.of(2012, 8, 30, 0, 0),
                    543, "polski", "46342", CoverType.SoftCover);
            book12.addCategory(categories.get(11));
            book12.addCategory(categories.get(8));
            book12.addCategory(categories.get(20));
            bookRepository.save(book1);
            bookRepository.save(book2);
            bookRepository.save(book3);
            bookRepository.save(book4);
            bookRepository.save(book5);
            bookRepository.save(book6);
            bookRepository.save(book7);
            bookRepository.save(book8);
            bookRepository.save(book9);
            bookRepository.save(book10);
            bookRepository.save(book11);
            bookRepository.save(book12);
        }
        System.out.println("Books: " + bookRepository.count());
    }
}

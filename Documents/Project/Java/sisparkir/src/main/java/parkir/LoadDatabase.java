package parkir;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoadDatabase {

    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(ParkirRepository repository){
        return args -> {
            log.info("Preloading " + repository.save(new Parkir("B 1822 WAL", "01-29-2022 19.00", "01-29-2022 21.00", "Has Left"
            , 10000.00, 8)));
        };
    }

}

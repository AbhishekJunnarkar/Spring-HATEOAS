package com.projectabhishek.partyDetailService.dataloader;

import com.projectabhishek.partyDetailService.domain.Party;
import com.projectabhishek.partyDetailService.repository.PartyRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Spring Boot will run ALL CommandLineRunner beans once the application context is loaded.
 */
@Configuration
@Slf4j
public class LoadDatabase {

    @Bean
    CommandLineRunner initDatabase(PartyRepository partyRepository) {
        return args -> {
            log.info("Preloading " + partyRepository.save(new Party("Abhishek", "Brussels", "Active", "A")));
            log.info("Preloading " + partyRepository.save(new Party("Abhinav", "Mumbai", "Active", "A")));
            log.info("Preloading " + partyRepository.save(new Party("Chaitanya", "San Fransisco", "Active", "B")));
            log.info("Preloading " + partyRepository.save(new Party("Yogesh", "Nagpur", "Inactive", "C")));
        };
    }
}

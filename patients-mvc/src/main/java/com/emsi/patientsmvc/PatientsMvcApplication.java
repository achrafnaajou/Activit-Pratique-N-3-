package com.emsi.patientsmvc;

import com.emsi.patientsmvc.entities.patient;
import com.emsi.patientsmvc.repositories.patientRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@SpringBootApplication
public class PatientsMvcApplication {

    public static void main(String[] args) {
        SpringApplication.run(PatientsMvcApplication.class, args);


    }
    @Bean
    CommandLineRunner commandLineRunner(patientRepository patientRepository){
       return args ->{
           patientRepository.save (new patient(null, "Hassan",  new Date (), false,  12));
           patientRepository.save (new patient(null, "Mohamed",  new Date (), false,  27));
           patientRepository.save (new patient(null, "Yassmine",  new Date (), false,  02));
           patientRepository.save (new patient(null, "Hanae",  new Date(), false,  37));
           ;

           patientRepository.findAll().forEach(p->{
               System.out.println(p.getNom());
           });


       };
    }

}

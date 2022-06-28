package pl.sda.arppl4.hibernate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
// klasa mapowana jest na tabele
// kazda instancja tej klasy mapowana jest na rekord
@Entity  //mapowanie na tabele / encja = rekord = wpis w bazie
@NoArgsConstructor
@AllArgsConstructor

public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // AUTO_INCREMENT
    private Long id;

    private String name;
    private String surname;
    private String indexNumber;
    private LocalDate birthDate;
}

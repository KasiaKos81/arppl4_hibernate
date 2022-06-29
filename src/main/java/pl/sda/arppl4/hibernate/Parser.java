package pl.sda.arppl4.hibernate;

import pl.sda.arppl4.hibernate.dao.StudentDao;
import pl.sda.arppl4.hibernate.model.Student;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Parser {

    private Scanner scanner;

    private StudentDao studentDao;

    public Parser(Scanner scanner, StudentDao studentDao) {
        this.scanner = scanner;
        this.studentDao = studentDao;
    }

    public void ogarnij() {
        String polecenie;

        do {
            System.out.println("podaj polecenie: dodaj, usun, zwrocListe, update lub podaj 'quit' by zakonczyc");
            polecenie = scanner.next();

            switch (polecenie) {
                case "dodaj":
                    obslugaPoleceniaDodaj();
                    break;
                case "zwrocListe":
                    obslugaPoleceniaZwrocListe();
                case "usun":
                    obslugaPoleceniaUsun();
                case "update":
                    obslugaPoleceniaUpdate();



            }
        } while (!polecenie.equalsIgnoreCase("quit"));
    }

    public void obslugaPoleceniaDodaj() {
        System.out.println("Podaj imie:");
        String name = scanner.next();

        System.out.println("Podaj nazwisko:");
        String surname = scanner.next();

        System.out.println("Podaj numer indeksu");
        String indexNumber = scanner.next();

        Student student = new Student(null, name, surname, indexNumber, LocalDate.now());
        studentDao.dodajStudenta(student);
    }

    public void obslugaPoleceniaZwrocListe(){
        List<Student> studenciki = studentDao.zwrocListeStudentow();
        System.out.println("Lista studencikow " + studenciki);
    }

    public void obslugaPoleceniaUsun(){
        System.out.println("Podaj id");
        Long id = scanner.nextLong();
        Optional <Student> studencikDoWywalenia = studentDao.zwrocStudenta(id);
        if(studencikDoWywalenia.isPresent()){
            Student student = studencikDoWywalenia.get();
            studentDao.usunStudenta(student);
        }

    }



}

package pl.sda.arppl4.hibernate;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateUtil {
    public SessionFactory sessionFactory;

    public HibernateUtil() {
    }

    // do ładowania konfiguracji
    // używamy tu rejestr


    public void loadConfiguration(){
        // załadowanie "Registry" jako kolekcji parametrów konfiguracyjnych do rejestru
        // Stworzenie obiektu zawuerającego zestaw ustawień
        StandardServiceRegistry standardServiceRegistry = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();

        // Stworzenie obiektu metadata - dane opisujące połączenie z bazą danych
        Metadata metadata = new MetadataSources(standardServiceRegistry).getMetadataBuilder().build();

        // wykorzystujemy metadane do skonfugurowania/parametryzacji fabryki. Tworzymy fabrykę
        sessionFactory = metadata.getSessionFactoryBuilder().build();

    }
// a tu getter :)
    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

}

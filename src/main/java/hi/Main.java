package hi;

import org.hibernate.SessionFactory;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

/**
 * Created by azhilin on 31.01.2017.
 */
public class Main {
    public static void main(String[] args) {
        SessionFactory sessionFactory = (SessionFactory) Persistence.createEntityManagerFactory("org.hibernate.jpa");
        EntityManager entityManager = sessionFactory.createEntityManager();

        entityManager.getTransaction().begin();

        Human human1 = new Human();
        human1.setName("Alex");
        human1.setSurname("Zhilin");
        entityManager.persist(human1);

        Manager manager1 = new Manager();
        manager1.setName("Igor");
        manager1.setSurname("Ivanov");
        manager1.setCompanyName("Canon");
        entityManager.persist(manager1);

        entityManager.getTransaction().commit();
        entityManager.close();
        sessionFactory.close();
    }
}

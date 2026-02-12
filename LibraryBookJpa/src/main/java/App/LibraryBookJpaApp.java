package App;

import entity.Book;

import javax.persistence.*;
import java.util.List;

public class LibraryBookJpaApp {

    public static void main(String[] args) {

        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("libraryPU");

        EntityManager em = emf.createEntityManager();

        // ---------- INSERT ----------
        em.getTransaction().begin();

        Book b1 = new Book(1,"Java","James Gosling",
                "Programming",500,"Available",2015);

        Book b2 = new Book(2,"Spring","Rod Johnson",
                "Programming",650,"Available",2018);

        Book b3 = new Book(3,"DSA","Mark",
                "CS",550,"Issued",2016);

        em.persist(b1);
        em.persist(b2);
        em.persist(b3);

        em.getTransaction().commit();

        // ---------- FETCH BY ID ----------
        Book book = em.find(Book.class,1);
        System.out.println(book.getTitle());

        // ---------- FETCH ALL ----------
        List<Book> list =
                em.createQuery("FROM Book",Book.class)
                        .getResultList();

        list.forEach(b ->
                System.out.println(b.getTitle()));

        // ---------- UPDATE ----------
        em.getTransaction().begin();

        Book updateBook = em.find(Book.class,2);
        updateBook.setPrice(700);
        updateBook.setAvailabilityStatus("Issued");

        em.getTransaction().commit();

        // ---------- DELETE ----------
        em.getTransaction().begin();

        Book deleteBook = em.find(Book.class,3);
        em.remove(deleteBook);

        em.getTransaction().commit();

        em.close();
        emf.close();
    }
}

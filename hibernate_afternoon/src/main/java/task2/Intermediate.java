package task2;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.Transaction;


public class Intermediate {
    public static void main(String args[]) {
        Session s = Util.getSession();

        Categories cat1 = new Categories();
        cat1.setCategoryId(1);
        cat1.setCategoryName("pizza");

        Categories cat2 = new Categories();
        cat2.setCategoryId(2);
        cat2.setCategoryName("burger");


        item i1 = new item();
        item i2 = new item();

        i1.setItemId(1);
        i1.setItemName("item1");

        i2.setItemId(2);
        i2.setItemName("item2");

        Set set = new HashSet();
        set.add(i1);
        set.add(i2);

        cat1.setItems(set);
        cat2.setItems(set);

        Transaction tx = s.beginTransaction();
        s.save(cat1);
        s.save(cat2);
        tx.commit();
        System.out.println("Many to Many has been resolved");
        s.close();
    }
}
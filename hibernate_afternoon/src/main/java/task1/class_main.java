package task1;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class class_main {
    public static void main(String[] args) {
        catogery cat1 = new catogery();
        cat1.setCatId(1);
        cat1.setCatName("cool drinks");

        catogery cat2 = new catogery();
        cat2.setCatId(2);
        cat2.setCatName("milk Products");



        product prod1 = new product();
        prod1.setProdId(1);
        prod1.setProdName("Badam");

        product prod2 = new product();
        prod2.setProdId(2);
        prod2.setProdName("Kaju");



        product prod3 = new product();
        prod3.setProdId(4);
        prod3.setProdName("kismis");

        supplier sup1 = new supplier();
        sup1.setSupplierId(1);
        sup1.setSupplierName("hyd suppliers");

        supplier sup2 = new supplier();
        sup2.setSupplierId(2);
        sup2.setSupplierName("banglore suppliers");


        cat1.getSupplist().add(sup1);
        cat1.getSupplist().add(sup2);
        cat2.getSupplist().add(sup1);
        cat2.getSupplist().add(sup2);

        cat1.setProdObj(prod1);
        cat2.setProdObj(prod1);


        prod1.getCatlist().add(cat1);
        prod1.getCatlist().add(cat2);



        sup1.getCatm2m().add(cat1);
        sup1.getCatm2m().add(cat2);
        sup2.getCatm2m().add(cat1);
        sup2.getCatm2m().add(cat2);

        Configuration config = (new Configuration().configure().addAnnotatedClass(catogery.class)
                .addAnnotatedClass(supplier.class)
                .addAnnotatedClass(product.class));

        ServiceRegistry registry = new StandardServiceRegistryBuilder().applySettings(config.getProperties()).build();
        SessionFactory sfactory = config.buildSessionFactory(registry);
        Session session = sfactory.openSession();
        session.beginTransaction();

        session.save(cat1);
        session.save(cat2);

        session.save(prod1);
        session.save(prod2);
        session.save(prod3);

        session.save(sup1);
        session.save(sup2);
        session.getTransaction().commit();
    }
}


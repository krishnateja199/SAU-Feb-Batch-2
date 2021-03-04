package task3;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class class_main {
    public static void main(String[] args) {
        audience a1 = new audience();
        a1.setAge(21);
        a1.setName("rajesh");

        audience a2 = new audience();
        a2.setAge(22);
        a2.setName("yashwanth");


        screen st = new screen();
        st.setScreenno(1);
        st.setShowtime(4);
        st.setName("cinepolis");

        a1.setScreen1(st);
        a2.setScreen1(st);

        st.getAudience().add(a1);
        st.getAudience().add(a2);


        Configuration config = new Configuration().configure().addAnnotatedClass(screen.class).addAnnotatedClass(audience.class);
        ServiceRegistry registry = new StandardServiceRegistryBuilder().applySettings(config.getProperties()).build();
        SessionFactory sf = config.buildSessionFactory(registry);
        Session session = sf.openSession();

        session.beginTransaction();
        session.save(a1);
        session.save(a2);
        session.save(st);
        session.getTransaction().commit();
    }
}



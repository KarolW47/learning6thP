import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class DBConnector {

    //creating SessionFactory and passing config to connect with DB
    public SessionFactory sessionFactory() {
        StandardServiceRegistry standardServiceRegistry = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();

        Metadata meta = new MetadataSources(standardServiceRegistry).getMetadataBuilder().build();

        return meta.getSessionFactoryBuilder().build();
    }

    public Session openSession(){
        return sessionFactory().openSession();
    }

    public Transaction beginTransaction(){
        return openSession().beginTransaction();
    }
}

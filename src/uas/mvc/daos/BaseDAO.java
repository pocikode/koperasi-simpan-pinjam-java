package uas.mvc.daos;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author agus
 */
abstract public class BaseDAO {
    protected Session session;
    protected final SessionFactory sessionFactory;

    public BaseDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    protected void openSession() {
        this.session = this.sessionFactory.openSession();
    }
}

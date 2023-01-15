package uas.mvc.daos;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import uas.mvc.models.Anggota;
import uas.mvc.models.SaldoAnggota;

/**
 *
 * @author agus
 */
public class SaldoAnggotaDAO extends BaseDAO {

    public SaldoAnggotaDAO(SessionFactory sessionFactory) {
        super(sessionFactory);
    }
    
    public boolean insert(SaldoAnggota saldoAnggota) {
        try {
            this.openSession();
            session.beginTransaction();
            Long id = (Long) session.save(saldoAnggota);
            session.getTransaction().commit();
            return id != null;
        } catch (Exception e) {
            Logger.getLogger(AnggotaDAO.class.getName()).log(Level.SEVERE, null, e);
            session.getTransaction().rollback();
            throw e;
        } finally {
            session.close();
        }
    }
    
    public boolean update(SaldoAnggota saldoAnggota) {
        try {
            this.openSession();
            session.beginTransaction();
            session.update(saldoAnggota);
            session.getTransaction().commit();
            return true;
        } catch (Exception e) {
            Logger.getLogger(AnggotaDAO.class.getName()).log(Level.SEVERE, null, e);
            session.getTransaction().rollback();
        } finally {
            session.close();
        }

        return false;
    }

    public SaldoAnggota getSaldoAnggotaByAnggota(Anggota anggota) {
        try {
            this.openSession();
            Query q = session.createQuery("FROM SaldoAnggota sa WHERE sa.anggota=:nik");
            q.setParameter("nik", anggota);
            return (SaldoAnggota) q.uniqueResult();
        } catch (Exception e) {
            Logger.getLogger(SaldoAnggotaDAO.class.getName()).log(Level.SEVERE, null, e);
            session.getTransaction().rollback();
        } finally {
            session.close();
        }

        return null;
    }
}

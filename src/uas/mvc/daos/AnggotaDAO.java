package uas.mvc.daos;

import java.util.List;
import uas.mvc.models.Anggota;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import uas.mvc.models.SaldoAnggota;

/**
 *
 * @author agus
 */
public class AnggotaDAO extends BaseDAO {

    public AnggotaDAO(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    public boolean insert(Anggota anggota) {
        try {
            this.openSession();
            session.beginTransaction();
            SaldoAnggota saldo = anggota.getSaldoAnggota();
            Long id = (Long) session.save(anggota);

            if (saldo != null) {
                saldo.setAnggota(anggota);
                session.saveOrUpdate(saldo);
            }

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

    public boolean update(Anggota anggota) {
        try {
            this.openSession();
            session.beginTransaction();
            session.update(anggota);
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

    public boolean delete(Anggota anggota) {
        try {
            this.openSession();
            session.beginTransaction();
            session.delete(anggota);
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

    public Anggota getAnggotaByNIK(Long nik) {
        try {
            this.openSession();
            Query q = session.createQuery("FROM Anggota a WHERE a.nik=:nik");
            q.setParameter("nik", nik);
            return (Anggota) q.uniqueResult();
        } catch (Exception e) {
            Logger.getLogger(AnggotaDAO.class.getName()).log(Level.SEVERE, null, e);
            session.getTransaction().rollback();
        } finally {
            session.close();
        }

        return null;
    }

    public List<Anggota> fetchAnggota() {
        try {
            this.openSession();
            return session.createQuery("FROM Anggota", Anggota.class).list();
        } catch (Exception e) {
            Logger.getLogger(AnggotaDAO.class.getName()).log(Level.SEVERE, null, e);
            session.getTransaction().rollback();
            throw e;
        } finally {
            session.close();
        }
    }

    public Long getTotalAnggota() {
        try {
            this.openSession();
            Query query = session.createQuery("SELECT COUNT(*) FROM Anggota a");

            return (Long) query.getSingleResult();
        } catch (Exception e) {
            Logger.getLogger(AnggotaDAO.class.getName()).log(Level.SEVERE, null, e);
            session.getTransaction().rollback();
            throw e;
        } finally {
            session.close();
        }
    }
}

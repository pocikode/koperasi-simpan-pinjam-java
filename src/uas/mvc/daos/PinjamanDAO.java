package uas.mvc.daos;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import uas.mvc.models.Anggota;
import uas.mvc.models.Pinjaman;
import uas.mvc.models.SaldoAnggota;

/**
 *
 * @author agus
 */
public class PinjamanDAO extends BaseDAO {

    private final SaldoAnggotaDAO saldoAnggotaDAO;

    public PinjamanDAO(SessionFactory sessionFactory) {
        super(sessionFactory);
        saldoAnggotaDAO = new SaldoAnggotaDAO(sessionFactory);
    }

    public boolean insert(Pinjaman pinjaman) {
        try {
            this.openSession();
            session.beginTransaction();

            SaldoAnggota saldo = saldoAnggotaDAO.getSaldoAnggotaByAnggota(pinjaman.getAnggota());
            saldo.setSisaPinjaman(saldo.getSisaPinjaman() + pinjaman.getTotalPinjaman());
            saldoAnggotaDAO.update(saldo);

            Integer id = (Integer) session.save(pinjaman);
            session.getTransaction().commit();
            return id != null;
        } catch (Exception e) {
            Logger.getLogger(PinjamanDAO.class.getName()).log(Level.SEVERE, null, e);
            session.getTransaction().rollback();
            throw e;
        } finally {
            session.close();
        }
    }

    public boolean update(Pinjaman pinjaman) {
        try {
            this.openSession();
            session.beginTransaction();
            session.update(pinjaman);
            session.getTransaction().commit();
            return true;
        } catch (Exception e) {
            Logger.getLogger(PinjamanDAO.class.getName()).log(Level.SEVERE, null, e);
            session.getTransaction().rollback();
        } finally {
            session.close();
        }

        return false;
    }

    public Pinjaman getPinjamanBelumLuasByAnggota(Anggota anggota) {
        try {
            this.openSession();
            Query q = session.createQuery("FROM Pinjaman p WHERE p.anggota=:nik AND p.status=:status");
            q.setParameter("nik", anggota)
                    .setParameter("status", Pinjaman.PinjamanStatus.BELUM_LUNAS);

            return (Pinjaman) q.uniqueResult();
        } catch (Exception e) {
            Logger.getLogger(PinjamanDAO.class.getName()).log(Level.SEVERE, null, e);
            session.getTransaction().rollback();
        } finally {
            session.close();
        }

        return null;
    }

    public Pinjaman getPinjaman(Integer id) {
        try {
            this.openSession();
            Query q = session.createQuery("FROM Pinjaman p WHERE sa.id=:id");
            q.setParameter("id", id);
            return (Pinjaman) q.uniqueResult();
        } catch (Exception e) {
            Logger.getLogger(SaldoAnggotaDAO.class.getName()).log(Level.SEVERE, null, e);
            session.getTransaction().rollback();
        } finally {
            session.close();
        }

        return null;
    }

    public List<Pinjaman> fetchPinjaman() {
        try {
            this.openSession();
            return session.createQuery("FROM Pinjaman", Pinjaman.class).list();
        } catch (Exception e) {
            Logger.getLogger(PinjamanDAO.class.getName()).log(Level.SEVERE, null, e);
            session.getTransaction().rollback();
            throw e;
        } finally {
            session.close();
        }
    }

    public Long getTotalPinjaman() {
        try {
            this.openSession();
            Query query = session.createQuery("SELECT SUM(jumlah) FROM Pinjaman p");

            return (Long) query.getSingleResult();
        } catch (Exception e) {
            Logger.getLogger(PinjamanDAO.class.getName()).log(Level.SEVERE, null, e);
            session.getTransaction().rollback();
            throw e;
        } finally {
            session.close();
        }
    }

}

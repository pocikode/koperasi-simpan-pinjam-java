package uas.mvc.daos;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.SessionFactory;
import uas.mvc.models.SaldoAnggota;
import uas.mvc.models.Simpanan;

/**
 *
 * @author agus
 */
public class SimpananDAO extends BaseDAO {

    private final SaldoAnggotaDAO saldoAnggotaDAO;

    public SimpananDAO(SessionFactory sessionFactory) {
        super(sessionFactory);
        saldoAnggotaDAO = new SaldoAnggotaDAO(sessionFactory);
    }

    public boolean insert(Simpanan simpanan) {
        try {
            this.openSession();
            session.beginTransaction();

            SaldoAnggota saldo = saldoAnggotaDAO.getSaldoAnggotaByAnggota(simpanan.getAnggota());

            Long saldoAwal = saldo.getSaldoSimpanan();
            Long saldoAkhir = saldo.getSaldoSimpanan();

            if (simpanan.getType() == Simpanan.SimpananType.CREDIT) {
                saldoAkhir += simpanan.getJumlah();
            } else {
                saldoAkhir -= simpanan.getJumlah();
            }

            saldo.setSaldoSimpanan(saldoAkhir);
            saldoAnggotaDAO.update(saldo);

            simpanan.setSaldoAwal(saldoAwal);
            simpanan.setSaldoAkhir(saldoAkhir);
            Integer id = (Integer) session.save(simpanan);
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
    
    public List<Simpanan> fetchSimpanan() {
        try {
            this.openSession();
            return session.createQuery("FROM Simpanan", Simpanan.class).list();
        } catch (Exception e) {
            Logger.getLogger(SimpananDAO.class.getName()).log(Level.SEVERE, null, e);
            session.getTransaction().rollback();
            throw e;
        } finally {
            session.close();
        }
    }
}

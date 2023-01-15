package uas.mvc.daos;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.SessionFactory;
import uas.mvc.models.Angsuran;
import uas.mvc.models.Pinjaman;
import uas.mvc.models.SaldoAnggota;

/**
 *
 * @author agus
 */
public class AngsuranDAO extends BaseDAO {

    private final PinjamanDAO pinjamanDAO;
    private final SaldoAnggotaDAO saldoAnggotaDAO;

    public AngsuranDAO(SessionFactory sessionFactory) {
        super(sessionFactory);
        pinjamanDAO = new PinjamanDAO(sessionFactory);
        saldoAnggotaDAO = new SaldoAnggotaDAO(sessionFactory);
    }

    public boolean insert(Angsuran angsuran) {
        try {
            this.openSession();
            session.beginTransaction();

            SaldoAnggota saldo = saldoAnggotaDAO.getSaldoAnggotaByAnggota(angsuran.getAnggota());

            Long sisaPinjaman = saldo.getSisaPinjaman() - angsuran.getJumlah();
            if (sisaPinjaman <= Long.valueOf(0)) {
                Pinjaman pinjaman = pinjamanDAO.getPinjaman(angsuran.getPinjaman().getId());
                pinjaman.setStatus(Pinjaman.PinjamanStatus.LUNAS);
                
                pinjamanDAO.update(pinjaman);
            }

            saldo.setSisaPinjaman(sisaPinjaman);
            saldoAnggotaDAO.update(saldo);

            Integer id = (Integer) session.save(angsuran);
            session.getTransaction().commit();
            return id != null;
        } catch (Exception e) {
            Logger.getLogger(AngsuranDAO.class.getName()).log(Level.SEVERE, null, e);
            session.getTransaction().rollback();
            throw e;
        } finally {
            session.close();
        }
    }

    public List<Angsuran> fetchAngsuran() {
        try {
            this.openSession();
            return session.createQuery("FROM Angsuran", Angsuran.class).list();
        } catch (Exception e) {
            Logger.getLogger(AnggotaDAO.class.getName()).log(Level.SEVERE, null, e);
            session.getTransaction().rollback();
            throw e;
        } finally {
            session.close();
        }
    }
}

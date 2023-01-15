package uas.mvc.controllers;

import java.util.List;
import uas.mvc.daos.AnggotaDAO;
import uas.mvc.models.Anggota;
import uas.mvc.models.CRUD;
import static uas.mvc.models.CRUD.UPDATE;
import uas.mvc.utils.HibernateUtil;

/**
 *
 * @author agus
 */
public class AnggotaController {

    private AnggotaDAO dao;

    public AnggotaController() {
        setDAO();
    }

    private void setDAO() {
        if (dao == null) {
            dao = new AnggotaDAO(HibernateUtil.getSessionFactory());
        }
    }

    public void setDML(Anggota anggota, CRUD c) {
        switch (c) {
            case CREATE:
                dao.insert(anggota);
                break;
            case UPDATE:
                dao.update(anggota);
                break;
            case DELETE:
                dao.delete(anggota);
                break;
        }
    }
    
    public Anggota getAnggotaByNIK(Long nik) {
        return dao.getAnggotaByNIK(nik);
    }

    public List<Anggota> fetchAnggota() {
        return dao.fetchAnggota();
    }
}

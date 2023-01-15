package uas.mvc.controllers;

import java.util.List;
import uas.mvc.daos.SaldoAnggotaDAO;
import uas.mvc.daos.SimpananDAO;
import uas.mvc.models.CRUD;
import static uas.mvc.models.CRUD.CREATE;
import static uas.mvc.models.CRUD.DELETE;
import static uas.mvc.models.CRUD.UPDATE;
import uas.mvc.models.Simpanan;
import uas.mvc.utils.HibernateUtil;

/**
 *
 * @author agus
 */
public class SimpananController {

    private SimpananDAO dao;

    public SimpananController() {
        setDAO();
    }

    private void setDAO() {
        dao = new SimpananDAO(HibernateUtil.getSessionFactory());
    }

    public void setDML(Simpanan simpanan, CRUD c) {
        switch (c) {
            case CREATE:
                dao.insert(simpanan);
                break;
            case UPDATE:
//                dao.update(simpanan);
                break;
            case DELETE:
//                dao.delete(simpanan);
                break;
        }
    }
    
    public List<Simpanan> fetchSimpanan() {
        return dao.fetchSimpanan();
    }

}

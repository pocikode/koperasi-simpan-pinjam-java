package uas.mvc.controllers;

import java.util.List;
import uas.mvc.daos.AngsuranDAO;
import uas.mvc.models.Angsuran;
import uas.mvc.models.CRUD;
import static uas.mvc.models.CRUD.CREATE;
import static uas.mvc.models.CRUD.DELETE;
import static uas.mvc.models.CRUD.UPDATE;
import uas.mvc.utils.HibernateUtil;

/**
 *
 * @author agus
 */
public class AngsuranController {

    private AngsuranDAO dao;

    public AngsuranController() {
        setDAO();
    }

    private void setDAO() {
        dao = new AngsuranDAO(HibernateUtil.getSessionFactory());
    }

    public void setDML(Angsuran angsuran, CRUD c) {
        switch (c) {
            case CREATE:
                dao.insert(angsuran);
                break;
            case UPDATE:
                break;
            case DELETE:
                break;
        }
    }

    public List<Angsuran> fetchAngsuran() {
        return dao.fetchAngsuran();
    }
}

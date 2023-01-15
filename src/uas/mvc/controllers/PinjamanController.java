package uas.mvc.controllers;

import java.util.List;
import uas.mvc.daos.PinjamanDAO;
import uas.mvc.models.Anggota;
import uas.mvc.models.CRUD;
import static uas.mvc.models.CRUD.CREATE;
import static uas.mvc.models.CRUD.DELETE;
import static uas.mvc.models.CRUD.UPDATE;
import uas.mvc.models.Pinjaman;
import uas.mvc.utils.HibernateUtil;

/**
 *
 * @author agus
 */
public class PinjamanController {

    private PinjamanDAO dao;

    public PinjamanController() {
        setDAO();
    }

    private void setDAO() {
        dao = new PinjamanDAO(HibernateUtil.getSessionFactory());
    }

    public void setDML(Pinjaman pinjaman, CRUD c) {
        switch (c) {
            case CREATE:
                dao.insert(pinjaman);
                break;
            case UPDATE:
//                dao.update(simpanan);
                break;
            case DELETE:
//                dao.delete(simpanan);
                break;
        }
    }

    public List<Pinjaman> fetchPinjaman() {
        return dao.fetchPinjaman();
    }

    public Pinjaman getPinjamanBelumLuasByAnggota(Anggota anggota) {
        return dao.getPinjamanBelumLuasByAnggota(anggota);
    }

    public Long getTotalPinjaman() {
        return dao.getTotalPinjaman();
    }
}

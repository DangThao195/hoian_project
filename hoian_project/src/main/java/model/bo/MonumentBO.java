package model.bo;

import java.util.List;
import model.bean.Monument;
import model.dao.MonumentDAO;

public class MonumentBO {
    private MonumentDAO monumentDAO = new MonumentDAO();

    public boolean addMonument(Monument m) {
        return monumentDAO.addMonument(m);
    }

    public boolean updateMonument(Monument m) {
        return monumentDAO.updateMonument(m);
    }

    public boolean deleteMonument(String id) {
        return monumentDAO.deleteMonument(id);
    }

    public Monument getMonumentById(String id) {
        return monumentDAO.getMonumentById(id);
    }

    public List<Monument> getAllMonuments() {
        return monumentDAO.getAllMonuments();
    }

    public List<Monument> searchMonument(String keyword) {
        return monumentDAO.searchMonument(keyword);
    }
}

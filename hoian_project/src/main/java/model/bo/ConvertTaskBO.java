package model.bo;

import java.util.List;
import model.bean.ConvertTask;
import model.dao.ConvertTaskDAO;

public class ConvertTaskBO {

    private ConvertTaskDAO convertTaskDAO = new ConvertTaskDAO();

    public boolean addTask(ConvertTask task) {
        return convertTaskDAO.addTask(task);
    }

    public boolean updateStatus(String id, String status, String outputPath) {
        return convertTaskDAO.updateStatus(id, status, outputPath);
    }

    public ConvertTask getTaskById(String id) {
        return convertTaskDAO.getTaskById(id);
    }

    public List<ConvertTask> getTasksByUser(String userId) {
        return convertTaskDAO.getTasksByUser(userId);
    }
}

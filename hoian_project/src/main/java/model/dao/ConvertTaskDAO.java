package model.dao;

import java.sql.*;
import java.util.*;
import model.bean.ConvertTask;

public class ConvertTaskDAO {

    public boolean addTask(ConvertTask task) {
        String sql = "INSERT INTO convert_task (id, user_id, input_file_path, output_file_path, status, created_at) " +
                     "VALUES (UUID(), ?, ?, ?, ?, NOW())";
        try (Connection conn = ConnectDB.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, task.getUserId());
            ps.setString(2, task.getInputFilePath());
            ps.setString(3, task.getOutputFilePath());
            ps.setString(4, task.getStatus());

            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean updateStatus(String id, String status, String outputPath) {
        String sql = "UPDATE convert_task SET status = ?, output_file_path = ?, finished_at = NOW() WHERE id = ?";
        try (Connection conn = ConnectDB.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, status);
            ps.setString(2, outputPath);
            ps.setString(3, id);

            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public ConvertTask getTaskById(String id) {
        String sql = "SELECT * FROM convert_task WHERE id = ?";
        try (Connection conn = ConnectDB.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return new ConvertTask(
                        rs.getString("id"),
                        rs.getString("user_id"),
                        rs.getString("input_file_path"),
                        rs.getString("output_file_path"),
                        rs.getString("status"),
                        rs.getTimestamp("created_at"),
                        rs.getTimestamp("finished_at")
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<ConvertTask> getTasksByUser(String userId) {
        List<ConvertTask> list = new ArrayList<>();
        String sql = "SELECT * FROM convert_task WHERE user_id = ? ORDER BY created_at DESC";
        try (Connection conn = ConnectDB.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, userId);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                list.add(new ConvertTask(
                        rs.getString("id"),
                        rs.getString("user_id"),
                        rs.getString("input_file_path"),
                        rs.getString("output_file_path"),
                        rs.getString("status"),
                        rs.getTimestamp("created_at"),
                        rs.getTimestamp("finished_at")
                ));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}

package model.dao;

import java.sql.*;
import java.util.*;
import model.bean.Comment;

public class CommentDAO {

    public boolean addComment(Comment cmt) {
        String sql = "INSERT INTO comment (id, user_id, monument_id, star, content) VALUES (UUID(), ?, ?, ?, ?)";
        try (Connection conn = ConnectDB.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, cmt.getUserId());
            ps.setString(2, cmt.getMonumentId());
            ps.setInt(3, cmt.getStar());
            ps.setString(4, cmt.getContent());
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean updateComment(Comment cmt) {
        String sql = "UPDATE comment SET star = ?, content = ? WHERE id = ?";
        try (Connection conn = ConnectDB.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, cmt.getStar());
            ps.setString(2, cmt.getContent());
            ps.setString(3, cmt.getId());
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean deleteComment(String id) {
        String sql = "DELETE FROM comment WHERE id = ?";
        try (Connection conn = ConnectDB.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, id);
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public List<Comment> getCommentsByUser(String userId) {
        List<Comment> list = new ArrayList<>();
        String sql = "SELECT * FROM comment WHERE user_id = ? ORDER BY created_at DESC";
        try (Connection conn = ConnectDB.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, userId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(mapComment(rs));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public List<Comment> getCommentsByMonument(String monumentId) {
        List<Comment> list = new ArrayList<>();
        String sql = "SELECT * FROM comment WHERE monument_id = ? ORDER BY created_at DESC";
        try (Connection conn = ConnectDB.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, monumentId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(mapComment(rs));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public List<Comment> getAllComments() {
        List<Comment> list = new ArrayList<>();
        String sql = "SELECT * FROM comment ORDER BY created_at DESC";
        try (Connection conn = ConnectDB.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                list.add(mapComment(rs));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    private Comment mapComment(ResultSet rs) throws SQLException {
        return new Comment(
                rs.getString("id"),
                rs.getString("user_id"),
                rs.getString("monument_id"),
                rs.getInt("star"),
                rs.getString("content"),
                rs.getTimestamp("created_at")
        );
    }
}

package model.bo;

import java.util.List;
import model.bean.Comment;
import model.dao.CommentDAO;

public class CommentBO {
    private CommentDAO commentDAO = new CommentDAO();

    public boolean addComment(Comment c) {
        return commentDAO.addComment(c);
    }

    public boolean updateComment(Comment c) {
        return commentDAO.updateComment(c);
    }

    public boolean deleteComment(String id) {
        return commentDAO.deleteComment(id);
    }

    public List<Comment> getCommentsByUser(String userId) {
        return commentDAO.getCommentsByUser(userId);
    }

    public List<Comment> getCommentsByMonument(String monumentId) {
        return commentDAO.getCommentsByMonument(monumentId);
    }

    public List<Comment> getAllComments() {
        return commentDAO.getAllComments();
    }
}

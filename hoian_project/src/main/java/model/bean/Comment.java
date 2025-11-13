package model.bean;

import java.util.Date;

public class Comment {
    private String id;
    private String userId;
    private String monumentId;
    private int star;
    private String content;
    private Date createdAt;

    public Comment() {}

    public Comment(String id, String userId, String monumentId, int star, String content, Date createdAt) {
        this.id = id;
        this.userId = userId;
        this.monumentId = monumentId;
        this.star = star;
        this.content = content;
        this.createdAt = createdAt;
    }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getUserId() { return userId; }
    public void setUserId(String userId) { this.userId = userId; }

    public String getMonumentId() { return monumentId; }
    public void setMonumentId(String monumentId) { this.monumentId = monumentId; }

    public int getStar() { return star; }
    public void setStar(int star) { this.star = star; }

    public String getContent() { return content; }
    public void setContent(String content) { this.content = content; }

    public Date getCreatedAt() { return createdAt; }
    public void setCreatedAt(Date createdAt) { this.createdAt = createdAt; }
}

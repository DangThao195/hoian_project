package model.bean;

import java.util.Date;

public class ConvertTask {
    private String id;
    private String userId;
    private String inputFilePath;
    private String outputFilePath;
    private String status;
    private Date createdAt;
    private Date finishedAt;

    public ConvertTask() {}

    public ConvertTask(String id, String userId, String inputFilePath, String outputFilePath, String status, Date createdAt, Date finishedAt) {
        this.id = id;
        this.userId = userId;
        this.inputFilePath = inputFilePath;
        this.outputFilePath = outputFilePath;
        this.status = status;
        this.createdAt = createdAt;
        this.finishedAt = finishedAt;
    }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getUserId() { return userId; }
    public void setUserId(String userId) { this.userId = userId; }

    public String getInputFilePath() { return inputFilePath; }
    public void setInputFilePath(String inputFilePath) { this.inputFilePath = inputFilePath; }

    public String getOutputFilePath() { return outputFilePath; }
    public void setOutputFilePath(String outputFilePath) { this.outputFilePath = outputFilePath; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public Date getCreatedAt() { return createdAt; }
    public void setCreatedAt(Date createdAt) { this.createdAt = createdAt; }

    public Date getFinishedAt() { return finishedAt; }
    public void setFinishedAt(Date finishedAt) { this.finishedAt = finishedAt; }
}

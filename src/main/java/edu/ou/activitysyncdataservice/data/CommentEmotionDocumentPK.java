package edu.ou.activitysyncdataservice.data;

import lombok.Data;

@Data
public class CommentEmotionDocumentPK {
    private int commentId;
    private int userId;
    private int emotionId;
}

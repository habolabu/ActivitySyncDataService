package edu.ou.activitysyncdataservice.data;

import lombok.Data;

@Data
public class PostEmotionDocumentPK {
    private int postId;
    private int userId;
    private int emotionId;
}

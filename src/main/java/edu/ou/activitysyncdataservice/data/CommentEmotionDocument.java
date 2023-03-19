package edu.ou.activitysyncdataservice.data;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Data
@Document("CommentEmotion")
public class CommentEmotionDocument implements Serializable {
    @Id
    private String id;
    private int oId;
    private int commentId;
    private int userId;
    private int emotionId;
}

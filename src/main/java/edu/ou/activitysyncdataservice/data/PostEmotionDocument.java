package edu.ou.activitysyncdataservice.data;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Data
@Document("PostEmotion")
public class PostEmotionDocument implements Serializable {
    @Id
    private String id;
    private int postId;
    private int userId;
    private int emotionId;
}

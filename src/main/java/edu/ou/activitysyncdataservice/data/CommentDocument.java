package edu.ou.activitysyncdataservice.data;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.Date;

@Data
@Document("Comment")
public class CommentDocument implements Serializable {
    @Id
    private String id;
    private int oId;
    private String content;
    private int totalEmotion;
    private Date createdAt;
    private int userId;
    private int postId;
    private Integer commentId;
}

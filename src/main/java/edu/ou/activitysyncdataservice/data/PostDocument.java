package edu.ou.activitysyncdataservice.data;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.Date;

@Data
@Document("Post")
public class PostDocument implements Serializable {
    @Id
    private String id;
    private int oId;
    private String title;
    private String slug;
    private String content;
    private int totalComment;
    private int totalEmotion;
    private Date createdAt;
    private boolean isEdited;
}

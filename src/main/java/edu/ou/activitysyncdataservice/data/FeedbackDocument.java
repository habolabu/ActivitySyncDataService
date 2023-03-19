package edu.ou.activitysyncdataservice.data;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.Date;

@Data
@Document("FeedBack")
public class FeedbackDocument implements Serializable {
    @Id
    private String id;
    private int oId;
    private String title;
    private String slug;
    private Date createdAt;
    private String content;
    private int userId;
    private int feedBackTypeId;
}

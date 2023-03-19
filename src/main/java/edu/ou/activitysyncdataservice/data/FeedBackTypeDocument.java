package edu.ou.activitysyncdataservice.data;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.Date;

@Data
@Document("FeedBackType")
public class FeedBackTypeDocument implements Serializable {
    @Id
    private String id;
    private int oId;
    private String name;
    private String slug;
    private Date createdAt;
}

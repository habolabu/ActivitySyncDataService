package edu.ou.activitysyncdataservice.repository.commentEmotion;

import edu.ou.activitysyncdataservice.data.CommentEmotionDocument;
import edu.ou.coreservice.repository.base.BaseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class CommentEmotionAddRepository extends BaseRepository<CommentEmotionDocument, CommentEmotionDocument> {
    private final MongoTemplate mongoTemplate;

    @Override
    protected void preExecute(CommentEmotionDocument input) {
        // do nothing
    }

    /**
     * Save new comment emotion
     *
     * @param commentEmotionDocument comment emotion
     * @return new comment emotion
     * @author Nguyen Trung Kien - OU
     */
    @Override
    protected CommentEmotionDocument doExecute(CommentEmotionDocument commentEmotionDocument) {
        return mongoTemplate.save(commentEmotionDocument);
    }

    @Override
    protected void postExecute(CommentEmotionDocument input) {
        // do nothing
    }
}

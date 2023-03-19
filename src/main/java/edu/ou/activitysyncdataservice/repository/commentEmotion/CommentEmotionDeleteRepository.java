package edu.ou.activitysyncdataservice.repository.commentEmotion;

import edu.ou.activitysyncdataservice.data.CommentEmotionDocumentPK;
import edu.ou.coreservice.repository.base.BaseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class CommentEmotionDeleteRepository extends BaseRepository<CommentEmotionDocumentPK, Object> {
    private final MongoTemplate mongoTemplate;

    @Override
    protected void preExecute(CommentEmotionDocumentPK input) {
        // do nothing
    }

    /**
     * Delete exist comment emotion
     *
     * @param commentEmotionDocumentPK comment emotion id
     * @return delete result
     * @author Nguyen Trung Kien - OU
     */
    @Override
    protected Object doExecute(CommentEmotionDocumentPK commentEmotionDocumentPK) {
        final List<Criteria> conditions = new ArrayList<>() {
            {
                add(Criteria.where("commentId")
                        .is(commentEmotionDocumentPK.getCommentId()));
                add(Criteria.where("userId")
                        .is(commentEmotionDocumentPK.getUserId()));
                add(Criteria.where("emotionId")
                        .is(commentEmotionDocumentPK.getEmotionId()));
            }
        };

        return mongoTemplate.remove(
                new Query(new Criteria().andOperator(conditions.toArray(new Criteria[0]))),
                CommentEmotionDocumentPK.class
        );
    }

    @Override
    protected void postExecute(CommentEmotionDocumentPK input) {
        // do nothing
    }
}

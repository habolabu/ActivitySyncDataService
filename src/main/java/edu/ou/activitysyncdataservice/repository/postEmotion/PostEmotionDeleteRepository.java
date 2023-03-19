package edu.ou.activitysyncdataservice.repository.postEmotion;

import edu.ou.activitysyncdataservice.data.PostEmotionDocumentPK;
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
public class PostEmotionDeleteRepository extends BaseRepository<PostEmotionDocumentPK, Object> {
    private final MongoTemplate mongoTemplate;

    @Override
    protected void preExecute(PostEmotionDocumentPK input) {
        // do nothing
    }

    /**
     * Delete exist post emotion
     *
     * @param postEmotionDocumentPK post emotion id
     * @return delete result
     * @author Nguyen Trung Kien - OU
     */
    @Override
    protected Object doExecute(PostEmotionDocumentPK postEmotionDocumentPK) {
        final List<Criteria> conditions = new ArrayList<>() {
            {
                add(Criteria.where("postId")
                        .is(postEmotionDocumentPK.getPostId()));
                add(Criteria.where("userId")
                        .is(postEmotionDocumentPK.getUserId()));
                add(Criteria.where("emotionId")
                        .is(postEmotionDocumentPK.getEmotionId()));
            }
        };

        return mongoTemplate.remove(
                new Query(new Criteria().andOperator(conditions.toArray(new Criteria[0]))),
                PostEmotionDocumentPK.class
        );
    }

    @Override
    protected void postExecute(PostEmotionDocumentPK input) {
        // do nothing
    }
}

package edu.ou.activitysyncdataservice.repository.postEmotion;

import edu.ou.activitysyncdataservice.data.PostEmotionDocument;
import edu.ou.coreservice.repository.base.BaseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class PostEmotionAddRepository extends BaseRepository<PostEmotionDocument, PostEmotionDocument> {
    private final MongoTemplate mongoTemplate;

    @Override
    protected void preExecute(PostEmotionDocument input) {
        // do nothing
    }

    /**
     * Save new post emotion
     *
     * @param postEmotionDocument post emotion
     * @return new post emotion
     * @author Nguyen Trung Kien - OU
     */
    @Override
    protected PostEmotionDocument doExecute(PostEmotionDocument postEmotionDocument) {
        return mongoTemplate.save(postEmotionDocument);
    }

    @Override
    protected void postExecute(PostEmotionDocument input) {
        // do nothing
    }
}

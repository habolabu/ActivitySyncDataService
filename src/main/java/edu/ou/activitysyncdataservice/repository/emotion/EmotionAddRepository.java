package edu.ou.activitysyncdataservice.repository.emotion;

import edu.ou.activitysyncdataservice.data.EmotionDocument;
import edu.ou.coreservice.repository.base.BaseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class EmotionAddRepository extends BaseRepository<EmotionDocument, EmotionDocument> {
    private final MongoTemplate mongoTemplate;

    @Override
    protected void preExecute(EmotionDocument input) {
        // do nothing
    }

    /**
     * Save new emotion
     *
     * @param emotionDocument emotion
     * @return new emotion
     * @author Nguyen Trung Kien - OU
     */
    @Override
    protected EmotionDocument doExecute(EmotionDocument emotionDocument) {
        return mongoTemplate.save(emotionDocument);
    }

    @Override
    protected void postExecute(EmotionDocument input) {
        // do nothing
    }
}

package edu.ou.activitysyncdataservice.repository.emotion;

import edu.ou.activitysyncdataservice.data.EmotionDocument;
import edu.ou.coreservice.repository.base.BaseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class EmotionFindOneRepository extends BaseRepository<Integer, EmotionDocument> {
    private final MongoTemplate mongoTemplate;

    @Override
    protected void preExecute(Integer input) {
        // do nothing
    }

    /**
     * Find emotion by id
     *
     * @param emotionId emotion id
     * @return emotion
     * @author Nguyen Trung Kien - OU
     */
    @Override
    protected EmotionDocument doExecute(Integer emotionId) {
        return mongoTemplate.findOne(
                new Query(
                        Criteria.where("oId")
                                .is(emotionId)
                ),
                EmotionDocument.class
        );
    }

    @Override
    protected void postExecute(Integer input) {
        // do nothing
    }
}

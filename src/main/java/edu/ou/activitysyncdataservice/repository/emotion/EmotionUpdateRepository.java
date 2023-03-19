package edu.ou.activitysyncdataservice.repository.emotion;

import edu.ou.activitysyncdataservice.data.EmotionDocument;
import edu.ou.coreservice.repository.base.BaseRepository;
import edu.ou.coreservice.repository.base.IBaseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class EmotionUpdateRepository extends BaseRepository<EmotionDocument, EmotionDocument> {
    private final IBaseRepository<Integer, EmotionDocument> emotionFindOneRepository;
    private final MongoTemplate mongoTemplate;

    @Override
    protected void preExecute(EmotionDocument input) {
        // do nothing
    }

    /**
     * Update exist emotion document
     *
     * @param emotionDocument emotion
     * @return updated emotion
     * @author Nguyen Trung Kien - OU
     */
    @Override
    protected EmotionDocument doExecute(EmotionDocument emotionDocument) {
        final EmotionDocument existEmotionDocument =
                emotionFindOneRepository.execute(emotionDocument.getOId());

        assert existEmotionDocument != null;
        emotionDocument.setId(existEmotionDocument.getId());

        return mongoTemplate.save(emotionDocument);
    }

    @Override
    protected void postExecute(EmotionDocument input) {
        // do nothing
    }
}

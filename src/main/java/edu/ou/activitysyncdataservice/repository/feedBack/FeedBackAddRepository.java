package edu.ou.activitysyncdataservice.repository.feedBack;

import edu.ou.activitysyncdataservice.data.FeedbackDocument;
import edu.ou.coreservice.repository.base.BaseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class FeedBackAddRepository extends BaseRepository<FeedbackDocument, FeedbackDocument> {
    private final MongoTemplate mongoTemplate;

    @Override
    protected void preExecute(FeedbackDocument input) {
        // do nothing
    }

    /**
     * Save new feedback
     *
     * @param feedbackDocument feedback
     * @return new feedback
     * @author Nguyen Trung Kien - OU
     */
    @Override
    protected FeedbackDocument doExecute(FeedbackDocument feedbackDocument) {
        return mongoTemplate.save(feedbackDocument);
    }

    @Override
    protected void postExecute(FeedbackDocument input) {
        // do nothing
    }
}

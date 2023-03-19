package edu.ou.activitysyncdataservice.repository.feedBack;

import edu.ou.activitysyncdataservice.data.FeedbackDocument;
import edu.ou.coreservice.repository.base.BaseRepository;
import edu.ou.coreservice.repository.base.IBaseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class FeedBackUpdateRepository extends BaseRepository<FeedbackDocument, FeedbackDocument> {
    private final IBaseRepository<Integer, FeedbackDocument> feedBackFindOneRepository;
    private final MongoTemplate mongoTemplate;

    @Override
    protected void preExecute(FeedbackDocument input) {
        // do nothing
    }

    /**
     * Update exist feedback document
     *
     * @param feedbackDocument feedback
     * @return updated feedback
     * @author Nguyen Trung Kien - OU
     */
    @Override
    protected FeedbackDocument doExecute(FeedbackDocument feedbackDocument) {
        final FeedbackDocument existFeedBackDocument =
                feedBackFindOneRepository.execute(feedbackDocument.getOId());

        assert existFeedBackDocument != null;
        feedbackDocument.setId(existFeedBackDocument.getId());

        return mongoTemplate.save(feedbackDocument);
    }

    @Override
    protected void postExecute(FeedbackDocument input) {
        // do nothing
    }
}

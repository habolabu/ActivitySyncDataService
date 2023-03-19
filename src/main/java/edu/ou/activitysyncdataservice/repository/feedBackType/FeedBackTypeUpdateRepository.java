package edu.ou.activitysyncdataservice.repository.feedBackType;

import edu.ou.activitysyncdataservice.data.FeedBackTypeDocument;
import edu.ou.coreservice.repository.base.BaseRepository;
import edu.ou.coreservice.repository.base.IBaseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class FeedBackTypeUpdateRepository extends BaseRepository<FeedBackTypeDocument, FeedBackTypeDocument> {
    private final IBaseRepository<Integer, FeedBackTypeDocument> feedBackTypeFindOneRepository;
    private final MongoTemplate mongoTemplate;

    @Override
    protected void preExecute(FeedBackTypeDocument input) {
        // do nothing
    }

    /**
     * Update exist feedback type document
     *
     * @param feedBackTypeDocument feedback type
     * @return updated feedback type
     * @author Nguyen Trung Kien - OU
     */
    @Override
    protected FeedBackTypeDocument doExecute(FeedBackTypeDocument feedBackTypeDocument) {
        final FeedBackTypeDocument existFeedBackTypeDocument =
                feedBackTypeFindOneRepository.execute(feedBackTypeDocument.getOId());

        assert existFeedBackTypeDocument != null;
        feedBackTypeDocument.setId(existFeedBackTypeDocument.getId());

        return mongoTemplate.save(feedBackTypeDocument);
    }

    @Override
    protected void postExecute(FeedBackTypeDocument input) {
        // do nothing
    }
}

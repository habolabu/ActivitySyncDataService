package edu.ou.activitysyncdataservice.repository.feedBackType;

import edu.ou.activitysyncdataservice.data.FeedBackTypeDocument;
import edu.ou.coreservice.repository.base.BaseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class FeedBackTypeAddRepository extends BaseRepository<FeedBackTypeDocument, FeedBackTypeDocument> {
    private final MongoTemplate mongoTemplate;

    @Override
    protected void preExecute(FeedBackTypeDocument input) {
        // do nothing
    }

    /**
     * Save new feedback type
     *
     * @param feedBackTypeDocument feedback type
     * @return new feedback type
     * @author Nguyen Trung Kien - OU
     */
    @Override
    protected FeedBackTypeDocument doExecute(FeedBackTypeDocument feedBackTypeDocument) {
        return mongoTemplate.save(feedBackTypeDocument);
    }

    @Override
    protected void postExecute(FeedBackTypeDocument input) {
        // do nothing
    }
}

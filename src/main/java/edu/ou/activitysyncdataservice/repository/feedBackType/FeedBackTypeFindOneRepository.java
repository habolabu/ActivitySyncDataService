package edu.ou.activitysyncdataservice.repository.feedBackType;

import edu.ou.activitysyncdataservice.data.FeedBackTypeDocument;
import edu.ou.coreservice.repository.base.BaseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class FeedBackTypeFindOneRepository extends BaseRepository<Integer, FeedBackTypeDocument> {
    private final MongoTemplate mongoTemplate;

    @Override
    protected void preExecute(Integer input) {
        // do nothing
    }

    /**
     * Find feedback type by id
     *
     * @param feedBackTypeId feedback type id
     * @return feedback type
     * @author Nguyen Trung Kien - OU
     */
    @Override
    protected FeedBackTypeDocument doExecute(Integer feedBackTypeId) {
        return mongoTemplate.findOne(
                new Query(
                        Criteria.where("oId")
                                .is(feedBackTypeId)
                ),
                FeedBackTypeDocument.class
        );
    }

    @Override
    protected void postExecute(Integer input) {
        // do nothing
    }
}

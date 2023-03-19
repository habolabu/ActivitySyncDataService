package edu.ou.activitysyncdataservice.repository.feedBack;

import edu.ou.activitysyncdataservice.data.FeedbackDocument;
import edu.ou.coreservice.repository.base.BaseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class FeedBackFindOneRepository extends BaseRepository<Integer, FeedbackDocument> {
    private final MongoTemplate mongoTemplate;

    @Override
    protected void preExecute(Integer input) {
        // do nothing
    }

    /**
     * Find feedback by id
     *
     * @param feedBackId feedback id
     * @return feedback
     * @author Nguyen Trung Kien - OU
     */
    @Override
    protected FeedbackDocument doExecute(Integer feedBackId) {
        return mongoTemplate.findOne(
                new Query(
                        Criteria.where("oId")
                                .is(feedBackId)
                ),
                FeedbackDocument.class
        );
    }

    @Override
    protected void postExecute(Integer input) {
        // do nothing
    }
}

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
public class FeedBackTypeDeleteRepository extends BaseRepository<String, Object> {
    private final MongoTemplate mongoTemplate;

    @Override
    protected void preExecute(String input) {
        // do nothing
    }

    /**
     * Delete exist feedback type
     *
     * @param feedBackTypeSlug feedback type slug
     * @return delete result
     * @author Nguyen Trung Kien - OU
     */
    @Override
    protected Object doExecute(String feedBackTypeSlug) {
        return mongoTemplate.remove(
                new Query(
                        Criteria.where("slug")
                                .is(feedBackTypeSlug)
                ),
                FeedBackTypeDocument.class
        );
    }

    @Override
    protected void postExecute(String input) {
        // do nothing
    }
}

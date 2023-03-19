package edu.ou.activitysyncdataservice.repository.post;

import edu.ou.activitysyncdataservice.data.PostDocument;
import edu.ou.coreservice.repository.base.BaseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class PostDeleteRepository extends BaseRepository<String, Object> {
    private final MongoTemplate mongoTemplate;

    @Override
    protected void preExecute(String input) {
        // do nothing
    }

    /**
     * Delete exist post
     *
     * @param postSlug post slug
     * @return delete result
     * @author Nguyen Trung Kien - OU
     */
    @Override
    protected Object doExecute(String postSlug) {
        return mongoTemplate.remove(
                new Query(
                        Criteria.where("slug")
                                .is(postSlug)
                ),
                PostDocument.class
        );
    }

    @Override
    protected void postExecute(String input) {
        // do nothing
    }
}

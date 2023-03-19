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
public class PostFindOneRepository extends BaseRepository<Integer, PostDocument> {
    private final MongoTemplate mongoTemplate;

    @Override
    protected void preExecute(Integer input) {
        // do nothing
    }

    /**
     * Find post by id
     *
     * @param postId post id
     * @return post
     * @author Nguyen Trung Kien - OU
     */
    @Override
    protected PostDocument doExecute(Integer postId) {
        return mongoTemplate.findOne(
                new Query(
                        Criteria.where("oId")
                                .is(postId)
                ),
                PostDocument.class
        );
    }

    @Override
    protected void postExecute(Integer input) {
        // do nothing
    }
}

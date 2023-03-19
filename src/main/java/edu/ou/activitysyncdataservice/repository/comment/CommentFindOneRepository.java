package edu.ou.activitysyncdataservice.repository.comment;

import edu.ou.activitysyncdataservice.data.CommentDocument;
import edu.ou.coreservice.repository.base.BaseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class CommentFindOneRepository extends BaseRepository<Integer, CommentDocument> {
    private final MongoTemplate mongoTemplate;

    @Override
    protected void preExecute(Integer input) {
        // do nothing
    }

    /**
     * Find comment by id
     *
     * @param commentId comment id
     * @return comment
     * @author Nguyen Trung Kien - OU
     */
    @Override
    protected CommentDocument doExecute(Integer commentId) {
        return mongoTemplate.findOne(
                new Query(
                        Criteria.where("oId")
                                .is(commentId)
                ),
                CommentDocument.class
        );
    }

    @Override
    protected void postExecute(Integer input) {
        // do nothing
    }
}

package edu.ou.activitysyncdataservice.repository.comment;

import edu.ou.activitysyncdataservice.data.CommentDocument;
import edu.ou.coreservice.repository.base.BaseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class CommentAddRepository extends BaseRepository<CommentDocument, CommentDocument> {
    private final MongoTemplate mongoTemplate;

    @Override
    protected void preExecute(CommentDocument input) {
        // do nothing
    }

    /**
     * Save new comment
     *
     * @param commentDocument comment
     * @return new comment
     * @author Nguyen Trung Kien - OU
     */
    @Override
    protected CommentDocument doExecute(CommentDocument commentDocument) {
        return mongoTemplate.save(commentDocument);
    }

    @Override
    protected void postExecute(CommentDocument input) {
        // do nothing
    }
}

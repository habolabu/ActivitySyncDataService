package edu.ou.activitysyncdataservice.repository.comment;

import edu.ou.activitysyncdataservice.data.CommentDocument;
import edu.ou.coreservice.repository.base.BaseRepository;
import edu.ou.coreservice.repository.base.IBaseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class CommentUpdateRepository extends BaseRepository<CommentDocument, CommentDocument> {
    private final IBaseRepository<Integer, CommentDocument> commentFindOneRepository;
    private final MongoTemplate mongoTemplate;

    @Override
    protected void preExecute(CommentDocument input) {
        // do nothing
    }

    /**
     * Update exist comment document
     *
     * @param commentDocument comment
     * @return updated comment
     * @author Nguyen Trung Kien - OU
     */
    @Override
    protected CommentDocument doExecute(CommentDocument commentDocument) {
        final CommentDocument existCommentDocument =
                commentFindOneRepository.execute(commentDocument.getOId());

        assert existCommentDocument != null;
        commentDocument.setId(existCommentDocument.getId());

        return mongoTemplate.save(commentDocument);
    }

    @Override
    protected void postExecute(CommentDocument input) {
        // do nothing
    }
}

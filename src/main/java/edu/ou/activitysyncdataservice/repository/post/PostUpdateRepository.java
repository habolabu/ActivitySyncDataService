package edu.ou.activitysyncdataservice.repository.post;

import edu.ou.activitysyncdataservice.data.PostDocument;
import edu.ou.coreservice.repository.base.BaseRepository;
import edu.ou.coreservice.repository.base.IBaseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class PostUpdateRepository extends BaseRepository<PostDocument, PostDocument> {
    private final IBaseRepository<Integer, PostDocument> postFindOneRepository;
    private final MongoTemplate mongoTemplate;

    @Override
    protected void preExecute(PostDocument input) {
        // do nothing
    }

    /**
     * Update exist post document
     *
     * @param postDocument post
     * @return updated post
     * @author Nguyen Trung Kien - OU
     */
    @Override
    protected PostDocument doExecute(PostDocument postDocument) {
        final PostDocument existPostDocument =
                postFindOneRepository.execute(postDocument.getOId());

        assert existPostDocument != null;
        postDocument.setId(existPostDocument.getId());

        return mongoTemplate.save(postDocument);
    }

    @Override
    protected void postExecute(PostDocument input) {
        // do nothing
    }
}

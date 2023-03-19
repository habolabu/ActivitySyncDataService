package edu.ou.activitysyncdataservice.repository.post;

import edu.ou.activitysyncdataservice.data.PostDocument;
import edu.ou.coreservice.repository.base.BaseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class PostAddRepository extends BaseRepository<PostDocument, PostDocument> {
    private final MongoTemplate mongoTemplate;

    @Override
    protected void preExecute(PostDocument input) {
        // do nothing
    }

    /**
     * Save new post
     *
     * @param postDocument post
     * @return new post
     * @author Nguyen Trung Kien - OU
     */
    @Override
    protected PostDocument doExecute(PostDocument postDocument) {
        return mongoTemplate.save(postDocument);
    }

    @Override
    protected void postExecute(PostDocument input) {
        // do nothing
    }
}

package edu.ou.activitysyncdataservice.listener.post;

import edu.ou.activitysyncdataservice.common.mapper.PostDocumentMapper;
import edu.ou.activitysyncdataservice.data.PostDocument;
import edu.ou.coreservice.listener.IBaseListener;
import edu.ou.coreservice.queue.activity.internal.post.PostUpdateQueueI;
import edu.ou.coreservice.repository.base.IBaseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
@RequiredArgsConstructor
public class PostUpdateListener implements IBaseListener<Object, Object> {
    private final IBaseRepository<PostDocument, PostDocument> postUpdateRepository;
    private final MessageConverter messageConverter;

    /**
     * Update information exist post
     *
     * @param post post
     * @author Nguyen Trung Kien - OU
     */
    @Override
    @RabbitListener(queues = {PostUpdateQueueI.QUEUE})
    public Object execute(Object post) {
        final Map<String, Object> dataMap = (HashMap<String, Object>) messageConverter.fromMessage((Message) post);
        final PostDocument postDocument = PostDocumentMapper.INSTANCE.fromMap(dataMap);

        return postUpdateRepository.execute(postDocument);
    }
}

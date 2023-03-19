package edu.ou.activitysyncdataservice.listener.postEmotion;

import edu.ou.activitysyncdataservice.common.mapper.PostEmotionDocumentMapper;
import edu.ou.activitysyncdataservice.data.PostEmotionDocument;
import edu.ou.coreservice.listener.IBaseListener;
import edu.ou.coreservice.queue.activity.internal.commentEmotion.CommentEmotionAddQueueI;
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
public class PostEmotionAddListener implements IBaseListener<Object, Object> {
    private final IBaseRepository<PostEmotionDocument, PostEmotionDocument> postEmotionAddRepository;
    private final MessageConverter messageConverter;

    /**
     * Add new post emotion
     *
     * @param postEmotion post emotion information
     * @author Nguyen Trung Kien - OU
     */
    @Override
    @RabbitListener(queues = {CommentEmotionAddQueueI.QUEUE})
    public Object execute(Object postEmotion) {
        final Map<String, Object> dataMap = (HashMap<String, Object>) messageConverter.fromMessage((Message) postEmotion);
        final PostEmotionDocument postEmotionDocument = PostEmotionDocumentMapper.INSTANCE.fromMap(dataMap);

        return postEmotionAddRepository.execute(postEmotionDocument);
    }
}

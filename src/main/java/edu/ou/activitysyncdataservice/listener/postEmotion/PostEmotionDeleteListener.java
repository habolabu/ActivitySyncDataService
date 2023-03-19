package edu.ou.activitysyncdataservice.listener.postEmotion;

import edu.ou.activitysyncdataservice.common.mapper.PostEmotionDocumentMapper;
import edu.ou.activitysyncdataservice.data.PostEmotionDocumentPK;
import edu.ou.coreservice.listener.IBaseListener;
import edu.ou.coreservice.queue.activity.internal.postEmotion.PostEmotionDeleteQueueI;
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
public class PostEmotionDeleteListener implements IBaseListener<Object, Object> {
    private final IBaseRepository<PostEmotionDocumentPK, Object> postEmotionDeleteRepository;
    private final MessageConverter messageConverter;

    /**
     * Delete exist post emotion id
     *
     * @param postEmotionId post emotion id
     * @author Nguyen Trung Kien - OU
     */
    @Override
    @RabbitListener(queues = {PostEmotionDeleteQueueI.QUEUE})
    public Object execute(Object postEmotionId) {
        final Map<String, Object> dataMap = (HashMap<String, Object>)
                messageConverter.fromMessage((Message) postEmotionId);
        final PostEmotionDocumentPK commentEmotionPK = PostEmotionDocumentMapper.INSTANCE.fromMapPK(dataMap);

        return postEmotionDeleteRepository.execute(commentEmotionPK);
    }
}

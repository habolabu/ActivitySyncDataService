package edu.ou.activitysyncdataservice.listener.commentEmotion;

import edu.ou.activitysyncdataservice.common.mapper.CommentEmotionDocumentMapper;
import edu.ou.activitysyncdataservice.data.CommentEmotionDocument;
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
public class CommentEmotionAddListener implements IBaseListener<Object, Object> {
    private final IBaseRepository<CommentEmotionDocument, CommentEmotionDocument> commentEmotionAddRepository;
    private final MessageConverter messageConverter;

    /**
     * Add new comment emotion
     *
     * @param comment comment emotion information
     * @author Nguyen Trung Kien - OU
     */
    @Override
    @RabbitListener(queues = {CommentEmotionAddQueueI.QUEUE})
    public Object execute(Object comment) {
        final Map<String, Object> dataMap = (HashMap<String, Object>) messageConverter.fromMessage((Message) comment);
        final CommentEmotionDocument commentEmotionDocument = CommentEmotionDocumentMapper.INSTANCE.fromMap(dataMap);

        return commentEmotionAddRepository.execute(commentEmotionDocument);
    }
}

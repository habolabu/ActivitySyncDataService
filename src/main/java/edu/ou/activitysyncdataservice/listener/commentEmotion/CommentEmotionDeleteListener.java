package edu.ou.activitysyncdataservice.listener.commentEmotion;

import edu.ou.activitysyncdataservice.common.mapper.CommentEmotionDocumentMapper;
import edu.ou.activitysyncdataservice.data.CommentEmotionDocumentPK;
import edu.ou.coreservice.listener.IBaseListener;
import edu.ou.coreservice.queue.activity.internal.commentEmotion.CommentEmotionDeleteQueueI;
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
public class CommentEmotionDeleteListener implements IBaseListener<Object, Object> {
    private final IBaseRepository<CommentEmotionDocumentPK, Object> commentEmotionDeleteRepository;
    private final MessageConverter messageConverter;

    /**
     * Delete exist comment emotion id
     *
     * @param commentEmotionId comment emotion id
     * @author Nguyen Trung Kien - OU
     */
    @Override
    @RabbitListener(queues = {CommentEmotionDeleteQueueI.QUEUE})
    public Object execute(Object commentEmotionId) {
        final Map<String, Object> dataMap = (HashMap<String, Object>)
                messageConverter.fromMessage((Message) commentEmotionId);
        final CommentEmotionDocumentPK commentEmotionPK = CommentEmotionDocumentMapper.INSTANCE.fromMapPK(dataMap);

        return commentEmotionDeleteRepository.execute(commentEmotionPK);
    }
}

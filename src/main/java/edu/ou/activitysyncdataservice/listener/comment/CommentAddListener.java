package edu.ou.activitysyncdataservice.listener.comment;

import edu.ou.activitysyncdataservice.common.mapper.CommentDocumentMapper;
import edu.ou.activitysyncdataservice.data.CommentDocument;
import edu.ou.coreservice.listener.IBaseListener;
import edu.ou.coreservice.queue.activity.internal.comment.CommentAddQueueI;
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
public class CommentAddListener implements IBaseListener<Object, Object> {
    private final IBaseRepository<CommentDocument, CommentDocument> commentAddRepository;
    private final MessageConverter messageConverter;

    /**
     * Add new comment
     *
     * @param comment comment information
     * @author Nguyen Trung Kien - OU
     */
    @Override
    @RabbitListener(queues = {CommentAddQueueI.QUEUE})
    public Object execute(Object comment) {
        final Map<String, Object> dataMap = (HashMap<String, Object>) messageConverter.fromMessage((Message) comment);
        final CommentDocument commentDocument = CommentDocumentMapper.INSTANCE.fromMap(dataMap);

        return commentAddRepository.execute(commentDocument);
    }
}

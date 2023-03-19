package edu.ou.activitysyncdataservice.listener.feedBackType;

import edu.ou.activitysyncdataservice.common.mapper.FeedBackTypeDocumentMapper;
import edu.ou.activitysyncdataservice.data.FeedBackTypeDocument;
import edu.ou.coreservice.listener.IBaseListener;
import edu.ou.coreservice.queue.activity.internal.feedBackType.FeedBackTypeUpdateQueueI;
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
public class FeedBackTypeUpdateListener implements IBaseListener<Object, Object> {
    private final IBaseRepository<FeedBackTypeDocument, FeedBackTypeDocument> feedBackTypeUpdateRepository;
    private final MessageConverter messageConverter;

    /**
     * Update information exist feedback type
     *
     * @param feedBackType feedback type
     * @author Nguyen Trung Kien - OU
     */
    @Override
    @RabbitListener(queues = {FeedBackTypeUpdateQueueI.QUEUE})
    public Object execute(Object feedBackType) {
        final Map<String, Object> dataMap = (HashMap<String, Object>) messageConverter.fromMessage((Message) feedBackType);
        final FeedBackTypeDocument feedbackDocument = FeedBackTypeDocumentMapper.INSTANCE.fromMap(dataMap);

        return feedBackTypeUpdateRepository.execute(feedbackDocument);
    }
}

package edu.ou.activitysyncdataservice.listener.feedBack;

import edu.ou.activitysyncdataservice.common.mapper.FeedBackDocumentMapper;
import edu.ou.activitysyncdataservice.data.FeedbackDocument;
import edu.ou.coreservice.listener.IBaseListener;
import edu.ou.coreservice.queue.activity.internal.feedBack.FeedBackUpdateQueueI;
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
public class FeedBackUpdateListener implements IBaseListener<Object, Object> {
    private final IBaseRepository<FeedbackDocument, FeedbackDocument> feedBackUpdateRepository;
    private final MessageConverter messageConverter;

    /**
     * Update information exist feedback
     *
     * @param feedback feedback
     * @author Nguyen Trung Kien - OU
     */
    @Override
    @RabbitListener(queues = {FeedBackUpdateQueueI.QUEUE})
    public Object execute(Object feedback) {
        final Map<String, Object> dataMap = (HashMap<String, Object>) messageConverter.fromMessage((Message) feedback);
        final FeedbackDocument feedbackDocument = FeedBackDocumentMapper.INSTANCE.fromMap(dataMap);

        return feedBackUpdateRepository.execute(feedbackDocument);
    }
}

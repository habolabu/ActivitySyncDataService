package edu.ou.activitysyncdataservice.listener.feedBack;

import edu.ou.activitysyncdataservice.common.mapper.FeedBackDocumentMapper;
import edu.ou.activitysyncdataservice.data.FeedbackDocument;
import edu.ou.coreservice.listener.IBaseListener;
import edu.ou.coreservice.queue.activity.internal.feedBack.FeedBackAddQueueI;
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
public class FeedBackAddListener implements IBaseListener<Object, Object> {
    private final IBaseRepository<FeedbackDocument, FeedbackDocument> feedBackAddRepository;
    private final MessageConverter messageConverter;

    /**
     * Add new feedback
     *
     * @param feedBack feedback information
     * @author Nguyen Trung Kien - OU
     */
    @Override
    @RabbitListener(queues = {FeedBackAddQueueI.QUEUE})
    public Object execute(Object feedBack) {
        final Map<String, Object> dataMap = (HashMap<String, Object>) messageConverter.fromMessage((Message) feedBack);
        final FeedbackDocument feedbackDocument = FeedBackDocumentMapper.INSTANCE.fromMap(dataMap);

        return feedBackAddRepository.execute(feedbackDocument);
    }
}

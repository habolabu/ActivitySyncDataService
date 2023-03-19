package edu.ou.activitysyncdataservice.listener.emotion;

import edu.ou.activitysyncdataservice.common.mapper.EmotionDocumentMapper;
import edu.ou.activitysyncdataservice.data.EmotionDocument;
import edu.ou.coreservice.listener.IBaseListener;
import edu.ou.coreservice.queue.activity.internal.emotion.EmotionUpdateQueueI;
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
public class EmotionUpdateListener implements IBaseListener<Object, Object> {
    private final IBaseRepository<EmotionDocument, EmotionDocument> emotionUpdateRepository;
    private final MessageConverter messageConverter;

    /**
     * Update information exist emotion
     *
     * @param emotion emotion
     * @author Nguyen Trung Kien - OU
     */
    @Override
    @RabbitListener(queues = {EmotionUpdateQueueI.QUEUE})
    public Object execute(Object emotion) {
        final Map<String, Object> dataMap = (HashMap<String, Object>) messageConverter.fromMessage((Message) emotion);
        final EmotionDocument emotionDocument = EmotionDocumentMapper.INSTANCE.fromMap(dataMap);

        return emotionUpdateRepository.execute(emotionDocument);
    }
}

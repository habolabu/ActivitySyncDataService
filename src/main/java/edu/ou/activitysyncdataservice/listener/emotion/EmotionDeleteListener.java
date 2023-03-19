package edu.ou.activitysyncdataservice.listener.emotion;

import edu.ou.coreservice.listener.IBaseListener;
import edu.ou.coreservice.queue.activity.internal.emotion.EmotionDeleteQueueI;
import edu.ou.coreservice.repository.base.IBaseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class EmotionDeleteListener implements IBaseListener<Integer, Object> {
    private final IBaseRepository<Integer, Object> emotionDeleteRepository;

    /**
     * Delete exist emotion
     *
     * @param emotionId emotion id
     * @author Nguyen Trung Kien - OU
     */
    @Override
    @RabbitListener(queues = {EmotionDeleteQueueI.QUEUE})
    public Object execute(Integer emotionId) {
        return emotionDeleteRepository.execute(emotionId);
    }
}

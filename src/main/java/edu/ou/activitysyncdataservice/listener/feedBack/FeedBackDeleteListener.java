package edu.ou.activitysyncdataservice.listener.feedBack;

import edu.ou.coreservice.listener.IBaseListener;
import edu.ou.coreservice.queue.activity.internal.feedBack.FeedBackDeleteQueueI;
import edu.ou.coreservice.repository.base.IBaseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class FeedBackDeleteListener implements IBaseListener<String, Object> {
    private final IBaseRepository<String, Object> feedBackDeleteRepository;

    /**
     * Delete exist feedBack slug
     *
     * @param feedBackSlug feedBack slug
     * @author Nguyen Trung Kien - OU
     */
    @Override
    @RabbitListener(queues = {FeedBackDeleteQueueI.QUEUE})
    public Object execute(String feedBackSlug) {
        return feedBackDeleteRepository.execute(feedBackSlug);
    }
}

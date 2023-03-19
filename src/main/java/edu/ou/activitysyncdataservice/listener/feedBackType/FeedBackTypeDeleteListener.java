package edu.ou.activitysyncdataservice.listener.feedBackType;

import edu.ou.coreservice.listener.IBaseListener;
import edu.ou.coreservice.queue.activity.internal.feedBackType.FeedBackTypeDeleteQueueI;
import edu.ou.coreservice.repository.base.IBaseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class FeedBackTypeDeleteListener implements IBaseListener<String, Object> {
    private final IBaseRepository<String, Object> feedBackTypeDeleteRepository;

    /**
     * Delete exist feedBack type slug
     *
     * @param feedBackTypeSlug feedBack type slug
     * @author Nguyen Trung Kien - OU
     */
    @Override
    @RabbitListener(queues = {FeedBackTypeDeleteQueueI.QUEUE})
    public Object execute(String feedBackTypeSlug) {
        return feedBackTypeDeleteRepository.execute(feedBackTypeSlug);
    }
}

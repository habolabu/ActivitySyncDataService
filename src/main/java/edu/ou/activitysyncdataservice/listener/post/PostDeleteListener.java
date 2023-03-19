package edu.ou.activitysyncdataservice.listener.post;

import edu.ou.coreservice.listener.IBaseListener;
import edu.ou.coreservice.queue.activity.internal.post.PostDeleteQueueI;
import edu.ou.coreservice.repository.base.IBaseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PostDeleteListener implements IBaseListener<String, Object> {
    private final IBaseRepository<String, Object> postDeleteRepository;

    /**
     * Delete exist post slug
     *
     * @param postSlug post slug
     * @author Nguyen Trung Kien - OU
     */
    @Override
    @RabbitListener(queues = {PostDeleteQueueI.QUEUE})
    public Object execute(String postSlug) {
        return postDeleteRepository.execute(postSlug);
    }
}

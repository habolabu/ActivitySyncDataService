package edu.ou.activitysyncdataservice.listener.comment;

import edu.ou.coreservice.listener.IBaseListener;
import edu.ou.coreservice.queue.activity.internal.comment.CommentDeleteQueueI;
import edu.ou.coreservice.repository.base.IBaseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CommentDeleteListener implements IBaseListener<Integer, Object> {
    private final IBaseRepository<Integer, Object> commentDeleteRepository;

    /**
     * Delete exist comment
     *
     * @param commentId comment id
     * @author Nguyen Trung Kien - OU
     */
    @Override
    @RabbitListener(queues = {CommentDeleteQueueI.QUEUE})
    public Object execute(Integer commentId) {
        return commentDeleteRepository.execute(commentId);
    }
}

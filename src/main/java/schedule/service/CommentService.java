package schedule.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import schedule.Constants;
import schedule.Repository.CommentRepository;
import schedule.Repository.ScheduleRepository;
import schedule.dto.CreateCommentRequest;
import schedule.dto.CreateCommentResponse;
import schedule.dto.GetOneCommentResponse;
import schedule.entity.Comment;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentService {
    private final CommentRepository commentRepository;
    private final ScheduleRepository scheduleRepository;

    @Transactional
    public CreateCommentResponse save(Long scheduleId, CreateCommentRequest request) {

        long commentNum = commentRepository.countByScheduleId(scheduleId);

        if (commentNum >= Constants.MAX_COMMENT) {
            throw new IllegalStateException("하나의 일정에는 댓글을 10개까지만 작성할 수 있습니다.");
        }

        //scheduleId 검사
        boolean exists = scheduleRepository.existsById(scheduleId);
        if (!exists) {
            throw new IllegalStateException("존재하지 않는 id입니다.");
        }

        Comment comment = new Comment(
                scheduleId,
                request.getContent(),
                request.getAuthor(),
                request.getPassword()
        );

        commentRepository.save(comment);

        return new CreateCommentResponse(
                comment.getId(),
                comment.getScheduleId(),
                comment.getContent(),
                comment.getAuthor(),
                comment.getCreatedAt(),
                comment.getModifiedAt()
        );
    }


    @Transactional(readOnly = true)
    public List<GetOneCommentResponse> getAll(Long scheduleId) {
        List<Comment> comments = commentRepository.findAllByScheduleId(scheduleId);

        List<GetOneCommentResponse> commentResponses = new ArrayList<>();
        for (Comment comment : comments) {
            commentResponses.add(new GetOneCommentResponse(
                    comment.getId(),
                    comment.getScheduleId(),
                    comment.getAuthor(),
                    comment.getContent(),
                    comment.getCreatedAt(),
                    comment.getModifiedAt()
            ));
        }

        return commentResponses;
    }
}

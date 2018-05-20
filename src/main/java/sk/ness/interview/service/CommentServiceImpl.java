package sk.ness.interview.service;

import org.springframework.stereotype.Service;
import sk.ness.interview.dao.CommentDAO;
import sk.ness.interview.domain.Comment;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class CommentServiceImpl implements CommentService {

    @Resource
    private CommentDAO commentDAO;

    @Override
    public Comment findById(final Integer commentId) {
        return this.commentDAO.findByID(commentId);
    }

    @Override
    public List<Comment> findAll() {
        return this.commentDAO.findAll();
    }

    @Override
    public void createComment(final Comment comment) {
        this.commentDAO.persist(comment);
    }

    @Override
    public void ingestComments(final String jsonComments) {
        throw new UnsupportedOperationException("Comment ingesting not implemented.");
    }
}

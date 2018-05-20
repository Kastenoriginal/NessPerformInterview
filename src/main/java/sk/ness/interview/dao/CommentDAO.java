package sk.ness.interview.dao;

import sk.ness.interview.domain.Comment;

import java.util.List;

public interface CommentDAO {

    /** Returns {@link Comment} with provided ID */
    Comment findByID(Integer commentId);

    /** Returns all available {@link Comment Comments} */
    List<Comment> findAll();

    /** Persists {@link Comment} into the DB */
    void persist(Comment comment);
}

package sk.ness.interview.service;

import sk.ness.interview.domain.Comment;

import java.util.List;

public interface CommentService {

    /** Returns {@link Comment} with provided ID */
    Comment findById(Integer commentId);

    /** Returns all available {@link Comment Comments} */
    List<Comment> findAll();

    /** Creates new {@link Comment} */
    void createComment(Comment comment);

    /** Creates new {@link Comment Comments} by ingesting all articles from json */
    void ingestComments(String jsonComments);
}

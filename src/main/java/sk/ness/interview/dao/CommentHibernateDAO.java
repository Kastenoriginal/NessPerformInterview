package sk.ness.interview.dao;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import sk.ness.interview.domain.Comment;
import sk.ness.interview.utils.Constants;

import javax.annotation.Resource;
import java.util.List;

@Repository
public class CommentHibernateDAO implements CommentDAO {

    @Resource(name = Constants.NAME_SESSION_FACTORY)
    private SessionFactory sessionFactory;

    @Override
    public Comment findByID(Integer commentId) {
        return (Comment) this.sessionFactory.getCurrentSession().get(Comment.class, commentId);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Comment> findAll() {
        return this.sessionFactory.getCurrentSession().createSQLQuery(Constants.SELECT_ALL_COMMENTS).addEntity(Comment.class).list();
    }

    @Override
    public void persist(Comment comment) {
        this.sessionFactory.getCurrentSession().saveOrUpdate(comment);
    }
}

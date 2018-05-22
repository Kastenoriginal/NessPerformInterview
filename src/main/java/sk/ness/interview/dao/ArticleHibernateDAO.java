package sk.ness.interview.dao;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import sk.ness.interview.domain.Article;
import sk.ness.interview.utils.Constants;

import javax.annotation.Resource;
import java.util.List;

/**
 * DAO for {@link Article} related DB operations
 *
 * @author michal.kmetka
 */
@Repository
public class ArticleHibernateDAO implements ArticleDAO {

    @Resource(name = "sessionFactory")
    private SessionFactory sessionFactory;

    @Override
    public Article findByID(final Integer articleId) {
        return (Article) this.sessionFactory.getCurrentSession().get(Article.class, articleId);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Article> findAll() {
        return this.sessionFactory.getCurrentSession().createSQLQuery("select * from articles").addEntity(Article.class).list();
    }

    public List<Article> findAllWithComments() {
        Query namedQuery = this.sessionFactory.getCurrentSession().getNamedQuery(Constants.FIND_ARTICLES_WITH_COMMENTS);
        return namedQuery.list();
    }

    @Override
    public void persist(final Article article) {
        this.sessionFactory.getCurrentSession().saveOrUpdate(article);
    }

}

package sk.ness.interview.dao;

import org.hibernate.SessionFactory;
import org.hibernate.transform.AliasToBeanResultTransformer;
import org.hibernate.type.DateType;
import org.hibernate.type.IntegerType;
import org.hibernate.type.StringType;
import org.springframework.stereotype.Repository;
import sk.ness.interview.domain.Article;
import sk.ness.interview.dto.ArticleWithoutComment;

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

    @SuppressWarnings("unchecked")
    @Override
    public List<Article> findAllWithoutComments() {
        return this.sessionFactory.getCurrentSession().createSQLQuery("select a.id as id, a.title as title, a.text as text, a.author as author, a.create_timestamp as createTimestamp from articles a")
                .addScalar("id", IntegerType.INSTANCE)
                .addScalar("title", StringType.INSTANCE)
                .addScalar("text", StringType.INSTANCE)
                .addScalar("author", StringType.INSTANCE)
                .addScalar("createTimestamp", DateType.INSTANCE)
                .setResultTransformer(new AliasToBeanResultTransformer(ArticleWithoutComment.class))
                .list();
    }

    @Override
    public void persist(final Article article) {
        this.sessionFactory.getCurrentSession().saveOrUpdate(article);
    }

}

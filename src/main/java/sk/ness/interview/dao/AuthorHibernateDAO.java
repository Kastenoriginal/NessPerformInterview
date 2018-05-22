package sk.ness.interview.dao;

import org.hibernate.SessionFactory;
import org.hibernate.transform.AliasToBeanResultTransformer;
import org.hibernate.type.IntegerType;
import org.hibernate.type.LongType;
import org.hibernate.type.StringType;
import org.springframework.stereotype.Repository;
import sk.ness.interview.dto.Author;
import sk.ness.interview.dto.AuthorStats;

import javax.annotation.Resource;
import java.util.List;

/**
 * DAO for {@link Author} related DB operations
 *
 * @author michal.kmetka
 */
@Repository
public class AuthorHibernateDAO implements AuthorDAO {

    @Resource(name = "sessionFactory")
    private SessionFactory sessionFactory;

    @SuppressWarnings("unchecked")
    @Override
    public List<Author> findAll() {
        return this.sessionFactory.getCurrentSession().createSQLQuery("select distinct a.author as name from articles a ")
                .addScalar("name", StringType.INSTANCE)
                .setResultTransformer(new AliasToBeanResultTransformer(Author.class)).list();
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<AuthorStats> fetchAllAuthorStats() {
//        return this.sessionFactory.getCurrentSession().createSQLQuery("select distinct a.author as authorName, count(c) from articles a")
        return this.sessionFactory.getCurrentSession().createSQLQuery("select distinct a.author as authorName, count(a.id) as articleCount from articles a group by authorName")
                .addScalar("authorName", StringType.INSTANCE)
                .addScalar("articleCount", IntegerType.INSTANCE)
                .setResultTransformer(new AliasToBeanResultTransformer(AuthorStats.class)).list();
    }
}

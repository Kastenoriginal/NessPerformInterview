package sk.ness.interview.service;

import org.springframework.stereotype.Service;
import sk.ness.interview.dao.ArticleDAO;
import sk.ness.interview.domain.Article;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.util.List;

/**
 * Service should be used as a gateway to {@link Article} world and handle all article related manipulation.
 *
 * @author michal.kmetka
 */
@Service
@Transactional
public class ArticleServiceImpl implements ArticleService {

    @Resource
    private ArticleDAO articleDAO;

    @Override
    public Article findByID(final Integer articleId) {
        return this.articleDAO.findByID(articleId);
    }

    @Override
    public List<Article> findAll() {
        return this.articleDAO.findAll();
    }

    @Override
    public void createArticle(final Article article) {
        this.articleDAO.persist(article);
    }

    @Override
    public void ingestArticles(final String jsonArticles) {
        throw new UnsupportedOperationException("Article ingesting not implemented.");
    }

}

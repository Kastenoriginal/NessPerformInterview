package sk.ness.interview.service;

import com.google.gson.Gson;
import org.springframework.stereotype.Service;
import sk.ness.interview.dao.ArticleDAO;
import sk.ness.interview.domain.Article;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
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
    public List<Article> findAllWithComments() {
        return this.articleDAO.findAllWithComments();
    }

    @Override
    public void createArticle(final Article article) {
        this.articleDAO.persist(article);
    }

    @Override
    public List<Article> getArticlesBysSearchText(String searchText) {
        List<Article> allArticles = this.articleDAO.findAll();
        List<Article> filteredArticles = new ArrayList<>();
        for (Article article : allArticles) {
            if (article.getAuthor().contains(searchText) ||
                    article.getTitle().contains(searchText) ||
                    article.getText().contains(searchText)) {
                filteredArticles.add(article);
            }
        }

        return filteredArticles;
    }

    @Override
    public void ingestArticles(final String jsonArticles) {
        Gson gson = new Gson();
        try {
            Article[] articles = gson.fromJson(new FileReader("articles_to_ingest.txt"), Article[].class);
            for (Article article : articles) {
                createArticle(article);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
    }

}

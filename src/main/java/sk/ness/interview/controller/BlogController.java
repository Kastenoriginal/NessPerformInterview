package sk.ness.interview.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import sk.ness.interview.domain.Article;
import sk.ness.interview.dto.Author;
import sk.ness.interview.dto.AuthorStats;
import sk.ness.interview.service.ArticleService;
import sk.ness.interview.service.AuthorService;

@Api
@RestController
public class BlogController {

  @Resource
  private ArticleService articleService;

  @Resource
  private AuthorService authorService;

  // ~~ Article

  @RequestMapping(value = "articles", method = RequestMethod.GET)
  public List<Article> getAllArticles() {
    return this.articleService.findAll();
  }

  @RequestMapping(value = "articles/{articleId}", method = RequestMethod.GET)
  public Article getArticle(@PathVariable final Integer articleId) {
    Article article = articleService.findByID(articleId);
//    List<CommentArticle> commentArticles = new ArrayList<>();
//    CommentArticle commentArticle = new CommentArticle("Patrik Varga", "Comment", "Date String");
//    commentArticles.add(commentArticle);
//
//    article.setComments(commentArticles);
//    articleService.createArticle(article);
//
    article.setComment("Comment text");
    return article;
//    return this.articleService.findByID(articleId);
  }

  @RequestMapping(value = "articles/search/{searchText}", method = RequestMethod.GET)
  public List<Article> searchArticle(@PathVariable final String searchText) {
    throw new UnsupportedOperationException("Full text search not implemented.");
  }

  @RequestMapping(value = "articles/add", method = RequestMethod.PUT)
  public void addArticle(@RequestBody final Article article) {
    this.articleService.createArticle(article);
  }

  // ~~ Author

  @RequestMapping(value = "authors", method = RequestMethod.GET)
  public List<Author> getAllAuthors() {
    return this.authorService.findAll();
  }

  @RequestMapping(value = "authors/stats", method = RequestMethod.GET)
  public List<AuthorStats> authorStats() {
    throw new UnsupportedOperationException("Author statistics not implemented.");
  }

}

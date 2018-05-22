package sk.ness.interview.controller;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;
import sk.ness.interview.domain.Article;
import sk.ness.interview.domain.Comment;
import sk.ness.interview.dto.Author;
import sk.ness.interview.dto.AuthorStats;
import sk.ness.interview.service.ArticleService;
import sk.ness.interview.service.AuthorService;
import sk.ness.interview.service.CommentService;
import sk.ness.interview.utils.Constants;

import javax.annotation.Resource;
import java.util.List;

@Api
@RestController
public class BlogController {

    @Resource
    private ArticleService articleService;

    @Resource
    private AuthorService authorService;

    @Resource
    private CommentService commentService;

    // ~~ Article

    @RequestMapping(value = "articles", method = RequestMethod.GET)
    public List<Article> getAllArticles() {
        return this.articleService.findAllWithComments();
    }

    @RequestMapping(value = "articles/{articleId}", method = RequestMethod.GET)
    public Article getArticle(@PathVariable final Integer articleId) {
        return this.articleService.findByID(articleId);
    }

    @RequestMapping(value = "articles/search/{searchText}", method = RequestMethod.GET)
    public List<Article> searchArticle(@PathVariable final String searchText) {
        return this.articleService.getArticlesBysSearchText(searchText);
    }

    @RequestMapping(value = "articles/add", method = RequestMethod.PUT)
    public void addArticle(@RequestBody final Article article) {
        this.articleService.createArticle(article);
    }

    // ~~ Author

    @RequestMapping(value = "authors", method = RequestMethod.GET)
    public List<Author> getAllAuthors() {
        List<Author> authors = this.authorService.findAll();
        for (Author author : authors) {
            System.out.println(author.getName());
        }
        return this.authorService.findAll();
    }

    @RequestMapping(value = "authors/stats", method = RequestMethod.GET)
    public List<AuthorStats> authorStats() {
        for (AuthorStats authorStats : this.authorService.fetchAllAuthorStats()) {
            System.out.println(authorStats.getAuthorName());
            System.out.println(authorStats.getArticleCount());
        }
        return this.authorService.fetchAllAuthorStats();
    }

    //region Comment

    @RequestMapping(value = Constants.API_GET_COMMENTS, method = RequestMethod.GET)
    public List<Comment> getAllComments() {
        return this.commentService.findAll();
    }

    @RequestMapping(value = Constants.API_GET_COMMENT_BY_ID, method = RequestMethod.GET)
    public Comment getComment(@PathVariable final Integer commentId) {
        return this.commentService.findById(commentId);
    }

    @RequestMapping(value = Constants.API_SEARCH_COMMENT, method = RequestMethod.GET)
    public List<Comment> searchComment(@PathVariable final String searchText) {
        throw new UnsupportedOperationException("Comment text search not implemented.");
    }

    @RequestMapping(value = Constants.API_ADD_COMMENT, method = RequestMethod.PUT)
    public void addComment(@RequestBody final Comment comment) {
        this.commentService.createComment(comment);
    }

    //endregion
}

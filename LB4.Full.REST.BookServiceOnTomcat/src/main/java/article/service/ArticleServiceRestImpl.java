package article.service;

import article.additions.ReturnsAtomic;
import article.dao.ArticleDAO;
import article.dao.ArticleDAOInMemoryImpl;
import article.dao.DAOException;
import article.entity.Article;
import article.entity.ArticleTag;
import article.entity.Comment;
import article.entity.Grade;
import com.sun.research.ws.wadl.Application;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Path(Constants.ARTICLES_SERVICE_PATH)
public class ArticleServiceRestImpl extends Application {

    private static final long LONG_WORK_WAIT_TIMEOUT = 1000;

    private static final int DEFAULT_THREAD_POOL_SIZE = 10;

    private ArticleDAO store;

    ExecutorService executor = Executors.newFixedThreadPool(DEFAULT_THREAD_POOL_SIZE);

    private void log(String msg) {
        System.out.println(this.getClass().getSimpleName() + ": " + msg);
    }

    @PostConstruct
    public void init() {
        log("init");
        store = ArticleDAOInMemoryImpl.instance();
    }

    @PreDestroy
    public void destroy() {
        log("destroy");
        store = null;
        executor.shutdown();
    }

    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Response listArticles() {
        log("all");
        var articles = this.store.listArticles();
        System.out.println("getting all");
        return Response.ok(articles).build();
    }


    @Path("search")
    public ArticleSearcher find() {
        return new ArticleSearcher();
    }

    @POST
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public ReturnsAtomic<Integer> addArticle(Article article) throws DAOException {
        log("add article");
        var id = store.addArticle(article);
        return new ReturnsAtomic<Integer>(id);
    }

//    @POST
//    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
//    public ReturnsAtomic<Integer> addComment(Comment comment) throws DAOException {
//        log("add comment");
//        var id = store.addComment(comment);
//        return new ReturnsAtomic<Integer>(id);
//    }
//
//    @POST
//    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
//    public ReturnsAtomic<Integer> addGrade(Grade grade) throws DAOException {
//        log("add grade");
//        var id = store.addGrade(grade);
//        return new ReturnsAtomic<Integer>(id);
//    }
//
//    @POST
//    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
//    public ReturnsAtomic<Integer> addArticleTag(ArticleTag articleTag) throws DAOException {
//        log("add article tag");
//        var id = store.addArticleTag(articleTag);
//        return new ReturnsAtomic<Integer>(id);
//    }
}

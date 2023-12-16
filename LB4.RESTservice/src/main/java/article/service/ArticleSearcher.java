package article.service;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import article.dao.ArticleDAO;
import article.dao.ArticleDAOInMemoryImpl;
import article.entity.Article;

import java.util.Collection;

public class ArticleSearcher {
    private ArticleDAO store = ArticleDAOInMemoryImpl.instance();
    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Collection<Article> search(@QueryParam("pattern") String pattern) {
        System.out.println("search for Article tag: " + pattern);
        return store.findByTag(pattern);
    }
}

package article.additions;

import article.service.ArticleSearcher;
import article.service.ArticleServiceRestImpl;
import jakarta.ws.rs.core.Application;

import java.util.HashSet;
import java.util.Set;

public class ArticleInfoApplication extends Application {
    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> classes = new HashSet<>();

        classes.add(ArticleServiceRestImpl.class);

        return classes;
    }
}

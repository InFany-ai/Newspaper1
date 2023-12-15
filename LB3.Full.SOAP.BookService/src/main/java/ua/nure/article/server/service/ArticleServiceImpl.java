package ua.nure.article.server.service;

import jakarta.jws.HandlerChain;
import jakarta.jws.WebService;
import ua.nure.article.entity.Article;
import ua.nure.article.entity.Comment;
import ua.nure.article.entity.Grade;
import ua.nure.article.server.dao.ArticleDAO;
import ua.nure.article.server.dao.ArticleDAOInMemoryImpl;
import ua.nure.article.server.dao.DAOException;

import java.util.Collection;

@WebService(serviceName="Articles",
        portName="ArticlePort",
        endpointInterface="ua.nure.article.server.service.ArticleService",
        targetNamespace="http://article.nure.ua/server/service")
public class ArticleServiceImpl implements ArticleService{

    private static ArticleDAO articleDAO = ArticleDAOInMemoryImpl.instance();

    @Override
    public int addComment(Comment comment) throws DAOException {
        return articleDAO.addComment(comment);
    }

    @Override
    public int addArticle(Article article) throws DAOException {
        return articleDAO.addArticle(article);
    }

    @Override
    public int addGrade(Grade grade) throws DAOException {
        return articleDAO.addGrade(grade);
    }

    @Override
    public Collection<Article> listArticles() {
        return articleDAO.listArticles();
    }

    @Override
    public Collection<Article> findByArticleTag(String pattern) {
        return articleDAO.findByTag(pattern);
    }

}

package ua.nure.article.server.service;

import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebResult;
import jakarta.jws.WebService;
import ua.nure.article.entity.Article;
import ua.nure.article.entity.Comment;
import ua.nure.article.entity.Grade;
import ua.nure.article.server.dao.DAOException;

import java.util.Collection;

@WebService(targetNamespace= Const.SERVICE_NS)
public interface ArticleService {
    @WebMethod()
    @WebResult(targetNamespace="http://article.nure.ua/entity")
    public int addComment(
            @WebParam(name="Comment", targetNamespace="http://article.nure.ua/entity")
            Comment comment) throws DAOException;

    @WebMethod()
    public int addArticle(
            @WebParam(name="Article", targetNamespace="http://article.nure.ua/entity")
            Article article) throws DAOException;

    @WebMethod()
    public int addGrade(
            @WebParam(name="Grade", targetNamespace="http://article.nure.ua/entity")
            Grade grade) throws DAOException;

    @WebMethod()
    @WebResult(name="articleList", targetNamespace="http://article.nure.ua/entity" )
    public Collection<Article> listArticles();

    @WebMethod()
    @WebResult(name="articleList", targetNamespace="http://article.nure.ua/entity")
    public Collection<Article> findByArticleTag(
            @WebParam(name="pattern")
            String pattern);
}

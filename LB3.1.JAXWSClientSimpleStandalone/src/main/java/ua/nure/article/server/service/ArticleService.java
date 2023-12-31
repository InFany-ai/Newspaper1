
package ua.nure.article.server.service;

import java.util.List;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebResult;
import jakarta.jws.WebService;
import jakarta.xml.bind.annotation.XmlSeeAlso;
import jakarta.xml.ws.Action;
import jakarta.xml.ws.FaultAction;
import jakarta.xml.ws.RequestWrapper;
import jakarta.xml.ws.ResponseWrapper;
import ua.nure.article.entity.Article;
import ua.nure.article.entity.Comment;
import ua.nure.article.entity.Grade;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 3.0.0
 * Generated source version: 3.0
 * 
 */
@WebService(name = "ArticleService", targetNamespace = "http://article.nure.ua/server/service")
@XmlSeeAlso({
    ua.nure.article.entity.ObjectFactory.class,
    ua.nure.article.server.service.ObjectFactory.class
})
public interface ArticleService {


    /**
     * 
     * @param pattern
     * @return
     *     returns java.util.List<ua.nure.article.entity.Article>
     */
    @WebMethod
    @WebResult(name = "articleList", targetNamespace = "http://article.nure.ua/entity")
    @RequestWrapper(localName = "findByArticleTag", targetNamespace = "http://article.nure.ua/server/service", className = "ua.nure.article.server.service.FindByArticleTag")
    @ResponseWrapper(localName = "findByArticleTagResponse", targetNamespace = "http://article.nure.ua/server/service", className = "ua.nure.article.server.service.FindByArticleTagResponse")
    @Action(input = "http://article.nure.ua/server/service/ArticleService/findByArticleTagRequest", output = "http://article.nure.ua/server/service/ArticleService/findByArticleTagResponse")
    public List<Article> findByArticleTag(
        @WebParam(name = "pattern", targetNamespace = "")
        String pattern);

    /**
     * 
     * @return
     *     returns java.util.List<ua.nure.article.entity.Article>
     */
    @WebMethod
    @WebResult(name = "articleList", targetNamespace = "http://article.nure.ua/entity")
    @RequestWrapper(localName = "listArticles", targetNamespace = "http://article.nure.ua/server/service", className = "ua.nure.article.server.service.ListArticles")
    @ResponseWrapper(localName = "listArticlesResponse", targetNamespace = "http://article.nure.ua/server/service", className = "ua.nure.article.server.service.ListArticlesResponse")
    @Action(input = "http://article.nure.ua/server/service/ArticleService/listArticlesRequest", output = "http://article.nure.ua/server/service/ArticleService/listArticlesResponse")
    public List<Article> listArticles();

    /**
     * 
     * @param article
     * @return
     *     returns int
     * @throws DAOException_Exception
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "addArticle", targetNamespace = "http://article.nure.ua/server/service", className = "ua.nure.article.server.service.AddArticle")
    @ResponseWrapper(localName = "addArticleResponse", targetNamespace = "http://article.nure.ua/server/service", className = "ua.nure.article.server.service.AddArticleResponse")
    @Action(input = "http://article.nure.ua/server/service/ArticleService/addArticleRequest", output = "http://article.nure.ua/server/service/ArticleService/addArticleResponse", fault = {
        @FaultAction(className = DAOException_Exception.class, value = "http://article.nure.ua/server/service/ArticleService/addArticle/Fault/DAOException")
    })
    public int addArticle(
        @WebParam(name = "Article", targetNamespace = "http://article.nure.ua/entity")
        Article article)
        throws DAOException_Exception
    ;

    /**
     * 
     * @param grade
     * @return
     *     returns int
     * @throws DAOException_Exception
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "addGrade", targetNamespace = "http://article.nure.ua/server/service", className = "ua.nure.article.server.service.AddGrade")
    @ResponseWrapper(localName = "addGradeResponse", targetNamespace = "http://article.nure.ua/server/service", className = "ua.nure.article.server.service.AddGradeResponse")
    @Action(input = "http://article.nure.ua/server/service/ArticleService/addGradeRequest", output = "http://article.nure.ua/server/service/ArticleService/addGradeResponse", fault = {
        @FaultAction(className = DAOException_Exception.class, value = "http://article.nure.ua/server/service/ArticleService/addGrade/Fault/DAOException")
    })
    public int addGrade(
        @WebParam(name = "Grade", targetNamespace = "http://article.nure.ua/entity")
        Grade grade)
        throws DAOException_Exception
    ;

    /**
     * 
     * @param comment
     * @return
     *     returns int
     * @throws DAOException_Exception
     */
    @WebMethod
    @WebResult(targetNamespace = "http://article.nure.ua/entity")
    @RequestWrapper(localName = "addComment", targetNamespace = "http://article.nure.ua/server/service", className = "ua.nure.article.server.service.AddComment")
    @ResponseWrapper(localName = "addCommentResponse", targetNamespace = "http://article.nure.ua/server/service", className = "ua.nure.article.server.service.AddCommentResponse")
    @Action(input = "http://article.nure.ua/server/service/ArticleService/addCommentRequest", output = "http://article.nure.ua/server/service/ArticleService/addCommentResponse", fault = {
        @FaultAction(className = DAOException_Exception.class, value = "http://article.nure.ua/server/service/ArticleService/addComment/Fault/DAOException")
    })
    public int addComment(
        @WebParam(name = "Comment", targetNamespace = "http://article.nure.ua/entity")
        Comment comment)
        throws DAOException_Exception
    ;

}

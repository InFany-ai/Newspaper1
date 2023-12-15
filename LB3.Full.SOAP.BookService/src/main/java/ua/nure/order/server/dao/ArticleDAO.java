package ua.nure.order.server.dao;

import ua.nure.article.entity.article.Article;
import ua.nure.article.entity.article.Comment;
import ua.nure.article.entity.article.Grade;

import java.util.Collection;

public interface ArticleDAO {
    public Collection<Article> listArticles();
    public int addArticle(Article item);
    public int addGrade(Grade grade);
    public int addComment(Comment comment);
    public Collection<Article> findByTag(String pattern);

}
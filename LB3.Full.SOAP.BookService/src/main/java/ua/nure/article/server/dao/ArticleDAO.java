package ua.nure.article.server.dao;


import ua.nure.article.entity.Article;
import ua.nure.article.entity.ArticleTag;
import ua.nure.article.entity.Comment;
import ua.nure.article.entity.Grade;

import java.util.Collection;

public interface ArticleDAO {
    public Collection<Article> listArticles();
    public int addArticle(Article item);
    public int addGrade(Grade grade);
    public int addComment(Comment comment);
    public int addArticleTag(ArticleTag articleTag);
    public Collection<Article> findByTag(String pattern);

}
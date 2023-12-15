package ua.nure.order.server.dao;

import ua.nure.article.entity.article.*;
import ua.nure.dbtable.DBTable;
import ua.nure.dbtable.DBTableFactory;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class ArticleDAOInMemoryImpl implements ArticleDAO {
    DBTable<Article> articles = DBTableFactory.instance();
    DBTable<Author> authors = DBTableFactory.instance();
    DBTable<Grade> grades = DBTableFactory.instance();
    DBTable<Comment> comments = DBTableFactory.instance();
    DBTable<ArticleTag> articleTags = DBTableFactory.instance();

    private static ArticleDAOInMemoryImpl instance;

    private ArticleDAOInMemoryImpl() {
        initArticles();
    }

    private Article newArticle(int articleId, String title, String body, Author author, List<ArticleTag> articleTags, List<Comment> comments, List<Grade> grades) {
        Article article = new Article();
        article.setId(articleId);
        article.setTitle(title);
        article.setBody(body);
        article.setAuthor(author);
        article.getArticleTag().addAll(articleTags);
        article.getComment().addAll(comments);
        article.getGrade().addAll(grades);
        return article;
    }

    private ArticleTag newArticleTag(String name, int articleId) {
        ArticleTag articleTag = new ArticleTag();
        articleTag.setName(name);
        articleTag.setArticleId(articleId);

        return articleTag;
    }

    private Comment newComment(String body, int articleId) {
        Comment comment = new Comment();
        comment.setBody(body);
        comment.setArticleId(articleId);

        return comment;
    }

    private Grade newGrade(int value, int articleId) {
        Grade grade = new Grade();
        grade.setValue(value);
        grade.setArticleId(articleId);

        return grade;
    }

    private Author newAuthor(String firstName, String lastName, int age) {
        Author author = new Author();
        author.setFirstName(firstName);
        author.setLastName(lastName);
        author.setAge(age);

        return author;
    }
    private void initArticles() {
        Article[] articles = new Article[] {
                newArticle(1,
                        "Почему ASP, а не Java",
                        "Body1",
                        newAuthor("Дмитро", "Кудрявський", 18),
                        Arrays.asList(new ArticleTag[] { newArticleTag("Real", 1) }),
                        Arrays.asList(new Comment[] { newComment("BEAUTIFUL1", 1) }),
                        Arrays.asList(new Grade[] { newGrade(5, 1)})
                        ),
                newArticle(2,
                        "Почему не Java, а ASP",
                        "Body2",
                        newAuthor("Дмитро", "Кудрявський", 19),
                        Arrays.asList(new ArticleTag[] { newArticleTag("Real Tomorrow", 2) }),
                        Arrays.asList(new Comment[] { newComment("BEAUTIFUL2", 2) }),
                        Arrays.asList(new Grade[] { newGrade(4, 2)})
                ),
                newArticle(3,
                        "Почему не Java",
                        "Body3",
                        newAuthor("Дмитро", "Кудрявський", 20),
                        Arrays.asList(new ArticleTag[] { newArticleTag("Fantasy", 3) }),
                        Arrays.asList(new Comment[] { newComment("BEAUTIFUL3", 3) }),
                        Arrays.asList(new Grade[] { newGrade(3, 3)})
                ),
                newArticle(4,
                        "Почему ASP",
                        "Body4",
                        newAuthor("Дмитро", "Кудрявський", 21),
                        Arrays.asList(new ArticleTag[] { newArticleTag("Real today", 4) }),
                        Arrays.asList(new Comment[] { newComment("BEAUTIFUL4", 4) }),
                        Arrays.asList(new Grade[] { newGrade(4, 4)})
                ),
        };
        for (int i = 0; i < articles.length; i++) {
            addArticle(articles[i]);
        }
    }

    @Override
    public Collection<Article> listArticles() {
        return this.articles.selectAll();
    }

    @Override
    public int addArticle(Article article) {
        int id = articles.insert(article);
        article.setId(id);
        try {
            articles.update(id, article);
        } catch (SQLException e) {
            // inmemory
        }
        return id;
    }

    @Override
    public int addGrade(Grade grade) {
        int id = grades.insert(grade);
        grade.setId(id);
        try {
            grades.update(id, grade);
        } catch (SQLException e) {
            // inmemory
        }
        return id;
    }

    @Override
    public int addComment(Comment comment) {
        int id = comments.insert(comment);
        comment.setId(id);
        try {
            comments.update(id, comment);
        } catch (SQLException e) {
            // inmemory
        }
        return id;
    }

    @Override
    public Collection<Article> findByTag(String pattern) {
        return null;
    }
}

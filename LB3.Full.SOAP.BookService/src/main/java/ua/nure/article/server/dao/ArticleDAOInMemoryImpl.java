package ua.nure.article.server.dao;

import ua.nure.article.entity.*;
import ua.nure.dbtable.DBTable;
import ua.nure.dbtable.DBTableFactory;
import ua.nure.dbtable.Filter;

import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;

public class ArticleDAOInMemoryImpl implements ArticleDAO {
    DBTable<Article> articles = DBTableFactory.instance();

    private static ArticleDAOInMemoryImpl instance;

    private static int UniqId = 1;

    private static int GetUniqId() {
        return UniqId++;
    }

    private ArticleDAOInMemoryImpl() {
        initArticles();
    }

    public static synchronized ArticleDAOInMemoryImpl instance() {
        if (instance == null) {
            instance = new ArticleDAOInMemoryImpl();
        }
        return instance;
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
                        "title1",
                        "Body1",
                        newAuthor("Джон", "Смит", 18),
                        Arrays.asList(newArticleTag("Real", 1)),
                        Arrays.asList(newComment("BEAUTIFUL1", 1)),
                        Arrays.asList(newGrade(5, 1))
                        ),
                newArticle(2,
                        "title2",
                        "Body2",
                        newAuthor("Джон", "Смит", 19),
                        Arrays.asList(newArticleTag("Real Tomorrow", 2)),
                        Arrays.asList(newComment("BEAUTIFUL2", 2)),
                        Arrays.asList(newGrade(4, 2))
                ),
                newArticle(3,
                        "title3",
                        "Body3",
                        newAuthor("Джон", "Смит", 20),
                        Arrays.asList(newArticleTag("Fantasy", 3)),
                        Arrays.asList(newComment("BEAUTIFUL3", 3)),
                        Arrays.asList(newGrade(3, 3))
                ),
                newArticle(4,
                        "title4",
                        "Body4",
                        newAuthor("Джон", "Смит", 21),
                        Arrays.asList(newArticleTag("Real today", 4)),
                        Arrays.asList(newComment("BEAUTIFUL4", 4)),
                        Arrays.asList(newGrade(4, 4))
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
        int id = GetUniqId();
        article.setId(id);

        var author = article.getAuthor();
        author.setId(GetUniqId());

        var articleTags = article.getArticleTag();
        for (int i = 0; i < articleTags.size(); i++) {
            var articleTag = articleTags.get(i);
            articleTag.setArticleId(article.getId());
            articleTag.setId(GetUniqId());
        }

        var comments = article.getComment();
        for (int i = 0; i < comments.size(); i++) {
            var comment = comments.get(i);
            comment.setArticleId(article.getId());

            comment.setId(GetUniqId());
        }

        var grades = article.getGrade();
        for (int i = 0; i < grades.size(); i++) {
            var grade = grades.get(i);
            grade.setArticleId(article.getId());

            grade.setId(GetUniqId());
        }

        this.articles.insert(article);

        return id;
    }

    @Override
    public int addGrade(Grade grade) {
        var article = getArticleById(grade.getArticleId());
        grade.setId(GetUniqId());
        article.getGrade().add(grade);

        return grade.getId();
    }

    @Override
    public int addArticleTag(ArticleTag articleTag) {
        var article = getArticleById(articleTag.getArticleId());
        articleTag.setId(GetUniqId());
        article.getArticleTag().add(articleTag);

        return articleTag.getId();
    }


    @Override
    public int addComment(Comment comment) {
        var article = getArticleById(comment.getArticleId());
        comment.setId(GetUniqId());
        article.getComment().add(comment);

        return comment.getId();
    }

    @Override
    public Collection<Article> findByTag(String pattern) {
        return articles.filter(pattern, tagFilter);
    }

    Filter<Article> tagFilter = new Filter<>() {
        @Override
        public boolean accept(Article item, Object pattern) {
            String p = (String) pattern;
            for (int i = 0; i < item.getArticleTag().size(); i++) {
                ArticleTag articleTag = item.getArticleTag().get(i);
                if(articleTag.getName().equals(p)) {
                    return true;
                }
            }

            return false;
        }
    };

    private Article getArticleById(int id) {
        return this.articles.filter(id, articleFilterById).iterator().next();
    }

    Filter<Article> articleFilterById = new Filter<>() {
        @Override
        public boolean accept(Article item, Object pattern) {
            int p = (int) pattern;
            if(item.getId() == p) {
                return true;
            }

            return false;
        }
    };
}

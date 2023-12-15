package ua.nure.parser;

import ua.nure.article.entity.article.*;
import ua.nure.article.entity.article.Comment;

import javax.xml.namespace.QName;
import javax.xml.stream.events.*;
import java.util.ArrayList;
import java.util.List;

public class EventHandler {
    private static final boolean LOG_ENABLED = false;

    private String current;
    private String bodyParent;
    private String articleIdParent;
    private Author author;
    private Article article;
    private ArticleTag articleTag;
    private Comment comment;
    private Grade grade;
    private List<Article> articles;

    private static void log(Object o) {
        if (LOG_ENABLED) {
            System.out.println(o);
        }
    }

    public void endElement(XMLEvent event) {
        EndElement endElement = event.asEndElement();
        String localName = endElement.getName().getLocalPart();
        if (Const.TAG_ARTICLE.equals(localName)) {
            this.articles.add(this.article);
        } else if (Const.TAG_ARTICLETAG.equals(localName)) {
            this.article.getArticleTag().add(this.articleTag);
        } else if (Const.TAG_AUTHOR.equals(localName)) {
            this.article.setAuthor(this.author);
        } else if (Const.TAG_COMMENT.equals(localName)) {
            this.article.getComment().add(this.comment);
        } else if (Const.TAG_GRADE.equals(localName)) {
            this.article.getGrade().add(this.grade);
        }
    }

    public void characters(XMLEvent event) {
        Characters characters = event.asCharacters();
        String value = characters.getData();
        log("Characters: " + this.current);
        if (Const.TAG_TITLE.equals(this.current)) {
            this.article.setTitle(value);
        } else if (Const.TAG_BODY.equals(this.current)) {
            if(this.bodyParent.equals(Const.TAG_ARTICLE)) {
                this.article.setBody(value);
            }
            if(this.bodyParent.equals(Const.TAG_COMMENT)) {
                this.comment.setBody(value);
            }
        } else if (Const.TAG_FIRSTNAME.equals(this.current)) {
            this.author.setFirstName(value);
        } else if (Const.TAG_LASTNAME.equals(this.current)) {
            this.author.setLastName(value);
        } else if (Const.TAG_AGE.equals(this.current)) {
            this.author.setAge(Integer.parseInt(value));
        } else if (Const.TAG_ARTICLEID.equals(this.current)) {
            int articleId = Integer.parseInt(value);
            if(this.articleIdParent.equals(Const.TAG_ARTICLETAG)) {
                this.articleTag.setArticleId(articleId);
            }

            if(this.articleIdParent.equals(Const.TAG_COMMENT)) {
                this.comment.setArticleId(articleId);
            }

            if(this.articleIdParent.equals(Const.TAG_GRADE)) {
                this.grade.setArticleId(articleId);
            }
        } else if (Const.TAG_VALUE.equals(this.current)) {
            this.grade.setValue(Integer.parseInt(value));
        }
    }

    public void startElement(XMLEvent event) {
        StartElement startElement = event.asStartElement();
        this.current = startElement.getName().getLocalPart();
        log("StartElement: " + startElement.getName());
        Attribute attr = startElement.getAttributeByName(new QName(Const.ATTRIBUTE_ID));

        if (Const.TAG_ARTICLES.equals(this.current)) {
            this.articles = new ArrayList<>();
        } else if (Const.TAG_ARTICLE.equals(this.current)) {
            this.article = new Article();
            this.bodyParent = Const.TAG_ARTICLE;
            if (attr != null) {
                this.article.setId(Integer.parseInt(attr.getValue()));
            }
        } else if (Const.TAG_ARTICLETAG.equals(this.current)) {
            this.articleTag = new ArticleTag();
            this.articleIdParent = Const.TAG_ARTICLETAG;
            if (attr != null) {
                this.articleTag.setId(Integer.parseInt(attr.getValue()));
            }
        } else if (Const.TAG_AUTHOR.equals(this.current)) {
            this.author = new Author();
            if (attr != null) {
                this.author.setId(Integer.parseInt(attr.getValue()));
            }
        } else if (Const.TAG_COMMENT.equals(this.current)) {
            this.comment = new Comment();
            this.bodyParent = Const.TAG_COMMENT;
            this.articleIdParent = Const.TAG_COMMENT;

            if (attr != null) {
                this.comment.setId(Integer.parseInt(attr.getValue()));
            }
        } else if (Const.TAG_GRADE.equals(this.current)) {
            this.grade = new Grade();
            this.articleIdParent = Const.TAG_GRADE;

            if (attr != null) {
                this.grade.setId(Integer.parseInt(attr.getValue()));
            }
        }
    }

    public List<Article> getArticles() {
        return articles;
    }
}

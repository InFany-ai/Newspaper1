package ua.nure.parser;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import ua.nure.article.entity.article.*;

import javax.xml.XMLConstants;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class SAXParser extends DefaultHandler {
    private static final boolean LOG_ENABLED = false;

    public static void log(Object o) {
        if (LOG_ENABLED) {
            System.out.println(o);
        }
    }

    private String current;
    private String bodyParent;
    private String articleIdParent;
    private List<Article> articles;
    private ArticleTag articleTag;
    private Author author;
    private Comment comment;
    private Grade grade;
    private Article article;

    public List<Article> getArticles() {
        return articles;
    }

    @Override
    public void error(org.xml.sax.SAXParseException e) throws SAXException {
//		throw e; // throw exception if xml not valid
        System.err.println(e.getMessage());
    }

    public List<Article> parse(InputStream in, Schema schema) throws ParserConfigurationException, SAXException, IOException {

        /**
         * SAXParserFactory factory = SAXParserFactory.newInstance();
         *
         * // to be compliant, completely disable DOCTYPE declaration:
         * factory.setFeature("http://apache.org/xml/features/disallow-doctype-decl", true);
         *
         * // or completely disable external entities declarations:
         * factory.setFeature("http://xml.org/sax/features/external-general-entities", false);
         * factory.setFeature("http://xml.org/sax/features/external-parameter-entities", false);
         *
         * // or prohibit the use of all protocols by external entities:
         * SAXParser parser = factory.newSAXParser(); // Noncompliant
         * parser.setProperty(XMLConstants.ACCESS_EXTERNAL_DTD, "");
         * parser.setProperty(XMLConstants.ACCESS_EXTERNAL_SCHEMA, "");
         *
         */
        // XML parsers should not be vulnerable to XXE attacks
        // Fix by yourself
        SAXParserFactory factory = SAXParserFactory.newInstance();
        factory.setNamespaceAware(true);

        // make parser validating
//		factory.setFeature(Const.FEATURE__TURN_VALIDATION_ON, true);
//		factory.setFeature(Const.FEATURE__TURN_SCHEMA_VALIDATION_ON, true);

        factory.setSchema(schema);
        javax.xml.parsers.SAXParser parser = factory.newSAXParser();
        parser.parse(in, this);

        return this.articles;
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) {

        this.current = localName;

        if (Const.TAG_ARTICLES.equals(this.current)) {
            this.articles = new ArrayList<>();
        } else if (Const.TAG_ARTICLE.equals(this.current)) {
            this.article = new Article();
            this.bodyParent = Const.TAG_ARTICLE;
            if (attributes.getLength() > 0) {
                this.article.setId(Integer.parseInt(attributes.getValue("Id")));
            }
        } else if (Const.TAG_ARTICLETAG.equals(this.current)) {
            this.articleTag = new ArticleTag();
            this.articleIdParent = Const.TAG_ARTICLETAG;
            if (attributes.getLength() > 0) {
                this.articleTag.setId(Integer.parseInt(attributes.getValue("Id")));
            }
        } else if (Const.TAG_AUTHOR.equals(this.current)) {
            this.author = new Author();
            if (attributes.getLength() > 0) {
                this.author.setId(Integer.parseInt(attributes.getValue("Id")));
            }
        } else if (Const.TAG_COMMENT.equals(this.current)) {
            this.comment = new Comment();
            this.bodyParent = Const.TAG_COMMENT;
            this.articleIdParent = Const.TAG_COMMENT;

            if (attributes.getLength() > 0) {
                this.comment.setId(Integer.parseInt(attributes.getValue("Id")));
            }
        } else if (Const.TAG_GRADE.equals(this.current)) {
            this.grade = new Grade();
            this.articleIdParent = Const.TAG_GRADE;

            if (attributes.getLength() > 0) {
                this.grade.setId(Integer.parseInt(attributes.getValue("Id")));
            }
        }

    }

    @Override
    public void characters(char[] ch, int start, int length) {
        String value = new String(ch, start, length);
        if (value.isBlank()) {
            return;
        }
        if (Const.TAG_TITLE.equals(this.current)) {
            this.article.setTitle(value);
        } else if (Const.TAG_BODY.equals(this.current)) {
            switch (this.bodyParent) {
                case Const.TAG_ARTICLE -> this.article.setBody(value);
                case Const.TAG_COMMENT -> this.comment.setBody(value);
            }
        } else if (Const.TAG_FIRSTNAME.equals(this.current)) {
            this.author.setFirstName(value);
        } else if (Const.TAG_LASTNAME.equals(this.current)) {
            this.author.setLastName(value);
        } else if (Const.TAG_AGE.equals(this.current)) {
            this.author.setAge(Integer.parseInt(value));
        } else if (Const.TAG_ARTICLEID.equals(this.current)) {
            int articleId = Integer.parseInt(value);
            switch (this.articleIdParent) {
                case Const.TAG_COMMENT -> this.comment.setArticleId(articleId);
                case Const.TAG_GRADE -> this.grade.setArticleId(articleId);
                case Const.TAG_ARTICLETAG -> this.articleTag.setArticleId(articleId);
            }
        } else if (Const.TAG_VALUE.equals(this.current)) {
            this.grade.setValue(Integer.parseInt(value));
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) {
        if (Const.TAG_ARTICLE.equals(localName)) {
            this.articles.add(this.article);
            log(this.current + " " + this.article);
        } else if (Const.TAG_ARTICLETAG.equals(localName)) {
            this.article.getArticleTag().add(this.articleTag);
            log(this.current + " " + this.articleTag);
        } else if (Const.TAG_AUTHOR.equals(localName)) {
            this.article.setAuthor(this.author);
            log(this.current + " " + this.author);
        } else if (Const.TAG_COMMENT.equals(localName)) {
            this.article.getComment().add(this.comment);
            log(this.current + " " + this.comment);
        } else if (Const.TAG_GRADE.equals(localName)) {
            this.article.getGrade().add(this.grade);
            log(this.current + " " + this.grade);
        }
    }

    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
        // Create against validation schema
        SchemaFactory sf = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
        Schema schema = sf.newSchema(new File(Const.XSD_FILE));

        System.out.println("--== SAX Parser ==--");
        SAXParser parser = new SAXParser();
        parser.parse(new FileInputStream("xml/Articles.xml"), schema);
        List<Article> articles = parser.getArticles();
        System.out.println("====================================");
        System.out.println("Here is the articles: \n" + articles);
        System.out.println("====================================");
        parser.parse(new FileInputStream(Const.INVALID_XML_FILE), schema);
        articles = parser.getArticles();
        System.out.println("====================================");
        System.out.println("Here is the invalid articles: \n" + articles);
        System.out.println("====================================");
    }
}



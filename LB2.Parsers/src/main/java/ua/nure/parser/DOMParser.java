package ua.nure.parser;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.DefaultHandler;

import ua.nure.article.entity.article.*;

public class DOMParser {
    private static boolean logEnabled = false;

    private static void log(Object o) {
        if (logEnabled) {
            System.out.println(o);
        }
    }

    private Article parseArticle(Node node) {
        Article article = new Article();
        NodeList nodes = node.getChildNodes();
        for (int i = 0; i < nodes.getLength(); i++) {
            Node item = nodes.item(i);
            String localName = item.getLocalName();
            String textContent = item.getTextContent();
            log(localName);
            if (Const.TAG_ARTICLETAG.equals(localName)) {
                article.getArticleTag().add(parseArticleTag(item));
            } else if (Const.TAG_AUTHOR.equals(localName)) {
                article.setAuthor(parseAuthor(item));
            } else if (Const.TAG_COMMENT.equals(localName)) {
                article.getComment().add(parseComment(item));
            } else if (Const.TAG_GRADE.equals(localName)) {
                article.getGrade().add(parseGrade(item));
            }else if (Const.TAG_TITLE.equals(localName)) {
                article.setTitle(textContent);
                this.LogFieldAndValue(localName, textContent);
            } else if (Const.TAG_BODY.equals(localName)) {
                article.setBody(textContent);
                this.LogFieldAndValue(localName, textContent);
            }
        }

        return article;
    }

    private ArticleTag parseArticleTag(Node node) {
        ArticleTag articleTag = new ArticleTag();
        Integer attrId = this.GetAttributeIdFromNode(node);
        if (attrId != null) {
            articleTag.setId(attrId);
        }

        NodeList nodes = node.getChildNodes();
        for (int i = 0; i < nodes.getLength(); i++) {
            Node item = nodes.item(i);
            String localName = item.getLocalName();
            String textContent = item.getTextContent();
            log(localName);

            if (Const.TAG_NAME.equals(localName)) {
                articleTag.setName(textContent);
                this.LogFieldAndValue(localName, textContent);
            } else if (Const.TAG_ARTICLEID.equals(localName)) {
                articleTag.setArticleId(Integer.parseInt(textContent));
            }
        }

        return articleTag;
    }

    private Comment parseComment(Node node) {
        Comment comment = new Comment();
        Integer attrId = this.GetAttributeIdFromNode(node);
        if (attrId != null) {
            comment.setId(attrId);
        }

        NodeList nodes = node.getChildNodes();
        for (int i = 0; i < nodes.getLength(); i++) {
            Node item = nodes.item(i);
            String localName = item.getLocalName();
            String textContent = item.getTextContent();
            log(localName);

            if (Const.TAG_ARTICLEID.equals(localName)) {
                comment.setArticleId(Integer.parseInt(textContent));
                this.LogFieldAndValue(localName, textContent);
            } else if (Const.TAG_BODY.equals(localName)) {
                comment.setBody(textContent);
            }
        }

        return comment;
    }

    private Grade parseGrade(Node node) {
        Grade grade = new Grade();
        Integer attrId = this.GetAttributeIdFromNode(node);
        if (attrId != null) {
            grade.setId(attrId);
        }

        NodeList nodes = node.getChildNodes();
        for (int i = 0; i < nodes.getLength(); i++) {
            Node item = nodes.item(i);
            String localName = item.getLocalName();
            String textContent = item.getTextContent();
            log(localName);

            if (Const.TAG_ARTICLEID.equals(localName)) {
                grade.setArticleId(Integer.parseInt(textContent));
                this.LogFieldAndValue(localName, textContent);
            } else if (Const.TAG_VALUE.equals(localName)) {
                grade.setValue(Integer.parseInt(textContent));
            }
        }

        return grade;
    }

    private Author parseAuthor(Node node) {
        Author author = new Author();

        Integer attrId = this.GetAttributeIdFromNode(node);
        if (attrId != null) {
            author.setId(attrId);
        }

        NodeList nodes = node.getChildNodes();
        for (int i = 0; i < nodes.getLength(); i++) {
            Node item = nodes.item(i);
            String localName = item.getLocalName();
            String textContent = item.getTextContent();
            log(localName);

            if (Const.TAG_FIRSTNAME.equals(localName)) {
                author.setFirstName(textContent);
                this.LogFieldAndValue(localName, textContent);
            } else if (Const.TAG_LASTNAME.equals(localName)) {
                author.setLastName(textContent);
                this.LogFieldAndValue(localName, textContent);
            } else if (Const.TAG_AGE.equals(localName)) {
                author.setAge(Integer.parseInt(textContent));
                this.LogFieldAndValue(localName, textContent);
            }
        }

        return author;
    }

    private void LogFieldAndValue(String fieldName, String fieldValue) {
        log(fieldName + "=" + fieldValue);
    }

    private Integer GetAttributeIdFromNode(Node node) {
        if (node.hasAttributes()) {
            NamedNodeMap attrs = node.getAttributes();
            Node item = attrs.getNamedItem(Const.ATTRIBUTE_ID);
            String textContent = item.getTextContent();
            log(item.getLocalName() + "=" + textContent);
            return Integer.parseInt(textContent);
        }

        return null;
    }

    public List<Article> parse(InputStream in, Schema schema)
            throws ParserConfigurationException, SAXException, IOException {

        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        dbf.setNamespaceAware(true);

        // to be compliant, completely disable DOCTYPE declaration:
        dbf.setFeature("http://apache.org/xml/features/disallow-doctype-decl", true);
        // or completely disable external entities declarations:
//		dbf.setFeature("http://xml.org/sax/features/external-general-entities", false);
//		dbf.setFeature("http://xml.org/sax/features/external-parameter-entities", false);

        // make parser validating against XSD, which internally referenced in XML doc
        // !!! OLD VULNERABLE FEATURE !!!
//		dbf.setFeature(Const.FEATURE__TURN_VALIDATION_ON, true);
//		dbf.setFeature(Const.FEATURE__TURN_SCHEMA_VALIDATION_ON, true);

        // set the validation against schema
        dbf.setSchema(schema);

        DocumentBuilder db = dbf.newDocumentBuilder();

        // setup validation error handler
        // the preferred way is the throwing an exception
        db.setErrorHandler(new DefaultHandler() {
            @Override
            public void error(SAXParseException e) throws SAXException {
                System.err.println(e.getMessage()); // log error
//				throw e;
            }
        });

        // get the top of the xml tree
        Document root = db.parse(in);

        List<Article> articles = new ArrayList<>();

        // get the root element of the xml document
        Element e = root.getDocumentElement();
        NodeList xmlArticles = e.getElementsByTagNameNS(Const.ARTICLES_NAMESPACE_URI, Const.TAG_ARTICLE);
        for (int i = 0; i < xmlArticles.getLength(); i++) {
            articles.add(parseArticle(xmlArticles.item(i)));
        }

        return articles;
    }

    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
        // Create against validation schema
        SchemaFactory sf = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
        Schema schema = sf.newSchema(new File("xml/Articles.xsd"));

        System.out.println("--== DOM Parser ==--");
        DOMParser domParser = new DOMParser();
        InputStream in = new FileInputStream("xml/Articles.xml");
        List<Article> articles = domParser.parse(in, schema);

        System.out.println("====================================");
        System.out.println("Here is the articles: \n" + articles);
        System.out.println("====================================");

        in = new FileInputStream("xml/invalid_articles.xml");
        articles = domParser.parse(in, schema);
        System.out.println("====================================");
        System.out.println("Here is the articles from invalid xml: \n" + articles);
        System.out.println("====================================");
    }
}

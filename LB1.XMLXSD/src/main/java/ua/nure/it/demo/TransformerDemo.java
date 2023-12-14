package ua.nure.it.demo;

public class TransformerDemo {

    public static void main(String[] args) throws Exception {
        XSLTransform.main(new String[] {"xml/listArticle.xsl", "xml/Articles.xml", "xml/Articles.html"});
    }
}
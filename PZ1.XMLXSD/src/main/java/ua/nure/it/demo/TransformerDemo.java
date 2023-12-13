package ua.nure.it.demo;

public class TransformerDemo {

    public static void main(String[] args) throws Exception {
        XSLTransform.main(new String[] {"xml/Article.xslt", "xml/Article.xml", "xml/Article.html"});
    }
}
package ua.nure.it.demo;

public class ValidatorDemo {

    public static void main(String[] args) throws Exception {
        AgainstValidator.main(new String[] {"xml/Article.xsd", "xml/Article.xml"});
    }
}
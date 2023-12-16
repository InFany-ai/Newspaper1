package app;

import app.additions.ReturnsAtomic;
import app.entity.*;
import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.Invocation.Builder;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.Application;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import shop.service.Constants;
import shop.service.rest.JAXBContextProvider;
import shop.service.rest.JSONMessageBodyReader;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.math.BigInteger;
import java.net.URI;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class ArticlesRestClient extends Application {

    private static final URI BASE_URI = URI.create(Constants.SERVICE_BASE_URL);

    private static void printMenu() {
        System.out.println("1. Get articles\n" +
            "2. Add article\n" +
            "3. Add comment\n" +
            "4. add grade\n" +
            "5. add article tag\n" +
            "6. Find by article tag\n" +
            "7. Exit\n");
    }

    private static void getArticlesInfo(Client client) throws Exception {
        WebTarget target = client.target(BASE_URI);
        Builder request = target.request()
                .accept(MediaType.APPLICATION_JSON);
        Response resp = request.get();
        if (Response.Status.OK.getStatusCode() == resp.getStatus()) {
            var articles = resp.readEntity(Article[].class);
            for (Article article : articles) {
                System.out.println(article.toString());
            }
        } else {
            throw new Exception("Error with code " + resp.getStatus());
        }
    }

    private static void addArticle(Client client) throws Exception {
        Scanner scanner = new Scanner(System.in);
        var article = new Article();
        System.out.println("====Article====");
        System.out.println("Enter article title: ");
        String title = scanner.nextLine();
        System.out.println("Enter article body: ");
        String body = scanner.nextLine();

        var author = createAuthorForArticle();

        System.out.println("Enter count article tags:");
        String countAt = scanner.nextLine();
        var countAtInt = Integer.parseInt(countAt);
        for (int i = 0; i < countAtInt; i++) {
            var articleTag = createArticleTagForArticle();
            article.getArticleTag().add(articleTag);
        }

        article.setAuthor(author);
        article.setTitle(title);
        article.setBody(body);

        WebTarget target = client.target(BASE_URI + "/addArticle");
        Builder request = target.request()
                .accept(MediaType.APPLICATION_JSON);
        jakarta.ws.rs.client.Entity<Article> payload = jakarta.ws.rs.client.Entity.json(article);
        Response resp = request.post(payload);
        if (Response.Status.OK.getStatusCode() == resp.getStatus()) {
            var body1 = resp.readEntity(ReturnsAtomic.class);
            System.out.println("id = " + body1.getItem());
        } else {
            throw new Exception("Error with code " + resp.getStatus());
        }
    }

    private static Author createAuthorForArticle() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("====Author====");

        var author = new Author();
        System.out.println("Enter author's first name: ");
        String firstName = scanner.nextLine();
        System.out.println("Enter author's last name: ");
        String lastName = scanner.nextLine();
        System.out.println("Enter author's age: ");
        int age = Integer.parseInt(scanner.nextLine());

        author.setFirstName(firstName);
        author.setLastName(lastName);
        author.setAge(age);
        author.setId(1);

        return author;
    }

    private static ArticleTag createArticleTagForArticle() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("====ArticleTag====");

        var articleTag = new ArticleTag();
        System.out.println("Enter article tag name: ");
        String name = scanner.nextLine();

        articleTag.setName(name);
        articleTag.setId(1);

        return articleTag;
    }

    private static void addComment(Client client) throws Exception {

        Scanner scanner = new Scanner(System.in);
        System.out.println("====Comment====");

        var comment = new Comment();
        System.out.println("Enter comment body: ");
        String body = scanner.nextLine();

        System.out.println("Enter article id: ");
        int id = Integer.parseInt(scanner.nextLine());

        comment.setArticleId(id);
        comment.setBody(body);

        WebTarget target = client.target(BASE_URI + "/addComment");
        Builder request = target.request()
                .accept(MediaType.APPLICATION_JSON);
        jakarta.ws.rs.client.Entity<Comment> payload = jakarta.ws.rs.client.Entity.json(comment);
        Response resp = request.post(payload);
        if (Response.Status.OK.getStatusCode() == resp.getStatus()) {
            var body1 = resp.readEntity(ReturnsAtomic.class);
            System.out.println("id = " + body1.getItem());
        } else {
            throw new Exception("Error with code " + resp.getStatus());
        }
    }

    private static void addGrade(Client client) throws Exception {
        Scanner scanner = new Scanner(System.in);

        System.out.println("====Grade====");

        var grade = new Grade();
        System.out.println("Enter grade value: ");
        int value = Integer.parseInt(scanner.nextLine());

        System.out.println("Enter article id: ");
        int id = Integer.parseInt(scanner.nextLine());

        grade.setArticleId(id);
        grade.setValue(value);
        grade.setId(1);

        WebTarget target = client.target(BASE_URI + "/addGrade");
        Builder request = target.request()
                .accept(MediaType.APPLICATION_JSON);
        jakarta.ws.rs.client.Entity<Grade> payload = jakarta.ws.rs.client.Entity.json(grade);
        Response resp = request.post(payload);
        if (Response.Status.OK.getStatusCode() == resp.getStatus()) {
            var body1 = resp.readEntity(ReturnsAtomic.class);
            System.out.println("id = " + body1.getItem());
        } else {
            throw new Exception("Error with code " + resp.getStatus());
        }
    }

    private static void addArticleTag(Client client) throws Exception {
        Scanner scanner = new Scanner(System.in);

        System.out.println("====ArticleTag====");

        var articleTag = new ArticleTag();
        System.out.println("Enter article tag name: ");
        String name = scanner.nextLine();

        System.out.println("Enter article id: ");
        int id = Integer.parseInt(scanner.nextLine());

        articleTag.setArticleId(id);
        articleTag.setName(name);
        articleTag.setId(1);
        WebTarget target = client.target(BASE_URI + "/addArticleTag");
        Builder request = target.request()
                .accept(MediaType.APPLICATION_JSON);
        jakarta.ws.rs.client.Entity<ArticleTag> payload = jakarta.ws.rs.client.Entity.json(articleTag);
        Response resp = request.post(payload);
        if (Response.Status.OK.getStatusCode() == resp.getStatus()) {
            var body1 = resp.readEntity(ReturnsAtomic.class);
            System.out.println("id = " + body1.getItem());
        } else {
            throw new Exception("Error with code " + resp.getStatus());
        }
    }

    private static void findArticleByArticleTag(Client client, Scanner scanner) throws Exception {
        System.out.println("Enter article tag: ");
        String name = scanner.nextLine();
        WebTarget target = client.target(BASE_URI).path("search").queryParam("pattern", name);
        Builder request = target.request()
            .accept(MediaType.APPLICATION_JSON);
        Response resp = request.get();
        if (Response.Status.OK.getStatusCode() == resp.getStatus()) {
            var body = resp.readEntity(Article[].class);
            for (Article article : body) {
                System.out.println(article.toString());
            }
        } else {
            throw new Exception("Error with code " + resp.getStatus());
        }
    }

    public static void main(String[] args) {
        Client client = ClientBuilder.newClient();
        client
            .register(JSONMessageBodyReader.class)
            .register(JAXBContextProvider.class);

        Scanner sc = new Scanner(System.in);
        printMenu();
        while (true) {
            int choise = Integer.valueOf(sc.nextLine());
            try {
                switch (choise) {
                    case 1 -> {
                        getArticlesInfo(client);
                        break;
                    }
                    case 2 -> {
                        addArticle(client);
                        break;
                    }
                    case 3 -> {
                        addComment(client);
                        break;
                    }
                    case 4 -> {
                        addGrade(client);
                        break;
                    }
                    case 5 -> {
                        addArticleTag(client);
                        break;
                    }
                    case 6 -> {
                        findArticleByArticleTag(client, sc);
                        break;
                    }
                    case 7 -> {
                        return;
                    }
                    default -> {
                        System.out.println("Invalid option");
                        break;
                    }
                }
            } catch (Exception e) {
                System.out.println("[Error] " + e.getMessage());
                e.printStackTrace();
            }
            printMenu();
        }
    }

    private static GregorianCalendar convertToGregorianCalendar(String dateString) throws ParseException, DatatypeConfigurationException {
        SimpleDateFormat dateFormat;

        if (dateString.length() <= 10) { // If input contains only date (without time)
            dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        } else {
            dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        }
        Date date = dateFormat.parse(dateString);

        GregorianCalendar cal = new GregorianCalendar();
        cal.setTime(date);

        return cal;
    }

    private static XMLGregorianCalendar convertToXMLGregorianCalendar(GregorianCalendar calendar) throws DatatypeConfigurationException {
        return DatatypeFactory.newInstance().newXMLGregorianCalendar(calendar);
    }
}

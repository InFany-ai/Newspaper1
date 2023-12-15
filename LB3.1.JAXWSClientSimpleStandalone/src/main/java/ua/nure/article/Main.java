package ua.nure.article;

import ua.nure.article.entity.*;
import ua.nure.article.server.service.AddArticle;
import ua.nure.article.server.service.ArticleService;
import ua.nure.article.server.service.Articles;
import ua.nure.article.server.service.DAOException_Exception;

import java.util.Scanner;

public class Main {
    private static final String CLIENT_TOKEN_VALID = "clientToken";
    private static String CLIENT_TOKEN = "clientToken";
    private static void printMenu() {
        System.out.println("1. Get Articles\n" +
                "2. Add article\n" +
                "3. Add comment\n" +
                "4. Add grade\n" +
                "5. Find by article tag\n" +
                "7. Exit\n" +
                "8. Send with invalid token\n" +
                "9. Send with valid token");
    }

    public static void main(String[] args) throws Exception {
        System.setProperty("com.sun.xml.ws.transport.http.client.HttpTransportPipe.dump", "true");
        System.setProperty("com.sun.xml.internal.ws.transport.http.client.HttpTransportPipe.dump", "true");
        ArticleService client = new Articles().getArticlePort();
        Scanner sc = new Scanner(System.in);
        printMenu();
        while (true) {
            int choise = Integer.valueOf(sc.nextLine());
            try {
                switch (choise) {
                    case 1 -> {
                        getArticles(client);
                        break;
                    }
                    case 2 -> {
                        addArticle(client, sc);
                        break;
                    }
                    case 3 -> {
                        createComment(client, sc);
                        break;
                    }
                    case 4 -> {
                        createGrade(client, sc);
                        break;
                    }
                    case 5 -> {
//                        deletePost(client, sc);
                        break;
                    }
                    case 6 -> {
//                        findPostByHeader(client, sc);
                        break;
                    }
                    case 7 -> {
                        return;
                    }
                    case 8 -> {
                        CLIENT_TOKEN = null;
                    }
                    case 9 -> {
                        CLIENT_TOKEN = CLIENT_TOKEN_VALID;
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

    private static void getArticles(ArticleService service) {
        var res = service.listArticles();
        for (var article : res) {
                System.out.println(article.toString());
            }
    }

    private static void addArticle(ArticleService service, Scanner scanner) throws DAOException_Exception {
        var article = new Article();
        System.out.println("Enter article title: ");
        String title = scanner.nextLine();
        System.out.println("Enter article body: ");
        String body = scanner.nextLine();
        System.out.println("Enter first name: ");
        String firstName = scanner.nextLine();
        System.out.println("Enter last name: ");
        String lastName = scanner.nextLine();

        // Assuming Author and Image classes are similar to the previous method
        var author = createAuthor(scanner);

        System.out.println("Enter count article tags:");
        String countAt = scanner.nextLine();
        var countAtInt = Integer.parseInt(countAt);
        for (int i = 0; i < countAtInt; i++) {
            var articleTag = createArticleTag(scanner);
            article.getArticleTag().add(articleTag);
        }

        var request = service.addArticle(article);
        System.out.println("Created article with id " + request);
    }

    private static void createGrade(ArticleService service, Scanner scanner) throws DAOException_Exception {
        System.out.println("====Author====");

        var grade = new Grade();
        System.out.println("Enter grade value: ");
        int value = Integer.parseInt(scanner.nextLine());

        System.out.println("Enter article id: ");
        int id = Integer.parseInt(scanner.nextLine());

        grade.setArticleId(id);
        grade.setValue(value);

        service.addGrade(grade);

    }

    private static void createComment(ArticleService service, Scanner scanner) throws DAOException_Exception {
        System.out.println("====Author====");

        var comment = new Comment();
        System.out.println("Enter comment body: ");
        String body = scanner.nextLine();

        System.out.println("Enter article id: ");
        int id = Integer.parseInt(scanner.nextLine());

        comment.setArticleId(id);

        comment.setBody(body);
        comment.setArticleId(1);

        service.addComment(comment);

    }

    private static ArticleTag createArticleTag(Scanner scanner) {
        System.out.println("====Author====");

        var articleTag = new ArticleTag();
        System.out.println("Enter article tag name: ");
        String name = scanner.nextLine();

        System.out.println("Enter article id: ");
        int id = Integer.parseInt(scanner.nextLine());

        articleTag.setName(name);
        articleTag.setArticleId(id);

        return articleTag;
    }

    private static Author createAuthor(Scanner scanner) {
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

        return author;
    }

}

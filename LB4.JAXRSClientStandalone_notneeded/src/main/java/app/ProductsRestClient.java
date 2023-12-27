package app;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import app.additions.ReturnsAtomic;
import app.entity.*;
import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.Invocation.Builder;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.*;

import shop.service.Constants;
import shop.service.rest.JSONMessageBodyReader;

public class ProductsRestClient extends Application {

	private static final URI BASE_URI = URI.create(Constants.SERVICE_BASE_URL);

	private static void printMenu() {
		System.out.println("1. Get posts\n" +
				"2. Get post by id\n" +
				"3. Add post\n" +
				"4. Update post\n" +
				"5. Delete post\n" +
				"6. Find by header\n" +
				"7. Exit\n");
	}

	private static void getPosts(Client client) throws Exception {
		WebTarget target = client.target(BASE_URI);
		Builder request = target.request()
				.accept(MediaType.APPLICATION_JSON);
		Response resp = request.get();
		if (Response.Status.OK.getStatusCode() == resp.getStatus()) {
			// Прочитать тело ответа
			var body = resp.readEntity(Posts.class);
			for (Post post : body.getPost()) {
				System.out.println(post.toString());
			}
		} else {
			throw new Exception("Error with code " + resp.getStatus());
		}
	}

	private static void getPostById(Client client, Scanner scanner) throws Exception {
		System.out.println("Enter post id: ");
		String id = scanner.nextLine();
		WebTarget target = client.target(BASE_URI).path(id);
		Builder request = target.request()
				.accept(MediaType.APPLICATION_JSON);
		Response resp = request.get();
		if (Response.Status.OK.getStatusCode() == resp.getStatus()) {
			var post = resp.readEntity(Post.class);
			System.out.println(post.toString());
		} else {
			throw new Exception("Error with code " + resp.getStatus());
		}
	}

	private static void findPostByHeader(Client client, Scanner scanner) throws Exception {
		System.out.println("Enter posts header: ");
		String header = scanner.nextLine();
		System.out.println("Enter posts author: ");
		String author = scanner.nextLine();
		WebTarget target = client.target(BASE_URI).path("search").queryParam("pattern", header).queryParam("author", author);
		Builder request = target.request()
				.accept(MediaType.APPLICATION_JSON);
		Response resp = request.get();
		if (Response.Status.OK.getStatusCode() == resp.getStatus()) {
			var body = resp.readEntity(Posts.class);
			for (Post post : body.getPost()) {
				System.out.println(post.toString());
			}
		} else {
			throw new Exception("Error with code " + resp.getStatus());
		}
	}

	private static void addPost(Client client, Scanner scanner) throws Exception {
		var post = new Post();
		System.out.println("Enter post header: ");
		String header = scanner.nextLine();
		System.out.println("Enter post text: ");
		String text = scanner.nextLine();
		System.out.println("How many images you want to add: ");
		int imageCount = Integer.valueOf(scanner.nextLine());
		List<Image> imagesList = new ArrayList<>();
		for (int i = 0; i < imageCount; i++) {
			var image = new Image();
			System.out.println("Enter image URL: ");
			String url = scanner.nextLine();
			image.setImageUrl(url);
			image.setId(123);
			imagesList.add(image);
		}
		System.out.println("Enter your name: ");
		String username = scanner.nextLine();
		System.out.println("Select access level: \n" +
				"1. PRIVATE\n" +
				"2. PUBLIC\n" +
				"3. FRIEND ONLY");
		AccessLevel accessLevel = null;
		var selectFlag = true;
		while (selectFlag) {
			int choise = Integer.valueOf(scanner.nextLine());
			switch (choise) {
				case 1 -> {
					accessLevel = AccessLevel.HIDDEN;
					selectFlag = false;
				}
				case 2 -> {
					accessLevel = AccessLevel.PUBLIC;
					selectFlag = false;
				}
				case 3 -> {
					accessLevel = AccessLevel.FRIENDS_ONLY;
					selectFlag = false;
				}
				default -> {
					System.out.println("Invalid option");
					break;
				}
			}
		}
		post.setHeader(header);
		post.setText(text);
		var images = new Images();
		images.getImage().addAll(imagesList);
		post.setImages(images);
		post.setAccessLevel(accessLevel);
		var createdBy = new Author();
		createdBy.setUsername(username);
		createdBy.setId(123);
		var createdByImage = new Image();
		createdByImage.setImageUrl("http://test.png");
		createdBy.setImage(createdByImage);
		post.setCreatedBy(createdBy);
		WebTarget target = client.target(BASE_URI);
		Builder request = target.request()
				.accept(MediaType.APPLICATION_JSON);
		jakarta.ws.rs.client.Entity<Post> payload = jakarta.ws.rs.client.Entity.json(post);
		Response resp = request.post(payload);
		if (Response.Status.OK.getStatusCode() == resp.getStatus()) {
			var body = resp.readEntity(ReturnsAtomic.class);
			System.out.println("id = " + body.getItem());
		} else {
			throw new Exception("Error with code " + resp.getStatus());
		}
	}

	private static void updatePost(Client client, Scanner scanner) throws Exception {
		System.out.println("Enter id of post to edit: ");
		int id = Integer.valueOf(scanner.nextLine());
		var post = new Post();
		System.out.println("Enter post header: ");
		String header = scanner.nextLine();
		System.out.println("Enter post text: ");
		String text = scanner.nextLine();
		System.out.println("How many images you want to add: ");
		int imageCount = Integer.valueOf(scanner.nextLine());
		List<Image> imagesList = new ArrayList<>();
		for (int i = 0; i < imageCount; i++) {
			var image = new Image();
			System.out.println("Enter image URL: ");
			String url = scanner.nextLine();
			image.setImageUrl(url);
			image.setId(123);
			imagesList.add(image);
		}
		System.out.println("Enter your name: ");
		String username = scanner.nextLine();
		System.out.println("Select access level: \n" +
				"1. PRIVATE\n" +
				"2. PUBLIC\n" +
				"3. FRIEND ONLY");
		AccessLevel accessLevel = null;
		var selectFlag = true;
		while (selectFlag) {
			int choise = Integer.valueOf(scanner.nextLine());
			switch (choise) {
				case 1 -> {
					accessLevel = AccessLevel.HIDDEN;
					selectFlag = false;
				}
				case 2 -> {
					accessLevel = AccessLevel.PUBLIC;
					selectFlag = false;
				}
				case 3 -> {
					accessLevel = AccessLevel.FRIENDS_ONLY;
					selectFlag = false;
				}
				default -> {
					System.out.println("Invalid option");
					break;
				}
			}
		}
		post.setHeader(header);
		post.setText(text);
		var images = new Images();
		images.getImage().addAll(imagesList);
		post.setImages(images);
		post.setAccessLevel(accessLevel);
		var createdBy = new Author();
		createdBy.setUsername(username);
		createdBy.setId(123);
		var createdByImage = new Image();
		createdByImage.setImageUrl("http://test.png");
		createdBy.setImage(createdByImage);
		post.setCreatedBy(createdBy);
		post.setId(id);
		WebTarget target = client.target(BASE_URI).path(String.valueOf(id));
		Builder request = target.request()
				.accept(MediaType.APPLICATION_JSON);
		jakarta.ws.rs.client.Entity<Post> payload = jakarta.ws.rs.client.Entity.json(post);
		Response resp = request.put(payload);
		if (Response.Status.OK.getStatusCode() == resp.getStatus()) {
			var body = resp.readEntity(ReturnsAtomic.class);
			System.out.println("id = " + body.getItem());
		} else {
			throw new Exception("Error with code " + resp.getStatus());
		}
	}

	private static void deletePost(Client client, Scanner scanner) throws Exception {
		System.out.println("Enter id of post to delete: ");
		String id = scanner.nextLine();
		WebTarget target = client.target(BASE_URI).path(String.valueOf(id));
		Builder request = target.request()
				.accept(MediaType.APPLICATION_JSON);
		Response resp = request.delete();
		if (Response.Status.OK.getStatusCode() == resp.getStatus()) {
			var body = resp.readEntity(Post.class);
			System.out.println("deleted " + body);
		} else {
			throw new Exception("Error with code " + resp.getStatus());
		}
	}

	public static void main(String[] args) {
		Client client = ClientBuilder.newClient();
		client
				.register(JSONMessageBodyReader.class);

		Scanner sc = new Scanner(System.in);
		printMenu();
		while (true) {
			int choise = Integer.valueOf(sc.nextLine());
			try {
				switch (choise) {
					case 1 -> {
						getPosts(client);
						break;
					}
					case 2 -> {
						getPostById(client, sc);
						break;
					}
					case 3 -> {
						addPost(client, sc);
						break;
					}
					case 4 -> {
						updatePost(client, sc);
						break;
					}
					case 5 -> {
						deletePost(client, sc);
						break;
					}
					case 6 -> {
						findPostByHeader(client, sc);
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
}

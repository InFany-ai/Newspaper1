package shop.service;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.MatrixParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import shop.dao.PostDAO;
import shop.dao.PostDAOInMemoryImpl;
import shop.entity.Posts;

public class PostSearcher {

	private PostDAO store = PostDAOInMemoryImpl.instance();

	@GET
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public Posts search(@QueryParam("pattern") String pattern, @QueryParam("author") String author) {
		System.out.println("search for Title: " + pattern + " Author: " + author);
        return store.findByTitleAndAuthor(pattern, author);
	}

}

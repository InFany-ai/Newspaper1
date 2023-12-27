package ua.nure.article.server.client.web;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ua.nure.article.entity.Article;
import ua.nure.article.server.service.ArticleService;

import java.io.IOException;
import java.util.List;

/**
 * Servlet implementation class ListArticles
 */
public class ListArticles extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final transient Logger log = LoggerFactory.getLogger(ListArticles.class);

	private ArticleService service;

	@Override
	public void init() throws ServletException {
		super.init();
		ServletContext ctx = getServletContext();
		service = (ArticleService) ctx.getAttribute("ArticleService");
		log.trace("Get attribute ArticleService : {}",service);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Article> articles = service.listArticles();
		log.debug("Get books from ArticleService : {}", articles);
		request.setAttribute("articles", articles);
		log.trace("Set books to the session : {}", articles);
		request.getRequestDispatcher("list.jsp").forward(request, response);
		log.trace("Redirect to list.jsp");
	}

}

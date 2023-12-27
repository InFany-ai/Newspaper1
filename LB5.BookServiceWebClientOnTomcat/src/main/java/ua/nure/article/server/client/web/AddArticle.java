package ua.nure.article.server.client.web;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ua.nure.article.entity.Article;
import ua.nure.article.entity.ArticleTag;
import ua.nure.article.entity.Author;
import ua.nure.article.server.service.ArticleService;

import java.io.IOException;

public class AddArticle extends HttpServlet {
    private static final String DEBUG_ERROR_MSG = "Set errorMsg to the session";
    private static final long serialVersionUID = 1L;
    private final transient Logger log = LoggerFactory.getLogger(AddArticle.class);

    private transient ArticleService service;

    @Override
    public void init() throws ServletException {
        super.init();
        ServletContext ctx = getServletContext();
        service = (ArticleService) ctx.getAttribute("ArticleService");
        log.trace("Get attribute ArticleService : {}",service);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Article article = new Article();
        HttpSession session = request.getSession();
        log.debug("Requst encoding : {}",request.getCharacterEncoding());
        String errMsg = null;
        try {
            article.setTitle(request.getParameter("title"));
            article.setBody(request.getParameter("articleBody"));

            var author = new Author();
            author.setFirstName(request.getParameter("firstName"));
            author.setLastName(request.getParameter("lastName"));
            author.setAge(Integer.parseInt(request.getParameter("age")));
            article.setAuthor(author);

            var countAt = Integer.parseInt(request.getParameter("countAt"));
            for (int i = 1; i <= countAt; i++)
            {
                var value = request.getParameter("articleTag" + i);
                var articleTag = new ArticleTag();
                articleTag.setName(value);
                article.getArticleTag().add(articleTag);
            }

            log.debug("Get article from request : {}", article);

            // ----------------------------
            // TO DO Validate article
            // ----------------------------

            // send request to web-service
            int id = service.addArticle(article);
            log.debug("Article added with id : {}",id);

            // if ok set book into session attribute
            session.setAttribute("article", article);
        } catch (Exception e) {
            // Any other exceptions
            errMsg = "Error: Can not communicate with article service";
            log.debug(DEBUG_ERROR_MSG, e);
        }
        if (errMsg != null) {
            session.setAttribute("errorMsg", errMsg);
        }

        // PRG pattern
        response.sendRedirect("viewarticle.jsp");
        log.debug("Redirect to viewarticle.jsp");
    }

}

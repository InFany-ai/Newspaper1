package ua.nure.article.server.client.web;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ua.nure.article.entity.Grade;
import ua.nure.article.server.service.ArticleService;
import ua.nure.article.server.service.DAOException_Exception;

import java.io.IOException;

/**
 * Servlet implementation class AddGrade
 */
public class AddGrade extends HttpServlet {
    private static final String DEBUG_ERROR_MSG = "Set errorMsg to the session";
    private static final long serialVersionUID = 1L;
    private final transient Logger log = LoggerFactory.getLogger(AddComment.class);

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
        Grade grade = new Grade();
        HttpSession session = request.getSession();
        log.debug("Request encoding : {}",request.getCharacterEncoding());
        String errMsg = null;
        try {
            grade.setValue(Integer.parseInt(request.getParameter("value")));
            grade.setArticleId(Integer.parseInt(request.getParameter("articleId")));
            log.debug("Get grade from request : {}", grade);

            // ----------------------------
            // TO DO Validate grade
            // ----------------------------

            // send request to web-service
            int id = service.addGrade(grade);
            log.debug("Grade added with id : {}",id);

            // if ok set book into session attribute
            session.setAttribute("grade", grade);
        } catch (DAOException_Exception e) {
            // Internal exception in web-service
            errMsg = "Error: Can not add grade into database";
            log.debug(DEBUG_ERROR_MSG, e);
        } catch (Exception e) {
            // Any other exceptions
            errMsg = "Error: Can not communicate with article service";
            log.debug(DEBUG_ERROR_MSG, e);
        }
        if (errMsg != null) {
            session.setAttribute("errorMsg", errMsg);
        }

        // PRG pattern
        response.sendRedirect("viewgrade.jsp");
        log.debug("Redirect to viewgrade.jsp");
    }

}

package ua.nure.article.server.client;

import ua.nure.article.server.service.ArticleService;
import ua.nure.article.server.service.Articles;
//import ua.nure.article.server.servicehandler.SecurityHandler;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class ServiceProvider {
	private static ArticleService articles;
	private static String url;
	
	protected ServiceProvider() {}
	
	private static ArticleService getDefaultArticles() {
		Articles port = new Articles();
//		port.setHandlerResolver(portInfo -> List.of(new SecurityHandler()));
		return port.getArticlePort();
	}
	
	private static ArticleService getArticles(String url) throws MalformedURLException {
		Articles port = new Articles(new URL(url));
//		port.setHandlerResolver(portInfo -> List.of(new SecurityHandler()));
		return port.getArticlePort();
	}
	
	public static synchronized ArticleService getInstance(String url) {
		if (articles == null) {
			if (url == null) {
				articles = getDefaultArticles();
			} else {
				try {
					articles = getArticles(url);
				} catch (MalformedURLException e) {
					articles = null;
				}
			}
		} else if (!url.equals(ServiceProvider.url)) {
			try {
				articles = getArticles(url);
				ServiceProvider.url = url;
			} catch (MalformedURLException e) {
				ServiceProvider.url = null;
				articles = null;
			}
		}
		return articles;
	}
}

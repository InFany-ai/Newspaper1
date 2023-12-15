
package ua.nure.article.server.service;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import jakarta.xml.ws.Service;
import jakarta.xml.ws.WebEndpoint;
import jakarta.xml.ws.WebServiceClient;
import jakarta.xml.ws.WebServiceException;
import jakarta.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 3.0.0
 * Generated source version: 3.0
 * 
 */
@WebServiceClient(name = "Articles", targetNamespace = "http://article.nure.ua/server/service", wsdlLocation = "http://localhost:9000/articles?wsdl")
public class Articles
    extends Service
{

    private final static URL ARTICLES_WSDL_LOCATION;
    private final static WebServiceException ARTICLES_EXCEPTION;
    private final static QName ARTICLES_QNAME = new QName("http://article.nure.ua/server/service", "Articles");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://localhost:9000/articles?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        ARTICLES_WSDL_LOCATION = url;
        ARTICLES_EXCEPTION = e;
    }

    public Articles() {
        super(__getWsdlLocation(), ARTICLES_QNAME);
    }

    public Articles(WebServiceFeature... features) {
        super(__getWsdlLocation(), ARTICLES_QNAME, features);
    }

    public Articles(URL wsdlLocation) {
        super(wsdlLocation, ARTICLES_QNAME);
    }

    public Articles(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, ARTICLES_QNAME, features);
    }

    public Articles(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public Articles(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns ArticleService
     */
    @WebEndpoint(name = "ArticlePort")
    public ArticleService getArticlePort() {
        return super.getPort(new QName("http://article.nure.ua/server/service", "ArticlePort"), ArticleService.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link jakarta.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns ArticleService
     */
    @WebEndpoint(name = "ArticlePort")
    public ArticleService getArticlePort(WebServiceFeature... features) {
        return super.getPort(new QName("http://article.nure.ua/server/service", "ArticlePort"), ArticleService.class, features);
    }

    private static URL __getWsdlLocation() {
        if (ARTICLES_EXCEPTION!= null) {
            throw ARTICLES_EXCEPTION;
        }
        return ARTICLES_WSDL_LOCATION;
    }

}
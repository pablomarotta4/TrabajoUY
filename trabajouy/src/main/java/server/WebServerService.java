
package server;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;

import javax.xml.namespace.QName;
import jakarta.xml.ws.Service;
import jakarta.xml.ws.WebEndpoint;
import jakarta.xml.ws.WebServiceClient;
import jakarta.xml.ws.WebServiceException;
import jakarta.xml.ws.WebServiceFeature;


/**
 * This class was generated by the XML-WS Tools.
 * XML-WS Tools 4.0.0
 * Generated source version: 3.0
 * 
 */
@WebServiceClient(name = "WebServerService", targetNamespace = "http://server/", wsdlLocation = "http://localhost:8085/webService?wsdl")
public class WebServerService
    extends Service
{

    private final static URL WEBSERVERSERVICE_WSDL_LOCATION;
    private final static WebServiceException WEBSERVERSERVICE_EXCEPTION;
    private final static QName WEBSERVERSERVICE_QNAME = new QName("http://server/", "WebServerService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
        	String path = System.getProperty("user.home") + File.separator + "trabajouy" + File.separator + "config.properties";
    		Properties appProps = new Properties();
    		try {
    			appProps.load(new FileInputStream(path));
    		} catch (FileNotFoundException ex) {
    			e.printStackTrace();
    		} catch (IOException ex) {
    			e.printStackTrace();
    		}
    		
    		String host = (String) appProps.get("host");
    		String port = (String) appProps.get("port");
    		String urlString = host + ":" + port + "/webService";
            url = new URL(urlString);
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        WEBSERVERSERVICE_WSDL_LOCATION = url;
        WEBSERVERSERVICE_EXCEPTION = e;
    }

    public WebServerService() {
        super(__getWsdlLocation(), WEBSERVERSERVICE_QNAME);
    }

    public WebServerService(WebServiceFeature... features) {
        super(__getWsdlLocation(), WEBSERVERSERVICE_QNAME, features);
    }

    public WebServerService(URL wsdlLocation) {
        super(wsdlLocation, WEBSERVERSERVICE_QNAME);
    }

    public WebServerService(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, WEBSERVERSERVICE_QNAME, features);
    }

    public WebServerService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public WebServerService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns WebServer
     */
    @WebEndpoint(name = "WebServerPort")
    public WebServer getWebServerPort() {
        return super.getPort(new QName("http://server/", "WebServerPort"), WebServer.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link jakarta.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns WebServer
     */
    @WebEndpoint(name = "WebServerPort")
    public WebServer getWebServerPort(WebServiceFeature... features) {
        return super.getPort(new QName("http://server/", "WebServerPort"), WebServer.class, features);
    }

    private static URL __getWsdlLocation() {
        if (WEBSERVERSERVICE_EXCEPTION!= null) {
            throw WEBSERVERSERVICE_EXCEPTION;
        }
        return WEBSERVERSERVICE_WSDL_LOCATION;
    }

}

package server;

import jakarta.jws.WebMethod;
import jakarta.jws.WebService;
import jakarta.jws.soap.SOAPBinding;
import jakarta.jws.soap.SOAPBinding.ParameterStyle;
import jakarta.jws.soap.SOAPBinding.Style;
import jakarta.xml.ws.Endpoint;
import logica.interfaces.Factory;
import logica.interfaces.IControladorCompraTipo;
import logica.interfaces.IControladorOferta;
import logica.interfaces.IControladorUsuario;


@WebService
@SOAPBinding(style = Style.RPC, parameterStyle = ParameterStyle.WRAPPED)
public class WebServer {

	private IControladorUsuario ctrlUsuario = Factory.getInstance().getControladorUsuario();
	private IControladorOferta ctrlOferta = Factory.getInstance().getControladorOferta();
	private IControladorCompraTipo ctrlCompraTipo = Factory.getInstance().getControladorCompraTipo();
	private Endpoint endpoint = null;
	
	@WebMethod(exclude = true)
	public void publicar() {
		endpoint = Endpoint.publish("http://localhost:8085/webService", this);
	}
	
    @WebMethod(exclude = true)
    public Endpoint getEndpoint() {
            return endpoint;
    }
    
    @WebMethod
    public int suma(int i, int j){
        return i + j;
    }
    
}
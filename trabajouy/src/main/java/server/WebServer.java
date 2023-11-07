
package server;

import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebResult;
import jakarta.jws.WebService;
import jakarta.jws.soap.SOAPBinding;
import jakarta.xml.bind.annotation.XmlSeeAlso;
import jakarta.xml.ws.Action;
import jakarta.xml.ws.FaultAction;


/**
 * This class was generated by the XML-WS Tools.
 * XML-WS Tools 4.0.0
 * Generated source version: 3.0
 * 
 */
@WebService(name = "WebServer", targetNamespace = "http://server/")
@SOAPBinding(style = SOAPBinding.Style.RPC)
@XmlSeeAlso({
    ObjectFactory.class
})
public interface WebServer {


    /**
     * 
     * @param arg0
     * @param arg1
     * @param arg2
     * @param arg3
     * @param arg4
     * @param arg5
     * @param arg6
     * @param arg7
     * @throws CamposVaciosExcepcion_Exception
     * @throws UsuarioRepetidoException_Exception
     */
    @WebMethod
    @Action(input = "http://server/WebServer/crearPostulanteRequest", output = "http://server/WebServer/crearPostulanteResponse", fault = {
        @FaultAction(className = UsuarioRepetidoException_Exception.class, value = "http://server/WebServer/crearPostulante/Fault/UsuarioRepetidoException"),
        @FaultAction(className = CamposVaciosExcepcion_Exception.class, value = "http://server/WebServer/crearPostulante/Fault/CamposVaciosExcepcion")
    })
    public void crearPostulante(
        @WebParam(name = "arg0", partName = "arg0")
        String arg0,
        @WebParam(name = "arg1", partName = "arg1")
        String arg1,
        @WebParam(name = "arg2", partName = "arg2")
        String arg2,
        @WebParam(name = "arg3", partName = "arg3")
        String arg3,
        @WebParam(name = "arg4", partName = "arg4")
        String arg4,
        @WebParam(name = "arg5", partName = "arg5")
        String arg5,
        @WebParam(name = "arg6", partName = "arg6")
        String arg6,
        @WebParam(name = "arg7", partName = "arg7")
        String arg7)
        throws CamposVaciosExcepcion_Exception, UsuarioRepetidoException_Exception
    ;

    /**
     * 
     * @param arg0
     * @param arg1
     * @param arg2
     * @param arg3
     * @param arg4
     * @param arg5
     * @throws UsuarioRepetidoException_Exception
     */
    @WebMethod
    @Action(input = "http://server/WebServer/crearTipoPublicacionRequest", output = "http://server/WebServer/crearTipoPublicacionResponse", fault = {
        @FaultAction(className = UsuarioRepetidoException_Exception.class, value = "http://server/WebServer/crearTipoPublicacion/Fault/UsuarioRepetidoException")
    })
    public void crearTipoPublicacion(
        @WebParam(name = "arg0", partName = "arg0")
        String arg0,
        @WebParam(name = "arg1", partName = "arg1")
        String arg1,
        @WebParam(name = "arg2", partName = "arg2")
        int arg2,
        @WebParam(name = "arg3", partName = "arg3")
        int arg3,
        @WebParam(name = "arg4", partName = "arg4")
        float arg4,
        @WebParam(name = "arg5", partName = "arg5")
        String arg5)
        throws UsuarioRepetidoException_Exception
    ;

    /**
     * 
     * @param arg0
     * @param arg1
     * @param arg2
     * @param arg3
     * @param arg4
     * @param arg5
     * @param arg6
     * @param arg7
     * @throws CamposVaciosExcepcion_Exception
     * @throws UsuarioRepetidoException_Exception
     */
    @WebMethod
    @Action(input = "http://server/WebServer/crearEmpresaRequest", output = "http://server/WebServer/crearEmpresaResponse", fault = {
        @FaultAction(className = UsuarioRepetidoException_Exception.class, value = "http://server/WebServer/crearEmpresa/Fault/UsuarioRepetidoException"),
        @FaultAction(className = CamposVaciosExcepcion_Exception.class, value = "http://server/WebServer/crearEmpresa/Fault/CamposVaciosExcepcion")
    })
    public void crearEmpresa(
        @WebParam(name = "arg0", partName = "arg0")
        String arg0,
        @WebParam(name = "arg1", partName = "arg1")
        String arg1,
        @WebParam(name = "arg2", partName = "arg2")
        String arg2,
        @WebParam(name = "arg3", partName = "arg3")
        String arg3,
        @WebParam(name = "arg4", partName = "arg4")
        String arg4,
        @WebParam(name = "arg5", partName = "arg5")
        String arg5,
        @WebParam(name = "arg6", partName = "arg6")
        String arg6,
        @WebParam(name = "arg7", partName = "arg7")
        String arg7)
        throws CamposVaciosExcepcion_Exception, UsuarioRepetidoException_Exception
    ;

    /**
     * 
     * @param arg0
     * @throws ElementoRepetidoException_Exception
     */
    @WebMethod
    @Action(input = "http://server/WebServer/altaKeywordRequest", output = "http://server/WebServer/altaKeywordResponse", fault = {
        @FaultAction(className = ElementoRepetidoException_Exception.class, value = "http://server/WebServer/altaKeyword/Fault/ElementoRepetidoException")
    })
    public void altaKeyword(
        @WebParam(name = "arg0", partName = "arg0")
        String arg0)
        throws ElementoRepetidoException_Exception
    ;

    /**
     * 
     * @param arg0
     * @param arg1
     * @param arg10
     * @param arg2
     * @param arg3
     * @param arg4
     * @param arg5
     * @param arg6
     * @param arg7
     * @param arg8
     * @param arg9
     * @throws ElementoInexistenteException_Exception
     * @throws ElementoRepetidoException_Exception
     */
    @WebMethod
    @Action(input = "http://server/WebServer/altaOfertaLaboralRequest", output = "http://server/WebServer/altaOfertaLaboralResponse", fault = {
        @FaultAction(className = ElementoRepetidoException_Exception.class, value = "http://server/WebServer/altaOfertaLaboral/Fault/ElementoRepetidoException"),
        @FaultAction(className = ElementoInexistenteException_Exception.class, value = "http://server/WebServer/altaOfertaLaboral/Fault/ElementoInexistenteException")
    })
    public void altaOfertaLaboral(
        @WebParam(name = "arg0", partName = "arg0")
        String arg0,
        @WebParam(name = "arg1", partName = "arg1")
        String arg1,
        @WebParam(name = "arg2", partName = "arg2")
        String arg2,
        @WebParam(name = "arg3", partName = "arg3")
        String arg3,
        @WebParam(name = "arg4", partName = "arg4")
        String arg4,
        @WebParam(name = "arg5", partName = "arg5")
        float arg5,
        @WebParam(name = "arg6", partName = "arg6")
        String arg6,
        @WebParam(name = "arg7", partName = "arg7")
        String arg7,
        @WebParam(name = "arg8", partName = "arg8")
        String arg8,
        @WebParam(name = "arg9", partName = "arg9")
        String arg9,
        @WebParam(name = "arg10", partName = "arg10")
        CollectionBean arg10)
        throws ElementoInexistenteException_Exception, ElementoRepetidoException_Exception
    ;

    /**
     * 
     * @param arg0
     * @param arg1
     * @param arg2
     * @param arg3
     * @param arg4
     * @throws ElementoInexistenteException_Exception
     * @throws ElementoRepetidoException_Exception
     * @throws NoExisteInstancia_Exception
     */
    @WebMethod
    @Action(input = "http://server/WebServer/altaPostulacionRequest", output = "http://server/WebServer/altaPostulacionResponse", fault = {
        @FaultAction(className = NoExisteInstancia_Exception.class, value = "http://server/WebServer/altaPostulacion/Fault/NoExisteInstancia"),
        @FaultAction(className = ElementoRepetidoException_Exception.class, value = "http://server/WebServer/altaPostulacion/Fault/ElementoRepetidoException"),
        @FaultAction(className = ElementoInexistenteException_Exception.class, value = "http://server/WebServer/altaPostulacion/Fault/ElementoInexistenteException")
    })
    public void altaPostulacion(
        @WebParam(name = "arg0", partName = "arg0")
        String arg0,
        @WebParam(name = "arg1", partName = "arg1")
        String arg1,
        @WebParam(name = "arg2", partName = "arg2")
        String arg2,
        @WebParam(name = "arg3", partName = "arg3")
        String arg3,
        @WebParam(name = "arg4", partName = "arg4")
        String arg4)
        throws ElementoInexistenteException_Exception, ElementoRepetidoException_Exception, NoExisteInstancia_Exception
    ;

    /**
     * 
     * @param arg0
     */
    @WebMethod
    @Action(input = "http://server/WebServer/pruebaCollectionRequest", output = "http://server/WebServer/pruebaCollectionResponse")
    public void pruebaCollection(
        @WebParam(name = "arg0", partName = "arg0")
        ArrayList arg0);

    /**
     * 
     * @param arg0
     * @param arg1
     * @return
     *     returns boolean
     */
    @WebMethod
    @WebResult(partName = "return")
    @Action(input = "http://server/WebServer/estaPostuladoRequest", output = "http://server/WebServer/estaPostuladoResponse")
    public boolean estaPostulado(
        @WebParam(name = "arg0", partName = "arg0")
        String arg0,
        @WebParam(name = "arg1", partName = "arg1")
        String arg1);

    /**
     * 
     * @return
     *     returns server.ArrayList
     */
    @WebMethod
    @WebResult(partName = "return")
    @Action(input = "http://server/WebServer/listarUsuariosRequest", output = "http://server/WebServer/listarUsuariosResponse")
    public ArrayList listarUsuarios();

    /**
     * 
     * @return
     *     returns server.ArrayList
     */
    @WebMethod
    @WebResult(partName = "return")
    @Action(input = "http://server/WebServer/listarNickEmpresasRequest", output = "http://server/WebServer/listarNickEmpresasResponse")
    public ArrayList listarNickEmpresas();

    /**
     * 
     * @param arg0
     * @return
     *     returns server.ArrayList
     */
    @WebMethod
    @WebResult(partName = "return")
    @Action(input = "http://server/WebServer/consultarOfertasRequest", output = "http://server/WebServer/consultarOfertasResponse")
    public ArrayList consultarOfertas(
        @WebParam(name = "arg0", partName = "arg0")
        String arg0);

    /**
     * 
     * @param arg0
     * @return
     *     returns server.DtOfertaLaboral
     * @throws ElementoInexistenteException_Exception
     */
    @WebMethod
    @WebResult(partName = "return")
    @Action(input = "http://server/WebServer/listarDatosOfertaRequest", output = "http://server/WebServer/listarDatosOfertaResponse", fault = {
        @FaultAction(className = ElementoInexistenteException_Exception.class, value = "http://server/WebServer/listarDatosOferta/Fault/ElementoInexistenteException")
    })
    public DtOfertaLaboral listarDatosOferta(
        @WebParam(name = "arg0", partName = "arg0")
        String arg0)
        throws ElementoInexistenteException_Exception
    ;

    /**
     * 
     * @param arg0
     * @param arg1
     * @param arg2
     * @param arg3
     * @param arg4
     * @param arg5
     * @param arg6
     * @param arg7
     */
    @WebMethod
    @Action(input = "http://server/WebServer/modificarUsuarioRequest", output = "http://server/WebServer/modificarUsuarioResponse")
    public void modificarUsuario(
        @WebParam(name = "arg0", partName = "arg0")
        String arg0,
        @WebParam(name = "arg1", partName = "arg1")
        String arg1,
        @WebParam(name = "arg2", partName = "arg2")
        String arg2,
        @WebParam(name = "arg3", partName = "arg3")
        String arg3,
        @WebParam(name = "arg4", partName = "arg4")
        String arg4,
        @WebParam(name = "arg5", partName = "arg5")
        String arg5,
        @WebParam(name = "arg6", partName = "arg6")
        LocalDate arg6,
        @WebParam(name = "arg7", partName = "arg7")
        String arg7);

    /**
     * 
     * @param arg0
     * @return
     *     returns server.DataPostulante
     */
    @WebMethod
    @WebResult(partName = "return")
    @Action(input = "http://server/WebServer/getDTPostulanteRequest", output = "http://server/WebServer/getDTPostulanteResponse")
    public DataPostulante getDTPostulante(
        @WebParam(name = "arg0", partName = "arg0")
        String arg0);

    /**
     * 
     * @param arg0
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(partName = "return")
    @Action(input = "http://server/WebServer/getFotoUsuarioRequest", output = "http://server/WebServer/getFotoUsuarioResponse")
    public String getFotoUsuario(
        @WebParam(name = "arg0", partName = "arg0")
        String arg0);

    /**
     * 
     * @return
     *     returns server.CollectionBean
     */
    @WebMethod
    @WebResult(partName = "return")
    @Action(input = "http://server/WebServer/listarKeywordsRequest", output = "http://server/WebServer/listarKeywordsResponse")
    public CollectionBean listarKeywords();

    /**
     * 
     * @param arg0
     * @return
     *     returns server.DataEmpresa
     */
    @WebMethod
    @WebResult(partName = "return")
    @Action(input = "http://server/WebServer/getDTEmpresaRequest", output = "http://server/WebServer/getDTEmpresaResponse")
    public DataEmpresa getDTEmpresa(
        @WebParam(name = "arg0", partName = "arg0")
        String arg0);

    /**
     * 
     * @return
     *     returns server.CollectionBean
     */
    @WebMethod
    @WebResult(partName = "return")
    @Action(input = "http://server/WebServer/listarDTUsuariosRequest", output = "http://server/WebServer/listarDTUsuariosResponse")
    public CollectionBean listarDTUsuarios();

    /**
     * 
     * @param arg0
     * @return
     *     returns server.Empresa
     */
    @WebMethod
    @WebResult(partName = "return")
    @Action(input = "http://server/WebServer/getEmpresaRequest", output = "http://server/WebServer/getEmpresaResponse")
    public Empresa getEmpresa(
        @WebParam(name = "arg0", partName = "arg0")
        String arg0);

    /**
     * 
     * @return
     *     returns server.CollectionBean
     */
    @WebMethod
    @WebResult(partName = "return")
    @Action(input = "http://server/WebServer/listarDtOfertasRequest", output = "http://server/WebServer/listarDtOfertasResponse")
    public CollectionBean listarDtOfertas();

    /**
     * 
     * @return
     *     returns server.CollectionBean
     */
    @WebMethod
    @WebResult(partName = "return")
    @Action(input = "http://server/WebServer/listarDtOfertasConfirmadasNoExpiradasRequest", output = "http://server/WebServer/listarDtOfertasConfirmadasNoExpiradasResponse")
    public CollectionBean listarDtOfertasConfirmadasNoExpiradas();

    /**
     * 
     * @param arg0
     * @return
     *     returns server.ArrayList
     */
    @WebMethod
    @WebResult(partName = "return")
    @Action(input = "http://server/WebServer/consultarPostulacionesRequest", output = "http://server/WebServer/consultarPostulacionesResponse")
    public ArrayList consultarPostulaciones(
        @WebParam(name = "arg0", partName = "arg0")
        String arg0);

    /**
     * 
     * @return
     *     returns server.ArrayList
     */
    @WebMethod
    @WebResult(partName = "return")
    @Action(input = "http://server/WebServer/listarNickPostulantesRequest", output = "http://server/WebServer/listarNickPostulantesResponse")
    public ArrayList listarNickPostulantes();

    /**
     * 
     * @return
     *     returns server.CollectionBean
     */
    @WebMethod
    @WebResult(partName = "return")
    @Action(input = "http://server/WebServer/getDataTiposPublicacionRequest", output = "http://server/WebServer/getDataTiposPublicacionResponse")
    public CollectionBean getDataTiposPublicacion();

    /**
     * 
     * @param arg0
     * @return
     *     returns server.DataUsuario
     */
    @WebMethod
    @WebResult(partName = "return")
    @Action(input = "http://server/WebServer/consultarDatosUsuarioRequest", output = "http://server/WebServer/consultarDatosUsuarioResponse")
    public DataUsuario consultarDatosUsuario(
        @WebParam(name = "arg0", partName = "arg0")
        String arg0);

    /**
     * 
     * @param arg0
     * @return
     *     returns server.DataTipoPublicacion
     */
    @WebMethod
    @WebResult(partName = "return")
    @Action(input = "http://server/WebServer/listarDatosTipoPubliacionRequest", output = "http://server/WebServer/listarDatosTipoPubliacionResponse")
    public DataTipoPublicacion listarDatosTipoPubliacion(
        @WebParam(name = "arg0", partName = "arg0")
        String arg0);

    /**
     * 
     * @param arg0
     * @return
     *     returns server.DtOfertaLaboral
     */
    @WebMethod
    @WebResult(partName = "return")
    @Action(input = "http://server/WebServer/obtenerEmpresaDeOfertaRequest", output = "http://server/WebServer/obtenerEmpresaDeOfertaResponse")
    public DtOfertaLaboral obtenerEmpresaDeOferta(
        @WebParam(name = "arg0", partName = "arg0")
        String arg0);

    /**
     * 
     * @param arg0
     * @param arg1
     * @return
     *     returns server.DtPostulacion
     */
    @WebMethod
    @WebResult(partName = "return")
    @Action(input = "http://server/WebServer/listarDatosPostulacionRequest", output = "http://server/WebServer/listarDatosPostulacionResponse")
    public DtPostulacion listarDatosPostulacion(
        @WebParam(name = "arg0", partName = "arg0")
        String arg0,
        @WebParam(name = "arg1", partName = "arg1")
        String arg1);

    /**
     * 
     * @param arg0
     * @param arg1
     * @return
     *     returns boolean
     * @throws ElementoInexistenteException_Exception
     */
    @WebMethod
    @WebResult(partName = "return")
    @Action(input = "http://server/WebServer/evaluarCredencialesRequest", output = "http://server/WebServer/evaluarCredencialesResponse", fault = {
        @FaultAction(className = ElementoInexistenteException_Exception.class, value = "http://server/WebServer/evaluarCredenciales/Fault/ElementoInexistenteException")
    })
    public boolean evaluarCredenciales(
        @WebParam(name = "arg0", partName = "arg0")
        String arg0,
        @WebParam(name = "arg1", partName = "arg1")
        String arg1)
        throws ElementoInexistenteException_Exception
    ;

    /**
     * 
     * @return
     *     returns server.CollectionBean
     */
    @WebMethod
    @WebResult(partName = "return")
    @Action(input = "http://server/WebServer/listarTiposPublicacionRequest", output = "http://server/WebServer/listarTiposPublicacionResponse")
    public CollectionBean listarTiposPublicacion();

    /**
     * 
     * @param arg0
     * @param arg1
     * @param arg2
     */
    @WebMethod
    @Action(input = "http://server/WebServer/agregarTipoAPaqueteRequest", output = "http://server/WebServer/agregarTipoAPaqueteResponse")
    public void agregarTipoAPaquete(
        @WebParam(name = "arg0", partName = "arg0")
        String arg0,
        @WebParam(name = "arg1", partName = "arg1")
        String arg1,
        @WebParam(name = "arg2", partName = "arg2")
        int arg2);

    /**
     * 
     * @param arg0
     * @return
     *     returns server.ArrayList
     */
    @WebMethod
    @WebResult(partName = "return")
    @Action(input = "http://server/WebServer/listarDtOfertasByFilterRequest", output = "http://server/WebServer/listarDtOfertasByFilterResponse")
    public ArrayList listarDtOfertasByFilter(
        @WebParam(name = "arg0", partName = "arg0")
        String arg0);

}

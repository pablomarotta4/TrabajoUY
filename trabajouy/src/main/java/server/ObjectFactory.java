
package server;

import javax.xml.namespace.QName;
import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.annotation.XmlElementDecl;
import jakarta.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the server package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _CamposVaciosExcepcion_QNAME = new QName("http://server/", "CamposVaciosExcepcion");
    private final static QName _ElementoInexistenteException_QNAME = new QName("http://server/", "ElementoInexistenteException");
    private final static QName _UsuarioRepetidoException_QNAME = new QName("http://server/", "UsuarioRepetidoException");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: server
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link CamposVaciosExcepcion }
     * 
     * @return
     *     the new instance of {@link CamposVaciosExcepcion }
     */
    public CamposVaciosExcepcion createCamposVaciosExcepcion() {
        return new CamposVaciosExcepcion();
    }

    /**
     * Create an instance of {@link ElementoInexistenteException }
     * 
     * @return
     *     the new instance of {@link ElementoInexistenteException }
     */
    public ElementoInexistenteException createElementoInexistenteException() {
        return new ElementoInexistenteException();
    }

    /**
     * Create an instance of {@link UsuarioRepetidoException }
     * 
     * @return
     *     the new instance of {@link UsuarioRepetidoException }
     */
    public UsuarioRepetidoException createUsuarioRepetidoException() {
        return new UsuarioRepetidoException();
    }

    /**
     * Create an instance of {@link DataTipoPublicacion }
     * 
     * @return
     *     the new instance of {@link DataTipoPublicacion }
     */
    public DataTipoPublicacion createDataTipoPublicacion() {
        return new DataTipoPublicacion();
    }

    /**
     * Create an instance of {@link LocalDate }
     * 
     * @return
     *     the new instance of {@link LocalDate }
     */
    public LocalDate createLocalDate() {
        return new LocalDate();
    }

    /**
     * Create an instance of {@link ArrayList }
     * 
     * @return
     *     the new instance of {@link ArrayList }
     */
    public ArrayList createArrayList() {
        return new ArrayList();
    }

    /**
     * Create an instance of {@link DtOfertaLaboral }
     * 
     * @return
     *     the new instance of {@link DtOfertaLaboral }
     */
    public DtOfertaLaboral createDtOfertaLaboral() {
        return new DtOfertaLaboral();
    }

    /**
     * Create an instance of {@link DtPostulacion }
     * 
     * @return
     *     the new instance of {@link DtPostulacion }
     */
    public DtPostulacion createDtPostulacion() {
        return new DtPostulacion();
    }

    /**
     * Create an instance of {@link DataEmpresa }
     * 
     * @return
     *     the new instance of {@link DataEmpresa }
     */
    public DataEmpresa createDataEmpresa() {
        return new DataEmpresa();
    }

    /**
     * Create an instance of {@link DataUsuario }
     * 
     * @return
     *     the new instance of {@link DataUsuario }
     */
    public DataUsuario createDataUsuario() {
        return new DataUsuario();
    }

    /**
     * Create an instance of {@link DataPostulante }
     * 
     * @return
     *     the new instance of {@link DataPostulante }
     */
    public DataPostulante createDataPostulante() {
        return new DataPostulante();
    }

    /**
     * Create an instance of {@link Empresa }
     * 
     * @return
     *     the new instance of {@link Empresa }
     */
    public Empresa createEmpresa() {
        return new Empresa();
    }

    /**
     * Create an instance of {@link Usuario }
     * 
     * @return
     *     the new instance of {@link Usuario }
     */
    public Usuario createUsuario() {
        return new Usuario();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CamposVaciosExcepcion }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link CamposVaciosExcepcion }{@code >}
     */
    @XmlElementDecl(namespace = "http://server/", name = "CamposVaciosExcepcion")
    public JAXBElement<CamposVaciosExcepcion> createCamposVaciosExcepcion(CamposVaciosExcepcion value) {
        return new JAXBElement<>(_CamposVaciosExcepcion_QNAME, CamposVaciosExcepcion.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ElementoInexistenteException }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ElementoInexistenteException }{@code >}
     */
    @XmlElementDecl(namespace = "http://server/", name = "ElementoInexistenteException")
    public JAXBElement<ElementoInexistenteException> createElementoInexistenteException(ElementoInexistenteException value) {
        return new JAXBElement<>(_ElementoInexistenteException_QNAME, ElementoInexistenteException.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UsuarioRepetidoException }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link UsuarioRepetidoException }{@code >}
     */
    @XmlElementDecl(namespace = "http://server/", name = "UsuarioRepetidoException")
    public JAXBElement<UsuarioRepetidoException> createUsuarioRepetidoException(UsuarioRepetidoException value) {
        return new JAXBElement<>(_UsuarioRepetidoException_QNAME, UsuarioRepetidoException.class, null, value);
    }

}

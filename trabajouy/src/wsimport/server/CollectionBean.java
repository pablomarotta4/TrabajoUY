
package server;

import java.util.ArrayList;
import java.util.List;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para collectionBean complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>{@code
 * <complexType name="collectionBean">
 *   <complexContent>
 *     <restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       <sequence>
 *         <element name="listaDtOfertas" type="{http://server/}dtOfertaLaboral" maxOccurs="unbounded" minOccurs="0"/>
 *         <element name="listaStrings" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *         <element name="listaDataTipoPublicacion" type="{http://server/}dataTipoPublicacion" maxOccurs="unbounded" minOccurs="0"/>
 *         <element name="listaDataUsuarios" type="{http://server/}dataUsuario" maxOccurs="unbounded" minOccurs="0"/>
 *       </sequence>
 *     </restriction>
 *   </complexContent>
 * </complexType>
 * }</pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "collectionBean", propOrder = {
    "listaDtOfertas",
    "listaStrings",
    "listaDataTipoPublicacion",
    "listaDataUsuarios"
})
public class CollectionBean {

    @XmlElement(nillable = true)
    protected List<DtOfertaLaboral> listaDtOfertas;
    @XmlElement(nillable = true)
    protected List<String> listaStrings;
    @XmlElement(nillable = true)
    protected List<DataTipoPublicacion> listaDataTipoPublicacion;
    @XmlElement(nillable = true)
    protected List<DataUsuario> listaDataUsuarios;

    /**
     * Gets the value of the listaDtOfertas property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a {@code set} method for the listaDtOfertas property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getListaDtOfertas().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DtOfertaLaboral }
     * 
     * 
     * @return
     *     The value of the listaDtOfertas property.
     */
    public List<DtOfertaLaboral> getListaDtOfertas() {
        if (listaDtOfertas == null) {
            listaDtOfertas = new ArrayList<>();
        }
        return this.listaDtOfertas;
    }

    /**
     * Gets the value of the listaStrings property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a {@code set} method for the listaStrings property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getListaStrings().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     * @return
     *     The value of the listaStrings property.
     */
    public List<String> getListaStrings() {
        if (listaStrings == null) {
            listaStrings = new ArrayList<>();
        }
        return this.listaStrings;
    }

    /**
     * Gets the value of the listaDataTipoPublicacion property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a {@code set} method for the listaDataTipoPublicacion property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getListaDataTipoPublicacion().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DataTipoPublicacion }
     * 
     * 
     * @return
     *     The value of the listaDataTipoPublicacion property.
     */
    public List<DataTipoPublicacion> getListaDataTipoPublicacion() {
        if (listaDataTipoPublicacion == null) {
            listaDataTipoPublicacion = new ArrayList<>();
        }
        return this.listaDataTipoPublicacion;
    }

    /**
     * Gets the value of the listaDataUsuarios property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a {@code set} method for the listaDataUsuarios property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getListaDataUsuarios().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DataUsuario }
     * 
     * 
     * @return
     *     The value of the listaDataUsuarios property.
     */
    public List<DataUsuario> getListaDataUsuarios() {
        if (listaDataUsuarios == null) {
            listaDataUsuarios = new ArrayList<>();
        }
        return this.listaDataUsuarios;
    }

}

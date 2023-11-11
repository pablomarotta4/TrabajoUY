
package server;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java class for dtPostulacion complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>{@code
 * <complexType name="dtPostulacion">
 *   <complexContent>
 *     <restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       <sequence>
 *         <element name="cvReducido" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         <element name="motivacion" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         <element name="fechaPostulacion" type="{http://server/}localDate" minOccurs="0"/>
 *         <element name="nombreOferta" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         <element name="nickpostulante" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         <element name="date" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       </sequence>
 *     </restriction>
 *   </complexContent>
 * </complexType>
 * }</pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "dtPostulacion", propOrder = {
    "cvReducido",
    "motivacion",
    "fechaPostulacion",
    "nombreOferta",
    "nickpostulante",
    "date"
})
public class DtPostulacion {

    protected String cvReducido;
    protected String motivacion;
    protected LocalDate fechaPostulacion;
    protected String nombreOferta;
    protected String nickpostulante;
    protected String date;

    /**
     * Gets the value of the cvReducido property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCvReducido() {
        return cvReducido;
    }

    /**
     * Sets the value of the cvReducido property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCvReducido(String value) {
        this.cvReducido = value;
    }

    /**
     * Gets the value of the motivacion property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMotivacion() {
        return motivacion;
    }

    /**
     * Sets the value of the motivacion property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMotivacion(String value) {
        this.motivacion = value;
    }

    /**
     * Gets the value of the fechaPostulacion property.
     * 
     * @return
     *     possible object is
     *     {@link LocalDate }
     *     
     */
    public LocalDate getFechaPostulacion() {
        return fechaPostulacion;
    }

    /**
     * Sets the value of the fechaPostulacion property.
     * 
     * @param value
     *     allowed object is
     *     {@link LocalDate }
     *     
     */
    public void setFechaPostulacion(LocalDate value) {
        this.fechaPostulacion = value;
    }

    /**
     * Gets the value of the nombreOferta property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNombreOferta() {
        return nombreOferta;
    }

    /**
     * Sets the value of the nombreOferta property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNombreOferta(String value) {
        this.nombreOferta = value;
    }

    /**
     * Gets the value of the nickpostulante property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNickpostulante() {
        return nickpostulante;
    }

    /**
     * Sets the value of the nickpostulante property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNickpostulante(String value) {
        this.nickpostulante = value;
    }

    /**
     * Gets the value of the date property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDate() {
        return date;
    }

    /**
     * Sets the value of the date property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDate(String value) {
        this.date = value;
    }

}

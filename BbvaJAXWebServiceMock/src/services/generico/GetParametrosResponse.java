//
// Generated By:JAX-WS RI IBM 2.1.6 in JDK 6 (JAXB RI IBM JAXB 2.1.10 in JDK 6)
//


package services.generico;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import com.bbva.armx.vo.RespuestaAEVo;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="getParametrosReturn" type="{http://VO.armx.bbva.com}RespuestaAEVo"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "getParametrosReturn"
})
@XmlRootElement(name = "getParametrosResponse")
public class GetParametrosResponse {

    @XmlElement(required = true, nillable = true)
    protected RespuestaAEVo getParametrosReturn;

    /**
     * Gets the value of the getParametrosReturn property.
     * 
     * @return
     *     possible object is
     *     {@link RespuestaAEVo }
     *     
     */
    public RespuestaAEVo getGetParametrosReturn() {
        return getParametrosReturn;
    }

    /**
     * Sets the value of the getParametrosReturn property.
     * 
     * @param value
     *     allowed object is
     *     {@link RespuestaAEVo }
     *     
     */
    public void setGetParametrosReturn(RespuestaAEVo value) {
        this.getParametrosReturn = value;
    }

}
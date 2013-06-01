package services.generico;

import com.bbva.armx.vo.RespuestaAEVo;

import org.apache.xml.xml_soap.Item;
import org.apache.xml.xml_soap.Map;


@javax.jws.WebService (endpointInterface="services.generico.TransaccionHostService", targetNamespace="http://generico.services", serviceName="TransaccionHost_serviceService", portName="TransaccionHost_service")
public class TransaccionHost_serviceSoapBindingImpl{

    public RespuestaAEVo getListaTx(String aplicacion, String usuario, String opcion, Map params) throws ARMXException {
        // TODO Auto-generated method stub
        return null;
    }

    public RespuestaAEVo ejecutaTxHost(String aplicacion, String usuario, String opcion, Map params) throws ARMXException {
        // TODO Auto-generated method stub
        return null;
    }

    public RespuestaAEVo getParametros(String aplicacion, String usuario, String opcion, Map params) throws ARMXException {
        // TODO Auto-generated method stub
        return null;
    }

    public RespuestaAEVo setTrackingH2H(String aplicacion, String usuario, String opcion, Map params) throws ARMXException {
        // TODO Auto-generated method stub
    	RespuestaAEVo respuestaAEVo = new RespuestaAEVo();
        System.out.println("gooo.....");
        respuestaAEVo.setMENSAJE("Ejecución correcta del servicio");
        Map hashMapResultado =  new Map();
        Item item01 = new Item();
        item01.setKey("ESTATUS");
        item01.setValue("00");
        Item item02 = new Item();
        item02.setKey("DESCRIP");
        item02.setValue("ALTA EFECTUADA");
        hashMapResultado.getItem().add(item01);
        hashMapResultado.getItem().add(item02);
        respuestaAEVo.setRESULTADO(hashMapResultado);
        return respuestaAEVo;
    }

}
package mappers.palabracomodin;

import java.util.List;

import mx.com.bbva.bancomer.bussinnes.model.vo.PalabraComodinVO;

public abstract interface MapPalabraComodin {
	public abstract List<PalabraComodinVO> obtenerPalabrasComodin(PalabraComodinVO palabraComodinVO);
}

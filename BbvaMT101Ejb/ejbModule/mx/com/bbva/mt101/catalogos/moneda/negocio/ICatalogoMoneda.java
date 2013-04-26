package mx.com.bbva.mt101.catalogos.moneda.negocio;

import java.util.List;
import javax.ejb.Local;
import mx.com.bbva.mt101.entities.Tgm042MonedaMx;

@Local
public abstract interface ICatalogoMoneda
{
  public abstract void salavarCatalogo(Tgm042MonedaMx paramTgm042MonedaMx);

  public abstract Tgm042MonedaMx buscarTgm042MonedaMx(Tgm042MonedaMx paramTgm042MonedaMx);

  public abstract List<Tgm042MonedaMx> obtenerTodosTgm042MonedaMx(Tgm042MonedaMx paramTgm042MonedaMx);

  public abstract List<Tgm042MonedaMx> filtarTgm042MonedaMx(Tgm042MonedaMx paramTgm042MonedaMx);
}

/* Location:           D:\Bancomer\EARS\BbvaMT101Ejb\
 * Qualified Name:     mx.com.bbva.mt101.catalogos.moneda.negocio.ICatalogoMoneda
 * JD-Core Version:    0.6.2
 */
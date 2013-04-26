package com.bancomer.gis.monitorwebswift.interfaces;

import java.util.ArrayList;

public interface CatalogoInterface {
	public void save(Object o) throws Exception;
	public void update(Object o)throws Exception;
	public ArrayList list()throws Exception;
}

package com.bancomer.gis.monitorwebswift.dao;

import java.util.ArrayList;

import com.bancomer.gis.monitorwebswift.db.DataBase;
import com.bancomer.gis.monitorwebswift.interfaces.CatalogoInterface;
import com.bancomer.gis.monitorwebswift.vo.CoinVo;


public class CatalogoAvisosDao extends GeneralDAO implements CatalogoInterface{
	
	public CatalogoAvisosDao(int switchConnection) throws Exception {
		super(switchConnection);
	}
	
	public void save(Object o) throws Exception{
		CoinVo aviso = null;
		if(o instanceof CoinVo){
				aviso = (CoinVo)o;
		}
		else{
			aviso = new CoinVo();
		}
		try {
			cs = con.prepareCall("{call SP_GM015_INS_AVISO(?)}");
			cs.setString(1, aviso.getName());
			cs.executeUpdate();
		}
		catch (Exception e) {
			con.rollback();
			throw new Exception(e.getMessage()); 
		}finally{
			closeAll(new Object[]{cs,con});
		}
	}
	
	public void delete(Object o) throws Exception{
		CoinVo aviso = null;
		if(o instanceof CoinVo){
				aviso = (CoinVo)o;
		}
		else{
			aviso = new CoinVo();
		}
		try {
			cs = con.prepareCall("{call SP_GM015_DEL_AVISO(?)}");
			cs.setInt(1, aviso.getCoinId());
			cs.executeUpdate();
		}
		catch (Exception e) {
			con.rollback();
			throw new Exception(e.getMessage());
		}finally{
			closeAll(new Object[]{cs,con});
		}
	}
	
	public void update(Object o) throws Exception{
		CoinVo aviso = null;
		if(o instanceof CoinVo){
				aviso = (CoinVo)o;
		}
		else{
			aviso = new CoinVo();
		}
		try {
			cs = con.prepareCall("{call SP_GM015_UPD_AVISO(?,?)}");
			cs.setString(1, aviso.getName());
			cs.setInt(2, aviso.getCoinId());
			cs.executeUpdate();
		}
		catch (Exception e) {
			con.rollback();
			throw new Exception(e.getMessage());
		}finally{
			closeAll(new Object[]{cs,con});
		}
	}
	
	public ArrayList<CoinVo> list() throws Exception{
		ArrayList<CoinVo> messages = new ArrayList<CoinVo>();
		try {
			ps = con.prepareStatement(DataBase.getQuery("getAvisos"));
			rs = ps.executeQuery();
			while(rs.next()){
				messages.add(
						new CoinVo(
								rs.getInt(1),
								rs.getString(2),
								rs.getString(3)
						)
				);
			}
		}catch(Exception e){
			con.rollback();
			throw new Exception(e.getMessage());
		}finally{
			closeAll(new Object[]{ps,rs,con});
		}
		return messages;
	}
}

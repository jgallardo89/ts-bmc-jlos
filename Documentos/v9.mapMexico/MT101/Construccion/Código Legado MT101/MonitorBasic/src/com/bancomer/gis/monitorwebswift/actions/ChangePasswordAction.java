package com.bancomer.gis.monitorwebswift.actions;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.bancomer.gis.monitorwebswift.logic.GisLogic;

public class ChangePasswordAction extends Action {
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		ActionErrors errors = new ActionErrors();
	    ActionForward forward = new ActionForward();
	    String idUser = request.getParameter("param1");
	    String newPass = request.getParameter("param2");
	    String confirmPass = request.getParameter("param3");
	    String verifyPass = request.getParameter("param4");
	    PrintWriter out = null;
		try{
			response.setContentType("text/html");
			out = response.getWriter();
			String messageError = "";
			if(!newPass.equals(confirmPass)){
				messageError="-1";
				response.setContentLength(messageError.length());
				out.print(messageError);
			}else{
				int id=0;
				if(idUser!=null && idUser.trim().length()>0) id = Integer.parseInt(idUser); 
				GisLogic logic= new GisLogic();
				int error = logic.changePassword(id, newPass,verifyPass);
				messageError = error+"";
				response.setContentLength(messageError.length());
				out.print(messageError);
			}
		}catch(Exception e){
			e.printStackTrace();
			errors.add("name", new ActionError("id"));
		}finally{
			out.flush();
			out.close();
		}
		if (!errors.isEmpty()) {
			saveErrors(request, errors);
	    }
        forward = mapping.findForward("refresh");
        return (forward);
	}
}

package manage.action;

import java.io.*;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.struts2.ServletActionContext;

import manage.dao.BanJiDao;
import manage.dao.KechengDao;
import manage.model.Kecheng;
import manage.util.Pager;

import com.opensymphony.xwork2.ActionSupport;

public class KechengAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7963004028001698964L;

	private KechengDao kechengDao;
	private BanJiDao banjiDao;

	public BanJiDao getBanjiDao() {
		return banjiDao;
	}




	public void setBanjiDao(BanJiDao banjiDao) {
		this.banjiDao = banjiDao;
	}
	
	
	public KechengDao getKechengDao() {
		return kechengDao;
	}

	public void setKechengDao(KechengDao kechengDao) {
		this.kechengDao = kechengDao;
	}


	public String kechenglist() {
		HttpServletRequest request = ServletActionContext.getRequest();
		int numPerPage = 20;
		 int pageNum = 1;
		if(request.getParameter("pageNum")!=null && !request.getParameter("pageNum").equals("")){
			pageNum = Integer.parseInt(request.getParameter("pageNum"));
		}
		if(request.getParameter("numPerPage")!=null){
			numPerPage = Integer.parseInt(request.getParameter("numPerPage"));
		}
		int total = kechengDao.selectAllKechengCount();
		List<Kecheng> kechengs = kechengDao.selectAllKecheng(
				(pageNum - 1) * numPerPage, numPerPage);
		request.setAttribute("totalCount", total);
		request.setAttribute("ps", numPerPage);
		request.setAttribute("pn", pageNum);
		request.setAttribute("kechenglist", kechengs);
		request.setAttribute("banjilist", banjiDao.getAll(""));
		return "success";
	}
	
	public String kechenglist2() {
		HttpServletRequest request = ServletActionContext.getRequest();
		int numPerPage = 20;
		 int pageNum = 1;
		if(request.getParameter("pageNum")!=null && !request.getParameter("pageNum").equals("")){
			pageNum = Integer.parseInt(request.getParameter("pageNum"));
		}
		if(request.getParameter("numPerPage")!=null){
			numPerPage = Integer.parseInt(request.getParameter("numPerPage"));
		}
		int total = kechengDao.selectAllKechengCount();
		HttpSession session = request.getSession();
		String role = (String)session.getAttribute("role");
		if("role4".equals(role)||role=="role4"){
			String banjinum=(String) session.getAttribute("banjinum"); 
			request.setAttribute("kechenglist", kechengDao.selectAllKechengBy((pageNum - 1) * numPerPage, 50,
					"and banjinum='"+banjinum+"'"));
		}else{
			request.setAttribute("kechenglist", kechengDao.selectAllKecheng(
					(pageNum - 1) * numPerPage, numPerPage));
			request.setAttribute("totalCount", total);
			request.setAttribute("ps", numPerPage);
			request.setAttribute("pn", pageNum);
		}
		
		
		//request.setAttribute("kechenglist", kechengs);
		return "success";
	}
	
	public String kechengadd(){
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("banjilist", banjiDao.getAll(""));
		return "success";
	}
	
	public String kechengadd2() throws Exception{
		HttpServletRequest request = ServletActionContext.getRequest();
		
		Kecheng kecheng = new Kecheng();
		
		kecheng.setKechengname1(request.getParameter("kechengname1"));
		kecheng.setKechengname2(request.getParameter("kechengname2"));
		kecheng.setKechengname3(request.getParameter("kechengname3"));
		kecheng.setKechengname4(request.getParameter("kechengname4"));
		kecheng.setKechengname5(request.getParameter("kechengname5"));
		kecheng.setKechengname6(request.getParameter("kechengname6"));
		kecheng.setKechengname7(request.getParameter("kechengname7"));
		
		kecheng.setKechenglock(Integer.parseInt(request.getParameter("kechenglock")));
		kecheng.setBanji(request.getParameter("banji"));
		kecheng.setBanjinum(request.getParameter("banjinum"));
		kecheng.setCreatetime(new Date());
		
		
			kechengDao.insertKecheng(kecheng);
		HttpServletResponse resp = ServletActionContext.getResponse();
		PrintWriter out = resp.getWriter();
		//out.write(manage.util.Util.outPutMsg("200", "添加成功", "", "", "kechenglist.html"));
		
		out.print("{\"statusCode\":\"200\", \"message\":\"SUCCESS!\",\"navTabId\":\"kechengList\", \"rel\":\"kechengList\", \"callbackType\":\"closeCurrent\",\"forwardUrl\":\"kecheng///kechenglist.html\"}");

		out.flush();
		out.close();
		return null;
	}
	
	public String kechengdel() throws IOException{
		HttpServletRequest request = ServletActionContext.getRequest();
		int id = Integer.parseInt(request.getParameter("id"));
		kechengDao.delKecheng(kechengDao.selectKecheng(id));
		HttpServletResponse resp = ServletActionContext.getResponse();
		PrintWriter out = resp.getWriter();
	//	out.print("{\"statusCode\":\"200\", \"message\":\"删除成功！\",\"navTabId\":\"kechengList\", \"rel\":\"kechengList\", \"callbackType\":\"closeCurrent\",\"forwardUrl\":\"kecheng///kechenglist.html\"}");
		out.write(manage.util.Util.outPutMsg("200", "SUCCESS!", "kechengList", "", false, "kecheng///kechenglist.html"));
		out.flush();
		out.close();
		return null;
	}

	
	public String  kechengupdate(){
		HttpServletRequest request = ServletActionContext.getRequest();
		int id = Integer.parseInt(request.getParameter("id"));
		request.setAttribute("bean", kechengDao.selectKecheng(id));
		request.setAttribute("id", id);
		//request.setAttribute("subjectilist", subjectDao.getAll(" and subjectlock=0 "));
		return "success";
	}
	
	public String kechengupdate2() throws Exception{
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse resp = ServletActionContext.getResponse();
		PrintWriter out = resp.getWriter();
		int id = Integer.parseInt(request.getParameter("id"));
		Kecheng bean = kechengDao.selectKecheng(id);
		
		if(request.getParameter("kechengname1")!=null){
			bean.setKechengname1(request.getParameter("kechengname1"));
		}
		if(request.getParameter("kechengname2")!=null){
			bean.setKechengname2(request.getParameter("kechengname2"));
		}
		if(request.getParameter("kechengname3")!=null){
			bean.setKechengname3(request.getParameter("kechengname3"));
		}
		if(request.getParameter("kechengname4")!=null){
			bean.setKechengname4(request.getParameter("kechengname4"));
		}
		if(request.getParameter("kechengname5")!=null){
			bean.setKechengname5(request.getParameter("kechengname5"));
		}
		if(request.getParameter("kechengname6")!=null){
			bean.setKechengname6(request.getParameter("kechengname6"));
		}
		if(request.getParameter("kechengname7")!=null){
			bean.setKechengname7(request.getParameter("kechengname7"));
		}
		
		if(request.getParameter("kechenglock")!=null){
			bean.setKechenglock(Integer.parseInt(request.getParameter("kechenglock")));
		}
		if(request.getParameter("banji")!=null){
			bean.setBanji(request.getParameter("banji"));
		}
		if(request.getParameter("banjiid")!=null){
			bean.setBanjinum(request.getParameter("banjinum"));
		}
		kechengDao.updateKecheng(bean);
		//out.write(manage.util.Util.outPutMsg("200", "修改成功", "", "", "kechenglist.html"));
		out.print("{\"statusCode\":\"200\", \"message\":\"SUCCESS!\",\"navTabId\":\"kechengList\", \"rel\":\"kechengList\", \"callbackType\":\"closeCurrent\",\"forwardUrl\":\"kecheng///kechenglist.html\"}");

		out.flush();
		out.close();
		return null;
	}
	
	
	public String searchkecheng(){
		HttpServletRequest request = ServletActionContext.getRequest();
		String keyword  = request.getParameter("keyword");
		
		int currentpage = 1;
		int pagesize = 50;
		if (request.getParameter("pagenum") != null)
			currentpage = Integer.parseInt(request.getParameter("pagenum"));
		request.setAttribute("kechenglist", kechengDao.selectAllKechengBy((currentpage - 1) * pagesize, 50,
						"and banjinum like '%"+keyword+"%'"));
		request.setAttribute("searchkechenglist", kechengDao.getAll(" and kechenglock=0 "));
		request.setAttribute("banjilist", banjiDao.getAll(""));
		return "success";
		
	}
	
	
	
	
}

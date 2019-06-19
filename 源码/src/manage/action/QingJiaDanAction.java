package manage.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import manage.dao.BanJiDao;
import manage.dao.QingJiaDanDao;
import manage.model.QingJiaDan;
import manage.util.Util;

public class QingJiaDanAction  {
	
	private static final long serialVersionUID = 7963004028001698964L;

	private QingJiaDanDao qingjiadanDao;
	private BanJiDao banjiDao;

	public BanJiDao getBanjiDao() {
		return banjiDao;
	}




	public void setBanjiDao(BanJiDao banjiDao) {
		this.banjiDao = banjiDao;
	}

	public QingJiaDanDao getQingjiadanDao() {
		return qingjiadanDao;
	}




	public void setQingjiadanDao(QingJiaDanDao qingjiadanDao) {
		this.qingjiadanDao = qingjiadanDao;
	}




	//设备使用列表
	@SuppressWarnings("unchecked")
	public String qingjiadanlist() throws Exception {	
		HttpServletRequest request = ServletActionContext.getRequest();
		int numPerPage = 20;
		 int pageNum = 1;
		if(request.getParameter("pageNum")!=null && !request.getParameter("pageNum").equals("")){
			pageNum = Integer.parseInt(request.getParameter("pageNum"));
		}
		if(request.getParameter("numPerPage")!=null){
			numPerPage = Integer.parseInt(request.getParameter("numPerPage"));
		}
		int total = qingjiadanDao.selectAllQingJiaDanCount();
		HttpSession session = request.getSession();
		String role = (String)session.getAttribute("role");
		if("role4".equals(role)||role=="role4"){
			String codenum=(String) session.getAttribute("codenum"); 
			request.setAttribute("qingjiadanlist", qingjiadanDao.selectAllQingJiaDanBy((pageNum - 1) * numPerPage, 50,
					"and codenum='"+codenum+"'"));
		}else{
			List<QingJiaDan> qingjiadans = qingjiadanDao.selectAllQingJiaDan(
					(pageNum - 1) * numPerPage, numPerPage);
			request.setAttribute("qingjiadanlist", qingjiadans);
			
		}
		
		request.setAttribute("totalCount", total);
		request.setAttribute("ps", numPerPage);
		request.setAttribute("pn", pageNum);
		
		
		return "success";
	}
	
	
	
	
	//跳转添加设备使用的页面
	public String qingjiadanadd(){
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("banjilist", banjiDao.getAll(""));
		return "success";
	}
	
	
	//添加设备使用操作
	public String qingjiadanadd2() throws Exception{
        HttpServletRequest request = ServletActionContext.getRequest();
		
		QingJiaDan qingjiadan = new QingJiaDan();
		
		qingjiadan.setCodenum(request.getParameter("codenum"));
		qingjiadan.setQjtime1(request.getParameter("qjtime1"));
		qingjiadan.setQjtime2(request.getParameter("qjtime2"));
		qingjiadan.setShenhe("审核中");
		qingjiadan.setUsername(request.getParameter("username"));
		qingjiadan.setBanjinum(request.getParameter("banjinum"));
		qingjiadan.setQjcontent(request.getParameter("qjcontent"));
		qingjiadan.setCreatetime(new Date());
		
		
			qingjiadanDao.insertQingJiaDan(qingjiadan);
		HttpServletResponse resp = ServletActionContext.getResponse();
		PrintWriter out = resp.getWriter();
		//out.write(manage.util.Util.outPutMsg("200", "添加成功", "", "", "qingjiadanlist.html"));
		
		out.print("{\"statusCode\":\"200\", \"message\":\"SUCCESS!\",\"navTabId\":\"qingjiadanList\", \"rel\":\"qingjiadanList\", \"callbackType\":\"closeCurrent\",\"forwardUrl\":\"qingjiadan/qingjiadanlist.html\"}");
		out.flush();
		out.close();
		return null;
	}
	
	//跳转更新设备使用的页面
	public String  qingjiadanupdate(){
		HttpServletRequest request = ServletActionContext.getRequest();
		int id = Integer.parseInt(request.getParameter("id"));
		request.setAttribute("bean", qingjiadanDao.selectQingJiaDan(id));
		request.setAttribute("id", id);
		request.setAttribute("banjilist", banjiDao.getAll(""));
		return "success";
	}
	
	
	//更新设备使用操作
	public String  qingjiadanupdate2() throws IOException{
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse resp = ServletActionContext.getResponse();
		PrintWriter out = resp.getWriter();
		int id = Integer.parseInt(request.getParameter("id"));
		QingJiaDan bean = qingjiadanDao.selectQingJiaDan(id);
		
		
		
		if(request.getParameter("username")!=null){
			bean.setUsername(request.getParameter("username"));
		}
		if(request.getParameter("banjinum")!=null){
			bean.setBanjinum(request.getParameter("banjinum"));
		}
		if(request.getParameter("codenum")!=null){
			bean.setCodenum(request.getParameter("codenum"));
		}
		if(request.getParameter("qjtime1")!=null){
			bean.setQjtime1(request.getParameter("qjtime1"));
			
		}
		if(request.getParameter("qjtime2")!=null){
			bean.setQjtime2(request.getParameter("qjtime2"));
		
		}
		if(request.getParameter("shenhe")!=null){
			bean.setShenhe(request.getParameter("shenhe"));
		}
		if(request.getParameter("shenhecontent")!=null){
			bean.setShenhecontent(request.getParameter("shenhecontent"));
		}
		
		qingjiadanDao.updateQingJiaDan(bean);
		//out.write(manage.util.Util.outPutMsg("200", "修改成功", "", "", "qingjiadanlist.html"));
		out.print("{\"statusCode\":\"200\", \"message\":\"SUCCESS!\",\"navTabId\":\"qingjiadanList\", \"rel\":\"qingjiadanList\", \"callbackType\":\"closeCurrent\",\"forwardUrl\":\"qingjiadan///qingjiadanlist.html\"}");

		out.flush();
		out.close();
		return null;
	}
	
	
	//删除设备使用操作
	public String qingjiadandel() throws IOException{
		HttpServletRequest request = ServletActionContext.getRequest();
		int id = Integer.parseInt(request.getParameter("id"));
		qingjiadanDao.delQingJiaDan(qingjiadanDao.selectQingJiaDan(id));
		HttpServletResponse resp = ServletActionContext.getResponse();
		PrintWriter out = resp.getWriter();
		//out.print("{\"statusCode\":\"200\", \"message\":\"删除成功！\",\"navTabId\":\"qingjiadanList\", \"rel\":\"qingjiadanList\", \"callbackType\":\"closeCurrent\",\"forwardUrl\":\"qingjiadan///qingjiadanlist.html\"}");
		out.write(manage.util.Util.outPutMsg("200", "SUCCESS!", "qingjiadanList", "", false, "qingjiadan///qingjiadanlist.html"));
		out.flush();
		out.close();
		return null;
	}
	
	
	//跳转更新设备使用的页面
	public String  qingjiadanupdate_sh(){
		HttpServletRequest request = ServletActionContext.getRequest();
		int id = Integer.parseInt(request.getParameter("id"));
		request.setAttribute("bean", qingjiadanDao.selectQingJiaDan(id));
		request.setAttribute("id", id);
		return "success";
	}
	
	
	//更新设备使用操作
	public String  qingjiadanupdate2_sh() throws IOException, Throwable{
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse resp = ServletActionContext.getResponse();
		PrintWriter out = resp.getWriter();
		int id = Integer.parseInt(request.getParameter("id"));
		QingJiaDan bean = qingjiadanDao.selectQingJiaDan(id);
		
		if(request.getParameter("username")!=null){
			bean.setUsername(request.getParameter("username"));
		}
		if(request.getParameter("banjinum")!=null){
			bean.setBanjinum(request.getParameter("banjinum"));
		}
		if(request.getParameter("codenum")!=null){
			bean.setCodenum(request.getParameter("codenum"));
		}
		if(request.getParameter("qjtime1")!=null){
			bean.setQjtime1(request.getParameter("qjtime1"));
			
		}
		if(request.getParameter("qjtime2")!=null){
			bean.setQjtime2(request.getParameter("qjtime2"));
		
		}
		if(request.getParameter("shenhe")!=null){
			bean.setShenhe(request.getParameter("shenhe"));
		}
		if(request.getParameter("shenhecontent")!=null){
			bean.setShenhecontent(request.getParameter("shenhecontent"));
		}
		String aa=request.getParameter("qjtime1");
		String bb=request.getParameter("qjtime2");
		if(aa!=null&&bb!=null){
			HttpSession session = request.getSession();
			String role = (String)session.getAttribute("role");
			Calendar nowDate = Calendar.getInstance();      
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			java.util.Date date1 = sdf.parse(aa);
			java.util.Date date2 = sdf.parse(bb);
			long daynum=(date2.getTime()-date1.getTime())/(24*60*60*1000); 
			if(daynum<3){
				if("role3".equals(role)||role=="role3"){
					qingjiadanDao.updateQingJiaDan(bean);
					out.print("{\"statusCode\":\"200\", \"message\":\"SUCCESS!\",\"navTabId\":\"qingjiadanList\", \"rel\":\"qingjiadanList\", \"callbackType\":\"closeCurrent\",\"forwardUrl\":\"qingjiadan///qingjiadanlist.html\"}");
					out.flush();
					out.close();
					}else{
						out.print("{\"statusCode\":\"200\", \"message\":\"FAILED!\",\"navTabId\":\"qingjiadanList\", \"rel\":\"qingjiadanList\", \"callbackType\":\"closeCurrent\",\"forwardUrl\":\"qingjiadan///qingjiadanlist.html\"}");
						out.flush();
						out.close();
					}
			}else {
				if("role1".equals(role)||role=="role1"){
					qingjiadanDao.updateQingJiaDan(bean);
					out.print("{\"statusCode\":\"200\", \"message\":\"SUCCESS!\",\"navTabId\":\"qingjiadanList\", \"rel\":\"qingjiadanList\", \"callbackType\":\"closeCurrent\",\"forwardUrl\":\"qingjiadan///qingjiadanlist.html\"}");
					out.flush();
					out.close();
					}else{
						out.print("{\"statusCode\":\"200\", \"message\":\"Failed!\",\"navTabId\":\"qingjiadanList\", \"rel\":\"qingjiadanList\", \"callbackType\":\"closeCurrent\",\"forwardUrl\":\"qingjiadan///qingjiadanlist.html\"}");
						out.flush();
						out.close();
					}
			}
			
		}else{
		
		//out.write(manage.util.Util.outPutMsg("200", "修改成功", "", "", "qingjiadanlist.html"));
		out.print("{\"statusCode\":\"200\", \"message\":\"Failed!\",\"navTabId\":\"qingjiadanList\", \"rel\":\"qingjiadanList\", \"callbackType\":\"closeCurrent\",\"forwardUrl\":\"qingjiadan///qingjiadanlist.html\"}");
		out.flush();
		out.close();
	}
		
		return null;
	}
	
}

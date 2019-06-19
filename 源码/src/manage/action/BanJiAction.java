package manage.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import manage.dao.BanJiDao;
import manage.dao.KechengDao;
import manage.model.BanJi;
import manage.model.Kecheng;
import manage.model.User;
import manage.util.Util;

public class BanJiAction  {
	
	private static final long serialVersionUID = 7963004028001698964L;

	private BanJiDao banjiDao;

	public BanJiDao getBanjiDao() {
		return banjiDao;
	}




	public void setBanjiDao(BanJiDao banjiDao) {
		this.banjiDao = banjiDao;
	}




	//设备使用列表
	@SuppressWarnings("unchecked")
	public String banjilist() throws Exception {	
		HttpServletRequest request = ServletActionContext.getRequest();
		int numPerPage = 20;
		 int pageNum = 1;
		if(request.getParameter("pageNum")!=null && !request.getParameter("pageNum").equals("")){
			pageNum = Integer.parseInt(request.getParameter("pageNum"));
		}
		if(request.getParameter("numPerPage")!=null){
			numPerPage = Integer.parseInt(request.getParameter("numPerPage"));
		}
		int total = banjiDao.selectAllBanJiCount();
		List<BanJi> banjis = banjiDao.selectAllBanJi(
				(pageNum - 1) * numPerPage, numPerPage);
		request.setAttribute("totalCount", total);
		request.setAttribute("ps", numPerPage);
		request.setAttribute("pn", pageNum);
		request.setAttribute("banjilist", banjis);
		return "success";
	}
	
	
	
	
	//跳转添加设备使用的页面
	public String banjiadd(){
		HttpServletRequest request = ServletActionContext.getRequest();
		return "success";
	}
	
	
	//添加设备使用操作
	public String banjiadd2() throws Exception{
        HttpServletRequest request = ServletActionContext.getRequest();
		
		BanJi banji = new BanJi();
		
		banji.setBanjiname(request.getParameter("banjiname"));
		banji.setBanjinum(request.getParameter("banjinum"));
		banji.setYuanxi(request.getParameter("yuanxi"));
		banji.setZhuanye(request.getParameter("zhuanye"));
		
		
		banji.setCreatetime(new Date());
		
		List<BanJi> u = banjiDao.selectAllBanJiBy(0, 10, "and banjinum='"+request.getParameter("banjinum")+"'");
		
		if(u.size()==0){
			banjiDao.insertBanJi(banji);
		
			
		HttpServletResponse resp = ServletActionContext.getResponse();
		PrintWriter out = resp.getWriter();
		//out.write(manage.util.Util.outPutMsg("200", "添加成功", "", "", "banjilist.html"));
		
		out.print("{\"statusCode\":\"200\", \"message\":\"SUCCEED!\",\"navTabId\":\"banjiList\", \"rel\":\"banjiList\", \"callbackType\":\"closeCurrent\",\"forwardUrl\":\"banji/banjilist.html\"}");
		out.flush();
		out.close();
		}else{
			request.setAttribute("info", "新增班级失败，班级编号已存在，请检查输入");
			HttpServletResponse resp = ServletActionContext.getResponse();
			PrintWriter out = resp.getWriter();
			//out.write(manage.util.Util.outPutMsg("200", "添加成功", "", "", "banjilist.html"));
			
			out.print("{\"statusCode\":\"200\", \"message\":\"SUCCEED!\",\"navTabId\":\"banjiList\", \"rel\":\"banjiList\", \"callbackType\":\"closeCurrent\",\"forwardUrl\":\"banji/banjilist.html\"}");
			out.flush();
			out.close();
		}
		return null;
	}
	
	//跳转更新设备使用的页面
	public String  banjiupdate(){
		HttpServletRequest request = ServletActionContext.getRequest();
		int id = Integer.parseInt(request.getParameter("id"));
		request.setAttribute("bean", banjiDao.selectBanJi(id));
		request.setAttribute("id", id);
		//request.setAttribute("subjectilist", subjectDao.getAll(" and subjectlock=0 "));
		return "success";
	}
	
	
	//更新操作
	public String  banjiupdate2() throws IOException{
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse resp = ServletActionContext.getResponse();
		PrintWriter out = resp.getWriter();
		int id = Integer.parseInt(request.getParameter("id"));
		BanJi bean = banjiDao.selectBanJi(id);
		
		
		if(request.getParameter("banjiname")!=null){
			bean.setBanjiname(request.getParameter("banjiname"));
		}
		if(request.getParameter("banjinum")!=null){
			bean.setBanjinum(request.getParameter("banjinum"));
		}
		if(request.getParameter("yuanxi")!=null){
			bean.setYuanxi(request.getParameter("yuanxi"));
		}
		if(request.getParameter("zhuanye")!=null){
			bean.setZhuanye(request.getParameter("zhuanye"));
		}
		
		banjiDao.updateBanJi(bean);
		//out.write(manage.util.Util.outPutMsg("200", "修改成功", "", "", "banjilist.html"));
		out.print("{\"statusCode\":\"200\", \"message\":\"SUCCEED!\",\"navTabId\":\"banjiList\", \"rel\":\"banjiList\", \"callbackType\":\"closeCurrent\",\"forwardUrl\":\"banji///banjilist.html\"}");

		out.flush();
		out.close();
		return null;
	}
	
	
	//删除操作
	public String banjidel() throws IOException{
		HttpServletRequest request = ServletActionContext.getRequest();
		int id = Integer.parseInt(request.getParameter("id"));
		banjiDao.delBanJi(banjiDao.selectBanJi(id));
		HttpServletResponse resp = ServletActionContext.getResponse();
		PrintWriter out = resp.getWriter();
		//out.print("{\"statusCode\":\"200\", \"message\":\"删除成功！\",\"navTabId\":\"banjiList\", \"rel\":\"banjiList\", \"callbackType\":\"closeCurrent\",\"forwardUrl\":\"banji///banjilist.html\"}");
		out.write(manage.util.Util.outPutMsg("200", "SUCCEED!", "banjiList", "", false, "banji///banjilist.html"));
		out.flush();
		out.close();
		return null;
	}
	
	
}

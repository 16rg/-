package manage.action;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jxl.Workbook;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

import org.apache.struts2.ServletActionContext;

import manage.dao.BanJiDao;
import manage.dao.KaoQinLogDao;
import manage.dao.UserDao;
import manage.model.KaoQinLog;
import manage.model.User;
import manage.util.Pager;
import com.opensymphony.xwork2.ActionSupport;

public class ManageAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7963004028001698964L;

	private UserDao userDao;
	private BanJiDao banjiDao;
	private KaoQinLogDao kaoqinlogDao;

	
	public KaoQinLogDao getKaoqinlogDao() {
		return kaoqinlogDao;
	}

	public void setKaoqinlogDao(KaoQinLogDao kaoqinlogDao) {
		this.kaoqinlogDao = kaoqinlogDao;
	}

	public BanJiDao getBanjiDao() {
		return banjiDao;
	}

	public void setBanjiDao(BanJiDao banjiDao) {
		this.banjiDao = banjiDao;
	}
	
	//取小树点后2位
	static  double  convert(double  value){  
        long  lg  =  Math.round(value*100); //四舍五入  
        double  d=  lg/100.0; //注意：使用 100.0而不是  100  
        return  d;  
    }  

	private int numPerPage = 20;
	private int pageNum = 1;
	
	
	public int getNumPerPage() {
		return numPerPage;
	}

	public void setNumPerPage(int numPerPage) {
		this.numPerPage = numPerPage;
	}

	

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}


	public String login() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		User user = userDao.selectUserbByusernameByPassword(username, password);
		if(user==null){
			request.setAttribute("errorMessage", "请重新输入帐号密码！！");
			return "fail";
		}
		List<KaoQinLog> kaoqinlogs = kaoqinlogDao.selectAllKaoQinLogBy(0, 100," and iskuangke=1 and codenum='"+user.getCodenum()+"'");
		String kaoqinlogtishi="";
		if(kaoqinlogs.size()>=3){
			kaoqinlogtishi="旷课次数已经超过3次!!!";
		}else{
			kaoqinlogtishi="";
		}
		if (user!=null) {
			HttpSession session = request.getSession();
			session.setAttribute("username", user.getUsername());
			session.setAttribute("codenum", user.getCodenum());
			session.setAttribute("banjinum", user.getBanjinum());
			session.setAttribute("role", "role"+user.getRole());
			session.setAttribute("loginuser", user);
			session.setAttribute("kaoqinlogtishi", kaoqinlogtishi);
			return "success";
		} else {
			request.setAttribute("errorMessage", "请重新输入帐号密码！！");
			return "fail";
		}
	}

	public String loginout() {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		session.removeAttribute("username");
		session.removeAttribute("role");
		return "success";
	}
	
	public String userlist() {
		HttpServletRequest request = ServletActionContext.getRequest();
		if(request.getParameter("pageNum")!=null && !request.getParameter("pageNum").equals("")){
			pageNum = Integer.parseInt(request.getParameter("pageNum"));
		}
		if(request.getParameter("numPerPage")!=null){
			numPerPage = Integer.parseInt(request.getParameter("numPerPage"));
		}
		int total = userDao.selectAllUserCount();
		List<User> users = userDao.selectAllUser(
				(pageNum - 1) * numPerPage, numPerPage);
		request.setAttribute("totalCount", total);
		request.setAttribute("ps", numPerPage);
		request.setAttribute("pn", pageNum);
		request.setAttribute("userlist", users);
//		request.setAttribute("pagerinfo", Pager.getPagerNormal(total, numPerPage,
//				currentPage, "userlist", "共有" + total + "条记录"));
		
		request.setAttribute("searchuserlist", userDao.getAll(" and userlock=0 "));
		return "success";
	}
	
	public String useradd(){
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("banjilist", banjiDao.getAll(""));
		return "success";
	}
	
	public String useradd2() throws Exception{
		HttpServletRequest request = ServletActionContext.getRequest();
		
		User user = new User();

		String username = request.getParameter("username");
		
		user.setUsername(username);
		
		user.setPassword(request.getParameter("password"));
		
		user.setAddress(request.getParameter("address"));
//		String[] banjinums=request.getParameterValues("banjinum");
//		String banjinum="";
//		for(String str : banjinums){
//			banjinum=banjinum+str;
//		}
		user.setBanjinum(request.getParameter("banjinum"));
		user.setCodenum(request.getParameter("codenum"));
		user.setPhone(request.getParameter("phone"));
		user.setRoom(request.getParameter("room"));
		
		user.setUserlock(Integer.parseInt(request.getParameter("userlock")));
		
		user.setRole(Integer.parseInt(request.getParameter("role")));
		
		user.setCreatetime(new Date());
		
		User u = userDao.selectUserbByusernameByPassword(user.getUsername(), user.getPassword());
		
		if(u==null){
			userDao.insertUser(user);
			}else{
			request.setAttribute("info", "新增失败，用户帐号已存在，请检查输入");
		}
		HttpServletResponse resp = ServletActionContext.getResponse();
		PrintWriter out = resp.getWriter();
		out.print("{\"statusCode\":\"200\", \"message\":\"SUCCESS!\",\"navTabId\":\"userList\", \"rel\":\"userList\", \"callbackType\":\"closeCurrent\",\"forwardUrl\":\"userlist.html\"}");
		out.flush();
		out.close();
		return null;
	}
	
	public String userdel() throws IOException{
		HttpServletRequest request = ServletActionContext.getRequest();
		int id = Integer.parseInt(request.getParameter("id"));
		userDao.delUser(userDao.selectUser(id));
		HttpServletResponse resp = ServletActionContext.getResponse();
		PrintWriter out = resp.getWriter();
		//out.write(manage.util.Util.outPutMsg("200", "删除成功", "", "", "userlist.html"));
		out.write(manage.util.Util.outPutMsg("200", "SUCCESS!", "userList", "", false, "userlist.html"));
		//out.print("{\"statusCode\":\"200\", \"message\":\"删除成功！\",\"navTab\":\"userList\", \"rel\":\"userList\", \"callbackType\":\"closeCurrent\",\"forwardUrl\":\"userlist.html\"}");
		out.flush();
		out.close();
		return null;
	}

	
	public String  userupdate(){
		HttpServletRequest request = ServletActionContext.getRequest();
		int id = Integer.parseInt(request.getParameter("id"));
		request.setAttribute("bean", userDao.selectUser(id));
		request.setAttribute("id", id);
		request.setAttribute("banjilist", banjiDao.getAll(""));
		return "success";
	}
	
	public String userupdate2() throws Exception{
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse resp = ServletActionContext.getResponse();
		PrintWriter out = resp.getWriter();
		int id = Integer.parseInt(request.getParameter("id"));
		User bean = userDao.selectUser(id);
		
		if(request.getParameter("username")!=null){
			bean.setUsername(request.getParameter("username"));
		}
		if(request.getParameter("password")!=null){
			bean.setPassword(request.getParameter("password"));
		}
		if(request.getParameter("address")!=null){
			bean.setAddress(request.getParameter("address"));
		}
		if(bean.getRole()==2){
			if(request.getParameterValues("banjinum")!=null){
				String[] banjinums=request.getParameterValues("banjinum");
				String banjinum="";
				for(String str : banjinums){
					banjinum=banjinum+str;
					bean.setBanjinum(banjinum);
				}
			}
			
		}else{
			if(request.getParameter("banjinum")!=null){
				bean.setBanjinum(request.getParameter("banjinum"));
			}
		}
		
		
		if(request.getParameter("phone")!=null){
			bean.setPhone(request.getParameter("phone"));
		}
		if(request.getParameter("room")!=null){
			bean.setRoom(request.getParameter("room"));
			
		}
		
		
		if(request.getParameter("userlock")!=null){
			bean.setUserlock(Integer.parseInt(request.getParameter("userlock")));
		}
		if(request.getParameter("role")!=null){
			bean.setRole(Integer.parseInt(request.getParameter("role")));
		}
		userDao.updateUser(bean);
		//out.write(manage.util.Util.outPutMsg("200", "修改成功", "", "", "userlist.html"));
		out.print("{\"statusCode\":\"200\", \"message\":\"SUCCESS!\",\"navTabId\":\"userList\", \"rel\":\"userList\", \"callbackType\":\"closeCurrent\",\"forwardUrl\":\"userlist.html\"}");

		out.flush();
		out.close();
		return null;
	}
	
	
	public String searchuser(){
		HttpServletRequest request = ServletActionContext.getRequest();
		String keyword  = request.getParameter("keyword");
		
		int currentpage = 1;
		int pagesize = 50;
		if (request.getParameter("pagenum") != null)
			currentpage = Integer.parseInt(request.getParameter("pagenum"));
		request
				.setAttribute("userlist", userDao.selectAllUserByusername((currentpage - 1) * pagesize, 50,
						keyword));
		request.setAttribute("searchuserlist", userDao.getAll(" and userlock=0 "));
		return "success";
		
	}
	public String  passwordupdateok(){
		HttpServletRequest request = ServletActionContext.getRequest();
		return "success";
	}
	
	public String  passwordupdate() throws IOException{
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		String username = (String)session.getAttribute("codenum");

		String password1 = request.getParameter("oldpwd");
		String password2 = request.getParameter("newspwd");
		User u = userDao.selectUserbByusernameByPassword(username, password1);
		if(u!=null){
			u.setPassword(password2);
			userDao.updateUser(u);
			request.setAttribute("info", "密码修改成功");
		}else{
			request.setAttribute("info", "修改密码失败，请先确认原密码是否正确");
		}
		HttpServletResponse resp = ServletActionContext.getResponse();
		PrintWriter out = resp.getWriter();
		out.print("{\"statusCode\":\"200\", \"message\":\"SUCCESS!\",\"navTabId\":\"userList\", \"rel\":\"userList\", \"callbackType\":\"closeCurrent\",\"forwardUrl\":\"userlist.html\"}");
		out.flush();
		out.close();
		return null;
	}
	
	public String  usershow(){
		HttpServletRequest request = ServletActionContext.getRequest();
		int id = Integer.parseInt(request.getParameter("id"));
		request.setAttribute("bean", userDao.selectUser(id));
		request.setAttribute("id", id);
		request.setAttribute("banjilist", banjiDao.getAll(""));
		return "success";
	}
}

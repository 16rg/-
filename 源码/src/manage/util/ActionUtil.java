package manage.util;

import javax.servlet.http.HttpServletRequest;

public class ActionUtil {
	/**
	 * session中用户名
	 */
	public static final String SESSION_USERNAME = "session_username";
	/**
	 * action中返回值
	 */
	public static final class Result{
		/**成功*/
		public static final String SUCCESS = "success";
		/**返回输入页面*/
		public static final String INPUT = "input";
		/**重定向到登录页面*/
		public static final String LOGIN = "login";
		/**内部转向到action属性中url值对应的jsp页面*/
		public static final String FORWARD = "forward";
		/**重定向到action属性中url值对应的地址*/
		public static final String REDIRECT = "redirect";
		/**内部转向到action属性中url值对应的action*/
		public static final String CHAIN = "chain";
	}
	/**
	 * 是否ajax请求
	 */
	public static boolean isAjaxRequest(HttpServletRequest request){
		if ("XMLHttpRequest".equalsIgnoreCase(request.getHeader("X-Requested-With")) || request.getParameter("ajax") != null){
			return true;
		}
		return false;
	}
}
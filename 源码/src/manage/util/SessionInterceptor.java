package manage.util;

import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class SessionInterceptor extends AbstractInterceptor {
	private static final long serialVersionUID = 7209051454091321430L;

	@Override
	public String intercept(ActionInvocation actionInvocation) throws Exception {
		Map<String, Object> session = ActionContext.getContext().getSession();
		if (session.get("username") == null) {
			HttpServletRequest req = ServletActionContext.getRequest();
			HttpServletResponse resp = ServletActionContext.getResponse();
			if (ActionUtil.isAjaxRequest(req)) {
				resp.setCharacterEncoding("utf-8");
				PrintWriter out = resp.getWriter();
				out.println("{\"statusCode\":\"301\", \"message\":\"登录超时，请重新登录！\"}");
				return null;
			}
			return ActionUtil.Result.LOGIN;
		}
		return actionInvocation.invoke();
	}
}

package org.hepx.proext.interceptor;

import javax.servlet.http.HttpServletRequest;

/**
 * 检查登录超时
 * @author hepx
 *
 */
public class TimeOutInterceptor {

	private static final long serialVersionUID = 6107796196783785175L;

/*	@Override
	public String intercept(ActionInvocation invocation)throws Exception{
		// TODO Auto-generated method stub
		Map<String,Object>sessionMap=invocation.getInvocationContext().getSession();
		UserInfoPojo userInfo=(UserInfoPojo)sessionMap.get(SysConfig.LOGIN_USER);
		if(userInfo==null){
			if(isAjaxRequest(ServletActionContext.getRequest())){
				AbstractActionSupport support=(AbstractActionSupport)invocation.getAction();
				support.setTimeout(true);
				return SysConfig.TIMEOUT_MESSAGE_PAGE;
			}else{
				return SysConfig.TIMEOUT_MESSAGE_PAGE;
			}
		}
		return invocation.invoke();
	}*/
	
	/**
	 * 判断请求是否为AJAX
	 * @param request
	 * @return
	 */
	private boolean isAjaxRequest(HttpServletRequest request) {
		String header = request.getHeader("X-Requested-With");
		if (header != null && "XMLHttpRequest".equals(header))
			return true;
		else
			return false;
	}

}

package org.hepx.proext.util;

import org.hepx.proext.pojo.UserInfoPojo;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

public class LoginUserUtils {

	/**
	 * 获得登录用户
	 * @author : hepx 
	 * @date : 2011-3-10下午06:15:54
	 * @description : TODO
	 * @return : UserInfoPojo
	 */
	public static UserInfoPojo getLoginUserInfo(){
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
                .getRequest();
        return (UserInfoPojo) request.getSession().getAttribute(SysConfig.LOGIN_USER);
	}
	
	public static Integer getRoleType(){
		return getLoginUserInfo().getRoleType();
	}
	
	public static Long getUserId(){
		return getLoginUserInfo().getId();
	}
}

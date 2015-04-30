package org.hepx.proext.web.Controller;

import org.hepx.proext.service.UserInfoService;
import org.hepx.proext.pojo.UserInfoPojo;
import org.hepx.proext.web.ResponseResult;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

/**
 * 用户Action
 * 
 * @author hepx
 * 
 */
@Controller
@RequestMapping("/userInfo")
public class UserInfoController {

	protected Logger log = Logger.getLogger(UserInfoController.class);

	@Autowired
	private UserInfoService userInfoService;

	/**
	 * 修改密码
	 * 
	 * @return
	 */
	@RequestMapping("modifyPwd")
    @ResponseBody
	public Map modifyPwd(String oldPwd,String newPwd) {
		try {
			userInfoService.modifyPwd(oldPwd, newPwd);
            return ResponseResult.buildSuccessResult().toMap();
		} catch (Exception e) {
			log.error(e.getMessage(), e);
            return ResponseResult.buildFailResult(e).toMap();
		}
	}

	/**
	 * 用户列表
	 * @return
	 */
	@RequestMapping("queryUserInfoList")
    @ResponseBody
	public Map queryUserInfoList() {
	    ResponseResult result = new ResponseResult();
	    try {
			List<UserInfoPojo> userInfoList = userInfoService.queryUserInfoList();
            result.setDefSucMsg();
            result.addData("userInfoList",userInfoList);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
            result.setExceptionMsg(e);
		}
		return result.toMap();
	}

	/**
	 * 删除用户
	 * 
	 * @return
	 */
	@RequestMapping("deleteUserInfo")
	@ResponseBody
    public Map deleteUserInfo(@RequestBody UserInfoPojo userInfo) {
		try {
			userInfoService.deleteUserInfo(userInfo);
            return ResponseResult.buildSuccessResult().toMap();
		} catch (Exception e) {
			log.error(e.getMessage(), e);
            return ResponseResult.buildFailResult(e).toMap();
		}
	}

	/**
	 * 保存或更新用户
	 * 
	 * @return
	 */
	@RequestMapping("saveOrUpdateUserInfo")
    @ResponseBody
	public Map saveOrUpdateUserInfo(@RequestBody UserInfoPojo userInfo) {
		try {
			userInfoService.saveOrUpdateUserInfo(userInfo);
            return ResponseResult.buildSuccessResult().toMap();
		} catch (Exception e) {
			log.error(e.getMessage(), e);
            return ResponseResult.buildFailResult(e).toMap();
		}
	}

}

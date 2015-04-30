package org.hepx.proext.web.Controller;

import org.hepx.proext.service.UserInfoService;
import org.hepx.proext.pojo.UserInfoPojo;
import org.hepx.proext.util.SysConfig;
import org.hepx.proext.web.ResponseResult;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * 登录ACTION
 *
 * @author hepx
 * @date 2010-11-28
 */
@Controller
public class LoginController {

    private static Logger log = Logger.getLogger(LoginController.class);

    @Autowired
    private UserInfoService userInfoService;

    /**
     * 登录
     *
     * @return
     */
    @RequestMapping("/loginIn")
    @ResponseBody
    public Map loginIn(@RequestBody UserInfoPojo userInfo) {

        try {
            //取得生成的验证码
//			String c=(String)ServletActionContext.getRequest().getSession().getAttribute(Constants.KAPTCHA_SESSION_KEY);
//			if(c!=null&&c.equals(userInfo.getRandCode())){
            userInfoService.login(userInfo);
//			}else{
//				throw new DoErrorException("验证码输入错误！");
//			}
            return ResponseResult.buildSuccessResult().toMap();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return ResponseResult.buildFailResult(e).toMap();
        }
    }

    @RequestMapping("/logout")
    public String logout(HttpSession session) {
        if (session.getAttribute(SysConfig.LOGIN_USER) != null) {
            session.removeAttribute(SysConfig.LOGIN_USER);
            session.invalidate();
        }
        return "redirect:/";
    }

    /**
     * 注册
     *
     * @return : String
     * @author : hepx
     * @date : 2011-3-14下午03:37:45
     * @description : TODO
     */
    @RequestMapping(value = "/registUser", method = RequestMethod.POST)
    @ResponseBody
    public Map registUser(UserInfoPojo userInfo) {
        try {
            userInfoService.saveOrUpdateUserInfo(userInfo);
            return ResponseResult.buildSuccessResult().toMap();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return ResponseResult.buildFailResult(e).toMap();
        }
    }

    /**
     * @return : String
     * @author : hepx
     * @date : 2011-3-15下午12:47:13
     * @description : 通过填写的用户和邮箱地址。发送一个链接到用户邮箱。供用户修改密码
     */
    @RequestMapping("/findPwd")
    @ResponseBody
    public Map findPwd(UserInfoPojo userInfo) {
        try {
            userInfoService.findPwd(userInfo);
            return ResponseResult.buildSuccessResult().toMap();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return ResponseResult.buildFailResult(e).toMap();
        }
    }

    /**
     * @return : String
     * @author : hepx
     * @date : 2011-3-16上午11:47:26
     * @description : 用户在进入修改密码页面。点击修改。来修改密码
     */
    @RequestMapping("/modifyInitPwd")
    @ResponseBody
    public Map modifyInitPwd(@RequestParam String uid, @RequestParam String pwd, @RequestParam String ein) {
        try {
            if (uid != null && pwd != null && ein != null) {
                userInfoService.modifyPwd(uid, ein, pwd);
            } else {
                //temp = "modifyPwd";   这里要跳到修改密码页面
            }
            return ResponseResult.buildSuccessResult().toMap();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return ResponseResult.buildFailResult(e).toMap();

        }
    }

}

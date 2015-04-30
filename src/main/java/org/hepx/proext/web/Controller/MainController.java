package org.hepx.proext.web.Controller;

import org.hepx.proext.util.SysConfig;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

/**
 * 程序主入口
 */
@Controller
@RequestMapping("/")
public class MainController {
	protected Logger log = Logger.getLogger(MainController.class);

    @RequestMapping(method = RequestMethod.GET)
    public String execute(HttpSession session) {
        if (session.getAttribute(SysConfig.LOGIN_USER) != null) {
            return "main/main";
        }else{
            return "main/login";
        }
    }
}

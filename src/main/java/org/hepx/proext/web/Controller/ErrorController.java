package org.hepx.proext.web.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * User: hepx
 * Date: 15-4-30
 * Time: 上午11:48
 */
@Controller
public class ErrorController {

    @RequestMapping("/404")
    public String to404(){
        return "error/404";
    }

    @RequestMapping("/500")
    public String to500(){
        return "error/500";
    }
}

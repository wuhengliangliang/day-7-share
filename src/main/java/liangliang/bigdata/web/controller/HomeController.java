package liangliang.bigdata.web.controller;

import liangliang.bigdata.base.ApiResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 用于访问主路径
 */
@Controller
public class HomeController {
    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("name","无痕");
        return "index";
    }
    @GetMapping("/get")
    @ResponseBody//返回结构体，也就是json数据
    public ApiResponse get() {

        return ApiResponse.ofMessage(200,"登录成功");
    }
    @GetMapping("/404")
    public String notFound () {
        return "404";
    }
    @GetMapping("/403")
    public String accessError () {
        return "403";
    }
    @GetMapping("/500")
    public String internalError () {
        return "500";
    }
    @GetMapping("/logout/page")
    public String logoutPage() {

        return "/logout";
    }
}

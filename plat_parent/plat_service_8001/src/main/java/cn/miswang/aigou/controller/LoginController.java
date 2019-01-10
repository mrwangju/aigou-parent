package cn.miswang.aigou.controller;

import cn.miswang.aigou.domain.Employee;
import cn.miswang.aigou.util.AjaxResult;
import org.aspectj.weaver.loadtime.Aj;
import org.springframework.web.bind.annotation.*;

@RestController
public class LoginController {
    //前台通过post提交一个json{},[]，后天接受要用@RequestBody
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public AjaxResult login(@RequestBody Employee employee){
        //模拟登录验证
        if("admin".equals(employee.getName())&&"admin".equals(employee.getPassword())){
            return AjaxResult.ajaxResult();
        }
        return AjaxResult.ajaxResult().setSuccess(false).setMssage("登录失败！！");
    }
}

package cn.miswang.aigou.controller;

import cn.miswang.aigou.client.PageClient;
import cn.miswang.aigou.utils.VelocityUtils;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class PageController implements PageClient{

    @Override
    @RequestMapping(value = "/page",method = RequestMethod.POST)
    public void genStaticPage(@RequestBody Map<String, Object> params) {
        System.out.println(params);
        Object model = params.get("model");
        String  templatePath = (String) params.get("templatePath");
        String  staticPagePath = (String) params.get("staticPagePath");
        System.out.println(model);
        System.out.println(templatePath);
        System.out.println(staticPagePath);
        //根据模板，静态化model到指定的文件 模板文件中通过访问model来访问设置的内容
        VelocityUtils.staticByTemplate(model, templatePath, staticPagePath);
    }
}

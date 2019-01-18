package cn.miswang.aigou.controller;

import cn.miswang.aigou.util.AjaxResult;
import cn.miswang.aigou.utils.FastDfsApiOpr;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
public class FastDfsController {
    @RequestMapping(value = "/upload",method = RequestMethod.POST)
    public AjaxResult upload(@RequestParam(value = "file",required = true)MultipartFile file){
        try {
            String originalFilename = file.getOriginalFilename();
            System.out.println("originalFilename"+originalFilename);
            String extName = originalFilename.substring(originalFilename.lastIndexOf(".")+ 1);
            String filePath = FastDfsApiOpr.upload(file.getBytes(), extName);
            return AjaxResult.me().setResultObj(filePath);
        } catch (IOException e) {
            e.printStackTrace();
            return AjaxResult.me().setSuccess(false).setMessage("上传失败!"+e.getMessage());
        }
    }
    @RequestMapping(value = "/upload",method = RequestMethod.DELETE)
    public AjaxResult upload(@RequestParam(value = "filePath",required = true)String filePath){
        System.out.println("我在删除"+filePath);
        String pathTmp = filePath.substring(1); // goup1/xxxxx/yyyy
        String groupName =  pathTmp.substring(0, pathTmp.indexOf("/")); //goup1
        String remotePath = pathTmp.substring(pathTmp.indexOf("/")+1);// /xxxxx/yyyy
        FastDfsApiOpr.delete(groupName, remotePath);
        return  AjaxResult.me();
    }
}

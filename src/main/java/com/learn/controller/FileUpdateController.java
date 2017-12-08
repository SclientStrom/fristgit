package com.learn.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class FileUpdateController {
    private static final Logger logger= LoggerFactory.getLogger(FileUpdateController.class);
    @RequestMapping("fileUpload.htm")
    public String  fileUpload(@RequestParam("file") CommonsMultipartFile file) throws IOException {
        //用来检测程序运行时间
        long  startTime=System.currentTimeMillis();
        logger.info("fileName:{}",file.getOriginalFilename());
            //获取输入流 CommonsMultipartFile 中可以直接得到文件的流
        InputStream is=file.getInputStream();
        int out=0;
        OutputStream outputStream=new FileOutputStream("/Users/slientstrom/soft/log/"+file.getOriginalFilename());
        List<Integer> integers=new ArrayList<>();
        while ((out=is.read())!=-1){
            outputStream.write(out);
            integers.add(out);
        }
        outputStream.close();
        OutputStream outputStream2=new FileOutputStream("/Users/slientstrom/soft/log/11"+file.getOriginalFilename());
        byte []bytes=new byte[integers.size()];
        for(int i=0;i<integers.size();i++){
            bytes[i]=(byte)integers.get(i).intValue();
        }
        outputStream2.write(bytes);
        outputStream2.close();
        logger.info("readFile content: {}",bytes);
        long  endTime=System.currentTimeMillis();
        logger.info("upload cost {}ms",(endTime-startTime));
        return "/success";
    }
}
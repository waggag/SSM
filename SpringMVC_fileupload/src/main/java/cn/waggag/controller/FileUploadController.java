package cn.waggag.controller;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.List;
import java.util.UUID;

/**
 * @description: 传统方式的文件上传
 * @author: waggag
 * @time: 2019/7/19 0:26
 * @Company http://www.waggag.cn
 */
@Controller
@RequestMapping("/user")
public class FileUploadController {

    /**
     * 跨服务器上传文件
     * @param upload
     * @throws Exception
     */
    @RequestMapping("/fileupload2")
    public String fileUpload2(MultipartFile upload) throws Exception {
        //定义上传文件服务器的地址
        String path= "http://localhost:8080/uploads/";

        //获取上传的文件名称
        String filename = upload.getOriginalFilename();
        String uuid = UUID.randomUUID().toString().replace("-", "");
        filename = uuid+"_"+filename;
        System.out.println(filename);

        //完成跨服务器的文件的上传
        Client client = Client.create();
        WebResource webResource = client.resource(path);
        webResource.put(upload.getBytes());

        System.out.println("跨服务器文件上传！");
        return "success";
    }

    /**
     * SpringMVC方式的文件上传
     * @param request
     * @throws Exception
     */
    @RequestMapping("/fileupload1")
    public String fileUpload1(HttpServletRequest request, MultipartFile upload) throws Exception {
        //文件存放的路径
        String path = request.getSession().getServletContext().getRealPath("/uploads/");
        //判断路径是否存在,不存在创建文件夹
        File file = new File(path);
        if(!file.exists()){
            file.mkdirs();
        }
        //获取上传的文件名称
        String filename = upload.getOriginalFilename();
        String uuid = UUID.randomUUID().toString().replace("-", "");
        filename = uuid+"_"+filename;
        System.out.println(filename);
        //完成文件的上传
        upload.transferTo(new File(path,filename));
        //删除临时文件
        System.out.println("SpringMVC文件上传！");
        return "success";
    }

    /**
     * 传统方式的文件上传
     * @param request
     * @throws Exception
     */
    @RequestMapping("/fileupload")
    public String fileUpload(HttpServletRequest request) throws Exception {
        try {
            //使用fileupload组件完成文件的上传
            //文件存放的路径
            String path = request.getSession().getServletContext().getRealPath("/uploads/");
            //判断路径是否存在,不存在创建文件夹
            File file = new File(path);
            if(!file.exists()){
                file.mkdirs();
            }
            //解析request对象，获取文件上传项
            DiskFileItemFactory factory = new DiskFileItemFactory();
            ServletFileUpload servletFileUpload = new ServletFileUpload(factory);
            //解析request
            List<FileItem> fileItemList = servletFileUpload.parseRequest(request);
            for (FileItem fileItem : fileItemList) {
                //判断当前item是否是上传的文件项
                if(fileItem.isFormField()){
                    //说明是普通的表单项
                }else{
                    //说明是上传的文件项
                    //获取上传的文件名称
                    String fildName = fileItem.getName();
                    String uuid = UUID.randomUUID().toString().replace("-", "");
                    fildName = uuid+"_"+fildName;
                    System.out.println(fildName);
                    //完成文件的上传
                    fileItem.write(new File(path,fildName));
                    //删除临时文件
                    fileItem.delete();
                }
            }
        } finally {
            System.out.println("文件上传！");
        }
        return "success";
    }
}

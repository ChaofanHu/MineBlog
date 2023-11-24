package pri.chaofan.mineblog.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pri.chaofan.mineblog.pojo.Blog;
import pri.chaofan.mineblog.pojo.BlogManage;
import pri.chaofan.mineblog.service.BlogService;
import pri.chaofan.mineblog.service.impl.BlogServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class BlogManageController {
    @Autowired
    private BlogService blogService;

    @GetMapping("/getAllBlogs")
    public List<Blog> getAllBLogs(){
        List<Blog> blogs = blogService.selectAll();
//        System.out.println("获取所有blog被调用了");
        return blogs;
    }

    @GetMapping("/blogManage")
    public List<BlogManage> blogManages(){
        List<BlogManage> blogManages = blogService.selectAllForManage();
//        System.out.println(blogManages);
        return blogManages;
    }

    @GetMapping("/")
    public String blogs(){
        return "blogs";
    }
}


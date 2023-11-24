package pri.chaofan.mineblog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import pri.chaofan.mineblog.pojo.IndexBlog;
import pri.chaofan.mineblog.service.BlogService;

import java.util.List;

@RestController
public class HomePageController {
    @Autowired
    private BlogService blogService;

    @GetMapping("/getAllBlogs")
    public List<IndexBlog> getAllBlogs(){
        List<IndexBlog> indexBlogs = blogService.selectAllIndexBlog();
        return indexBlogs;
    }
}

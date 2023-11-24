package pri.chaofan.mineblog.controller;


import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pri.chaofan.mineblog.pojo.Blog;
import pri.chaofan.mineblog.pojo.IndexBlog;
import pri.chaofan.mineblog.service.BlogService;

@RestController
public class BlogController {

    @Autowired
    @Resource
    private BlogService blogService;



    @GetMapping("/getBlogById")
    public Blog getBlogById(@RequestParam int id){
        Blog blog = blogService.selectById(id);
        return blog;
    }

    @GetMapping("/getBlogHeader")
    public IndexBlog getBlogHeader(@RequestParam int id){
        IndexBlog indexBlog = blogService.selectHeaderById(id);
        return indexBlog;
    }
}

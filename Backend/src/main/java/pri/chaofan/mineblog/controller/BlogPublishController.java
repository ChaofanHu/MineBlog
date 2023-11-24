package pri.chaofan.mineblog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import pri.chaofan.mineblog.pojo.Blog;
import pri.chaofan.mineblog.service.BlogService;
import pri.chaofan.mineblog.util.Result;

@RestController
@RequestMapping("/admin")
public class BlogPublishController {

    @Autowired
    private BlogService blogService;


    @Transactional
    @PostMapping("/establishBlog")
    public Result establishBlog(@RequestBody Blog blog){
        int i = blogService.establishBlog(blog);
        if( i >= 1){
            return Result.success(200,"add successful");
        }else {
            return Result.error(401,"error");
        }
    }
}

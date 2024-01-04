package pri.chaofan.mineblog.controller;


import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pri.chaofan.mineblog.pojo.*;
import pri.chaofan.mineblog.service.BlogService;
import pri.chaofan.mineblog.service.CategoryService;
import pri.chaofan.mineblog.service.FlagService;
import pri.chaofan.mineblog.service.TagService;

import java.util.List;

@RestController
public class BlogController {

    @Autowired
    @Resource
    private BlogService blogService;

    @Autowired
    private CategoryService categoryService;
    @Autowired
    private TagService tagService;



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

    @GetMapping("/getAllCategory")
    public List<Category> getAllCategory(){
        List<Category> categories = categoryService.selectAll();
        return categories;
    }

    @GetMapping("/getAllTags")
    public List<Tag> getAllTags(){
        List<Tag> tags = tagService.selectAll();
        return tags;
    }
}

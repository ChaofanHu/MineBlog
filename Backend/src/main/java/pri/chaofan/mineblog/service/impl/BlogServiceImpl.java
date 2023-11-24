package pri.chaofan.mineblog.service.impl;

import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pri.chaofan.mineblog.dao.BlogManageMapper;
import pri.chaofan.mineblog.dao.BlogMapper;
import pri.chaofan.mineblog.dao.IndexBlogMapper;
import pri.chaofan.mineblog.pojo.Blog;
import pri.chaofan.mineblog.pojo.BlogManage;
import pri.chaofan.mineblog.pojo.IndexBlog;
import pri.chaofan.mineblog.service.BlogService;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class BlogServiceImpl implements BlogService {
    @Autowired
    @Resource
    BlogMapper blogMapper;
    @Autowired
    @Resource
    BlogManageMapper blogManageMapper;

    @Autowired
    @Resource
    private IndexBlogMapper indexBlogMapper;

    @Override
    public List<Blog> selectAll() {
        List<Blog> blogs = blogMapper.selectAll();
        return blogs;
    }

    @Override
    public List<BlogManage> selectAllForManage() {
        List<BlogManage> blogManages = blogManageMapper.selectAll();
        return blogManages;
    }

    @Override
    public int establishBlog(Blog blog) {
        String dateTime = DateTimeFormatter.ofPattern("yyyy-MM-dd").format(LocalDateTime.now());
        blog.setViews(0);
        blog.setCreateTime(dateTime);
        blog.setUpdateTime(dateTime);
        int i = blogMapper.establishBlog(blog);
        return i;
    }

    @Override
    public Blog selectById(int id) {
        Blog blog = blogMapper.selectById(id);
        return blog;
    }

    @Override
    public List<IndexBlog> selectAllIndexBlog() {
        List<IndexBlog> indexBlogs = indexBlogMapper.selectAllIndexBlog();
        return indexBlogs;
    }

    @Override
    public IndexBlog selectHeaderById(int id) {
        IndexBlog indexBlog = indexBlogMapper.selectById(id);
        return indexBlog;
    }


}

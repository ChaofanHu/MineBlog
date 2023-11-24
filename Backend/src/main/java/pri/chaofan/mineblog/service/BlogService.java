package pri.chaofan.mineblog.service;

import pri.chaofan.mineblog.pojo.Blog;
import pri.chaofan.mineblog.pojo.BlogManage;
import pri.chaofan.mineblog.pojo.IndexBlog;

import java.util.List;

public interface BlogService {
    List<Blog> selectAll();
    List<BlogManage> selectAllForManage();

    int establishBlog(Blog blog);

    Blog selectById(int id);

    List<IndexBlog> selectAllIndexBlog();

    IndexBlog selectHeaderById(int id);
}

package pri.chaofan.mineblog.dao;


import pri.chaofan.mineblog.pojo.Blog;
import pri.chaofan.mineblog.pojo.IndexBlog;


import java.util.List;

public interface BlogMapper {
    List<Blog> selectAll();

    int establishBlog(Blog blog);

    Blog selectById(int id);
}

package pri.chaofan.mineblog.dao;

import pri.chaofan.mineblog.pojo.IndexBlog;

import java.util.List;

public interface IndexBlogMapper {
    List<IndexBlog> selectAllIndexBlog();

    IndexBlog selectById(int id);
}

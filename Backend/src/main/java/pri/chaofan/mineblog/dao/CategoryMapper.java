package pri.chaofan.mineblog.dao;

import pri.chaofan.mineblog.pojo.Category;

import java.util.List;

public interface CategoryMapper {
    List<Category> selectAll();
}

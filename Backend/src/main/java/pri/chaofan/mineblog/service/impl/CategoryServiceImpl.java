package pri.chaofan.mineblog.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pri.chaofan.mineblog.dao.CategoryMapper;
import pri.chaofan.mineblog.pojo.Category;
import pri.chaofan.mineblog.service.CategoryService;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryMapper categoryMapper;

    @Override
    public List<Category> selectAll() {
        List<Category> categories = categoryMapper.selectAll();
        return categories;
    }
}

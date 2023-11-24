package pri.chaofan.mineblog.controller;


import com.alibaba.fastjson2.JSONObject;
import netscape.javascript.JSObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pri.chaofan.mineblog.pojo.Category;
import pri.chaofan.mineblog.service.CategoryService;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/admin")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/selectAllCategory")
    public List<JSONObject> selectAllCategory(){
        List<Category> categories = categoryService.selectAll();
        List<JSONObject> list = new ArrayList<>();
        JSONObject jsonObject = null;
        for(Category category: categories){
            jsonObject = new JSONObject();
            jsonObject.put("text",category.getName());
            jsonObject.put("value",category.getId());
            list.add(jsonObject);
        }
        return list;
    }
}

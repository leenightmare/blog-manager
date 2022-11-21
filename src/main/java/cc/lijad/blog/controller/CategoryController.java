package cc.lijad.blog.controller;

import cc.lijad.blog.domain.AjaxResult;
import cc.lijad.blog.domain.entity.Category;
import cc.lijad.blog.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author 李坚达
 * @create 2022/11/16 14:18
 */
@RestController
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/category/list")
    public AjaxResult listCategory(){
        List<Category> categories = categoryService.listCategory();
        return AjaxResult.success(categories);
    }
}

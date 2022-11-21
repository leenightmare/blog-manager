package cc.lijad.blog.service.impl;

import cc.lijad.blog.dao.CategoryMapper;
import cc.lijad.blog.domain.entity.Category;
import cc.lijad.blog.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 李坚达
 * @create 2022/11/16 14:17
 */
@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryMapper categoryMapper;

    /**
     *
     * @return
     */
    @Override
    public List<Category> listCategory() {
        List<Category> categories = categoryMapper.listCategory();
        return categories;
    }
}

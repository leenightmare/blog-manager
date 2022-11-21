package cc.lijad.blog.service;

import cc.lijad.blog.domain.entity.Category;

import java.util.List;

/**
 * @author 李坚达
 * @create 2022/11/16 14:16
 */
public interface CategoryService {
    /**
     * 获取所有分类
     * @return
     */
    List<Category> listCategory();
}

package cc.lijad.blog.dao;

import cc.lijad.blog.domain.entity.Category;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author 李坚达
 * @create 2022/11/14 22:10
 */
@Mapper
public interface CategoryMapper {
    /**
     * 查询所有分类
     * @return
     */
    List<Category> listCategory();
}

package cc.lijad.blog.dao;

import cc.lijad.blog.domain.entity.Tag;
import cc.lijad.blog.queryvo.TagWithCountVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author 李坚达
 * @create 2022/11/14 22:14
 */
@Mapper
public interface TagMapper {

    /**
     * 查询所有标签
     *
     * @return
     */
    List<Tag> listTag();


    /**
     * 根据一个文章id查询对应标签
     *
     * @param articleId
     * @return
     */
    List<Tag> listTagOfArticle(Long articleId);


    /**
     * 查询标签，且带有文章数量
     *
     * @return
     */
    List<TagWithCountVO> listTagWithCount();
}

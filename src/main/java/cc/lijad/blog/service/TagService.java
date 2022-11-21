package cc.lijad.blog.service;

import cc.lijad.blog.domain.entity.Tag;
import cc.lijad.blog.queryvo.TagWithCountVO;

import java.util.List;

/**
 * @author 李坚达
 * @create 2022/11/14 23:17
 */
public interface TagService {

    /**
     * 获取所有标签
     *
     * @return
     */
    List<Tag> listTag();

    /**
     * @param articleId
     * @return
     */
    List<Tag> listTagByArticleId(Long articleId);


    /**
     *
     * @return
     */
    List<TagWithCountVO> listTagWithCount();
}

package cc.lijad.blog.service.impl;

import cc.lijad.blog.dao.TagMapper;
import cc.lijad.blog.domain.entity.Tag;
import cc.lijad.blog.queryvo.TagWithCountVO;
import cc.lijad.blog.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 李坚达
 * @create 2022/11/14 23:19
 */
@Service
public class TagServiceImpl implements TagService {

    @Autowired
    private TagMapper tagMapper;

    /**
     * @return
     */
    @Override
    public List<Tag> listTag() {
        return tagMapper.listTag();
    }


    /**
     * @param articleId
     * @return
     */
    @Override
    public List<Tag> listTagByArticleId(Long articleId) {
        List<Tag> tags = tagMapper.listTagOfArticle(articleId);
        return tags;
    }

    @Override
    public List<TagWithCountVO> listTagWithCount() {
        List<TagWithCountVO> tagWithCountVOS = tagMapper.listTagWithCount();
        return tagWithCountVOS;
    }
}

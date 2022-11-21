package cc.lijad.blog.queryvo;

import cc.lijad.blog.domain.entity.Tag;

import java.util.List;

/**
 * @author 李坚达
 * @create 2022/11/14 22:37
 */
public class MiniArticle extends BaseQueryArticle {

    private static final long serialVersionUID = 1L;

    /*标签列表*/
    private List<Tag> tagList;

    public MiniArticle() {
    }

    public List<Tag> getTagList() {
        return tagList;
    }

    public void setTagList(List<Tag> tagList) {
        this.tagList = tagList;
    }
}

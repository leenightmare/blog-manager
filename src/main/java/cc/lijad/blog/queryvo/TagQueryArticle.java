package cc.lijad.blog.queryvo;

import cc.lijad.blog.domain.entity.Tag;

/**
 * @author 李坚达
 * @create 2022/11/15 12:05
 */
//用于展示详情的博客
public class TagQueryArticle extends BaseQueryArticle {

    private static final long serialVersionUID = 1L;

    private Tag tag;

    public TagQueryArticle() {
    }

    public Tag getTag() {
        return tag;
    }

    public void setTag(Tag tag) {
        this.tag = tag;
    }
}

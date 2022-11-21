package cc.lijad.blog.queryvo;

import cc.lijad.blog.domain.entity.Tag;

/**
 * @author 李坚达
 * @create 2022/11/17 17:35
 */
//分类包含文章的数量
public class TagWithCountVO extends Tag {

    private Integer articleCount;

    public TagWithCountVO() {
    }

    public Integer getArticleCount() {
        return articleCount;
    }

    public void setArticleCount(Integer articleCount) {
        this.articleCount = articleCount;
    }
}

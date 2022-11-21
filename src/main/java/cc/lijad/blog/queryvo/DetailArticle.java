package cc.lijad.blog.queryvo;

import cc.lijad.blog.domain.entity.Tag;

import java.util.List;

/**
 * @author 李坚达
 * @create 2022/11/15 9:25
 */
public class DetailArticle extends BaseQueryArticle {

    private static final long serialVersionUID = 1L;

    /*标签列表*/
    private List<Tag> tagList;

    /*文章内容*/
    private String content;
    /*文章内容md格式*/
    private String contentMd;


    public DetailArticle() {
    }

    public List<Tag> getTagList() {
        return tagList;
    }

    public void setTagList(List<Tag> tagList) {
        this.tagList = tagList;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getContentMd() {
        return contentMd;
    }

    public void setContentMd(String contentMd) {
        this.contentMd = contentMd;
    }
}

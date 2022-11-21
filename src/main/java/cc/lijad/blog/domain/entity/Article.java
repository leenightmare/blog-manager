package cc.lijad.blog.domain.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author 李坚达
 * @create 2022/11/13 18:00
 */
public class Article implements Serializable {
    private static final long serialVersionUID = 1L;

    /*主键*/
    private Long id;
    /*作者（用户）id*/
    private Long userId;
    /*文章标题*/
    private String title;
    /*文章概要描述*/
    private String description;
    /*文章版图*/
    private String image;
    /*文章内容*/
    private String content;
    /*文章内容md格式*/
    private String contentMd;
    /*创建时间*/
    private LocalDateTime createTime;
    /*最新修改时间*/
    private LocalDateTime updateTime;
    /*分类id*/
    private Long categoryId;
    /*评论数量*/
    private Integer commentCount;
    /*访问量*/
    private Integer visits;
    /*点赞数量*/
    private Integer pollCount;
    /*是否开启评论*/
    private Integer isComment;
    /*是否置顶*/
    private Integer isTop;
    /*是否开启赞赏*/
    private Integer isReward;
    /*文章状态*/
    private Integer status;


    public Article() {
    }

    @Override
    public String toString() {
        return "Article{" +
                "id=" + id +
                ", userId=" + userId +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", image='" + image + '\'' +
                ", content='" + content + '\'' +
                ", contentMd='" + contentMd + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", categoryId=" + categoryId +
                ", commentCount=" + commentCount +
                ", visits=" + visits +
                ", pollCount=" + pollCount +
                ", isComment=" + isComment +
                ", isTop=" + isTop +
                ", isReward=" + isReward +
                ", status=" + status +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
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

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public LocalDateTime getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public Integer getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(Integer commentCount) {
        this.commentCount = commentCount;
    }

    public Integer getVisits() {
        return visits;
    }

    public void setVisits(Integer visits) {
        this.visits = visits;
    }

    public Integer getPollCount() {
        return pollCount;
    }

    public void setPollCount(Integer pollCount) {
        this.pollCount = pollCount;
    }

    public Integer getIsComment() {
        return isComment;
    }

    public void setIsComment(Integer isComment) {
        this.isComment = isComment;
    }

    public Integer getIsTop() {
        return isTop;
    }

    public void setIsTop(Integer isTop) {
        this.isTop = isTop;
    }

    public Integer getIsReward() {
        return isReward;
    }

    public void setIsReward(Integer isReward) {
        this.isReward = isReward;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}

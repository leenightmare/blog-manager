package cc.lijad.blog.queryvo;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author 李坚达
 * @create 2022/11/15 12:06
 */
public class BaseQueryArticle implements Serializable {
    private static final long serialVersionUID = 1L;

    /*主键*/
    private Long id;

    /*文章标题*/
    private String title;

    /*文章概要描述*/
    private String description;

    /*作者（用户）id*/
    private Long userId;

    /*用户名*/
    private String nickname;

    /*创建时间*/
    private LocalDateTime createTime;

    /*最新修改时间*/
    private LocalDateTime updateTime;

    /*访问量*/
    private Integer visits;

    /*点赞数量*/
    private Integer pollCount;

    /*评论数量*/
    private Integer commentCount;

    /*分类id*/
    private Long categoryId;

    /*分类名字*/
    private String categoryName;

    /*文章版图*/
    private String image;

    /*是否置顶*/
    private Integer isTop;

    /*文章状态*/
    private Integer status;


    /*用户头像*/
    private String userAvatar;

    public BaseQueryArticle() {
    }

    public String getUserAvatar() {
        return userAvatar;
    }

    public void setUserAvatar(String userAvatar) {
        this.userAvatar = userAvatar;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
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

    public Integer getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(Integer commentCount) {
        this.commentCount = commentCount;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Integer getIsTop() {
        return isTop;
    }

    public void setIsTop(Integer isTop) {
        this.isTop = isTop;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}

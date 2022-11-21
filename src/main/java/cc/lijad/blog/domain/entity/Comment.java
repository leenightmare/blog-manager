package cc.lijad.blog.domain.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author 李坚达
 * @create 2022/11/13 18:13
 */
public class Comment  implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private Long parentId;
    private String userAgent;
    private String userIp;
    private String userEmail;
    private Long userId;
    private String userNickName;
    private String content;
    private Long replyUserId;
    private String replyUserNickName;
    private Integer targetType;
    private Long articleId;
    private LocalDateTime createTime;
    private Integer status;
    private String userAvatar;
    private String replyUserAvatar;

    public Comment() {
    }

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", parentId=" + parentId +
                ", userAgent='" + userAgent + '\'' +
                ", userIp='" + userIp + '\'' +
                ", userEmail='" + userEmail + '\'' +
                ", userId=" + userId +
                ", userNickName='" + userNickName + '\'' +
                ", content='" + content + '\'' +
                ", replyUserId=" + replyUserId +
                ", replyUserNickName='" + replyUserNickName + '\'' +
                ", targetType=" + targetType +
                ", articleId=" + articleId +
                ", createTime=" + createTime +
                ", status=" + status +
                ", userAvatar='" + userAvatar + '\'' +
                ", replyUserAvatar='" + replyUserAvatar + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public String getUserAgent() {
        return userAgent;
    }

    public void setUserAgent(String userAgent) {
        this.userAgent = userAgent;
    }

    public String getUserIp() {
        return userIp;
    }

    public void setUserIp(String userIp) {
        this.userIp = userIp;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserNickName() {
        return userNickName;
    }

    public void setUserNickName(String userNickName) {
        this.userNickName = userNickName;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Long getReplyUserId() {
        return replyUserId;
    }

    public void setReplyUserId(Long replyUserId) {
        this.replyUserId = replyUserId;
    }

    public String getReplyUserNickName() {
        return replyUserNickName;
    }

    public void setReplyUserNickName(String replyUserNickName) {
        this.replyUserNickName = replyUserNickName;
    }

    public Integer getTargetType() {
        return targetType;
    }

    public void setTargetType(Integer targetType) {
        this.targetType = targetType;
    }

    public Long getArticleId() {
        return articleId;
    }

    public void setArticleId(Long articleId) {
        this.articleId = articleId;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getUserAvatar() {
        return userAvatar;
    }

    public void setUserAvatar(String userAvatar) {
        this.userAvatar = userAvatar;
    }

    public String getReplyUserAvatar() {
        return replyUserAvatar;
    }

    public void setReplyUserAvatar(String replyUserAvatar) {
        this.replyUserAvatar = replyUserAvatar;
    }
}

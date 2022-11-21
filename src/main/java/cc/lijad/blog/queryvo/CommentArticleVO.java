package cc.lijad.blog.queryvo;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author 李坚达
 * @create 2022/11/15 13:21
 */
public class CommentArticleVO {
    private static final long serialVersionUID = 1L;

    private Long id;
    private Long parentId;
    private String userAgent;
    private String userIp;
    private String userEmail;
    private Long userId;
    private String content;
    private Long replyUserId;
    private Integer targetType;
    private Long articleId;
    private LocalDateTime createTime;
    private Integer status;

    //
    private String userNickName;
    private String replyUserNickName;
    private String userAvatar;
    private String replyUserAvatar;

    List<CommentArticleVO> childComment;



    public CommentArticleVO() {
    }

    @Override
    public String toString() {
        return "CommentArticleVO{" +
                "id=" + id +
                ", parentId=" + parentId +
                ", userAgent='" + userAgent + '\'' +
                ", userIp='" + userIp + '\'' +
                ", userEmail='" + userEmail + '\'' +
                ", userId=" + userId +
                ", content='" + content + '\'' +
                ", replyUserId=" + replyUserId +
                ", targetType=" + targetType +
                ", articleId=" + articleId +
                ", createTime=" + createTime +
                ", status=" + status +
                ", userNickName='" + userNickName + '\'' +
                ", replyUserNickName='" + replyUserNickName + '\'' +
                ", userAvatar='" + userAvatar + '\'' +
                ", replyUserAvatar='" + replyUserAvatar + '\'' +
                ", childComment=" + childComment +
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

    public String getUserNickName() {
        return userNickName;
    }

    public void setUserNickName(String userNickName) {
        this.userNickName = userNickName;
    }

    public String getReplyUserNickName() {
        return replyUserNickName;
    }

    public void setReplyUserNickName(String replyUserNickName) {
        this.replyUserNickName = replyUserNickName;
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

    public List<CommentArticleVO> getChildComment() {
        return childComment;
    }

    public void setChildComment(List<CommentArticleVO> childComment) {
        this.childComment = childComment;
    }
}

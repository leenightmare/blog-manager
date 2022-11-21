package cc.lijad.blog.domain;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author 李坚达
 * @create 2022/11/14 15:27
 */
public class LoginUser implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long id;
    private Integer role;
    private String username;
    private String nickname;
    private String avatar;
    private String email;
    private LocalDateTime lastLoginTime;
    private LocalDateTime createTime;
    private Integer status;

    private String token;

    @Override
    public String toString() {
        return "LoginUser{" +
                "id=" + id +
                ", role=" + role +
                ", username='" + username + '\'' +
                ", nickname='" + nickname + '\'' +
                ", avatar='" + avatar + '\'' +
                ", email='" + email + '\'' +
                ", lastLoginTime=" + lastLoginTime +
                ", createTime=" + createTime +
                ", status=" + status +
                ", token='" + token + '\'' +
                '}';
    }

    public LoginUser() {
    }

    public LoginUser(Long id, Integer role, String username, String nickname, String avatar, String email, LocalDateTime lastLoginTime, LocalDateTime createTime, Integer status, String token) {
        this.id = id;
        this.role = role;
        this.username = username;
        this.nickname = nickname;
        this.avatar = avatar;
        this.email = email;
        this.lastLoginTime = lastLoginTime;
        this.createTime = createTime;
        this.status = status;
        this.token = token;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getRole() {
        return role;
    }

    public void setRole(Integer role) {
        this.role = role;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDateTime getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(LocalDateTime lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
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

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}

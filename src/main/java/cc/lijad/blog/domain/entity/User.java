package cc.lijad.blog.domain.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author 李坚达
 * @create 2022/11/13 18:17
 */
public class User implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private Integer role;
    private String username;
    private String nickname;
    private String avatar;
    private String password;
    private String email;
    private LocalDateTime lastLoginTime;
    private LocalDateTime createTime;
    private Integer status;




    public User() {
    }

    public User(Long id, Integer role, String username, String nickname, String avatar, String password, String email, LocalDateTime lastLoginTime, LocalDateTime createTime, Integer status) {
        this.id = id;
        this.role = role;
        this.username = username;
        this.nickname = nickname;
        this.avatar = avatar;
        this.password = password;
        this.email = email;
        this.lastLoginTime = lastLoginTime;
        this.createTime = createTime;
        this.status = status;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", role=" + role +
                ", username='" + username + '\'' +
                ", nickname='" + nickname + '\'' +
                ", avatar='" + avatar + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", lastLoginTime=" + lastLoginTime +
                ", createTime=" + createTime +
                ", status=" + status +
                '}';
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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
}

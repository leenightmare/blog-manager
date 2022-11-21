package cc.lijad.blog.domain.entity;

import java.io.Serializable;

/**
 * @author 李坚达
 * @create 2022/11/13 18:16
 */
public class Tag implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private String name;
    private String url;
    private Integer status;


    public Tag() {
    }

    public Tag(Long id, String name, String url, Integer status) {
        this.id = id;
        this.name = name;
        this.url = url;
        this.status = status;
    }

    @Override
    public String toString() {
        return "Tag{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", url='" + url + '\'' +
                ", status=" + status +
                '}';
    }


    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}

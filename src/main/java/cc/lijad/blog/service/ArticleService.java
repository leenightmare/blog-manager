package cc.lijad.blog.service;

import cc.lijad.blog.domain.entity.Article;
import cc.lijad.blog.domain.web.PageResult;
import cc.lijad.blog.queryvo.DetailArticle;

import java.util.List;

/**
 * @author 李坚达
 * @create 2022/11/14 12:00
 */

public interface ArticleService {

    Integer saveArticle(Article article);


    List<Article> listArticle();


    /**
     * 按照情况分页查询
     *
     * @param pageNo
     * @param pageSize
     * @return
     */
    PageResult pageArticleForShowList(Integer pageNo, Integer pageSize, Article article);


    /**
     * 根据文章的id查询文章详细内容
     *
     * @param articleId
     * @return
     */
    DetailArticle getDetailArticleById(long articleId);


    /**
     * 查询某个分类下的文章
     *
     * @param categoryId
     * @return
     */
    //已通过pageArticleForShowList实现需求
    //@Deprecated
//    PageResult pageMiniArticleByCategoryId(Integer pageNo, Integer pageSize, long categoryId);


    /**
     * 根据某个标签id查询对应文章
     *
     * @param tagId
     * @return
     */
    PageResult pageMiniArticleByTagId(Integer pageNo, Integer pageSize, long tagId);

    /**
     * 所有年份
     *
     * @return
     */
    List<String> listArticleYear();


    /**
     * 根据年份查询文章。（归档）
     *
     * @param pageNo
     * @param pageSize
     * @param time
     * @return
     */
    //已通过pageArticleForShowList实现需求
    //@Deprecated
//    PageResult pageMiniArticleForTime(Integer pageNo, Integer pageSize, String time);


    /**
     * 更新文章评论数量
     */
    void updateArticleCommentCount(long articleId);
}

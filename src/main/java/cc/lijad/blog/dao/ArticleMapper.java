package cc.lijad.blog.dao;

import cc.lijad.blog.domain.entity.Article;
import cc.lijad.blog.queryvo.DetailArticle;
import cc.lijad.blog.queryvo.MiniArticle;
import cc.lijad.blog.queryvo.TagQueryArticle;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author 李坚达
 * @create 2022/11/14 11:48
 */
@Mapper
public interface ArticleMapper {
    /**
     * @param article
     * @return
     */
    Integer saveArticle(Article article);

    /**
     * @param article
     * @return
     */
    Integer removeArticle(Article article);

    /**
     * @param article
     * @return
     */
    Integer updateArticle(Article article);

    /**
     * @return
     */
    List<Article> listArticle();


    /**
     * 按照情况分页查询。tagList需要在service中补充
     *
     * @return
     */
    List<MiniArticle> pageMiniArticle(Article article);


    /**
     * 根据id查询文章，展示详细信息。tagList需要在service中补充
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
    @Deprecated
    List<MiniArticle> pageMiniArticleByCategoryId(long categoryId);


    /**
     * 根据某个标签id查询对应文章
     *
     * @param tagId
     * @return
     */
    List<MiniArticle> pageMiniArticleByTagId(long tagId);


    /**
     * 所有年份
     *
     * @return
     */
    List<String> listArticleYear();

    /**
     * 根据年份查询文章。（归档）
     *
     * @param time
     * @return
     */
    @Deprecated
    List<MiniArticle> pageMiniArticleForTime(String time);


    /**
     * 文章评论数量 +1
     */
    void updateArticleCommentCount(long articleId);

    /**
     * 获取文章总数量
     *
     * @return
     */
    Integer getArticleTotalCount();


//    List<MiniArticle> pageMiniArticleByKeyWord();
}

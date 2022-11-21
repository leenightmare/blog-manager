package cc.lijad.blog.dao;

import cc.lijad.blog.domain.entity.Comment;
import cc.lijad.blog.queryvo.CommentArticleVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author 李坚达
 * @create 2022/11/15 13:50
 */
@Mapper
public interface CommentMapper {

    /**
     * 查询文章的一级评论
     *
     * @param articleId
     * @return
     */
    List<CommentArticleVO> getParentCommentOfArticle(long articleId);

    /**
     * 根据id查询二级评论
     *
     * @param commentId
     * @return
     */
    List<CommentArticleVO> getChildCommentOfArticle(long commentId);

    /**
     * 获取留言。（articleId为null的情况）
     *
     * @return
     */
    List<CommentArticleVO> getPageMessageComment();


    /**
     * 添加评论
     *
     * @param comment
     * @return
     */
    Integer saveComment(Comment comment);


}

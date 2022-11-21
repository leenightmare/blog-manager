package cc.lijad.blog.service;

import cc.lijad.blog.domain.entity.Comment;
import cc.lijad.blog.domain.web.PageResult;

/**
 * @author 李坚达
 * @create 2022/11/15 20:17
 */

public interface CommentService {


    /**
     * 根据文章id查询评论。并且分页
     *
     * @param pageNo
     * @param pageSize
     * @param articleId
     * @return
     */
    PageResult getPageCommentByArticleId(Integer pageNo, Integer pageSize, long articleId);

    /**
     * 获取留言。（articleId为null的情况）
     * @param pageNo
     * @param pageSize
     * @return
     */
    PageResult getPageMessageComment(Integer pageNo, Integer pageSize);


    /**
     * 添加评论
     *
     * @param comment
     * @return
     */
    boolean saveComment(Comment comment);
}

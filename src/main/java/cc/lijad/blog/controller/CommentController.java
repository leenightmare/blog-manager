package cc.lijad.blog.controller;

import cc.lijad.blog.domain.AjaxResult;
import cc.lijad.blog.domain.entity.Comment;
import cc.lijad.blog.domain.web.PageResult;
import cc.lijad.blog.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @author 李坚达
 * @create 2022/11/15 20:31
 */
@RestController
public class CommentController {

    @Autowired
    private CommentService commentService;

    /**
     * 查询文章评论
     *
     * @param pageNo
     * @param pageSize
     * @param articleId
     * @return
     */
    @GetMapping("/comment/byArticleId")
    public AjaxResult getPageComment(Integer pageNo, Integer pageSize, long articleId) {
        PageResult commentForArticle = commentService.getPageCommentByArticleId(pageNo, pageSize, articleId);
        return AjaxResult.success(commentForArticle);
    }

    /**
     * 添加评论
     *
     * @param comment
     * @return
     */
    @PostMapping("/comment/save")
    public AjaxResult saveComment(@RequestBody Comment comment, HttpServletRequest request) {
        String userIp = request.getRemoteAddr();
        comment.setUserIp(userIp);
        boolean flag = commentService.saveComment(comment);
        return AjaxResult.success("添加评论成功");
    }


    @GetMapping("/comment/message")
    public AjaxResult getPageMessageComment(Integer pageNo, Integer pageSize) {
        PageResult pageMessageComment = commentService.getPageMessageComment(pageNo, pageSize);
        return AjaxResult.success(pageMessageComment);
    }
}

package cc.lijad.blog.service.impl;

import cc.lijad.blog.dao.CommentMapper;
import cc.lijad.blog.domain.entity.Comment;
import cc.lijad.blog.domain.web.PageResult;
import cc.lijad.blog.exception.ServiceException;
import cc.lijad.blog.queryvo.CommentArticleVO;
import cc.lijad.blog.service.ArticleService;
import cc.lijad.blog.service.CommentService;
import cc.lijad.blog.util.PageUtils;
import cc.lijad.blog.util.ParamValidateUtils;
import cc.lijad.blog.util.StringUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author 李坚达
 * @create 2022/11/15 20:19
 */
@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentMapper commentMapper;

    @Autowired
    private ArticleService articleService;

    /**
     * 查询文章评论，分页
     *
     * @param pageNo
     * @param pageSize
     * @param articleId
     * @return
     */
    @Override
    public PageResult getPageCommentByArticleId(Integer pageNo, Integer pageSize, long articleId) {
        ParamValidateUtils.checkNumberLegal(pageNo, pageSize);
        ParamValidateUtils.checkNumberLegal(articleId);
        PageHelper.startPage(pageNo, pageSize);
        //先查询一级评论
        List<CommentArticleVO> parentComment = commentMapper.getParentCommentOfArticle(articleId);

        for (CommentArticleVO parentCommentItem : parentComment) {
            Long parentId = parentCommentItem.getId();
            if (parentId == null) {
                throw new ServiceException().setDetailMessage("一级评论ID为空");
            }
            List<CommentArticleVO> childComment = commentMapper.getChildCommentOfArticle(parentId);
            parentCommentItem.setChildComment(childComment);
        }
        PageInfo<CommentArticleVO> commentArticleVOPageInfo = new PageInfo<>(parentComment);
        PageResult pageResult = PageUtils.getPageResult(commentArticleVOPageInfo);

        return pageResult;
    }

    /**
     * 获取留言
     *
     * @param pageNo
     * @param pageSize
     * @return
     */
    @Override
    public PageResult getPageMessageComment(Integer pageNo, Integer pageSize) {
        ParamValidateUtils.checkNumberLegal(pageNo, pageSize);
        PageHelper.startPage(pageNo, pageSize);
        List<CommentArticleVO> messageComment = commentMapper.getPageMessageComment();
        for (CommentArticleVO commentArticleVO : messageComment) {
            Long articleVOId = commentArticleVO.getId();
            if (articleVOId == null) {
                throw new ServiceException().setDetailMessage("一级评论ID为空");
            }
            List<CommentArticleVO> childCommentOfArticle = commentMapper.getChildCommentOfArticle(articleVOId);
            commentArticleVO.setChildComment(childCommentOfArticle);
        }

        PageInfo<CommentArticleVO> commentArticleVOPageInfo = new PageInfo<>(messageComment);
        PageResult pageResult = PageUtils.getPageResult(commentArticleVOPageInfo);

        return pageResult;
    }


    /**
     * 添加评论
     *
     * @param comment
     * @return
     */
    @SuppressWarnings({"all"})
    @Override
    @Transactional
    public boolean saveComment(Comment comment) {
        comment.setCreateTime(LocalDateTime.now());
        comment.setStatus(1);
        comment.setTargetType(1);
        if (comment.getUserNickName() == null || StringUtils.isBlank(comment.getUserNickName())) {
            comment.setUserNickName("Anonymous");
        }
        //一级评论
        if (comment.getParentId() == null) {
            comment.setTargetType(1);
        } else if (comment.getArticleId() != null) {
            comment.setTargetType(2);
        } else {
            comment.setTargetType(3);
        }
        Integer num = commentMapper.saveComment(comment);
        //添加评论之后，文章的评论数加一
        if (comment.getArticleId() != null) {
            articleService.updateArticleCommentCount(comment.getArticleId());
        }
        return num > 0;
    }
}

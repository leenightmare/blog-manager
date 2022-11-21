package cc.lijad.blog.service.impl;

import cc.lijad.blog.dao.ArticleMapper;
import cc.lijad.blog.domain.entity.Article;
import cc.lijad.blog.domain.entity.Tag;
import cc.lijad.blog.domain.web.PageResult;
import cc.lijad.blog.exception.RequestParamException;
import cc.lijad.blog.exception.ServiceException;
import cc.lijad.blog.queryvo.DetailArticle;
import cc.lijad.blog.queryvo.MiniArticle;
import cc.lijad.blog.service.ArticleService;
import cc.lijad.blog.service.TagService;
import cc.lijad.blog.util.PageUtils;
import cc.lijad.blog.util.ParamValidateUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 李坚达
 * @create 2022/11/14 12:02
 */
@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleMapper articleMapper;

    @Autowired
    private TagService tagService;


    @Override
    public Integer saveArticle(Article article) {

        Integer result = articleMapper.saveArticle(article);
        if (result > 0) {
            System.out.println("添加成功");
        } else {
            System.out.println("添加失败");
        }
        return null;
    }

    @Override
    public List<Article> listArticle() {
        List<Article> articles = articleMapper.listArticle();
        for (Article article : articles) {
            System.out.println(article);
        }

        return null;
    }


    /**
     * 根据情况分页查询文章列表。
     *
     * @param pageNo
     * @param pageSize
     * @return
     */
    @Override
    public PageResult pageArticleForShowList(Integer pageNo, Integer pageSize, Article article) {
        if (article == null) throw new ServiceException("查询条件Article对象为空");

        ParamValidateUtils.checkNumberLegal(pageNo, pageSize);
        PageHelper.startPage(pageNo, pageSize);

        //查询出文章列表。没有包含contentMd以及tagList
        List<MiniArticle> miniArticles = articleMapper.pageMiniArticle(article);
        /**
         * 待优化。这里使用循环获取articleId去查询对应的tagList
         */
        for (MiniArticle miniArticle : miniArticles) {
            Long articleId = miniArticle.getId();
            if (articleId == null || articleId < 0) {
                throw new ServiceException("articleId非法").setDetailMessage("分页查询文章列表，articleId为null或负数");
            }
            List<Tag> tags = tagService.listTagByArticleId(articleId);
            miniArticle.setTagList(tags);
        }
        PageInfo<MiniArticle> pageInfo = new PageInfo<>(miniArticles);
        PageResult pageResult = PageUtils.getPageResult(pageInfo);
        return pageResult;
    }

    /**
     * 根据ID获取文章详情
     *
     * @param articleId
     * @return
     */
    @Override
    public DetailArticle getDetailArticleById(long articleId) {
        ParamValidateUtils.checkParamNotNull(articleId);
        DetailArticle detailArticle = articleMapper.getDetailArticleById(articleId);
        //分步查询，获取对应的标签
        List<Tag> tags = tagService.listTagByArticleId(articleId);
        if (detailArticle != null) {
            detailArticle.setTagList(tags);
        }
        return detailArticle;
    }


    /**
     * 根据标签ID获取对应所有文章
     *
     * @param pageNo
     * @param pageSize
     * @param tagId
     * @return
     */
    @Override
    public PageResult pageMiniArticleByTagId(Integer pageNo, Integer pageSize, long tagId) {
        ParamValidateUtils.checkNumberLegal(pageNo, pageSize);
        ParamValidateUtils.checkNumberLegal(tagId);
        PageHelper.startPage(pageNo, pageSize);
        List<MiniArticle> miniArticles = articleMapper.pageMiniArticleByTagId(tagId);

        /**
         * 待优化。这里使用循环获取articleId去查询对应的tagList
         */
        for (MiniArticle miniArticle : miniArticles) {
            Long articleId = miniArticle.getId();
            if (articleId == null || articleId < 0) {
                throw new ServiceException("articleId非法").setDetailMessage("分页查询文章列表，articleId为null或负数");
            }
            List<Tag> tags = tagService.listTagByArticleId(articleId);
            miniArticle.setTagList(tags);
        }


        PageInfo<MiniArticle> miniArticlePageInfo = new PageInfo<>(miniArticles);
        PageResult pageResult = PageUtils.getPageResult(miniArticlePageInfo);
        return pageResult;
    }

    /**
     * 查询所有年份
     *
     * @return
     */
    @Override
    public List<String> listArticleYear() {
        List<String> years = articleMapper.listArticleYear();
        return years;
    }

    /**
     * 更新一条评论数量
     *
     * @param articleId
     */
    @Override
    public void updateArticleCommentCount(long articleId) {
        articleMapper.updateArticleCommentCount(articleId);
    }


    /***
     * 根据分类ID获取对应多有文章
     * @param pageNo
     * @param pageSize
     * @param categoryId
     * @return
     */
    /*
    @Override
    public PageResult pageMiniArticleByCategoryId(Integer pageNo, Integer pageSize, long categoryId) {
        ParamValidateUtils.checkNumberLegal(pageNo, pageSize);

        PageHelper.startPage(pageNo, pageSize);
        List<MiniArticle> miniArticles = articleMapper.pageMiniArticleByCategoryId(categoryId);

        for (MiniArticle miniArticle : miniArticles) {
            Long articleId = miniArticle.getId();
            if (articleId == null || articleId < 0) {
                throw new ServiceException("articleId非法").setDetailMessage("分页查询文章列表，articleId为null或负数");
            }
            List<Tag> tags = tagService.listTagByArticleId(articleId);
            miniArticle.setTagList(tags);
        }

        PageInfo<MiniArticle> miniArticlePageInfo = new PageInfo<>(miniArticles);
        PageResult pageResult = PageUtils.getPageResult(miniArticlePageInfo);
        return pageResult;
    }
*/


    /**
     * 归档。根据一个年份获取对应的文章
     *
     * @param pageNo
     * @param pageSize
     * @param time
     * @return
     */
    /*
    @Override
    public PageResult pageMiniArticleForTime(Integer pageNo, Integer pageSize, String time) {
        if (StringUtils.isNotBlank(time)) {
            ParamValidateUtils.checkNumberLegal(pageNo, pageSize);
            PageHelper.startPage(pageNo, pageSize);


            List<MiniArticle> miniArticles = articleMapper.pageMiniArticleForTime(time);

            for (MiniArticle miniArticle : miniArticles) {
                Long articleId = miniArticle.getId();
                if (articleId == null || articleId < 0) {
                    throw new ServiceException("articleId非法").setDetailMessage("分页查询文章列表，articleId为null或负数");
                }
                List<Tag> tags = tagService.listTagByArticleId(articleId);
                miniArticle.setTagList(tags);
            }
            PageInfo<MiniArticle> miniArticlePageInfo = new PageInfo<>(miniArticles);
            PageResult pageResult = PageUtils.getPageResult(miniArticlePageInfo);
            return pageResult;
        }
        throw new RequestParamException("归档参数异常", time);
    }*/


}

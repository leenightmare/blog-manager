package cc.lijad.blog.controller;

import cc.lijad.blog.domain.AjaxResult;
import cc.lijad.blog.domain.entity.Article;
import cc.lijad.blog.domain.web.PageResult;
import cc.lijad.blog.queryvo.DetailArticle;
import cc.lijad.blog.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

/**
 * @author 李坚达
 * @create 2022/11/14 12:05
 */
@RestController
public class ArticleController {

    @Autowired
    ArticleService articleService;


    /**
     * 不带条件分页查
     *
     * @param pageNo
     * @param pageSize
     * @return
     */
    @GetMapping("/article/page/mini")
    public AjaxResult pageArticle(Integer pageNo, Integer pageSize) {
//        传一个空对象过去
        PageResult result = articleService.pageArticleForShowList(pageNo, pageSize, new Article());
        return AjaxResult.success(result);
    }

    /**
     * 查详情
     *
     * @param articleId
     * @return
     */
    @GetMapping("/article/detail/{articleId}")
    public AjaxResult getDetailArticle(@PathVariable long articleId) {
        DetailArticle article = articleService.getDetailArticleById(articleId);
        return AjaxResult.success(article);
    }

    /**
     * 根据分类ID查询
     *
     * @param pageNo
     * @param pageSize
     * @param categoryId
     * @return
     */
    @GetMapping("/article/category/{categoryId}")
    public AjaxResult pageMiniArticleByCategoryId(Integer pageNo, Integer pageSize, @PathVariable long categoryId) {
        Article article = new Article();
        article.setCategoryId(categoryId);
        PageResult pageResult = articleService.pageArticleForShowList(pageNo, pageSize, article);
        return AjaxResult.success(pageResult);
    }


    /**
     * 根据标签ID查询
     *
     * @param pageNo
     * @param pageSize
     * @param tagId
     * @return
     */
    @GetMapping("/article/tag/{tagId}")
    public AjaxResult pageMiniArticleByTagId(Integer pageNo, Integer pageSize, @PathVariable long tagId) {
        PageResult pageResult = articleService.pageMiniArticleByTagId(pageNo, pageSize, tagId);
        return AjaxResult.success(pageResult);
    }

    /**
     * 查询对应所有年份
     *
     * @return
     */
    @GetMapping("/article/yearlist")
    public AjaxResult listArticleYear() {
        return AjaxResult.success(articleService.listArticleYear());
    }


    /**
     * 归档查询
     *
     * @param pageNo
     * @param pageSize
     * @param year
     * @return
     */
    @GetMapping("/article/timeline/{year}")
    public AjaxResult pageMiniArticleForTime(Integer pageNo, Integer pageSize, @PathVariable Integer year) {
        LocalDateTime dateTime = null;
        try {
            dateTime = LocalDateTime.of(year, 1, 1, 0, 0, 0);
        } catch (Exception e) {
            return AjaxResult.error("时间格式错误");
        }
        Article article = new Article();
        article.setCreateTime(dateTime);
        PageResult pageResult = articleService.pageArticleForShowList(pageNo, pageSize, article);
        return AjaxResult.success(pageResult);
    }


    /**
     * 根据关键词（标题查询）
     *
     * @param pageNo
     * @param pageSize
     * @param title
     * @return
     */
    @GetMapping("/article/keyword/{title}")
    public AjaxResult pageMiniArticleByKeyWord(Integer pageNo, Integer pageSize, @PathVariable String title) {
        Article article = new Article();
        article.setTitle(title);
        PageResult pageResult = articleService.pageArticleForShowList(pageNo, pageSize, article);
        return AjaxResult.success(pageResult);
    }
}

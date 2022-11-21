package cc.lijad.blog.controller;

import cc.lijad.blog.domain.AjaxResult;
import cc.lijad.blog.domain.entity.Tag;
import cc.lijad.blog.queryvo.TagWithCountVO;
import cc.lijad.blog.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author 李坚达
 * @create 2022/11/16 14:14
 */
@RestController
public class TagController {

    @Autowired
    private TagService tagService;

    @GetMapping("/tag/list")
    public AjaxResult listTag() {
        List<Tag> tags = tagService.listTag();
        return AjaxResult.success(tags);
    }

    @GetMapping("/tag/listwithcount")
    public AjaxResult listTagWithCount() {
        List<TagWithCountVO> tagWithCountVOS = tagService.listTagWithCount();
        return AjaxResult.success(tagWithCountVOS);
    }
}

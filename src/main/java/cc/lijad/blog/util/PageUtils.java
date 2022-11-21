package cc.lijad.blog.util;

import cc.lijad.blog.domain.web.PageResult;
import com.github.pagehelper.PageInfo;

/**
 * @author 李坚达
 * @create 2022/11/14 21:25
 */
public class PageUtils {
    /**
     * 将分页信息封装到统一的接口
     *
     * @param pageInfo
     * @return
     */
    public static PageResult getPageResult(PageInfo<?> pageInfo) {
        PageResult pageResult = new PageResult();

        pageResult.setPageNo(pageInfo.getPageNum());
        pageResult.setPageSize(pageInfo.getPageSize());
        pageResult.setTotalSize(pageInfo.getTotal());
        pageResult.setTotalPages(pageInfo.getPages());
        pageResult.setRecords(pageInfo.getList());


        pageResult.setNavigateFirstPage(pageInfo.getNavigateFirstPage());
        pageResult.setNavigateLastPage(pageInfo.getNavigateLastPage());

        pageResult.setNavigatepageNums(pageInfo.getNavigatepageNums());


        pageResult.setNavigatePages(pageInfo.getNavigatePages());
        pageResult.setNextPage(pageInfo.getNextPage());
        pageResult.setPrePage(pageInfo.getPrePage());
        pageResult.setStartRow(pageInfo.getStartRow());
        pageResult.setEndRow(pageInfo.getEndRow());
        pageResult.setSize(pageInfo.getSize());

        pageResult.setIsFirstPage(pageInfo.isIsFirstPage());
        pageResult.setIsLastPage(pageInfo.isIsLastPage());
        pageResult.setIsHasNextPage(pageInfo.isHasNextPage());
        pageResult.setIsHasPreviousPage(pageInfo.isHasPreviousPage());

        return pageResult;
    }


}

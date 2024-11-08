package zjnu.red_study.controller;

import com.github.pagehelper.PageInfo;
import jakarta.annotation.Resource;
import zjnu.red_study.common.Result;
import zjnu.red_study.entity.News;
import zjnu.red_study.service.NewsService;

import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 系统公告前端操作接口
 **/
@RestController
@RequestMapping("/news")
public class NewsController {

    @Resource
    private NewsService newsService;

    /**
     * 新增
     */
    @PostMapping("/add")
    public Result add(@RequestBody News news) {
        newsService.add(news);
        return Result.success();
    }

    /**
     * 删除
     */
    @DeleteMapping("/delete/{id}")
    public Result deleteById(@PathVariable Integer id) {
        newsService.deleteById(id);
        return Result.success();
    }

    /**
     * 修改
     */
    @PutMapping("/update")
    public Result updateById(@RequestBody News news) {
        newsService.updateById(news);
        return Result.success();
    }

    /**
     * 根据ID查询
     */
    @GetMapping("/selectById/{id}")
    public Result selectById(@PathVariable Integer id) {
        News news = newsService.selectById(id);
        return Result.success(news);
    }

    /**
     * 查询所有
     */
    @GetMapping("/selectAll")
    public Result selectAll(News news) {
        List<News> list = newsService.selectAll(news);
        return Result.success(list);
    }

    /**
     * 分页查询
     */
    @GetMapping("/selectPage")
    public Result selectPage(News news, @RequestParam(defaultValue = "1") Integer pageNum,
            @RequestParam(defaultValue = "10") Integer pageSize) {
        PageInfo<News> page = newsService.selectPage(news, pageNum, pageSize);
        return Result.success(page);
    }

}
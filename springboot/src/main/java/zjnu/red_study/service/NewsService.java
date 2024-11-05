package zjnu.red_study.service;

import cn.hutool.core.date.DateUtil;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import jakarta.annotation.Resource;
import zjnu.red_study.entity.News;
import zjnu.red_study.mapper.NewsMapper;

import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 系统公告业务处理
 **/
@Service
public class NewsService {

    @Resource
    private NewsMapper newsMapper;

    /**
     * 新增
     */
    public void add(News news) {
        news.setTime(DateUtil.now());
        newsMapper.insert(news);
    }

    /**
     * 删除
     */
    public void deleteById(Integer id) {
        newsMapper.deleteById(id);
    }

    /**
     * 修改
     */
    public void updateById(News news) {
        newsMapper.updateById(news);
    }

    /**
     * 根据ID查询
     */
    public News selectById(Integer id) {
        return newsMapper.selectById(id);
    }

    /**
     * 查询所有
     */
    public List<News> selectAll(News news) {
        return newsMapper.selectAll(news);
    }

    /**
     * 分页查询
     */
    public PageInfo<News> selectPage(News news, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<News> list = newsMapper.selectAll(news);
        return PageInfo.of(list);
    }

}
package zjnu.red_study.service;

import org.springframework.stereotype.Service;

import jakarta.annotation.Resource;
import zjnu.red_study.entity.Content;
import zjnu.red_study.mapper.ContentMapper;

import java.util.List;

@Service
public class ContentService {

    @Resource
    private ContentMapper contentMapper;

    public List<Content> getContentByArticleId(Integer articleId) {
        return contentMapper.selectByArticleId(articleId);
    }
}

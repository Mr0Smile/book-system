package zjnu.red_study.mapper;

import org.apache.ibatis.annotations.Mapper;

import zjnu.red_study.entity.Content;

import java.util.List;

@Mapper
public interface ContentMapper {
    List<Content> selectByArticleId(Integer articleId);
}

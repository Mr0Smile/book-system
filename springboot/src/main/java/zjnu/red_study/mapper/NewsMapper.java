package zjnu.red_study.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;

import zjnu.red_study.entity.News;

import java.util.List;

/**
 * 操作news相关数据接口
 */
public interface NewsMapper {

  /**
   * 新增
   */
  int insert(News news);

  /**
   * 删除
   */
  @Delete("delete from news where id = #{id}")
  int deleteById(Integer id);

  /**
   * 修改
   */
  int updateById(News news);

  /**
   * 根据ID查询
   */
  @Select("select * from news where id = #{id}")
  News selectById(Integer id);

  /**
   * 查询所有
   */
  List<News> selectAll(News news);

}
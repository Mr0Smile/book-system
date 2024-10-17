package zjnu.red_study.mapper;

import org.apache.ibatis.annotations.Delete;

import zjnu.red_study.entity.Goods;

import java.util.List;

/**
 * 操作goods相关数据接口
 */
public interface GoodsMapper {

  /**
   * 新增
   */
  int insert(Goods goods);

  /**
   * 删除
   */
  @Delete("delete from goods where id = #{id}")
  int deleteById(Integer id);

  /**
   * 修改
   */
  int updateById(Goods goods);

  Goods selectById(Integer id);

  /**
   * 查询所有
   */
  List<Goods> selectAll(Goods goods);

}
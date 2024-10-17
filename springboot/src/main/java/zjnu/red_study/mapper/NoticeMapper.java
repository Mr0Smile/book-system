package zjnu.red_study.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;

import zjnu.red_study.entity.Notice;

import java.util.List;

/**
 * 操作category相关数据接口
*/
public interface NoticeMapper {

    /**
      * 新增
    */
    int insert(Notice notice);

    /**
      * 删除
    */
    @Delete("delete from notice where id = #{id}")
    int deleteById(Integer id);

    /**
      * 修改
    */
    int updateById(Notice notice);

    /**
      * 根据ID查询
    */
    @Select("select * from notice where id = #{id}")
    Notice selectById(Integer id);

    /**
      * 查询所有
    */
    List<Notice> selectAll(Notice notice);


}
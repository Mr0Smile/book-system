package zjnu.red_study.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import jakarta.annotation.Resource;
import zjnu.red_study.entity.StudyBase;
import zjnu.red_study.mapper.StudyBaseMapper;

import org.springframework.stereotype.Service;

import java.util.List;

/**
 * studybaseform业务处理
 **/
@Service
public class StudyBaseService {

    @Resource
    private StudyBaseMapper studybaseformMapper;

    /**
     * 新增
     */
    public void add(StudyBase studybaseform) {
        studybaseformMapper.insert(studybaseform);
    }

    /**
     * 删除
     */
    public void deleteById(Integer id) {
        studybaseformMapper.deleteById(id);
    }

    /**
     * 修改
     */
    public void updateById(StudyBase studybaseform) {
        studybaseformMapper.updateById(studybaseform);
    }

    /**
     * 根据ID查询
     */
    public StudyBase selectById(Integer id) {
        return studybaseformMapper.selectById(id);
    }

    /**
     * 查询所有
     */
    public List<StudyBase> selectAll(StudyBase studybaseform) {
        return studybaseformMapper.selectAll(studybaseform);
    }

    /**
     * 分页查询
     */
    public PageInfo<StudyBase> selectPage(StudyBase studybaseform, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<StudyBase> list = studybaseformMapper.selectAll(studybaseform);
        return PageInfo.of(list);
    }

}
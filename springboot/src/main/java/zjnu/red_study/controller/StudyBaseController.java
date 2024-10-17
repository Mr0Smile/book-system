package zjnu.red_study.controller;

import com.github.pagehelper.PageInfo;
import jakarta.annotation.Resource;
import zjnu.red_study.common.Result;
import zjnu.red_study.entity.StudyBase;
import zjnu.red_study.service.StudyBaseService;

import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 分类前端操作接口
 **/
@RestController
@RequestMapping("/studybaseform")
public class StudyBaseController {

    @Resource
    private StudyBaseService studybaseformService;

    /**
     * 新增
     */
    @PostMapping("/add")
    public Result add(@RequestBody StudyBase studybaseform) {
        System.out.println("--------------------");
        System.out.println(studybaseform);
        System.out.println("--------------------");

        studybaseformService.add(studybaseform);
        return Result.success();
    }

    /**
     * 删除
     */
    @DeleteMapping("/delete/{id}")
    public Result deleteById(@PathVariable Integer id) {
        studybaseformService.deleteById(id);
        return Result.success();
    }

    /**
     * 修改
     */
    @PutMapping("/update")
    public Result updateById(@RequestBody StudyBase studybaseform) {
        studybaseformService.updateById(studybaseform);
        return Result.success();
    }

    /**
     * 根据ID查询
     */
    @GetMapping("/selectById/{id}")
    public Result selectById(@PathVariable Integer id) {
        StudyBase studybaseform = studybaseformService.selectById(id);
        return Result.success(studybaseform);
    }

    /**
     * 查询所有
     */
    @GetMapping("/selectAll")
    public Result selectAll(StudyBase studybaseform) {
        List<StudyBase> list = studybaseformService.selectAll(studybaseform);
        return Result.success(list);
    }

    /**
     * 分页查询
     */
    @GetMapping("/selectPage")
    public Result selectPage(StudyBase studybaseform, @RequestParam(defaultValue = "1") Integer pageNum,
            @RequestParam(defaultValue = "10") Integer pageSize) {
        PageInfo<StudyBase> page = studybaseformService.selectPage(studybaseform, pageNum, pageSize);
        return Result.success(page);
    }

}
package zjnu.red_study.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import jakarta.annotation.Resource;
import zjnu.red_study.entity.Goods;
import zjnu.red_study.entity.GoodsIn;
import zjnu.red_study.mapper.GoodsInMapper;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * goodsIn业务处理
 **/
@Service
public class GoodsInService {

    @Resource
    private GoodsInMapper goodsInMapper;

    @Resource
    private GoodsService goodsService;

    /**
     * 新增
     */
    @Transactional
    public void add(GoodsIn goodsIn) {
        Integer num = goodsIn.getNum();
        Goods goods = goodsService.selectById(goodsIn.getGoods_id());
        goods.setStock(goods.getStock() + num);

        goodsService.updateById(goods);
        goodsInMapper.insert(goodsIn);
    }

    /**
     * 删除
     */
    public void deleteById(Integer id) {
        GoodsIn goodsIn = selectById(id);
        Integer num = goodsIn.getNum();

        Goods goods = goodsService.selectById(goodsIn.getGoods_id());
        goods.setStock(goods.getStock() - num);

        goodsService.updateById(goods);
        goodsInMapper.deleteById(id);
    }

    /**
     * 修改
     */
    public void updateById(GoodsIn goodsIn) {
        // 获取更新前的数据
        GoodsIn originalGoodsIn = goodsInMapper.selectById(goodsIn.getId());
        Integer updateNum = goodsIn.getNum() - originalGoodsIn.getNum();

        Goods goods = goodsService.selectById(goodsIn.getGoods_id());
        goods.setStock(goods.getStock() + updateNum);

        goodsService.updateById(goods);
        goodsInMapper.updateById(goodsIn);

    }

    /**
     * 根据ID查询
     */
    public GoodsIn selectById(Integer id) {
        return goodsInMapper.selectById(id);
    }

    /**
     * 查询所有
     */
    public List<GoodsIn> selectAll(GoodsIn goodsIn) {
        return goodsInMapper.selectAll(goodsIn);
    }

    /**
     * 分页查询
     */
    public PageInfo<GoodsIn> selectPage(GoodsIn goodsIn, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<GoodsIn> list = goodsInMapper.selectAll(goodsIn);
        return PageInfo.of(list);
    }

}
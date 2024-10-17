package zjnu.red_study.service;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.IdUtil;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import jakarta.annotation.Resource;
import zjnu.red_study.entity.Goods;
import zjnu.red_study.entity.Orders;
import zjnu.red_study.mapper.OrdersMapper;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * orders业务处理
 **/
@Service
public class OrdersService {

    @Resource
    private OrdersMapper ordersMapper;
    @Resource
    private GoodsService goodsService;

    /**
     * 新增
     */
    @Transactional
    public void add(Orders orders) {
        orders.setOrder_no(IdUtil.fastSimpleUUID());
        orders.setTime(DateUtil.now());
        orders.setStatus("待支付");

        System.out.println(orders);

        Goods goods = goodsService.selectById(orders.getGoods_id());
        if (goods == null) {
            throw new RuntimeException("商品不存在");
        }
        int stock = goods.getStock() - orders.getNum();
        if (stock < 0) {
            throw new RuntimeException("库存不足");
        }
        goods.setStock(stock);
        goodsService.updateById(goods);

        ordersMapper.insert(orders);
    }

    /**
     * 删除
     */
    public void deleteById(Integer id) {
        ordersMapper.deleteById(id);
    }

    /**
     * 修改
     */
    public void updateById(Orders orders) {
        ordersMapper.updateById(orders);
    }

    /**
     * 根据ID查询
     */
    public Orders selectById(Integer id) {
        return ordersMapper.selectById(id);
    }

    /**
     * 查询所有
     */
    public List<Orders> selectAll(Orders orders) {
        return ordersMapper.selectAll(orders);
    }

    /**
     * 分页查询
     */
    public PageInfo<Orders> selectPage(Orders orders, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Orders> list = ordersMapper.selectAll(orders);
        return PageInfo.of(list);
    }

}
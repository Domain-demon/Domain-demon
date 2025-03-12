package com.hezekiah.text_03.service;

import com.hezekiah.text_03.entity.domain.Order;
import com.hezekiah.text_03.mapper.OrderMapper;
import com.hezekiah.text_03.utils.HttpResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 订单服务类，提供订单相关的业务逻辑处理
 */
@Service
public class OrderService {
    // 注入订单映射器，用于操作数据库中的订单表
    @Autowired
    private OrderMapper orderMapper;

    /**
     * 根据订单ID获取订单信息
     * 此方法通过订单ID查询数据库中的订单信息，并返回查询结果
     * 使用了orderMapper的selectByPrimaryKey方法来实现根据主键查询订单的功能
     *
     * @param orderId 订单ID，用于查询特定订单信息
     * @return 返回一个Map对象，其中包含订单信息查询结果
     * 如果查询成功，返回的结果中会包含成功信息和订单数据
     */
    public Map<String, Object> getOrder(Integer orderId) {
        // 根据订单ID查询订单信息
        Order order = orderMapper.selectByPrimaryKey(orderId);
        // 返回查询结果，包括成功信息和订单数据
        return HttpResult.success("查询成功", order);
    }

    /**
     * 发布订单
     * 将订单信息插入数据库，并返回结果
     *
     * @param order 订单对象，包含订单的详细信息
     * @return 返回一个Map对象，包含HTTP结果，表示订单发布是否成功以及插入的订单信息
     */
    public Map<String, Object> pushOrder(Order order) {
        // 将订单信息插入数据库
        int insert = orderMapper.insert(order);
        // 返回成功结果和插入的订单信息
        return HttpResult.success("发布成功", insert);
    }

    /**
     * 根据订单分类ID查询订单信息
     *
     * @param oclassifyId 订单分类ID，用于筛选具有相同分类的订单
     * @return 返回一个包含查询结果的Map对象，其中包含订单列表
     */
    public Map<String, Object> getByOClassifyId(Integer oclassifyId) {
        // 根据分类ID查询订单信息
        List<Order> orderList = orderMapper.getByOClassifyId(oclassifyId);
        // 返回查询成功的HTTP结果，包含订单列表
        return HttpResult.success("查询成功", orderList);
    }
}

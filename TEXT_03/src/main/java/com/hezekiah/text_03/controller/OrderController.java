package com.hezekiah.text_03.controller;

import com.hezekiah.text_03.entity.domain.Order;
import com.hezekiah.text_03.mapper.OrderMapper;
import com.hezekiah.text_03.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

// 允许跨域请求，以便前端应用可以与后端服务进行交互
@CrossOrigin
// 将该类标记为Spring的组件，使其能够被自动扫描和管理
@RestController
// 定义控制器的根路径，与前端应用进行URL映射
@RequestMapping("/order")
public class OrderController {
    // 注入OrderService接口的实现，用于处理订单相关的业务逻辑
    @Autowired
    private OrderService orderService;
    // 注入OrderMapper接口的实现，用于执行与订单相关的数据库操作
    @Qualifier("orderMapper")
    @Autowired
    private OrderMapper orderMapper;

    /**
     * 根据订单ID获取订单详情
     * <p>
     * 该接口通过GET请求接收一个订单ID参数，并返回该订单的详细信息
     * 主要用于前端在界面上展示特定订单的信息
     *
     * @param orderId 订单ID，用于标识特定的订单
     * @return 包含订单详情的Map对象
     */
    @GetMapping("/detail/{orderId}")
    public Map<String, Object> getOrder(@PathVariable("orderId") Integer orderId) {
        return orderService.getOrder(orderId);
    }

    /**
     * 推送新订单
     * <p>
     * 该接口通过POST请求接收一个Order对象，并将其保存到数据库中
     * 主要用于创建新订单
     *
     * @param order 要推送的订单对象，包含订单的详细信息
     * @return 包含推送结果的Map对象
     */
    @PostMapping("/push")
    public Map<String, Object> pushOrder(@RequestBody Order order) {
        return orderService.pushOrder(order);
    }

    /**
     * 根据订单分类ID获取订单
     * <p>
     * 该接口通过GET请求接收一个订单分类ID参数，并返回该分类下的所有订单
     * 主要用于按分类查询订单
     *
     * @param oclassifyId 订单分类ID，用于标识特定的订单分类
     * @return 包含订单信息的Map对象
     */
    @GetMapping("/getByOClassifyId/{oclassifyId}")
    public Map<String, Object> getByOClassifyId(@PathVariable("oclassifyId") Integer oclassifyId) {
        return orderService.getByOClassifyId(oclassifyId);
    }
}

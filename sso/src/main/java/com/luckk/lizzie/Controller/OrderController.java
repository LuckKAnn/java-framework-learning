package com.luckk.lizzie.Controller;

import com.luckk.lizzie.domain.OrderDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

/**
 * @Author liukun.inspire
 * @Date 2023/6/1 16:16
 * @PackageName: com.luckk.lizzie.Controller
 * @ClassName: OrderController
 * @Version 1.0
 */
@RestController
@RequestMapping("/order")
public class OrderController {

    @GetMapping("/order")
    public List<OrderDTO> queryOrderDTO() {
        return Arrays.asList(new OrderDTO(100L, "order1,", 1), new OrderDTO(101L, "order2", 2));
    }
}

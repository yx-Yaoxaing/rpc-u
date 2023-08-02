package com.cqnews.rpc.order;
import com.cqnews.rpc.order.resp.OrderInfo;
import com.cqnews.rpc.util.R;
/**
 * @description:
 * @author: uYxUuu actionYx1998@163.com
 * @createTime:2023/7/17 19:04
 */

public interface OrderService {

    R<?> addOrder(String userId,String proId);


}

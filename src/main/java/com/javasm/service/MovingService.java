package com.javasm.service;

import com.javasm.pojo.MovingBooking;
import com.javasm.pojo.Pager;

import java.util.List;

/**
 * @Author：xiaoYuncong
 * @Version：1.0
 * @Date：2022/9/20-19:40
 * @Since：jdk1.8
 * @Description：
 */
public interface MovingService {

    /**
     * 添加用户预订记录,成功返回正数,失败返回0
     * @param mv
     * @return
     */
    int saveInfoOfClient(MovingBooking mv);


    /**
     * 查询所有预约记录
     * @return
     */
    List<MovingBooking> selectAllMoveBooking();


    /**
     * 修改预约
     * @param id
     * @return
     */
    int updateStatus(int id);


    /**
     * 分页查询
     * @param page 当前页码数
     * @param size 每页显示条数
     * @return
     */
    Pager<MovingBooking> findByPager(int page,int size);
}

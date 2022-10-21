package com.javasm.mapper;

import com.javasm.pojo.MovingBooking;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @Author：xiaoYuncong
 * @Version：1.0
 * @Date：2022/9/20-19:23
 * @Since：jdk1.8
 * @Description：
 */
public interface MovingMapper {

    /**
     * 存储用户预订信息
     * @param mv
     * @return
     */
    int save(@Param("mv") MovingBooking mv);


    /**
     * 查询所有用户预订记录
     * @return
     */
    List<MovingBooking> selectAll();


    /**
     * 根据id修改状态
     * @param id
     * @return
     */
    int updateStatusById(int id);


    /**
     *
     * @param params
     * @return
     */
   List<MovingBooking> findByPager(Map<String, Object> params);


    /**
     * 查询记录总条数
     * @return
     */
     long count();

}

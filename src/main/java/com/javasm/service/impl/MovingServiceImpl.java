package com.javasm.service.impl;

import com.javasm.commons.utils.SqlSessionFactoryUtils;
import com.javasm.mapper.MovingMapper;
import com.javasm.pojo.MovingBooking;
import com.javasm.pojo.Pager;
import com.javasm.service.MovingService;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.HashMap;
import java.util.List;

/**
 * @Author：xiaoYuncong
 * @Version：1.0
 * @Date：2022/9/20-19:41
 * @Since：jdk1.8
 * @Description：
 */
public class MovingServiceImpl implements MovingService {
    private static SqlSessionFactory sqlSessionFactory=SqlSessionFactoryUtils.getSqlSessionFactory();


    @Override
    public int saveInfoOfClient(MovingBooking mv) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        MovingMapper mapper = sqlSession.getMapper(MovingMapper.class);
        int save = mapper.save(mv);
        if(save>0){
            sqlSession.commit();
            sqlSession.close();
        }
        return save;
    }

    @Override
    public List<MovingBooking> selectAllMoveBooking() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        MovingMapper mapper = sqlSession.getMapper(MovingMapper.class);
        List<MovingBooking> movingBookings = mapper.selectAll();
        sqlSession.close();
        return movingBookings;
    }

    @Override
    public int updateStatus(int id) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        MovingMapper mapper = sqlSession.getMapper(MovingMapper.class);
        int i = mapper.updateStatusById(id);
        if(i>0){
            sqlSession.commit();
            sqlSession.close();
        }
        return i;
    }

    @Override
    public Pager<MovingBooking> findByPager(int page, int size) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("page",(page-1)*size);
        map.put("size",size);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        MovingMapper mapper = sqlSession.getMapper(MovingMapper.class);
        List<MovingBooking> byPager = mapper.findByPager(map);
        Pager<MovingBooking> pager = new Pager<>();
        long total = mapper.count();
        pager.setTotal(total);
        pager.setSize(size);
        pager.setPage(page);
        pager.setRows(byPager);
        pager.setPageSize(total,size);
        return pager;
    }
}

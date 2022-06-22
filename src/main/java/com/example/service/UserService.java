package com.example.service;

import com.example.dao.UserRepository;
import com.example.entity.User;
import org.springframework.data.domain.Page;//springdataJPA框架提供的page对象
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
//CRUD业务逻辑
@Service
public class UserService {

    @Resource
    private UserRepository userRepository;

    //本来是应该写add和update两个函数的，但是因为都是传入一个新对象，并且使用接口保存，合并为一个save函数
    public void save(User user) {
        String now = new SimpleDateFormat("yyyy-MM-dd").format(new Date());//时间
        user.setCreateTime(now);
        userRepository.save(user);
    }

    //删除，直接用接口对象userR的deleteById
    public void delete(Long id) {
        userRepository.deleteById(id);
    }

    public User findById(Long id) {
        return userRepository.findById(id).orElse(null);
    }//如果没查询出来就返回NULL

    public List<User> findAll() {
        return userRepository.findAll();
    }

    //分页查询，springbootJPA提供的分页查询
    public Page<User> findPage(Integer pageNum, Integer pageSize, String name) {
        // 构建分页查询条件，参数为：当前页，每页多少个，模糊查询name
        //排序，倒序排序，根据create time
        Sort sort = new Sort(Sort.Direction.DESC, "create_time");
        //分页参数，实现分页
        Pageable pageRequest = PageRequest.of(pageNum - 1, pageSize, sort);//-1是因为这里是从0开始
        return userRepository.findByNameLike(name, pageRequest);//在接口里自定义的查询
    }
}

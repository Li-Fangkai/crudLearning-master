package com.example.controller;

import com.example.common.Result;
import com.example.entity.User;
import com.example.service.UserService;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

//处理对应的请求，controller调用了service层

@RestController//表示返回数据
@RequestMapping("/user")
public class UserController {

    @Resource//引入userService
    private UserService userService;

    // 新增用户
    @PostMapping//处理post请求
    public Result add(@RequestBody User user) {//requestbody用来接收前端传来的json数据，一般前端传来的都用post，对象转为user
        userService.save(user);
        return Result.success();//返回成功的数据提示
    }

    // 修改用户
    @PutMapping//处理put请求
    public Result update(@RequestBody User user) {
        userService.save(user);
        return Result.success();
    }

    // 删除用户注解，传递id
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        userService.delete(id);
    }

    // 根据id查询用户
    @GetMapping("/{id}")
    public Result<User> findById(@PathVariable Long id) {
        return Result.success(userService.findById(id));
    }

    // 查询所有用户
    @GetMapping
    public Result<List<User>> findAll() {
        return Result.success(userService.findAll());
    }

    // 分页查询用户
    @GetMapping("/page")
    public Result<Page<User>> findPage(@RequestParam(defaultValue = "1") Integer pageNum,
                                       @RequestParam(defaultValue = "10") Integer pageSize,
                                       @RequestParam(required = false) String name) {
        return Result.success(userService.findPage(pageNum, pageSize, name));
    }

}

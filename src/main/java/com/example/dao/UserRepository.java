package com.example.dao;

import com.example.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
//这是一个数据库操作接口，继承JpaRepository<实体名，主键>
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    //query注解：里面写SQL，模糊查询，定义为原生SQL
    @Query(value = "select * from user where name like %?1%", nativeQuery = true)
    Page<User> findByNameLike(String name, Pageable pageRequest);
}

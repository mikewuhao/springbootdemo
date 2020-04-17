package com.jd.dao;

import com.jd.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * @Description: user的mapper
 * @CreateDate: 2020-02-04 19:38
 * @Author: wuhao
 */
@Mapper
@Repository
public interface UserMapper {

    User queryUserById(Long id);

    int addUser(User user);

    int modifyUser(User user);

    int deleteUserById(Long id);


}

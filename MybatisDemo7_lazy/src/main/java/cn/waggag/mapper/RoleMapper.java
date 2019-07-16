package cn.waggag.mapper;

import cn.waggag.domain.Role;

import java.util.List;

/**
 * @description:
 * @author: waggag
 * @time: 2019/7/16 10:36
 * @Company http://www.waggag.cn
 */
public interface RoleMapper {

    /**
     * 查询所有角色
     * @return
     */
    List<Role> findALL();

}

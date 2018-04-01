package pers.husen.demo.shiro.dao;

import java.util.List;
import pers.husen.demo.shiro.po.SysRole;

public interface SysRoleMapper {
    int deleteByPrimaryKey(Long id);

    int insert(SysRole record);

    SysRole selectByPrimaryKey(Long id);

    List<SysRole> selectAll();

    int updateByPrimaryKey(SysRole record);
}
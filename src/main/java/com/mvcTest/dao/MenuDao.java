package com.mvcTest.dao;

import com.mvcTest.entity.MenuObject;

import java.util.List;

public interface MenuDao {

    List<MenuObject> menuList();

    void remove(MenuObject menu);

    void saveOrUpdate(MenuObject menu);

}

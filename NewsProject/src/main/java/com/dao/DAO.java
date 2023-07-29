package com.dao;

import com.model.News;

import java.util.ArrayList;

/**
 * @author Will
 * @project NewsProject
 * @date 7/29/2023
 */
public interface DAO<T> {

        public void insert(T t);

        public void update(T t);

        public void delete(T t);

        public ArrayList<T> selectAll();

        public News selectByCondition(String condition);

        public ArrayList<T> selectByTime();

}

package com.dao;

import com.hibernate.HibernateUltils;
import com.model.News;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;

/**
 * @author Will
 * @project NewsProject
 * @date 7/29/2023
 */
public class NewsDAO implements DAO<News>{
    public static NewsDAO getInstance() {
        return new NewsDAO();
    }
    @Override
    public void insert(News news) {
        Session session = HibernateUltils.getSessionFactory().openSession();
        try {
            org.hibernate.Transaction ts = session.beginTransaction();
            session.save(news);
            ts.commit();
            System.out.println("Done !!");
            session.close();
        } catch (HibernateException e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            //   session.flush();
            session.close();
        }
    }

    public static void main(String[] args) {
        Date date = new Date();
        Timestamp timestamp2 = new Timestamp(date.getTime());
        System.out.println(timestamp2);
        int max = 100000;
        int min = 1000;
        int random = (int)(Math.random()*(max-min+1)+min);
        News news1 = new News("Chủ tịch nước thăm Tòa thánh Vatican, gặp Giáo hoàng Francis","Chủ tịch nước thăm Tòa thánh Vatican, gặp Giáo hoàng Francis","Trung Kiên",timestamp2,random);
        News news2 = new News("Giá gạo trong nước và xuất khẩu tăng vọt","Giá gạo xuất khẩu 5% tấm của Việt Nam tăng 35% so với cùng kỳ năm ngoái lên 558 USD một tấn, cùng lúc gạo bán lẻ trong nước cũng leo thang.","Trung Cường",timestamp2,random);
        News news3 = new News("Giá vàng thế giới lao dốc vì GDP Mỹ","Tăng trưởng kinh tế của Mỹ quý II mạnh hơn dự báo, khiến giá vàng thế giới giảm gần 30 USD một ounce tối 27/7.","Công Huy",timestamp2,random);
        NewsDAO.getInstance().insert(news1);
        NewsDAO.getInstance().insert(news2);
        NewsDAO.getInstance().insert(news3);
    }
    @Override
    public void update(News news) {

    }

    @Override
    public void delete(News news) {

    }

    @Override
    public ArrayList<News> selectAll() {
        Session session = HibernateUltils.getSessionFactory().openSession();
        return (ArrayList<News>) session.createQuery(" FROM News c").list();
    }

    @Override
    public News selectByCondition(String condition) {
        return null;
    }

    @Override
    public ArrayList<News> selectByTime() {
        return null;
    }
}

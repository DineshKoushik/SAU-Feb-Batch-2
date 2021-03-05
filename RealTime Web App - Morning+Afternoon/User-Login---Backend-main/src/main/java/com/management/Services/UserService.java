package com.management.Services;

import com.management.Model.User;
import com.management.Model.UserModel;
import com.management.Utils.SessionUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private static Session session = SessionUtil.getSession();
    private static Configuration configuration = new Configuration();
    private static SessionFactory factory;
    private static Transaction tx;

    public User createUser(UserModel user){
        configuration.configure("hibernate.cfg.xml");
        factory = configuration.buildSessionFactory();
        tx = session.beginTransaction();

        User tempUser = new User();
        tempUser.setId(user.getId());
        tempUser.setUsername(user.getUsername());
        tempUser.setPassword(user.getPassword());
        tempUser.setAge(user.getAge());
        tempUser.setDob(user.getDob());
        tempUser.setfName(user.getfName());
        tempUser.setlName(user.getlName());
        tempUser.setEmail(user.getEmail());

        session.save(tempUser);
        tx.commit();
        return tempUser;
    }

    public User checkUser(UserModel user){
        Query query = session.createQuery("from User where username = :username and password = :password");
        query.setParameter("username", user.getUsername());
        query.setParameter("password", user.getPassword());
        System.out.println(query.uniqueResult());
        return (User)query.uniqueResult();
    }

    public User getUserDetails(int userId){
        Query query = session.createQuery("from User where id = :id");
        query.setParameter("id", userId);
        System.out.println(query.uniqueResult());
        return (User)query.uniqueResult();
    }

}

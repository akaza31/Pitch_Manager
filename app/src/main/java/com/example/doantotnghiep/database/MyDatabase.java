package com.example.doantotnghiep.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.doantotnghiep.dao.CustomerDAO;
import com.example.doantotnghiep.dao.HistoryBuyDAO;
import com.example.doantotnghiep.dao.ManagerCategoryDAO;
import com.example.doantotnghiep.dao.ManagerDAO;
import com.example.doantotnghiep.dao.NotificationDAO;
import com.example.doantotnghiep.dao.NotificationDetailsDAO;
import com.example.doantotnghiep.dao.OrderDAO;
import com.example.doantotnghiep.dao.OrderDetailsDAO;
import com.example.doantotnghiep.dao.PitchCategoryDAO;
import com.example.doantotnghiep.dao.PitchDAO;
import com.example.doantotnghiep.dao.ServiceDAO;
import com.example.doantotnghiep.dao.TimeDAO;
import com.example.doantotnghiep.dao.TimeOrderDetailsDAO;
import com.example.doantotnghiep.model.Customer;
import com.example.doantotnghiep.model.HistoryBuy;
import com.example.doantotnghiep.model.Manager;
import com.example.doantotnghiep.model.ManagerCategory;
import com.example.doantotnghiep.model.MyNotification;
import com.example.doantotnghiep.model.MyTime;
import com.example.doantotnghiep.model.NotificationDetails;
import com.example.doantotnghiep.model.Order;
import com.example.doantotnghiep.model.OrderDetails;
import com.example.doantotnghiep.model.Pitch;
import com.example.doantotnghiep.model.PithCategory;
import com.example.doantotnghiep.model.ServiceBall;
import com.example.doantotnghiep.model.TimeOrderDetails;

@Database(entities = {Customer.class,Manager.class, Order.class
        , OrderDetails.class, Pitch.class, PithCategory.class
        , ServiceBall.class, ManagerCategory.class, MyNotification.class
        , MyTime.class, TimeOrderDetails.class, HistoryBuy.class
        , NotificationDetails.class}, version = 1)
public abstract class MyDatabase extends RoomDatabase {

    private static String DB_NAME = "PITCH_MANAGER22";
    private static MyDatabase instance;

    public static synchronized MyDatabase getInstance(Context context){
        if(instance == null){
            instance = Room.databaseBuilder(context.getApplicationContext(),MyDatabase.class,DB_NAME)
                    .allowMainThreadQueries()
                    .build();
        }
        return instance;
    }

    public abstract CustomerDAO customerDAO();
    public abstract ManagerDAO managerDAO();
    public abstract OrderDAO orderDAO();
    public abstract OrderDetailsDAO orderDetailsDAO();
    public abstract PitchCategoryDAO pitchCategoryDAO();
    public abstract PitchDAO pitchDao();
    public abstract ServiceDAO serviceDAO();
    public abstract ManagerCategoryDAO managerCategoryDAO();
    public abstract TimeOrderDetailsDAO timeOrderDetailsDAO();
    public abstract TimeDAO timeDAO();
    public abstract HistoryBuyDAO historyBuyDAO();
    public abstract NotificationDetailsDAO notificationDetailsDAO();
    public abstract NotificationDAO notificationDAO();
}

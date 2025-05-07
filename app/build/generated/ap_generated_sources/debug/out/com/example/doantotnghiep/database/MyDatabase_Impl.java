package com.example.doantotnghiep.database;

import androidx.annotation.NonNull;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomOpenHelper;
import androidx.room.RoomOpenHelper.Delegate;
import androidx.room.RoomOpenHelper.ValidationResult;
import androidx.room.migration.AutoMigrationSpec;
import androidx.room.migration.Migration;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.room.util.TableInfo.Column;
import androidx.room.util.TableInfo.ForeignKey;
import androidx.room.util.TableInfo.Index;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import androidx.sqlite.db.SupportSQLiteOpenHelper.Callback;
import androidx.sqlite.db.SupportSQLiteOpenHelper.Configuration;
import com.example.doantotnghiep.dao.CustomerDAO;
import com.example.doantotnghiep.dao.CustomerDAO_Impl;
import com.example.doantotnghiep.dao.HistoryBuyDAO;
import com.example.doantotnghiep.dao.HistoryBuyDAO_Impl;
import com.example.doantotnghiep.dao.ManagerCategoryDAO;
import com.example.doantotnghiep.dao.ManagerCategoryDAO_Impl;
import com.example.doantotnghiep.dao.ManagerDAO;
import com.example.doantotnghiep.dao.ManagerDAO_Impl;
import com.example.doantotnghiep.dao.NotificationDAO;
import com.example.doantotnghiep.dao.NotificationDAO_Impl;
import com.example.doantotnghiep.dao.NotificationDetailsDAO;
import com.example.doantotnghiep.dao.NotificationDetailsDAO_Impl;
import com.example.doantotnghiep.dao.OrderDAO;
import com.example.doantotnghiep.dao.OrderDAO_Impl;
import com.example.doantotnghiep.dao.OrderDetailsDAO;
import com.example.doantotnghiep.dao.OrderDetailsDAO_Impl;
import com.example.doantotnghiep.dao.PitchCategoryDAO;
import com.example.doantotnghiep.dao.PitchCategoryDAO_Impl;
import com.example.doantotnghiep.dao.PitchDAO;
import com.example.doantotnghiep.dao.PitchDAO_Impl;
import com.example.doantotnghiep.dao.ServiceDAO;
import com.example.doantotnghiep.dao.ServiceDAO_Impl;
import com.example.doantotnghiep.dao.TimeDAO;
import com.example.doantotnghiep.dao.TimeDAO_Impl;
import com.example.doantotnghiep.dao.TimeOrderDetailsDAO;
import com.example.doantotnghiep.dao.TimeOrderDetailsDAO_Impl;
import java.lang.Class;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

@SuppressWarnings({"unchecked", "deprecation"})
public final class MyDatabase_Impl extends MyDatabase {
  private volatile CustomerDAO _customerDAO;

  private volatile ManagerDAO _managerDAO;

  private volatile OrderDAO _orderDAO;

  private volatile OrderDetailsDAO _orderDetailsDAO;

  private volatile PitchCategoryDAO _pitchCategoryDAO;

  private volatile PitchDAO _pitchDAO;

  private volatile ServiceDAO _serviceDAO;

  private volatile ManagerCategoryDAO _managerCategoryDAO;

  private volatile TimeOrderDetailsDAO _timeOrderDetailsDAO;

  private volatile TimeDAO _timeDAO;

  private volatile HistoryBuyDAO _historyBuyDAO;

  private volatile NotificationDetailsDAO _notificationDetailsDAO;

  private volatile NotificationDAO _notificationDAO;

  @Override
  protected SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration configuration) {
    final SupportSQLiteOpenHelper.Callback _openCallback = new RoomOpenHelper(configuration, new RoomOpenHelper.Delegate(1) {
      @Override
      public void createAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("CREATE TABLE IF NOT EXISTS `CUSTOMER` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `phone` TEXT, `name` TEXT, `address` TEXT, `coin` INTEGER NOT NULL, `password` TEXT, `cmnd` TEXT, `img` BLOB)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `MANAGER` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `phone` TEXT, `name` TEXT, `category_id` INTEGER NOT NULL, `password` TEXT, `salary` INTEGER NOT NULL, `bankNumber` TEXT, `bankName` TEXT, `status` INTEGER NOT NULL, FOREIGN KEY(`category_id`) REFERENCES `MANAGER_CATEGORY`(`id`) ON UPDATE NO ACTION ON DELETE CASCADE )");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `ORDERS` (`id` INTEGER NOT NULL, `managerId` INTEGER NOT NULL, `customerId` INTEGER NOT NULL, `pitchId` INTEGER NOT NULL, `dateCreate` TEXT, `datePlay` TEXT, `totalPitchMoney` INTEGER NOT NULL, `totalServiceMoney` INTEGER NOT NULL, `chiPhiKhac` INTEGER NOT NULL, `total` INTEGER NOT NULL, `status` INTEGER NOT NULL, `soCa` INTEGER NOT NULL, `soLanCapNhat` INTEGER NOT NULL, PRIMARY KEY(`id`), FOREIGN KEY(`customerId`) REFERENCES `CUSTOMER`(`id`) ON UPDATE NO ACTION ON DELETE CASCADE , FOREIGN KEY(`pitchId`) REFERENCES `PITCH`(`id`) ON UPDATE NO ACTION ON DELETE CASCADE , FOREIGN KEY(`managerId`) REFERENCES `MANAGER`(`id`) ON UPDATE NO ACTION ON DELETE CASCADE )");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `ORDER_DETAILS` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `orderId` INTEGER NOT NULL, `serviceId` INTEGER NOT NULL, `soLuong` INTEGER NOT NULL, `tongTien` INTEGER NOT NULL, FOREIGN KEY(`orderId`) REFERENCES `ORDERS`(`id`) ON UPDATE NO ACTION ON DELETE CASCADE , FOREIGN KEY(`serviceId`) REFERENCES `SERVICE`(`id`) ON UPDATE NO ACTION ON DELETE CASCADE )");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `PITCH` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `name` TEXT, `categoryId` INTEGER NOT NULL, `status` INTEGER NOT NULL, FOREIGN KEY(`categoryId`) REFERENCES `PITCH_CATEGORY`(`id`) ON UPDATE NO ACTION ON DELETE CASCADE )");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `PITCH_CATEGORY` (`id` INTEGER NOT NULL, `name` TEXT, `money` INTEGER NOT NULL, PRIMARY KEY(`id`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `SERVICE` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `name` TEXT, `money` INTEGER NOT NULL, `isProduct` INTEGER NOT NULL)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `MANAGER_CATEGORY` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `name` TEXT)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `MY_NOTIFICATION` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `title` TEXT, `content` TEXT, `date` TEXT, `status` INTEGER NOT NULL)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `MyTime` (`id` INTEGER NOT NULL, `name` TEXT, `startTime` INTEGER NOT NULL, `endTime` INTEGER NOT NULL, `money` INTEGER NOT NULL, PRIMARY KEY(`id`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `TimeOrderDetails` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `orderId` INTEGER NOT NULL, `timeId` INTEGER NOT NULL, FOREIGN KEY(`orderId`) REFERENCES `ORDERS`(`id`) ON UPDATE NO ACTION ON DELETE CASCADE , FOREIGN KEY(`timeId`) REFERENCES `MyTime`(`id`) ON UPDATE NO ACTION ON DELETE CASCADE )");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `HistoryBuy` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `idCustomer` INTEGER NOT NULL, `money` INTEGER NOT NULL, `status` INTEGER NOT NULL, `date` TEXT)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `NotificationDetails` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `customerId` INTEGER NOT NULL, `notificationId` INTEGER NOT NULL, FOREIGN KEY(`notificationId`) REFERENCES `MY_NOTIFICATION`(`id`) ON UPDATE NO ACTION ON DELETE NO ACTION , FOREIGN KEY(`customerId`) REFERENCES `CUSTOMER`(`id`) ON UPDATE NO ACTION ON DELETE NO ACTION )");
        _db.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        _db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '662886a157abe2469026df7b68192d71')");
      }

      @Override
      public void dropAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("DROP TABLE IF EXISTS `CUSTOMER`");
        _db.execSQL("DROP TABLE IF EXISTS `MANAGER`");
        _db.execSQL("DROP TABLE IF EXISTS `ORDERS`");
        _db.execSQL("DROP TABLE IF EXISTS `ORDER_DETAILS`");
        _db.execSQL("DROP TABLE IF EXISTS `PITCH`");
        _db.execSQL("DROP TABLE IF EXISTS `PITCH_CATEGORY`");
        _db.execSQL("DROP TABLE IF EXISTS `SERVICE`");
        _db.execSQL("DROP TABLE IF EXISTS `MANAGER_CATEGORY`");
        _db.execSQL("DROP TABLE IF EXISTS `MY_NOTIFICATION`");
        _db.execSQL("DROP TABLE IF EXISTS `MyTime`");
        _db.execSQL("DROP TABLE IF EXISTS `TimeOrderDetails`");
        _db.execSQL("DROP TABLE IF EXISTS `HistoryBuy`");
        _db.execSQL("DROP TABLE IF EXISTS `NotificationDetails`");
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onDestructiveMigration(_db);
          }
        }
      }

      @Override
      protected void onCreate(SupportSQLiteDatabase _db) {
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onCreate(_db);
          }
        }
      }

      @Override
      public void onOpen(SupportSQLiteDatabase _db) {
        mDatabase = _db;
        _db.execSQL("PRAGMA foreign_keys = ON");
        internalInitInvalidationTracker(_db);
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onOpen(_db);
          }
        }
      }

      @Override
      public void onPreMigrate(SupportSQLiteDatabase _db) {
        DBUtil.dropFtsSyncTriggers(_db);
      }

      @Override
      public void onPostMigrate(SupportSQLiteDatabase _db) {
      }

      @Override
      protected RoomOpenHelper.ValidationResult onValidateSchema(SupportSQLiteDatabase _db) {
        final HashMap<String, TableInfo.Column> _columnsCUSTOMER = new HashMap<String, TableInfo.Column>(8);
        _columnsCUSTOMER.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCUSTOMER.put("phone", new TableInfo.Column("phone", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCUSTOMER.put("name", new TableInfo.Column("name", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCUSTOMER.put("address", new TableInfo.Column("address", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCUSTOMER.put("coin", new TableInfo.Column("coin", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCUSTOMER.put("password", new TableInfo.Column("password", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCUSTOMER.put("cmnd", new TableInfo.Column("cmnd", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCUSTOMER.put("img", new TableInfo.Column("img", "BLOB", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysCUSTOMER = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesCUSTOMER = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoCUSTOMER = new TableInfo("CUSTOMER", _columnsCUSTOMER, _foreignKeysCUSTOMER, _indicesCUSTOMER);
        final TableInfo _existingCUSTOMER = TableInfo.read(_db, "CUSTOMER");
        if (! _infoCUSTOMER.equals(_existingCUSTOMER)) {
          return new RoomOpenHelper.ValidationResult(false, "CUSTOMER(com.example.doantotnghiep.model.Customer).\n"
                  + " Expected:\n" + _infoCUSTOMER + "\n"
                  + " Found:\n" + _existingCUSTOMER);
        }
        final HashMap<String, TableInfo.Column> _columnsMANAGER = new HashMap<String, TableInfo.Column>(9);
        _columnsMANAGER.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMANAGER.put("phone", new TableInfo.Column("phone", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMANAGER.put("name", new TableInfo.Column("name", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMANAGER.put("category_id", new TableInfo.Column("category_id", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMANAGER.put("password", new TableInfo.Column("password", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMANAGER.put("salary", new TableInfo.Column("salary", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMANAGER.put("bankNumber", new TableInfo.Column("bankNumber", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMANAGER.put("bankName", new TableInfo.Column("bankName", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMANAGER.put("status", new TableInfo.Column("status", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysMANAGER = new HashSet<TableInfo.ForeignKey>(1);
        _foreignKeysMANAGER.add(new TableInfo.ForeignKey("MANAGER_CATEGORY", "CASCADE", "NO ACTION",Arrays.asList("category_id"), Arrays.asList("id")));
        final HashSet<TableInfo.Index> _indicesMANAGER = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoMANAGER = new TableInfo("MANAGER", _columnsMANAGER, _foreignKeysMANAGER, _indicesMANAGER);
        final TableInfo _existingMANAGER = TableInfo.read(_db, "MANAGER");
        if (! _infoMANAGER.equals(_existingMANAGER)) {
          return new RoomOpenHelper.ValidationResult(false, "MANAGER(com.example.doantotnghiep.model.Manager).\n"
                  + " Expected:\n" + _infoMANAGER + "\n"
                  + " Found:\n" + _existingMANAGER);
        }
        final HashMap<String, TableInfo.Column> _columnsORDERS = new HashMap<String, TableInfo.Column>(13);
        _columnsORDERS.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsORDERS.put("managerId", new TableInfo.Column("managerId", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsORDERS.put("customerId", new TableInfo.Column("customerId", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsORDERS.put("pitchId", new TableInfo.Column("pitchId", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsORDERS.put("dateCreate", new TableInfo.Column("dateCreate", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsORDERS.put("datePlay", new TableInfo.Column("datePlay", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsORDERS.put("totalPitchMoney", new TableInfo.Column("totalPitchMoney", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsORDERS.put("totalServiceMoney", new TableInfo.Column("totalServiceMoney", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsORDERS.put("chiPhiKhac", new TableInfo.Column("chiPhiKhac", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsORDERS.put("total", new TableInfo.Column("total", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsORDERS.put("status", new TableInfo.Column("status", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsORDERS.put("soCa", new TableInfo.Column("soCa", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsORDERS.put("soLanCapNhat", new TableInfo.Column("soLanCapNhat", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysORDERS = new HashSet<TableInfo.ForeignKey>(3);
        _foreignKeysORDERS.add(new TableInfo.ForeignKey("CUSTOMER", "CASCADE", "NO ACTION",Arrays.asList("customerId"), Arrays.asList("id")));
        _foreignKeysORDERS.add(new TableInfo.ForeignKey("PITCH", "CASCADE", "NO ACTION",Arrays.asList("pitchId"), Arrays.asList("id")));
        _foreignKeysORDERS.add(new TableInfo.ForeignKey("MANAGER", "CASCADE", "NO ACTION",Arrays.asList("managerId"), Arrays.asList("id")));
        final HashSet<TableInfo.Index> _indicesORDERS = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoORDERS = new TableInfo("ORDERS", _columnsORDERS, _foreignKeysORDERS, _indicesORDERS);
        final TableInfo _existingORDERS = TableInfo.read(_db, "ORDERS");
        if (! _infoORDERS.equals(_existingORDERS)) {
          return new RoomOpenHelper.ValidationResult(false, "ORDERS(com.example.doantotnghiep.model.Order).\n"
                  + " Expected:\n" + _infoORDERS + "\n"
                  + " Found:\n" + _existingORDERS);
        }
        final HashMap<String, TableInfo.Column> _columnsORDERDETAILS = new HashMap<String, TableInfo.Column>(5);
        _columnsORDERDETAILS.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsORDERDETAILS.put("orderId", new TableInfo.Column("orderId", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsORDERDETAILS.put("serviceId", new TableInfo.Column("serviceId", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsORDERDETAILS.put("soLuong", new TableInfo.Column("soLuong", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsORDERDETAILS.put("tongTien", new TableInfo.Column("tongTien", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysORDERDETAILS = new HashSet<TableInfo.ForeignKey>(2);
        _foreignKeysORDERDETAILS.add(new TableInfo.ForeignKey("ORDERS", "CASCADE", "NO ACTION",Arrays.asList("orderId"), Arrays.asList("id")));
        _foreignKeysORDERDETAILS.add(new TableInfo.ForeignKey("SERVICE", "CASCADE", "NO ACTION",Arrays.asList("serviceId"), Arrays.asList("id")));
        final HashSet<TableInfo.Index> _indicesORDERDETAILS = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoORDERDETAILS = new TableInfo("ORDER_DETAILS", _columnsORDERDETAILS, _foreignKeysORDERDETAILS, _indicesORDERDETAILS);
        final TableInfo _existingORDERDETAILS = TableInfo.read(_db, "ORDER_DETAILS");
        if (! _infoORDERDETAILS.equals(_existingORDERDETAILS)) {
          return new RoomOpenHelper.ValidationResult(false, "ORDER_DETAILS(com.example.doantotnghiep.model.OrderDetails).\n"
                  + " Expected:\n" + _infoORDERDETAILS + "\n"
                  + " Found:\n" + _existingORDERDETAILS);
        }
        final HashMap<String, TableInfo.Column> _columnsPITCH = new HashMap<String, TableInfo.Column>(4);
        _columnsPITCH.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPITCH.put("name", new TableInfo.Column("name", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPITCH.put("categoryId", new TableInfo.Column("categoryId", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPITCH.put("status", new TableInfo.Column("status", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysPITCH = new HashSet<TableInfo.ForeignKey>(1);
        _foreignKeysPITCH.add(new TableInfo.ForeignKey("PITCH_CATEGORY", "CASCADE", "NO ACTION",Arrays.asList("categoryId"), Arrays.asList("id")));
        final HashSet<TableInfo.Index> _indicesPITCH = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoPITCH = new TableInfo("PITCH", _columnsPITCH, _foreignKeysPITCH, _indicesPITCH);
        final TableInfo _existingPITCH = TableInfo.read(_db, "PITCH");
        if (! _infoPITCH.equals(_existingPITCH)) {
          return new RoomOpenHelper.ValidationResult(false, "PITCH(com.example.doantotnghiep.model.Pitch).\n"
                  + " Expected:\n" + _infoPITCH + "\n"
                  + " Found:\n" + _existingPITCH);
        }
        final HashMap<String, TableInfo.Column> _columnsPITCHCATEGORY = new HashMap<String, TableInfo.Column>(3);
        _columnsPITCHCATEGORY.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPITCHCATEGORY.put("name", new TableInfo.Column("name", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPITCHCATEGORY.put("money", new TableInfo.Column("money", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysPITCHCATEGORY = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesPITCHCATEGORY = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoPITCHCATEGORY = new TableInfo("PITCH_CATEGORY", _columnsPITCHCATEGORY, _foreignKeysPITCHCATEGORY, _indicesPITCHCATEGORY);
        final TableInfo _existingPITCHCATEGORY = TableInfo.read(_db, "PITCH_CATEGORY");
        if (! _infoPITCHCATEGORY.equals(_existingPITCHCATEGORY)) {
          return new RoomOpenHelper.ValidationResult(false, "PITCH_CATEGORY(com.example.doantotnghiep.model.PithCategory).\n"
                  + " Expected:\n" + _infoPITCHCATEGORY + "\n"
                  + " Found:\n" + _existingPITCHCATEGORY);
        }
        final HashMap<String, TableInfo.Column> _columnsSERVICE = new HashMap<String, TableInfo.Column>(4);
        _columnsSERVICE.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSERVICE.put("name", new TableInfo.Column("name", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSERVICE.put("money", new TableInfo.Column("money", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSERVICE.put("isProduct", new TableInfo.Column("isProduct", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysSERVICE = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesSERVICE = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoSERVICE = new TableInfo("SERVICE", _columnsSERVICE, _foreignKeysSERVICE, _indicesSERVICE);
        final TableInfo _existingSERVICE = TableInfo.read(_db, "SERVICE");
        if (! _infoSERVICE.equals(_existingSERVICE)) {
          return new RoomOpenHelper.ValidationResult(false, "SERVICE(com.example.doantotnghiep.model.ServiceBall).\n"
                  + " Expected:\n" + _infoSERVICE + "\n"
                  + " Found:\n" + _existingSERVICE);
        }
        final HashMap<String, TableInfo.Column> _columnsMANAGERCATEGORY = new HashMap<String, TableInfo.Column>(2);
        _columnsMANAGERCATEGORY.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMANAGERCATEGORY.put("name", new TableInfo.Column("name", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysMANAGERCATEGORY = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesMANAGERCATEGORY = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoMANAGERCATEGORY = new TableInfo("MANAGER_CATEGORY", _columnsMANAGERCATEGORY, _foreignKeysMANAGERCATEGORY, _indicesMANAGERCATEGORY);
        final TableInfo _existingMANAGERCATEGORY = TableInfo.read(_db, "MANAGER_CATEGORY");
        if (! _infoMANAGERCATEGORY.equals(_existingMANAGERCATEGORY)) {
          return new RoomOpenHelper.ValidationResult(false, "MANAGER_CATEGORY(com.example.doantotnghiep.model.ManagerCategory).\n"
                  + " Expected:\n" + _infoMANAGERCATEGORY + "\n"
                  + " Found:\n" + _existingMANAGERCATEGORY);
        }
        final HashMap<String, TableInfo.Column> _columnsMYNOTIFICATION = new HashMap<String, TableInfo.Column>(5);
        _columnsMYNOTIFICATION.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMYNOTIFICATION.put("title", new TableInfo.Column("title", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMYNOTIFICATION.put("content", new TableInfo.Column("content", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMYNOTIFICATION.put("date", new TableInfo.Column("date", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMYNOTIFICATION.put("status", new TableInfo.Column("status", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysMYNOTIFICATION = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesMYNOTIFICATION = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoMYNOTIFICATION = new TableInfo("MY_NOTIFICATION", _columnsMYNOTIFICATION, _foreignKeysMYNOTIFICATION, _indicesMYNOTIFICATION);
        final TableInfo _existingMYNOTIFICATION = TableInfo.read(_db, "MY_NOTIFICATION");
        if (! _infoMYNOTIFICATION.equals(_existingMYNOTIFICATION)) {
          return new RoomOpenHelper.ValidationResult(false, "MY_NOTIFICATION(com.example.doantotnghiep.model.MyNotification).\n"
                  + " Expected:\n" + _infoMYNOTIFICATION + "\n"
                  + " Found:\n" + _existingMYNOTIFICATION);
        }
        final HashMap<String, TableInfo.Column> _columnsMyTime = new HashMap<String, TableInfo.Column>(5);
        _columnsMyTime.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMyTime.put("name", new TableInfo.Column("name", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMyTime.put("startTime", new TableInfo.Column("startTime", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMyTime.put("endTime", new TableInfo.Column("endTime", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMyTime.put("money", new TableInfo.Column("money", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysMyTime = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesMyTime = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoMyTime = new TableInfo("MyTime", _columnsMyTime, _foreignKeysMyTime, _indicesMyTime);
        final TableInfo _existingMyTime = TableInfo.read(_db, "MyTime");
        if (! _infoMyTime.equals(_existingMyTime)) {
          return new RoomOpenHelper.ValidationResult(false, "MyTime(com.example.doantotnghiep.model.MyTime).\n"
                  + " Expected:\n" + _infoMyTime + "\n"
                  + " Found:\n" + _existingMyTime);
        }
        final HashMap<String, TableInfo.Column> _columnsTimeOrderDetails = new HashMap<String, TableInfo.Column>(3);
        _columnsTimeOrderDetails.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTimeOrderDetails.put("orderId", new TableInfo.Column("orderId", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTimeOrderDetails.put("timeId", new TableInfo.Column("timeId", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysTimeOrderDetails = new HashSet<TableInfo.ForeignKey>(2);
        _foreignKeysTimeOrderDetails.add(new TableInfo.ForeignKey("ORDERS", "CASCADE", "NO ACTION",Arrays.asList("orderId"), Arrays.asList("id")));
        _foreignKeysTimeOrderDetails.add(new TableInfo.ForeignKey("MyTime", "CASCADE", "NO ACTION",Arrays.asList("timeId"), Arrays.asList("id")));
        final HashSet<TableInfo.Index> _indicesTimeOrderDetails = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoTimeOrderDetails = new TableInfo("TimeOrderDetails", _columnsTimeOrderDetails, _foreignKeysTimeOrderDetails, _indicesTimeOrderDetails);
        final TableInfo _existingTimeOrderDetails = TableInfo.read(_db, "TimeOrderDetails");
        if (! _infoTimeOrderDetails.equals(_existingTimeOrderDetails)) {
          return new RoomOpenHelper.ValidationResult(false, "TimeOrderDetails(com.example.doantotnghiep.model.TimeOrderDetails).\n"
                  + " Expected:\n" + _infoTimeOrderDetails + "\n"
                  + " Found:\n" + _existingTimeOrderDetails);
        }
        final HashMap<String, TableInfo.Column> _columnsHistoryBuy = new HashMap<String, TableInfo.Column>(5);
        _columnsHistoryBuy.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsHistoryBuy.put("idCustomer", new TableInfo.Column("idCustomer", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsHistoryBuy.put("money", new TableInfo.Column("money", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsHistoryBuy.put("status", new TableInfo.Column("status", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsHistoryBuy.put("date", new TableInfo.Column("date", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysHistoryBuy = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesHistoryBuy = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoHistoryBuy = new TableInfo("HistoryBuy", _columnsHistoryBuy, _foreignKeysHistoryBuy, _indicesHistoryBuy);
        final TableInfo _existingHistoryBuy = TableInfo.read(_db, "HistoryBuy");
        if (! _infoHistoryBuy.equals(_existingHistoryBuy)) {
          return new RoomOpenHelper.ValidationResult(false, "HistoryBuy(com.example.doantotnghiep.model.HistoryBuy).\n"
                  + " Expected:\n" + _infoHistoryBuy + "\n"
                  + " Found:\n" + _existingHistoryBuy);
        }
        final HashMap<String, TableInfo.Column> _columnsNotificationDetails = new HashMap<String, TableInfo.Column>(3);
        _columnsNotificationDetails.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsNotificationDetails.put("customerId", new TableInfo.Column("customerId", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsNotificationDetails.put("notificationId", new TableInfo.Column("notificationId", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysNotificationDetails = new HashSet<TableInfo.ForeignKey>(2);
        _foreignKeysNotificationDetails.add(new TableInfo.ForeignKey("MY_NOTIFICATION", "NO ACTION", "NO ACTION",Arrays.asList("notificationId"), Arrays.asList("id")));
        _foreignKeysNotificationDetails.add(new TableInfo.ForeignKey("CUSTOMER", "NO ACTION", "NO ACTION",Arrays.asList("customerId"), Arrays.asList("id")));
        final HashSet<TableInfo.Index> _indicesNotificationDetails = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoNotificationDetails = new TableInfo("NotificationDetails", _columnsNotificationDetails, _foreignKeysNotificationDetails, _indicesNotificationDetails);
        final TableInfo _existingNotificationDetails = TableInfo.read(_db, "NotificationDetails");
        if (! _infoNotificationDetails.equals(_existingNotificationDetails)) {
          return new RoomOpenHelper.ValidationResult(false, "NotificationDetails(com.example.doantotnghiep.model.NotificationDetails).\n"
                  + " Expected:\n" + _infoNotificationDetails + "\n"
                  + " Found:\n" + _existingNotificationDetails);
        }
        return new RoomOpenHelper.ValidationResult(true, null);
      }
    }, "662886a157abe2469026df7b68192d71", "825931a425aa7cfcd2ac50e2ab830631");
    final SupportSQLiteOpenHelper.Configuration _sqliteConfig = SupportSQLiteOpenHelper.Configuration.builder(configuration.context)
        .name(configuration.name)
        .callback(_openCallback)
        .build();
    final SupportSQLiteOpenHelper _helper = configuration.sqliteOpenHelperFactory.create(_sqliteConfig);
    return _helper;
  }

  @Override
  protected InvalidationTracker createInvalidationTracker() {
    final HashMap<String, String> _shadowTablesMap = new HashMap<String, String>(0);
    HashMap<String, Set<String>> _viewTables = new HashMap<String, Set<String>>(0);
    return new InvalidationTracker(this, _shadowTablesMap, _viewTables, "CUSTOMER","MANAGER","ORDERS","ORDER_DETAILS","PITCH","PITCH_CATEGORY","SERVICE","MANAGER_CATEGORY","MY_NOTIFICATION","MyTime","TimeOrderDetails","HistoryBuy","NotificationDetails");
  }

  @Override
  public void clearAllTables() {
    super.assertNotMainThread();
    final SupportSQLiteDatabase _db = super.getOpenHelper().getWritableDatabase();
    boolean _supportsDeferForeignKeys = android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP;
    try {
      if (!_supportsDeferForeignKeys) {
        _db.execSQL("PRAGMA foreign_keys = FALSE");
      }
      super.beginTransaction();
      if (_supportsDeferForeignKeys) {
        _db.execSQL("PRAGMA defer_foreign_keys = TRUE");
      }
      _db.execSQL("DELETE FROM `CUSTOMER`");
      _db.execSQL("DELETE FROM `MANAGER`");
      _db.execSQL("DELETE FROM `ORDERS`");
      _db.execSQL("DELETE FROM `ORDER_DETAILS`");
      _db.execSQL("DELETE FROM `PITCH`");
      _db.execSQL("DELETE FROM `PITCH_CATEGORY`");
      _db.execSQL("DELETE FROM `SERVICE`");
      _db.execSQL("DELETE FROM `MANAGER_CATEGORY`");
      _db.execSQL("DELETE FROM `MY_NOTIFICATION`");
      _db.execSQL("DELETE FROM `MyTime`");
      _db.execSQL("DELETE FROM `TimeOrderDetails`");
      _db.execSQL("DELETE FROM `HistoryBuy`");
      _db.execSQL("DELETE FROM `NotificationDetails`");
      super.setTransactionSuccessful();
    } finally {
      super.endTransaction();
      if (!_supportsDeferForeignKeys) {
        _db.execSQL("PRAGMA foreign_keys = TRUE");
      }
      _db.query("PRAGMA wal_checkpoint(FULL)").close();
      if (!_db.inTransaction()) {
        _db.execSQL("VACUUM");
      }
    }
  }

  @Override
  protected Map<Class<?>, List<Class<?>>> getRequiredTypeConverters() {
    final HashMap<Class<?>, List<Class<?>>> _typeConvertersMap = new HashMap<Class<?>, List<Class<?>>>();
    _typeConvertersMap.put(CustomerDAO.class, CustomerDAO_Impl.getRequiredConverters());
    _typeConvertersMap.put(ManagerDAO.class, ManagerDAO_Impl.getRequiredConverters());
    _typeConvertersMap.put(OrderDAO.class, OrderDAO_Impl.getRequiredConverters());
    _typeConvertersMap.put(OrderDetailsDAO.class, OrderDetailsDAO_Impl.getRequiredConverters());
    _typeConvertersMap.put(PitchCategoryDAO.class, PitchCategoryDAO_Impl.getRequiredConverters());
    _typeConvertersMap.put(PitchDAO.class, PitchDAO_Impl.getRequiredConverters());
    _typeConvertersMap.put(ServiceDAO.class, ServiceDAO_Impl.getRequiredConverters());
    _typeConvertersMap.put(ManagerCategoryDAO.class, ManagerCategoryDAO_Impl.getRequiredConverters());
    _typeConvertersMap.put(TimeOrderDetailsDAO.class, TimeOrderDetailsDAO_Impl.getRequiredConverters());
    _typeConvertersMap.put(TimeDAO.class, TimeDAO_Impl.getRequiredConverters());
    _typeConvertersMap.put(HistoryBuyDAO.class, HistoryBuyDAO_Impl.getRequiredConverters());
    _typeConvertersMap.put(NotificationDetailsDAO.class, NotificationDetailsDAO_Impl.getRequiredConverters());
    _typeConvertersMap.put(NotificationDAO.class, NotificationDAO_Impl.getRequiredConverters());
    return _typeConvertersMap;
  }

  @Override
  public Set<Class<? extends AutoMigrationSpec>> getRequiredAutoMigrationSpecs() {
    final HashSet<Class<? extends AutoMigrationSpec>> _autoMigrationSpecsSet = new HashSet<Class<? extends AutoMigrationSpec>>();
    return _autoMigrationSpecsSet;
  }

  @Override
  public List<Migration> getAutoMigrations(
      @NonNull Map<Class<? extends AutoMigrationSpec>, AutoMigrationSpec> autoMigrationSpecsMap) {
    return Arrays.asList();
  }

  @Override
  public CustomerDAO customerDAO() {
    if (_customerDAO != null) {
      return _customerDAO;
    } else {
      synchronized(this) {
        if(_customerDAO == null) {
          _customerDAO = new CustomerDAO_Impl(this);
        }
        return _customerDAO;
      }
    }
  }

  @Override
  public ManagerDAO managerDAO() {
    if (_managerDAO != null) {
      return _managerDAO;
    } else {
      synchronized(this) {
        if(_managerDAO == null) {
          _managerDAO = new ManagerDAO_Impl(this);
        }
        return _managerDAO;
      }
    }
  }

  @Override
  public OrderDAO orderDAO() {
    if (_orderDAO != null) {
      return _orderDAO;
    } else {
      synchronized(this) {
        if(_orderDAO == null) {
          _orderDAO = new OrderDAO_Impl(this);
        }
        return _orderDAO;
      }
    }
  }

  @Override
  public OrderDetailsDAO orderDetailsDAO() {
    if (_orderDetailsDAO != null) {
      return _orderDetailsDAO;
    } else {
      synchronized(this) {
        if(_orderDetailsDAO == null) {
          _orderDetailsDAO = new OrderDetailsDAO_Impl(this);
        }
        return _orderDetailsDAO;
      }
    }
  }

  @Override
  public PitchCategoryDAO pitchCategoryDAO() {
    if (_pitchCategoryDAO != null) {
      return _pitchCategoryDAO;
    } else {
      synchronized(this) {
        if(_pitchCategoryDAO == null) {
          _pitchCategoryDAO = new PitchCategoryDAO_Impl(this);
        }
        return _pitchCategoryDAO;
      }
    }
  }

  @Override
  public PitchDAO pitchDao() {
    if (_pitchDAO != null) {
      return _pitchDAO;
    } else {
      synchronized(this) {
        if(_pitchDAO == null) {
          _pitchDAO = new PitchDAO_Impl(this);
        }
        return _pitchDAO;
      }
    }
  }

  @Override
  public ServiceDAO serviceDAO() {
    if (_serviceDAO != null) {
      return _serviceDAO;
    } else {
      synchronized(this) {
        if(_serviceDAO == null) {
          _serviceDAO = new ServiceDAO_Impl(this);
        }
        return _serviceDAO;
      }
    }
  }

  @Override
  public ManagerCategoryDAO managerCategoryDAO() {
    if (_managerCategoryDAO != null) {
      return _managerCategoryDAO;
    } else {
      synchronized(this) {
        if(_managerCategoryDAO == null) {
          _managerCategoryDAO = new ManagerCategoryDAO_Impl(this);
        }
        return _managerCategoryDAO;
      }
    }
  }

  @Override
  public TimeOrderDetailsDAO timeOrderDetailsDAO() {
    if (_timeOrderDetailsDAO != null) {
      return _timeOrderDetailsDAO;
    } else {
      synchronized(this) {
        if(_timeOrderDetailsDAO == null) {
          _timeOrderDetailsDAO = new TimeOrderDetailsDAO_Impl(this);
        }
        return _timeOrderDetailsDAO;
      }
    }
  }

  @Override
  public TimeDAO timeDAO() {
    if (_timeDAO != null) {
      return _timeDAO;
    } else {
      synchronized(this) {
        if(_timeDAO == null) {
          _timeDAO = new TimeDAO_Impl(this);
        }
        return _timeDAO;
      }
    }
  }

  @Override
  public HistoryBuyDAO historyBuyDAO() {
    if (_historyBuyDAO != null) {
      return _historyBuyDAO;
    } else {
      synchronized(this) {
        if(_historyBuyDAO == null) {
          _historyBuyDAO = new HistoryBuyDAO_Impl(this);
        }
        return _historyBuyDAO;
      }
    }
  }

  @Override
  public NotificationDetailsDAO notificationDetailsDAO() {
    if (_notificationDetailsDAO != null) {
      return _notificationDetailsDAO;
    } else {
      synchronized(this) {
        if(_notificationDetailsDAO == null) {
          _notificationDetailsDAO = new NotificationDetailsDAO_Impl(this);
        }
        return _notificationDetailsDAO;
      }
    }
  }

  @Override
  public NotificationDAO notificationDAO() {
    if (_notificationDAO != null) {
      return _notificationDAO;
    } else {
      synchronized(this) {
        if(_notificationDAO == null) {
          _notificationDAO = new NotificationDAO_Impl(this);
        }
        return _notificationDAO;
      }
    }
  }
}

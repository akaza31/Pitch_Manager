package com.example.doantotnghiep.dao;

import android.database.Cursor;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.example.doantotnghiep.model.Manager;
import java.lang.Class;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@SuppressWarnings({"unchecked", "deprecation"})
public final class ManagerDAO_Impl implements ManagerDAO {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<Manager> __insertionAdapterOfManager;

  private final EntityDeletionOrUpdateAdapter<Manager> __deletionAdapterOfManager;

  private final EntityDeletionOrUpdateAdapter<Manager> __updateAdapterOfManager;

  private final SharedSQLiteStatement __preparedStmtOfDeleteAll;

  public ManagerDAO_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfManager = new EntityInsertionAdapter<Manager>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `MANAGER` (`id`,`phone`,`name`,`category_id`,`password`,`salary`,`bankNumber`,`bankName`,`status`) VALUES (nullif(?, 0),?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Manager value) {
        stmt.bindLong(1, value.getId());
        if (value.getPhone() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getPhone());
        }
        if (value.getName() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getName());
        }
        stmt.bindLong(4, value.getCategory_id());
        if (value.getPassword() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getPassword());
        }
        stmt.bindLong(6, value.getSalary());
        if (value.getBankNumber() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getBankNumber());
        }
        if (value.getBankName() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.getBankName());
        }
        stmt.bindLong(9, value.getStatus());
      }
    };
    this.__deletionAdapterOfManager = new EntityDeletionOrUpdateAdapter<Manager>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `MANAGER` WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Manager value) {
        stmt.bindLong(1, value.getId());
      }
    };
    this.__updateAdapterOfManager = new EntityDeletionOrUpdateAdapter<Manager>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `MANAGER` SET `id` = ?,`phone` = ?,`name` = ?,`category_id` = ?,`password` = ?,`salary` = ?,`bankNumber` = ?,`bankName` = ?,`status` = ? WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Manager value) {
        stmt.bindLong(1, value.getId());
        if (value.getPhone() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getPhone());
        }
        if (value.getName() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getName());
        }
        stmt.bindLong(4, value.getCategory_id());
        if (value.getPassword() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getPassword());
        }
        stmt.bindLong(6, value.getSalary());
        if (value.getBankNumber() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getBankNumber());
        }
        if (value.getBankName() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.getBankName());
        }
        stmt.bindLong(9, value.getStatus());
        stmt.bindLong(10, value.getId());
      }
    };
    this.__preparedStmtOfDeleteAll = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM MANAGER";
        return _query;
      }
    };
  }

  @Override
  public void insert(final Manager manager) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfManager.insert(manager);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void delete(final Manager manager) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __deletionAdapterOfManager.handle(manager);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void update(final Manager manager) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __updateAdapterOfManager.handle(manager);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void deleteAll() {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteAll.acquire();
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfDeleteAll.release(_stmt);
    }
  }

  @Override
  public List<Manager> getAll() {
    final String _sql = "SELECT * FROM MANAGER";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfPhone = CursorUtil.getColumnIndexOrThrow(_cursor, "phone");
      final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
      final int _cursorIndexOfCategoryId = CursorUtil.getColumnIndexOrThrow(_cursor, "category_id");
      final int _cursorIndexOfPassword = CursorUtil.getColumnIndexOrThrow(_cursor, "password");
      final int _cursorIndexOfSalary = CursorUtil.getColumnIndexOrThrow(_cursor, "salary");
      final int _cursorIndexOfBankNumber = CursorUtil.getColumnIndexOrThrow(_cursor, "bankNumber");
      final int _cursorIndexOfBankName = CursorUtil.getColumnIndexOrThrow(_cursor, "bankName");
      final int _cursorIndexOfStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "status");
      final List<Manager> _result = new ArrayList<Manager>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Manager _item;
        _item = new Manager();
        final int _tmpId;
        _tmpId = _cursor.getInt(_cursorIndexOfId);
        _item.setId(_tmpId);
        final String _tmpPhone;
        if (_cursor.isNull(_cursorIndexOfPhone)) {
          _tmpPhone = null;
        } else {
          _tmpPhone = _cursor.getString(_cursorIndexOfPhone);
        }
        _item.setPhone(_tmpPhone);
        final String _tmpName;
        if (_cursor.isNull(_cursorIndexOfName)) {
          _tmpName = null;
        } else {
          _tmpName = _cursor.getString(_cursorIndexOfName);
        }
        _item.setName(_tmpName);
        final int _tmpCategory_id;
        _tmpCategory_id = _cursor.getInt(_cursorIndexOfCategoryId);
        _item.setCategory_id(_tmpCategory_id);
        final String _tmpPassword;
        if (_cursor.isNull(_cursorIndexOfPassword)) {
          _tmpPassword = null;
        } else {
          _tmpPassword = _cursor.getString(_cursorIndexOfPassword);
        }
        _item.setPassword(_tmpPassword);
        final int _tmpSalary;
        _tmpSalary = _cursor.getInt(_cursorIndexOfSalary);
        _item.setSalary(_tmpSalary);
        final String _tmpBankNumber;
        if (_cursor.isNull(_cursorIndexOfBankNumber)) {
          _tmpBankNumber = null;
        } else {
          _tmpBankNumber = _cursor.getString(_cursorIndexOfBankNumber);
        }
        _item.setBankNumber(_tmpBankNumber);
        final String _tmpBankName;
        if (_cursor.isNull(_cursorIndexOfBankName)) {
          _tmpBankName = null;
        } else {
          _tmpBankName = _cursor.getString(_cursorIndexOfBankName);
        }
        _item.setBankName(_tmpBankName);
        final int _tmpStatus;
        _tmpStatus = _cursor.getInt(_cursorIndexOfStatus);
        _item.setStatus(_tmpStatus);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<Manager> getManagerWithPhone(final String phone, final int id) {
    final String _sql = "SELECT * FROM MANAGER WHERE PHONE = ? AND ID != ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 2);
    int _argIndex = 1;
    if (phone == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, phone);
    }
    _argIndex = 2;
    _statement.bindLong(_argIndex, id);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfPhone = CursorUtil.getColumnIndexOrThrow(_cursor, "phone");
      final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
      final int _cursorIndexOfCategoryId = CursorUtil.getColumnIndexOrThrow(_cursor, "category_id");
      final int _cursorIndexOfPassword = CursorUtil.getColumnIndexOrThrow(_cursor, "password");
      final int _cursorIndexOfSalary = CursorUtil.getColumnIndexOrThrow(_cursor, "salary");
      final int _cursorIndexOfBankNumber = CursorUtil.getColumnIndexOrThrow(_cursor, "bankNumber");
      final int _cursorIndexOfBankName = CursorUtil.getColumnIndexOrThrow(_cursor, "bankName");
      final int _cursorIndexOfStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "status");
      final List<Manager> _result = new ArrayList<Manager>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Manager _item;
        _item = new Manager();
        final int _tmpId;
        _tmpId = _cursor.getInt(_cursorIndexOfId);
        _item.setId(_tmpId);
        final String _tmpPhone;
        if (_cursor.isNull(_cursorIndexOfPhone)) {
          _tmpPhone = null;
        } else {
          _tmpPhone = _cursor.getString(_cursorIndexOfPhone);
        }
        _item.setPhone(_tmpPhone);
        final String _tmpName;
        if (_cursor.isNull(_cursorIndexOfName)) {
          _tmpName = null;
        } else {
          _tmpName = _cursor.getString(_cursorIndexOfName);
        }
        _item.setName(_tmpName);
        final int _tmpCategory_id;
        _tmpCategory_id = _cursor.getInt(_cursorIndexOfCategoryId);
        _item.setCategory_id(_tmpCategory_id);
        final String _tmpPassword;
        if (_cursor.isNull(_cursorIndexOfPassword)) {
          _tmpPassword = null;
        } else {
          _tmpPassword = _cursor.getString(_cursorIndexOfPassword);
        }
        _item.setPassword(_tmpPassword);
        final int _tmpSalary;
        _tmpSalary = _cursor.getInt(_cursorIndexOfSalary);
        _item.setSalary(_tmpSalary);
        final String _tmpBankNumber;
        if (_cursor.isNull(_cursorIndexOfBankNumber)) {
          _tmpBankNumber = null;
        } else {
          _tmpBankNumber = _cursor.getString(_cursorIndexOfBankNumber);
        }
        _item.setBankNumber(_tmpBankNumber);
        final String _tmpBankName;
        if (_cursor.isNull(_cursorIndexOfBankName)) {
          _tmpBankName = null;
        } else {
          _tmpBankName = _cursor.getString(_cursorIndexOfBankName);
        }
        _item.setBankName(_tmpBankName);
        final int _tmpStatus;
        _tmpStatus = _cursor.getInt(_cursorIndexOfStatus);
        _item.setStatus(_tmpStatus);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<Manager> getManagerWithName(final String name) {
    final String _sql = "SELECT * FROM MANAGER WHERE NAME LIKE ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (name == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, name);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfPhone = CursorUtil.getColumnIndexOrThrow(_cursor, "phone");
      final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
      final int _cursorIndexOfCategoryId = CursorUtil.getColumnIndexOrThrow(_cursor, "category_id");
      final int _cursorIndexOfPassword = CursorUtil.getColumnIndexOrThrow(_cursor, "password");
      final int _cursorIndexOfSalary = CursorUtil.getColumnIndexOrThrow(_cursor, "salary");
      final int _cursorIndexOfBankNumber = CursorUtil.getColumnIndexOrThrow(_cursor, "bankNumber");
      final int _cursorIndexOfBankName = CursorUtil.getColumnIndexOrThrow(_cursor, "bankName");
      final int _cursorIndexOfStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "status");
      final List<Manager> _result = new ArrayList<Manager>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Manager _item;
        _item = new Manager();
        final int _tmpId;
        _tmpId = _cursor.getInt(_cursorIndexOfId);
        _item.setId(_tmpId);
        final String _tmpPhone;
        if (_cursor.isNull(_cursorIndexOfPhone)) {
          _tmpPhone = null;
        } else {
          _tmpPhone = _cursor.getString(_cursorIndexOfPhone);
        }
        _item.setPhone(_tmpPhone);
        final String _tmpName;
        if (_cursor.isNull(_cursorIndexOfName)) {
          _tmpName = null;
        } else {
          _tmpName = _cursor.getString(_cursorIndexOfName);
        }
        _item.setName(_tmpName);
        final int _tmpCategory_id;
        _tmpCategory_id = _cursor.getInt(_cursorIndexOfCategoryId);
        _item.setCategory_id(_tmpCategory_id);
        final String _tmpPassword;
        if (_cursor.isNull(_cursorIndexOfPassword)) {
          _tmpPassword = null;
        } else {
          _tmpPassword = _cursor.getString(_cursorIndexOfPassword);
        }
        _item.setPassword(_tmpPassword);
        final int _tmpSalary;
        _tmpSalary = _cursor.getInt(_cursorIndexOfSalary);
        _item.setSalary(_tmpSalary);
        final String _tmpBankNumber;
        if (_cursor.isNull(_cursorIndexOfBankNumber)) {
          _tmpBankNumber = null;
        } else {
          _tmpBankNumber = _cursor.getString(_cursorIndexOfBankNumber);
        }
        _item.setBankNumber(_tmpBankNumber);
        final String _tmpBankName;
        if (_cursor.isNull(_cursorIndexOfBankName)) {
          _tmpBankName = null;
        } else {
          _tmpBankName = _cursor.getString(_cursorIndexOfBankName);
        }
        _item.setBankName(_tmpBankName);
        final int _tmpStatus;
        _tmpStatus = _cursor.getInt(_cursorIndexOfStatus);
        _item.setStatus(_tmpStatus);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<Manager> getManagerWithID(final int id) {
    final String _sql = "SELECT * FROM MANAGER WHERE ID = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, id);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfPhone = CursorUtil.getColumnIndexOrThrow(_cursor, "phone");
      final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
      final int _cursorIndexOfCategoryId = CursorUtil.getColumnIndexOrThrow(_cursor, "category_id");
      final int _cursorIndexOfPassword = CursorUtil.getColumnIndexOrThrow(_cursor, "password");
      final int _cursorIndexOfSalary = CursorUtil.getColumnIndexOrThrow(_cursor, "salary");
      final int _cursorIndexOfBankNumber = CursorUtil.getColumnIndexOrThrow(_cursor, "bankNumber");
      final int _cursorIndexOfBankName = CursorUtil.getColumnIndexOrThrow(_cursor, "bankName");
      final int _cursorIndexOfStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "status");
      final List<Manager> _result = new ArrayList<Manager>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Manager _item;
        _item = new Manager();
        final int _tmpId;
        _tmpId = _cursor.getInt(_cursorIndexOfId);
        _item.setId(_tmpId);
        final String _tmpPhone;
        if (_cursor.isNull(_cursorIndexOfPhone)) {
          _tmpPhone = null;
        } else {
          _tmpPhone = _cursor.getString(_cursorIndexOfPhone);
        }
        _item.setPhone(_tmpPhone);
        final String _tmpName;
        if (_cursor.isNull(_cursorIndexOfName)) {
          _tmpName = null;
        } else {
          _tmpName = _cursor.getString(_cursorIndexOfName);
        }
        _item.setName(_tmpName);
        final int _tmpCategory_id;
        _tmpCategory_id = _cursor.getInt(_cursorIndexOfCategoryId);
        _item.setCategory_id(_tmpCategory_id);
        final String _tmpPassword;
        if (_cursor.isNull(_cursorIndexOfPassword)) {
          _tmpPassword = null;
        } else {
          _tmpPassword = _cursor.getString(_cursorIndexOfPassword);
        }
        _item.setPassword(_tmpPassword);
        final int _tmpSalary;
        _tmpSalary = _cursor.getInt(_cursorIndexOfSalary);
        _item.setSalary(_tmpSalary);
        final String _tmpBankNumber;
        if (_cursor.isNull(_cursorIndexOfBankNumber)) {
          _tmpBankNumber = null;
        } else {
          _tmpBankNumber = _cursor.getString(_cursorIndexOfBankNumber);
        }
        _item.setBankNumber(_tmpBankNumber);
        final String _tmpBankName;
        if (_cursor.isNull(_cursorIndexOfBankName)) {
          _tmpBankName = null;
        } else {
          _tmpBankName = _cursor.getString(_cursorIndexOfBankName);
        }
        _item.setBankName(_tmpBankName);
        final int _tmpStatus;
        _tmpStatus = _cursor.getInt(_cursorIndexOfStatus);
        _item.setStatus(_tmpStatus);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}

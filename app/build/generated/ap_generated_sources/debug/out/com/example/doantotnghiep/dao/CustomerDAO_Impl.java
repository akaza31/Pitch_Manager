package com.example.doantotnghiep.dao;

import android.database.Cursor;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.example.doantotnghiep.model.Customer;
import java.lang.Class;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@SuppressWarnings({"unchecked", "deprecation"})
public final class CustomerDAO_Impl implements CustomerDAO {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<Customer> __insertionAdapterOfCustomer;

  private final EntityDeletionOrUpdateAdapter<Customer> __deletionAdapterOfCustomer;

  private final EntityDeletionOrUpdateAdapter<Customer> __updateAdapterOfCustomer;

  public CustomerDAO_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfCustomer = new EntityInsertionAdapter<Customer>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `CUSTOMER` (`id`,`phone`,`name`,`address`,`coin`,`password`,`cmnd`,`img`) VALUES (nullif(?, 0),?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Customer value) {
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
        if (value.getAddress() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getAddress());
        }
        stmt.bindLong(5, value.getCoin());
        if (value.getPassword() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getPassword());
        }
        if (value.getCmnd() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getCmnd());
        }
        if (value.getImg() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindBlob(8, value.getImg());
        }
      }
    };
    this.__deletionAdapterOfCustomer = new EntityDeletionOrUpdateAdapter<Customer>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `CUSTOMER` WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Customer value) {
        stmt.bindLong(1, value.getId());
      }
    };
    this.__updateAdapterOfCustomer = new EntityDeletionOrUpdateAdapter<Customer>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `CUSTOMER` SET `id` = ?,`phone` = ?,`name` = ?,`address` = ?,`coin` = ?,`password` = ?,`cmnd` = ?,`img` = ? WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Customer value) {
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
        if (value.getAddress() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getAddress());
        }
        stmt.bindLong(5, value.getCoin());
        if (value.getPassword() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getPassword());
        }
        if (value.getCmnd() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getCmnd());
        }
        if (value.getImg() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindBlob(8, value.getImg());
        }
        stmt.bindLong(9, value.getId());
      }
    };
  }

  @Override
  public void insert(final Customer customer) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfCustomer.insert(customer);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void delete(final Customer customer) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __deletionAdapterOfCustomer.handle(customer);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void update(final Customer customer) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __updateAdapterOfCustomer.handle(customer);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public List<Customer> getAll() {
    final String _sql = "SELECT * FROM CUSTOMER";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfPhone = CursorUtil.getColumnIndexOrThrow(_cursor, "phone");
      final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
      final int _cursorIndexOfAddress = CursorUtil.getColumnIndexOrThrow(_cursor, "address");
      final int _cursorIndexOfCoin = CursorUtil.getColumnIndexOrThrow(_cursor, "coin");
      final int _cursorIndexOfPassword = CursorUtil.getColumnIndexOrThrow(_cursor, "password");
      final int _cursorIndexOfCmnd = CursorUtil.getColumnIndexOrThrow(_cursor, "cmnd");
      final int _cursorIndexOfImg = CursorUtil.getColumnIndexOrThrow(_cursor, "img");
      final List<Customer> _result = new ArrayList<Customer>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Customer _item;
        _item = new Customer();
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
        final String _tmpAddress;
        if (_cursor.isNull(_cursorIndexOfAddress)) {
          _tmpAddress = null;
        } else {
          _tmpAddress = _cursor.getString(_cursorIndexOfAddress);
        }
        _item.setAddress(_tmpAddress);
        final int _tmpCoin;
        _tmpCoin = _cursor.getInt(_cursorIndexOfCoin);
        _item.setCoin(_tmpCoin);
        final String _tmpPassword;
        if (_cursor.isNull(_cursorIndexOfPassword)) {
          _tmpPassword = null;
        } else {
          _tmpPassword = _cursor.getString(_cursorIndexOfPassword);
        }
        _item.setPassword(_tmpPassword);
        final String _tmpCmnd;
        if (_cursor.isNull(_cursorIndexOfCmnd)) {
          _tmpCmnd = null;
        } else {
          _tmpCmnd = _cursor.getString(_cursorIndexOfCmnd);
        }
        _item.setCmnd(_tmpCmnd);
        final byte[] _tmpImg;
        if (_cursor.isNull(_cursorIndexOfImg)) {
          _tmpImg = null;
        } else {
          _tmpImg = _cursor.getBlob(_cursorIndexOfImg);
        }
        _item.setImg(_tmpImg);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<Customer> getCustomerWithPhone(final String phone, final int id) {
    final String _sql = "SELECT * FROM CUSTOMER WHERE PHONE = ? AND ID != ?";
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
      final int _cursorIndexOfAddress = CursorUtil.getColumnIndexOrThrow(_cursor, "address");
      final int _cursorIndexOfCoin = CursorUtil.getColumnIndexOrThrow(_cursor, "coin");
      final int _cursorIndexOfPassword = CursorUtil.getColumnIndexOrThrow(_cursor, "password");
      final int _cursorIndexOfCmnd = CursorUtil.getColumnIndexOrThrow(_cursor, "cmnd");
      final int _cursorIndexOfImg = CursorUtil.getColumnIndexOrThrow(_cursor, "img");
      final List<Customer> _result = new ArrayList<Customer>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Customer _item;
        _item = new Customer();
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
        final String _tmpAddress;
        if (_cursor.isNull(_cursorIndexOfAddress)) {
          _tmpAddress = null;
        } else {
          _tmpAddress = _cursor.getString(_cursorIndexOfAddress);
        }
        _item.setAddress(_tmpAddress);
        final int _tmpCoin;
        _tmpCoin = _cursor.getInt(_cursorIndexOfCoin);
        _item.setCoin(_tmpCoin);
        final String _tmpPassword;
        if (_cursor.isNull(_cursorIndexOfPassword)) {
          _tmpPassword = null;
        } else {
          _tmpPassword = _cursor.getString(_cursorIndexOfPassword);
        }
        _item.setPassword(_tmpPassword);
        final String _tmpCmnd;
        if (_cursor.isNull(_cursorIndexOfCmnd)) {
          _tmpCmnd = null;
        } else {
          _tmpCmnd = _cursor.getString(_cursorIndexOfCmnd);
        }
        _item.setCmnd(_tmpCmnd);
        final byte[] _tmpImg;
        if (_cursor.isNull(_cursorIndexOfImg)) {
          _tmpImg = null;
        } else {
          _tmpImg = _cursor.getBlob(_cursorIndexOfImg);
        }
        _item.setImg(_tmpImg);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<Customer> getCustomerWithName(final String name) {
    final String _sql = "SELECT * FROM CUSTOMER WHERE name LIKE ?";
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
      final int _cursorIndexOfAddress = CursorUtil.getColumnIndexOrThrow(_cursor, "address");
      final int _cursorIndexOfCoin = CursorUtil.getColumnIndexOrThrow(_cursor, "coin");
      final int _cursorIndexOfPassword = CursorUtil.getColumnIndexOrThrow(_cursor, "password");
      final int _cursorIndexOfCmnd = CursorUtil.getColumnIndexOrThrow(_cursor, "cmnd");
      final int _cursorIndexOfImg = CursorUtil.getColumnIndexOrThrow(_cursor, "img");
      final List<Customer> _result = new ArrayList<Customer>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Customer _item;
        _item = new Customer();
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
        final String _tmpAddress;
        if (_cursor.isNull(_cursorIndexOfAddress)) {
          _tmpAddress = null;
        } else {
          _tmpAddress = _cursor.getString(_cursorIndexOfAddress);
        }
        _item.setAddress(_tmpAddress);
        final int _tmpCoin;
        _tmpCoin = _cursor.getInt(_cursorIndexOfCoin);
        _item.setCoin(_tmpCoin);
        final String _tmpPassword;
        if (_cursor.isNull(_cursorIndexOfPassword)) {
          _tmpPassword = null;
        } else {
          _tmpPassword = _cursor.getString(_cursorIndexOfPassword);
        }
        _item.setPassword(_tmpPassword);
        final String _tmpCmnd;
        if (_cursor.isNull(_cursorIndexOfCmnd)) {
          _tmpCmnd = null;
        } else {
          _tmpCmnd = _cursor.getString(_cursorIndexOfCmnd);
        }
        _item.setCmnd(_tmpCmnd);
        final byte[] _tmpImg;
        if (_cursor.isNull(_cursorIndexOfImg)) {
          _tmpImg = null;
        } else {
          _tmpImg = _cursor.getBlob(_cursorIndexOfImg);
        }
        _item.setImg(_tmpImg);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<Customer> getCustomerWithID(final int id) {
    final String _sql = "SELECT * FROM CUSTOMER WHERE id LIKE ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, id);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfPhone = CursorUtil.getColumnIndexOrThrow(_cursor, "phone");
      final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
      final int _cursorIndexOfAddress = CursorUtil.getColumnIndexOrThrow(_cursor, "address");
      final int _cursorIndexOfCoin = CursorUtil.getColumnIndexOrThrow(_cursor, "coin");
      final int _cursorIndexOfPassword = CursorUtil.getColumnIndexOrThrow(_cursor, "password");
      final int _cursorIndexOfCmnd = CursorUtil.getColumnIndexOrThrow(_cursor, "cmnd");
      final int _cursorIndexOfImg = CursorUtil.getColumnIndexOrThrow(_cursor, "img");
      final List<Customer> _result = new ArrayList<Customer>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Customer _item;
        _item = new Customer();
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
        final String _tmpAddress;
        if (_cursor.isNull(_cursorIndexOfAddress)) {
          _tmpAddress = null;
        } else {
          _tmpAddress = _cursor.getString(_cursorIndexOfAddress);
        }
        _item.setAddress(_tmpAddress);
        final int _tmpCoin;
        _tmpCoin = _cursor.getInt(_cursorIndexOfCoin);
        _item.setCoin(_tmpCoin);
        final String _tmpPassword;
        if (_cursor.isNull(_cursorIndexOfPassword)) {
          _tmpPassword = null;
        } else {
          _tmpPassword = _cursor.getString(_cursorIndexOfPassword);
        }
        _item.setPassword(_tmpPassword);
        final String _tmpCmnd;
        if (_cursor.isNull(_cursorIndexOfCmnd)) {
          _tmpCmnd = null;
        } else {
          _tmpCmnd = _cursor.getString(_cursorIndexOfCmnd);
        }
        _item.setCmnd(_tmpCmnd);
        final byte[] _tmpImg;
        if (_cursor.isNull(_cursorIndexOfImg)) {
          _tmpImg = null;
        } else {
          _tmpImg = _cursor.getBlob(_cursorIndexOfImg);
        }
        _item.setImg(_tmpImg);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public Cursor getAllId() {
    final String _sql = "SELECT id FROM CUSTOMER";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    final Cursor _tmpResult = __db.query(_statement);
    return _tmpResult;
  }

  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}

package com.example.doantotnghiep.dao;

import android.database.Cursor;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.example.doantotnghiep.model.ServiceBall;
import java.lang.Class;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@SuppressWarnings({"unchecked", "deprecation"})
public final class ServiceDAO_Impl implements ServiceDAO {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<ServiceBall> __insertionAdapterOfServiceBall;

  private final EntityDeletionOrUpdateAdapter<ServiceBall> __deletionAdapterOfServiceBall;

  private final EntityDeletionOrUpdateAdapter<ServiceBall> __updateAdapterOfServiceBall;

  public ServiceDAO_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfServiceBall = new EntityInsertionAdapter<ServiceBall>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `SERVICE` (`id`,`name`,`money`,`isProduct`) VALUES (nullif(?, 0),?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, ServiceBall value) {
        stmt.bindLong(1, value.getId());
        if (value.getName() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getName());
        }
        stmt.bindLong(3, value.getMoney());
        final int _tmp = value.isProduct() ? 1 : 0;
        stmt.bindLong(4, _tmp);
      }
    };
    this.__deletionAdapterOfServiceBall = new EntityDeletionOrUpdateAdapter<ServiceBall>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `SERVICE` WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, ServiceBall value) {
        stmt.bindLong(1, value.getId());
      }
    };
    this.__updateAdapterOfServiceBall = new EntityDeletionOrUpdateAdapter<ServiceBall>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `SERVICE` SET `id` = ?,`name` = ?,`money` = ?,`isProduct` = ? WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, ServiceBall value) {
        stmt.bindLong(1, value.getId());
        if (value.getName() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getName());
        }
        stmt.bindLong(3, value.getMoney());
        final int _tmp = value.isProduct() ? 1 : 0;
        stmt.bindLong(4, _tmp);
        stmt.bindLong(5, value.getId());
      }
    };
  }

  @Override
  public void insert(final ServiceBall serviceBall) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfServiceBall.insert(serviceBall);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void delete(final ServiceBall serviceBall) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __deletionAdapterOfServiceBall.handle(serviceBall);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void update(final ServiceBall serviceBall) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __updateAdapterOfServiceBall.handle(serviceBall);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public List<ServiceBall> getAll() {
    final String _sql = "SELECT * FROM SERVICE";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
      final int _cursorIndexOfMoney = CursorUtil.getColumnIndexOrThrow(_cursor, "money");
      final int _cursorIndexOfIsProduct = CursorUtil.getColumnIndexOrThrow(_cursor, "isProduct");
      final List<ServiceBall> _result = new ArrayList<ServiceBall>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final ServiceBall _item;
        _item = new ServiceBall();
        final int _tmpId;
        _tmpId = _cursor.getInt(_cursorIndexOfId);
        _item.setId(_tmpId);
        final String _tmpName;
        if (_cursor.isNull(_cursorIndexOfName)) {
          _tmpName = null;
        } else {
          _tmpName = _cursor.getString(_cursorIndexOfName);
        }
        _item.setName(_tmpName);
        final int _tmpMoney;
        _tmpMoney = _cursor.getInt(_cursorIndexOfMoney);
        _item.setMoney(_tmpMoney);
        final boolean _tmpIsProduct;
        final int _tmp;
        _tmp = _cursor.getInt(_cursorIndexOfIsProduct);
        _tmpIsProduct = _tmp != 0;
        _item.setProduct(_tmpIsProduct);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<ServiceBall> getServiceWithId(final int id) {
    final String _sql = "SELECT * FROM SERVICE WHERE id = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, id);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
      final int _cursorIndexOfMoney = CursorUtil.getColumnIndexOrThrow(_cursor, "money");
      final int _cursorIndexOfIsProduct = CursorUtil.getColumnIndexOrThrow(_cursor, "isProduct");
      final List<ServiceBall> _result = new ArrayList<ServiceBall>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final ServiceBall _item;
        _item = new ServiceBall();
        final int _tmpId;
        _tmpId = _cursor.getInt(_cursorIndexOfId);
        _item.setId(_tmpId);
        final String _tmpName;
        if (_cursor.isNull(_cursorIndexOfName)) {
          _tmpName = null;
        } else {
          _tmpName = _cursor.getString(_cursorIndexOfName);
        }
        _item.setName(_tmpName);
        final int _tmpMoney;
        _tmpMoney = _cursor.getInt(_cursorIndexOfMoney);
        _item.setMoney(_tmpMoney);
        final boolean _tmpIsProduct;
        final int _tmp;
        _tmp = _cursor.getInt(_cursorIndexOfIsProduct);
        _tmpIsProduct = _tmp != 0;
        _item.setProduct(_tmpIsProduct);
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

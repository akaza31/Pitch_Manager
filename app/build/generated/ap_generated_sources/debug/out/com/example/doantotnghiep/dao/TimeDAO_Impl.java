package com.example.doantotnghiep.dao;

import android.database.Cursor;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.example.doantotnghiep.model.MyTime;
import java.lang.Class;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@SuppressWarnings({"unchecked", "deprecation"})
public final class TimeDAO_Impl implements TimeDAO {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<MyTime> __insertionAdapterOfMyTime;

  private final EntityDeletionOrUpdateAdapter<MyTime> __deletionAdapterOfMyTime;

  private final EntityDeletionOrUpdateAdapter<MyTime> __updateAdapterOfMyTime;

  public TimeDAO_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfMyTime = new EntityInsertionAdapter<MyTime>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `MyTime` (`id`,`name`,`startTime`,`endTime`,`money`) VALUES (?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, MyTime value) {
        stmt.bindLong(1, value.getId());
        if (value.getName() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getName());
        }
        stmt.bindLong(3, value.getStartTime());
        stmt.bindLong(4, value.getEndTime());
        stmt.bindLong(5, value.getMoney());
      }
    };
    this.__deletionAdapterOfMyTime = new EntityDeletionOrUpdateAdapter<MyTime>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `MyTime` WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, MyTime value) {
        stmt.bindLong(1, value.getId());
      }
    };
    this.__updateAdapterOfMyTime = new EntityDeletionOrUpdateAdapter<MyTime>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `MyTime` SET `id` = ?,`name` = ?,`startTime` = ?,`endTime` = ?,`money` = ? WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, MyTime value) {
        stmt.bindLong(1, value.getId());
        if (value.getName() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getName());
        }
        stmt.bindLong(3, value.getStartTime());
        stmt.bindLong(4, value.getEndTime());
        stmt.bindLong(5, value.getMoney());
        stmt.bindLong(6, value.getId());
      }
    };
  }

  @Override
  public void insert(final MyTime time) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfMyTime.insert(time);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void delete(final MyTime time) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __deletionAdapterOfMyTime.handle(time);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void update(final MyTime time) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __updateAdapterOfMyTime.handle(time);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public List<MyTime> getAll() {
    final String _sql = "SELECT * FROM MyTime";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
      final int _cursorIndexOfStartTime = CursorUtil.getColumnIndexOrThrow(_cursor, "startTime");
      final int _cursorIndexOfEndTime = CursorUtil.getColumnIndexOrThrow(_cursor, "endTime");
      final int _cursorIndexOfMoney = CursorUtil.getColumnIndexOrThrow(_cursor, "money");
      final List<MyTime> _result = new ArrayList<MyTime>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final MyTime _item;
        _item = new MyTime();
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
        final int _tmpStartTime;
        _tmpStartTime = _cursor.getInt(_cursorIndexOfStartTime);
        _item.setStartTime(_tmpStartTime);
        final int _tmpEndTime;
        _tmpEndTime = _cursor.getInt(_cursorIndexOfEndTime);
        _item.setEndTime(_tmpEndTime);
        final int _tmpMoney;
        _tmpMoney = _cursor.getInt(_cursorIndexOfMoney);
        _item.setMoney(_tmpMoney);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<MyTime> getTimeWithId(final int id) {
    final String _sql = "SELECT * FROM MyTime WHERE id = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, id);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
      final int _cursorIndexOfStartTime = CursorUtil.getColumnIndexOrThrow(_cursor, "startTime");
      final int _cursorIndexOfEndTime = CursorUtil.getColumnIndexOrThrow(_cursor, "endTime");
      final int _cursorIndexOfMoney = CursorUtil.getColumnIndexOrThrow(_cursor, "money");
      final List<MyTime> _result = new ArrayList<MyTime>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final MyTime _item;
        _item = new MyTime();
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
        final int _tmpStartTime;
        _tmpStartTime = _cursor.getInt(_cursorIndexOfStartTime);
        _item.setStartTime(_tmpStartTime);
        final int _tmpEndTime;
        _tmpEndTime = _cursor.getInt(_cursorIndexOfEndTime);
        _item.setEndTime(_tmpEndTime);
        final int _tmpMoney;
        _tmpMoney = _cursor.getInt(_cursorIndexOfMoney);
        _item.setMoney(_tmpMoney);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<MyTime> getTimeWithOrderId(final int id) {
    final String _sql = "SELECT * FROM MyTime INNER JOIN TIMEORDERDETAILS ON MyTime.id = TIMEORDERDETAILS.timeId INNER JOIN ORDERS ON TIMEORDERDETAILS.orderId = ORDERS.id WHERE ORDERS.id = ? ORDER BY ORDERS.id ASC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, id);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
      final int _cursorIndexOfStartTime = CursorUtil.getColumnIndexOrThrow(_cursor, "startTime");
      final int _cursorIndexOfEndTime = CursorUtil.getColumnIndexOrThrow(_cursor, "endTime");
      final int _cursorIndexOfMoney = CursorUtil.getColumnIndexOrThrow(_cursor, "money");
      final int _cursorIndexOfId_1 = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfId_2 = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final List<MyTime> _result = new ArrayList<MyTime>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final MyTime _item;
        _item = new MyTime();
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
        final int _tmpStartTime;
        _tmpStartTime = _cursor.getInt(_cursorIndexOfStartTime);
        _item.setStartTime(_tmpStartTime);
        final int _tmpEndTime;
        _tmpEndTime = _cursor.getInt(_cursorIndexOfEndTime);
        _item.setEndTime(_tmpEndTime);
        final int _tmpMoney;
        _tmpMoney = _cursor.getInt(_cursorIndexOfMoney);
        _item.setMoney(_tmpMoney);
        final int _tmpId_1;
        _tmpId_1 = _cursor.getInt(_cursorIndexOfId_1);
        _item.setId(_tmpId_1);
        final int _tmpId_2;
        _tmpId_2 = _cursor.getInt(_cursorIndexOfId_2);
        _item.setId(_tmpId_2);
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

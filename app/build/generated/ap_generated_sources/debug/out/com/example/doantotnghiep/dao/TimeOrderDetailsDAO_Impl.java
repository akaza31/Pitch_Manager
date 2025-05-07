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
import com.example.doantotnghiep.model.TimeOrderDetails;
import java.lang.Class;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@SuppressWarnings({"unchecked", "deprecation"})
public final class TimeOrderDetailsDAO_Impl implements TimeOrderDetailsDAO {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<TimeOrderDetails> __insertionAdapterOfTimeOrderDetails;

  private final EntityDeletionOrUpdateAdapter<TimeOrderDetails> __deletionAdapterOfTimeOrderDetails;

  private final EntityDeletionOrUpdateAdapter<TimeOrderDetails> __updateAdapterOfTimeOrderDetails;

  private final SharedSQLiteStatement __preparedStmtOfDeleteWithOrderIdAndTimeId;

  public TimeOrderDetailsDAO_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfTimeOrderDetails = new EntityInsertionAdapter<TimeOrderDetails>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `TimeOrderDetails` (`id`,`orderId`,`timeId`) VALUES (nullif(?, 0),?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, TimeOrderDetails value) {
        stmt.bindLong(1, value.getId());
        stmt.bindLong(2, value.getOrderId());
        stmt.bindLong(3, value.getTimeId());
      }
    };
    this.__deletionAdapterOfTimeOrderDetails = new EntityDeletionOrUpdateAdapter<TimeOrderDetails>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `TimeOrderDetails` WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, TimeOrderDetails value) {
        stmt.bindLong(1, value.getId());
      }
    };
    this.__updateAdapterOfTimeOrderDetails = new EntityDeletionOrUpdateAdapter<TimeOrderDetails>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `TimeOrderDetails` SET `id` = ?,`orderId` = ?,`timeId` = ? WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, TimeOrderDetails value) {
        stmt.bindLong(1, value.getId());
        stmt.bindLong(2, value.getOrderId());
        stmt.bindLong(3, value.getTimeId());
        stmt.bindLong(4, value.getId());
      }
    };
    this.__preparedStmtOfDeleteWithOrderIdAndTimeId = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM TIMEORDERDETAILS WHERE orderId = ? AND timeId = ?";
        return _query;
      }
    };
  }

  @Override
  public void insert(final TimeOrderDetails details) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfTimeOrderDetails.insert(details);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void delete(final TimeOrderDetails details) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __deletionAdapterOfTimeOrderDetails.handle(details);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void update(final TimeOrderDetails details) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __updateAdapterOfTimeOrderDetails.handle(details);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void deleteWithOrderIdAndTimeId(final int orderId, final int timeId) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteWithOrderIdAndTimeId.acquire();
    int _argIndex = 1;
    _stmt.bindLong(_argIndex, orderId);
    _argIndex = 2;
    _stmt.bindLong(_argIndex, timeId);
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfDeleteWithOrderIdAndTimeId.release(_stmt);
    }
  }

  @Override
  public List<TimeOrderDetails> getAll() {
    final String _sql = "SELECT * FROM TIMEORDERDETAILS";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfOrderId = CursorUtil.getColumnIndexOrThrow(_cursor, "orderId");
      final int _cursorIndexOfTimeId = CursorUtil.getColumnIndexOrThrow(_cursor, "timeId");
      final List<TimeOrderDetails> _result = new ArrayList<TimeOrderDetails>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final TimeOrderDetails _item;
        _item = new TimeOrderDetails();
        final int _tmpId;
        _tmpId = _cursor.getInt(_cursorIndexOfId);
        _item.setId(_tmpId);
        final int _tmpOrderId;
        _tmpOrderId = _cursor.getInt(_cursorIndexOfOrderId);
        _item.setOrderId(_tmpOrderId);
        final int _tmpTimeId;
        _tmpTimeId = _cursor.getInt(_cursorIndexOfTimeId);
        _item.setTimeId(_tmpTimeId);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<TimeOrderDetails> getTimeOrderWithOrderId(final int id) {
    final String _sql = "SELECT * FROM TIMEORDERDETAILS WHERE orderId = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, id);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfOrderId = CursorUtil.getColumnIndexOrThrow(_cursor, "orderId");
      final int _cursorIndexOfTimeId = CursorUtil.getColumnIndexOrThrow(_cursor, "timeId");
      final List<TimeOrderDetails> _result = new ArrayList<TimeOrderDetails>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final TimeOrderDetails _item;
        _item = new TimeOrderDetails();
        final int _tmpId;
        _tmpId = _cursor.getInt(_cursorIndexOfId);
        _item.setId(_tmpId);
        final int _tmpOrderId;
        _tmpOrderId = _cursor.getInt(_cursorIndexOfOrderId);
        _item.setOrderId(_tmpOrderId);
        final int _tmpTimeId;
        _tmpTimeId = _cursor.getInt(_cursorIndexOfTimeId);
        _item.setTimeId(_tmpTimeId);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<TimeOrderDetails> getTimeOrderWithOrderId(final String date, final int pitchId,
      final int id) {
    final String _sql = "SELECT * FROM TIMEORDERDETAILS INNER JOIN ORDERS ON TIMEORDERDETAILS.orderId = ORDERS.id WHERE ORDERS.datePlay = ? AND ORDERS.pitchId = ? AND ORDERS.id = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 3);
    int _argIndex = 1;
    if (date == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, date);
    }
    _argIndex = 2;
    _statement.bindLong(_argIndex, pitchId);
    _argIndex = 3;
    _statement.bindLong(_argIndex, id);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfOrderId = CursorUtil.getColumnIndexOrThrow(_cursor, "orderId");
      final int _cursorIndexOfTimeId = CursorUtil.getColumnIndexOrThrow(_cursor, "timeId");
      final int _cursorIndexOfId_1 = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final List<TimeOrderDetails> _result = new ArrayList<TimeOrderDetails>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final TimeOrderDetails _item;
        _item = new TimeOrderDetails();
        final int _tmpId;
        _tmpId = _cursor.getInt(_cursorIndexOfId);
        _item.setId(_tmpId);
        final int _tmpOrderId;
        _tmpOrderId = _cursor.getInt(_cursorIndexOfOrderId);
        _item.setOrderId(_tmpOrderId);
        final int _tmpTimeId;
        _tmpTimeId = _cursor.getInt(_cursorIndexOfTimeId);
        _item.setTimeId(_tmpTimeId);
        final int _tmpId_1;
        _tmpId_1 = _cursor.getInt(_cursorIndexOfId_1);
        _item.setId(_tmpId_1);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<TimeOrderDetails> getTimeOrderWithDateAndPitch(final String date, final int pitchId,
      final int status) {
    final String _sql = "SELECT * FROM TIMEORDERDETAILS INNER JOIN ORDERS ON TIMEORDERDETAILS.orderId = ORDERS.id WHERE ORDERS.datePlay = ? AND ORDERS.pitchId = ? AND ORDERS.status != ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 3);
    int _argIndex = 1;
    if (date == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, date);
    }
    _argIndex = 2;
    _statement.bindLong(_argIndex, pitchId);
    _argIndex = 3;
    _statement.bindLong(_argIndex, status);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfOrderId = CursorUtil.getColumnIndexOrThrow(_cursor, "orderId");
      final int _cursorIndexOfTimeId = CursorUtil.getColumnIndexOrThrow(_cursor, "timeId");
      final int _cursorIndexOfId_1 = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final List<TimeOrderDetails> _result = new ArrayList<TimeOrderDetails>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final TimeOrderDetails _item;
        _item = new TimeOrderDetails();
        final int _tmpId;
        _tmpId = _cursor.getInt(_cursorIndexOfId);
        _item.setId(_tmpId);
        final int _tmpOrderId;
        _tmpOrderId = _cursor.getInt(_cursorIndexOfOrderId);
        _item.setOrderId(_tmpOrderId);
        final int _tmpTimeId;
        _tmpTimeId = _cursor.getInt(_cursorIndexOfTimeId);
        _item.setTimeId(_tmpTimeId);
        final int _tmpId_1;
        _tmpId_1 = _cursor.getInt(_cursorIndexOfId_1);
        _item.setId(_tmpId_1);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public Cursor getInfoTime(final String date) {
    final String _sql = "SELECT MYTIME.name,COUNT(MYTIME.ID) FROM MYTIME INNER JOIN TIMEORDERDETAILS ON MYTIME.id = TIMEORDERDETAILS.timeId INNER JOIN ORDERS ON TIMEORDERDETAILS.orderId = ORDERS.id WHERE ORDERS.dateCreate LIKE ? GROUP BY MYTIME.ID";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (date == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, date);
    }
    final Cursor _tmpResult = __db.query(_statement);
    return _tmpResult;
  }

  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}

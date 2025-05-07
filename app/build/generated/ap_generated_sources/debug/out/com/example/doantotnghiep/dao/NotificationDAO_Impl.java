package com.example.doantotnghiep.dao;

import android.database.Cursor;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.example.doantotnghiep.model.MyNotification;
import java.lang.Class;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@SuppressWarnings({"unchecked", "deprecation"})
public final class NotificationDAO_Impl implements NotificationDAO {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<MyNotification> __insertionAdapterOfMyNotification;

  private final EntityDeletionOrUpdateAdapter<MyNotification> __deletionAdapterOfMyNotification;

  private final EntityDeletionOrUpdateAdapter<MyNotification> __updateAdapterOfMyNotification;

  public NotificationDAO_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfMyNotification = new EntityInsertionAdapter<MyNotification>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `MY_NOTIFICATION` (`id`,`title`,`content`,`date`,`status`) VALUES (nullif(?, 0),?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, MyNotification value) {
        stmt.bindLong(1, value.getId());
        if (value.getTitle() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getTitle());
        }
        if (value.getContent() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getContent());
        }
        if (value.getDate() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getDate());
        }
        stmt.bindLong(5, value.getStatus());
      }
    };
    this.__deletionAdapterOfMyNotification = new EntityDeletionOrUpdateAdapter<MyNotification>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `MY_NOTIFICATION` WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, MyNotification value) {
        stmt.bindLong(1, value.getId());
      }
    };
    this.__updateAdapterOfMyNotification = new EntityDeletionOrUpdateAdapter<MyNotification>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `MY_NOTIFICATION` SET `id` = ?,`title` = ?,`content` = ?,`date` = ?,`status` = ? WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, MyNotification value) {
        stmt.bindLong(1, value.getId());
        if (value.getTitle() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getTitle());
        }
        if (value.getContent() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getContent());
        }
        if (value.getDate() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getDate());
        }
        stmt.bindLong(5, value.getStatus());
        stmt.bindLong(6, value.getId());
      }
    };
  }

  @Override
  public void insert(final MyNotification notification) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfMyNotification.insert(notification);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void delete(final MyNotification notification) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __deletionAdapterOfMyNotification.handle(notification);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void update(final MyNotification notification) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __updateAdapterOfMyNotification.handle(notification);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public List<MyNotification> getALl() {
    final String _sql = "SELECT * FROM MY_NOTIFICATION ORDER BY MY_NOTIFICATION.id DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfTitle = CursorUtil.getColumnIndexOrThrow(_cursor, "title");
      final int _cursorIndexOfContent = CursorUtil.getColumnIndexOrThrow(_cursor, "content");
      final int _cursorIndexOfDate = CursorUtil.getColumnIndexOrThrow(_cursor, "date");
      final int _cursorIndexOfStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "status");
      final List<MyNotification> _result = new ArrayList<MyNotification>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final MyNotification _item;
        _item = new MyNotification();
        final int _tmpId;
        _tmpId = _cursor.getInt(_cursorIndexOfId);
        _item.setId(_tmpId);
        final String _tmpTitle;
        if (_cursor.isNull(_cursorIndexOfTitle)) {
          _tmpTitle = null;
        } else {
          _tmpTitle = _cursor.getString(_cursorIndexOfTitle);
        }
        _item.setTitle(_tmpTitle);
        final String _tmpContent;
        if (_cursor.isNull(_cursorIndexOfContent)) {
          _tmpContent = null;
        } else {
          _tmpContent = _cursor.getString(_cursorIndexOfContent);
        }
        _item.setContent(_tmpContent);
        final String _tmpDate;
        if (_cursor.isNull(_cursorIndexOfDate)) {
          _tmpDate = null;
        } else {
          _tmpDate = _cursor.getString(_cursorIndexOfDate);
        }
        _item.setDate(_tmpDate);
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
  public List<MyNotification> getNotifiWithCusId(final int id, final int status) {
    final String _sql = "SELECT * FROM MY_NOTIFICATION INNER JOIN NOTIFICATIONDETAILS ON MY_NOTIFICATION.id = NOTIFICATIONDETAILS.notificationId INNER JOIN CUSTOMER ON NOTIFICATIONDETAILS.customerId = CUSTOMER.id WHERE CUSTOMER.id = ? AND status = ? ORDER BY MY_NOTIFICATION.id DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 2);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, id);
    _argIndex = 2;
    _statement.bindLong(_argIndex, status);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfTitle = CursorUtil.getColumnIndexOrThrow(_cursor, "title");
      final int _cursorIndexOfContent = CursorUtil.getColumnIndexOrThrow(_cursor, "content");
      final int _cursorIndexOfDate = CursorUtil.getColumnIndexOrThrow(_cursor, "date");
      final int _cursorIndexOfStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "status");
      final int _cursorIndexOfId_1 = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfId_2 = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final List<MyNotification> _result = new ArrayList<MyNotification>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final MyNotification _item;
        _item = new MyNotification();
        final int _tmpId;
        _tmpId = _cursor.getInt(_cursorIndexOfId);
        _item.setId(_tmpId);
        final String _tmpTitle;
        if (_cursor.isNull(_cursorIndexOfTitle)) {
          _tmpTitle = null;
        } else {
          _tmpTitle = _cursor.getString(_cursorIndexOfTitle);
        }
        _item.setTitle(_tmpTitle);
        final String _tmpContent;
        if (_cursor.isNull(_cursorIndexOfContent)) {
          _tmpContent = null;
        } else {
          _tmpContent = _cursor.getString(_cursorIndexOfContent);
        }
        _item.setContent(_tmpContent);
        final String _tmpDate;
        if (_cursor.isNull(_cursorIndexOfDate)) {
          _tmpDate = null;
        } else {
          _tmpDate = _cursor.getString(_cursorIndexOfDate);
        }
        _item.setDate(_tmpDate);
        final int _tmpStatus;
        _tmpStatus = _cursor.getInt(_cursorIndexOfStatus);
        _item.setStatus(_tmpStatus);
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

  @Override
  public int getNewNotification() {
    final String _sql = "SELECT MAX(id) FROM MY_NOTIFICATION";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _result;
      if(_cursor.moveToFirst()) {
        _result = _cursor.getInt(0);
      } else {
        _result = 0;
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

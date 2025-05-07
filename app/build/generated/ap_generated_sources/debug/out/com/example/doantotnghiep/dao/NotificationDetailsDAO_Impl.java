package com.example.doantotnghiep.dao;

import android.database.Cursor;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.example.doantotnghiep.model.NotificationDetails;
import java.lang.Class;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@SuppressWarnings({"unchecked", "deprecation"})
public final class NotificationDetailsDAO_Impl implements NotificationDetailsDAO {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<NotificationDetails> __insertionAdapterOfNotificationDetails;

  private final EntityDeletionOrUpdateAdapter<NotificationDetails> __deletionAdapterOfNotificationDetails;

  private final EntityDeletionOrUpdateAdapter<NotificationDetails> __updateAdapterOfNotificationDetails;

  public NotificationDetailsDAO_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfNotificationDetails = new EntityInsertionAdapter<NotificationDetails>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `NotificationDetails` (`id`,`customerId`,`notificationId`) VALUES (nullif(?, 0),?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, NotificationDetails value) {
        stmt.bindLong(1, value.getId());
        stmt.bindLong(2, value.getCustomerId());
        stmt.bindLong(3, value.getNotificationId());
      }
    };
    this.__deletionAdapterOfNotificationDetails = new EntityDeletionOrUpdateAdapter<NotificationDetails>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `NotificationDetails` WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, NotificationDetails value) {
        stmt.bindLong(1, value.getId());
      }
    };
    this.__updateAdapterOfNotificationDetails = new EntityDeletionOrUpdateAdapter<NotificationDetails>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `NotificationDetails` SET `id` = ?,`customerId` = ?,`notificationId` = ? WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, NotificationDetails value) {
        stmt.bindLong(1, value.getId());
        stmt.bindLong(2, value.getCustomerId());
        stmt.bindLong(3, value.getNotificationId());
        stmt.bindLong(4, value.getId());
      }
    };
  }

  @Override
  public void insert(final NotificationDetails details) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfNotificationDetails.insert(details);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void delete(final NotificationDetails details) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __deletionAdapterOfNotificationDetails.handle(details);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void update(final NotificationDetails details) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __updateAdapterOfNotificationDetails.handle(details);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public List<NotificationDetails> getAll() {
    final String _sql = "SELECT * FROM NOTIFICATIONDETAILS";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfCustomerId = CursorUtil.getColumnIndexOrThrow(_cursor, "customerId");
      final int _cursorIndexOfNotificationId = CursorUtil.getColumnIndexOrThrow(_cursor, "notificationId");
      final List<NotificationDetails> _result = new ArrayList<NotificationDetails>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final NotificationDetails _item;
        _item = new NotificationDetails();
        final int _tmpId;
        _tmpId = _cursor.getInt(_cursorIndexOfId);
        _item.setId(_tmpId);
        final int _tmpCustomerId;
        _tmpCustomerId = _cursor.getInt(_cursorIndexOfCustomerId);
        _item.setCustomerId(_tmpCustomerId);
        final int _tmpNotificationId;
        _tmpNotificationId = _cursor.getInt(_cursorIndexOfNotificationId);
        _item.setNotificationId(_tmpNotificationId);
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

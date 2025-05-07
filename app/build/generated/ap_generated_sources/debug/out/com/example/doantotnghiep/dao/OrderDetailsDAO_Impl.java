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
import com.example.doantotnghiep.model.OrderDetails;
import java.lang.Class;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@SuppressWarnings({"unchecked", "deprecation"})
public final class OrderDetailsDAO_Impl implements OrderDetailsDAO {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<OrderDetails> __insertionAdapterOfOrderDetails;

  private final EntityDeletionOrUpdateAdapter<OrderDetails> __deletionAdapterOfOrderDetails;

  private final EntityDeletionOrUpdateAdapter<OrderDetails> __updateAdapterOfOrderDetails;

  private final SharedSQLiteStatement __preparedStmtOfDeleteWithOrderId;

  public OrderDetailsDAO_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfOrderDetails = new EntityInsertionAdapter<OrderDetails>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `ORDER_DETAILS` (`id`,`orderId`,`serviceId`,`soLuong`,`tongTien`) VALUES (nullif(?, 0),?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, OrderDetails value) {
        stmt.bindLong(1, value.getId());
        stmt.bindLong(2, value.getOrderId());
        stmt.bindLong(3, value.getServiceId());
        stmt.bindLong(4, value.getSoLuong());
        stmt.bindLong(5, value.getTongTien());
      }
    };
    this.__deletionAdapterOfOrderDetails = new EntityDeletionOrUpdateAdapter<OrderDetails>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `ORDER_DETAILS` WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, OrderDetails value) {
        stmt.bindLong(1, value.getId());
      }
    };
    this.__updateAdapterOfOrderDetails = new EntityDeletionOrUpdateAdapter<OrderDetails>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `ORDER_DETAILS` SET `id` = ?,`orderId` = ?,`serviceId` = ?,`soLuong` = ?,`tongTien` = ? WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, OrderDetails value) {
        stmt.bindLong(1, value.getId());
        stmt.bindLong(2, value.getOrderId());
        stmt.bindLong(3, value.getServiceId());
        stmt.bindLong(4, value.getSoLuong());
        stmt.bindLong(5, value.getTongTien());
        stmt.bindLong(6, value.getId());
      }
    };
    this.__preparedStmtOfDeleteWithOrderId = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM ORDER_DETAILS WHERE orderId = ?";
        return _query;
      }
    };
  }

  @Override
  public void insert(final OrderDetails details) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfOrderDetails.insert(details);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void delete(final OrderDetails details) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __deletionAdapterOfOrderDetails.handle(details);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void update(final OrderDetails details) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __updateAdapterOfOrderDetails.handle(details);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void deleteWithOrderId(final int orderId) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteWithOrderId.acquire();
    int _argIndex = 1;
    _stmt.bindLong(_argIndex, orderId);
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfDeleteWithOrderId.release(_stmt);
    }
  }

  @Override
  public List<OrderDetails> getAll() {
    final String _sql = "SELECT * FROM ORDER_DETAILS";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfOrderId = CursorUtil.getColumnIndexOrThrow(_cursor, "orderId");
      final int _cursorIndexOfServiceId = CursorUtil.getColumnIndexOrThrow(_cursor, "serviceId");
      final int _cursorIndexOfSoLuong = CursorUtil.getColumnIndexOrThrow(_cursor, "soLuong");
      final int _cursorIndexOfTongTien = CursorUtil.getColumnIndexOrThrow(_cursor, "tongTien");
      final List<OrderDetails> _result = new ArrayList<OrderDetails>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final OrderDetails _item;
        _item = new OrderDetails();
        final int _tmpId;
        _tmpId = _cursor.getInt(_cursorIndexOfId);
        _item.setId(_tmpId);
        final int _tmpOrderId;
        _tmpOrderId = _cursor.getInt(_cursorIndexOfOrderId);
        _item.setOrderId(_tmpOrderId);
        final int _tmpServiceId;
        _tmpServiceId = _cursor.getInt(_cursorIndexOfServiceId);
        _item.setServiceId(_tmpServiceId);
        final int _tmpSoLuong;
        _tmpSoLuong = _cursor.getInt(_cursorIndexOfSoLuong);
        _item.setSoLuong(_tmpSoLuong);
        final int _tmpTongTien;
        _tmpTongTien = _cursor.getInt(_cursorIndexOfTongTien);
        _item.setTongTien(_tmpTongTien);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<OrderDetails> getOrderDetailsByOrderId(final int orderId) {
    final String _sql = "SELECT * FROM ORDER_DETAILS WHERE orderId = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, orderId);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfOrderId = CursorUtil.getColumnIndexOrThrow(_cursor, "orderId");
      final int _cursorIndexOfServiceId = CursorUtil.getColumnIndexOrThrow(_cursor, "serviceId");
      final int _cursorIndexOfSoLuong = CursorUtil.getColumnIndexOrThrow(_cursor, "soLuong");
      final int _cursorIndexOfTongTien = CursorUtil.getColumnIndexOrThrow(_cursor, "tongTien");
      final List<OrderDetails> _result = new ArrayList<OrderDetails>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final OrderDetails _item;
        _item = new OrderDetails();
        final int _tmpId;
        _tmpId = _cursor.getInt(_cursorIndexOfId);
        _item.setId(_tmpId);
        final int _tmpOrderId;
        _tmpOrderId = _cursor.getInt(_cursorIndexOfOrderId);
        _item.setOrderId(_tmpOrderId);
        final int _tmpServiceId;
        _tmpServiceId = _cursor.getInt(_cursorIndexOfServiceId);
        _item.setServiceId(_tmpServiceId);
        final int _tmpSoLuong;
        _tmpSoLuong = _cursor.getInt(_cursorIndexOfSoLuong);
        _item.setSoLuong(_tmpSoLuong);
        final int _tmpTongTien;
        _tmpTongTien = _cursor.getInt(_cursorIndexOfTongTien);
        _item.setTongTien(_tmpTongTien);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<OrderDetails> getOrderDetailsWithId(final int id) {
    final String _sql = "SELECT * FROM ORDER_DETAILS WHERE orderId = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, id);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfOrderId = CursorUtil.getColumnIndexOrThrow(_cursor, "orderId");
      final int _cursorIndexOfServiceId = CursorUtil.getColumnIndexOrThrow(_cursor, "serviceId");
      final int _cursorIndexOfSoLuong = CursorUtil.getColumnIndexOrThrow(_cursor, "soLuong");
      final int _cursorIndexOfTongTien = CursorUtil.getColumnIndexOrThrow(_cursor, "tongTien");
      final List<OrderDetails> _result = new ArrayList<OrderDetails>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final OrderDetails _item;
        _item = new OrderDetails();
        final int _tmpId;
        _tmpId = _cursor.getInt(_cursorIndexOfId);
        _item.setId(_tmpId);
        final int _tmpOrderId;
        _tmpOrderId = _cursor.getInt(_cursorIndexOfOrderId);
        _item.setOrderId(_tmpOrderId);
        final int _tmpServiceId;
        _tmpServiceId = _cursor.getInt(_cursorIndexOfServiceId);
        _item.setServiceId(_tmpServiceId);
        final int _tmpSoLuong;
        _tmpSoLuong = _cursor.getInt(_cursorIndexOfSoLuong);
        _item.setSoLuong(_tmpSoLuong);
        final int _tmpTongTien;
        _tmpTongTien = _cursor.getInt(_cursorIndexOfTongTien);
        _item.setTongTien(_tmpTongTien);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public Cursor getInfoDoanhThuService(final String month) {
    final String _sql = "SELECT SERVICE.name,SUM(ORDER_DETAILS.tongTien) FROM SERVICE INNER JOIN ORDER_DETAILS ON SERVICE.id = ORDER_DETAILS.serviceId INNER JOIN ORDERS ON ORDER_DETAILS.orderId = ORDERS.id WHERE ORDERS.dateCreate LIKE ? GROUP BY ORDER_DETAILS.serviceId";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (month == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, month);
    }
    final Cursor _tmpResult = __db.query(_statement);
    return _tmpResult;
  }

  @Override
  public Cursor getInfoPopularService(final String month) {
    final String _sql = "SELECT SERVICE.name,COUNT(ORDER_DETAILS.serviceId) FROM SERVICE INNER JOIN ORDER_DETAILS ON SERVICE.id = ORDER_DETAILS.serviceId INNER JOIN ORDERS ON ORDER_DETAILS.orderId = ORDERS.id WHERE ORDERS.dateCreate LIKE ? GROUP BY ORDER_DETAILS.serviceId";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (month == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, month);
    }
    final Cursor _tmpResult = __db.query(_statement);
    return _tmpResult;
  }

  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}

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
import com.example.doantotnghiep.model.Order;
import java.lang.Class;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@SuppressWarnings({"unchecked", "deprecation"})
public final class OrderDAO_Impl implements OrderDAO {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<Order> __insertionAdapterOfOrder;

  private final EntityDeletionOrUpdateAdapter<Order> __deletionAdapterOfOrder;

  private final EntityDeletionOrUpdateAdapter<Order> __updateAdapterOfOrder;

  private final SharedSQLiteStatement __preparedStmtOfDeleteAll;

  public OrderDAO_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfOrder = new EntityInsertionAdapter<Order>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `ORDERS` (`id`,`managerId`,`customerId`,`pitchId`,`dateCreate`,`datePlay`,`totalPitchMoney`,`totalServiceMoney`,`chiPhiKhac`,`total`,`status`,`soCa`,`soLanCapNhat`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Order value) {
        stmt.bindLong(1, value.getId());
        stmt.bindLong(2, value.getManagerId());
        stmt.bindLong(3, value.getCustomerId());
        stmt.bindLong(4, value.getPitchId());
        if (value.getDateCreate() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getDateCreate());
        }
        if (value.getDatePlay() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getDatePlay());
        }
        stmt.bindLong(7, value.getTotalPitchMoney());
        stmt.bindLong(8, value.getTotalServiceMoney());
        stmt.bindLong(9, value.getChiPhiKhac());
        stmt.bindLong(10, value.getTotal());
        stmt.bindLong(11, value.getStatus());
        stmt.bindLong(12, value.getSoCa());
        stmt.bindLong(13, value.getSoLanCapNhat());
      }
    };
    this.__deletionAdapterOfOrder = new EntityDeletionOrUpdateAdapter<Order>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `ORDERS` WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Order value) {
        stmt.bindLong(1, value.getId());
      }
    };
    this.__updateAdapterOfOrder = new EntityDeletionOrUpdateAdapter<Order>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `ORDERS` SET `id` = ?,`managerId` = ?,`customerId` = ?,`pitchId` = ?,`dateCreate` = ?,`datePlay` = ?,`totalPitchMoney` = ?,`totalServiceMoney` = ?,`chiPhiKhac` = ?,`total` = ?,`status` = ?,`soCa` = ?,`soLanCapNhat` = ? WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Order value) {
        stmt.bindLong(1, value.getId());
        stmt.bindLong(2, value.getManagerId());
        stmt.bindLong(3, value.getCustomerId());
        stmt.bindLong(4, value.getPitchId());
        if (value.getDateCreate() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getDateCreate());
        }
        if (value.getDatePlay() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getDatePlay());
        }
        stmt.bindLong(7, value.getTotalPitchMoney());
        stmt.bindLong(8, value.getTotalServiceMoney());
        stmt.bindLong(9, value.getChiPhiKhac());
        stmt.bindLong(10, value.getTotal());
        stmt.bindLong(11, value.getStatus());
        stmt.bindLong(12, value.getSoCa());
        stmt.bindLong(13, value.getSoLanCapNhat());
        stmt.bindLong(14, value.getId());
      }
    };
    this.__preparedStmtOfDeleteAll = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM ORDERS";
        return _query;
      }
    };
  }

  @Override
  public void insert(final Order order) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfOrder.insert(order);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void delete(final Order order) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __deletionAdapterOfOrder.handle(order);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void update(final Order order) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __updateAdapterOfOrder.handle(order);
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
  public List<Order> getAll() {
    final String _sql = "SELECT * FROM ORDERS ORDER BY id DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfManagerId = CursorUtil.getColumnIndexOrThrow(_cursor, "managerId");
      final int _cursorIndexOfCustomerId = CursorUtil.getColumnIndexOrThrow(_cursor, "customerId");
      final int _cursorIndexOfPitchId = CursorUtil.getColumnIndexOrThrow(_cursor, "pitchId");
      final int _cursorIndexOfDateCreate = CursorUtil.getColumnIndexOrThrow(_cursor, "dateCreate");
      final int _cursorIndexOfDatePlay = CursorUtil.getColumnIndexOrThrow(_cursor, "datePlay");
      final int _cursorIndexOfTotalPitchMoney = CursorUtil.getColumnIndexOrThrow(_cursor, "totalPitchMoney");
      final int _cursorIndexOfTotalServiceMoney = CursorUtil.getColumnIndexOrThrow(_cursor, "totalServiceMoney");
      final int _cursorIndexOfChiPhiKhac = CursorUtil.getColumnIndexOrThrow(_cursor, "chiPhiKhac");
      final int _cursorIndexOfTotal = CursorUtil.getColumnIndexOrThrow(_cursor, "total");
      final int _cursorIndexOfStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "status");
      final int _cursorIndexOfSoCa = CursorUtil.getColumnIndexOrThrow(_cursor, "soCa");
      final int _cursorIndexOfSoLanCapNhat = CursorUtil.getColumnIndexOrThrow(_cursor, "soLanCapNhat");
      final List<Order> _result = new ArrayList<Order>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Order _item;
        _item = new Order();
        final int _tmpId;
        _tmpId = _cursor.getInt(_cursorIndexOfId);
        _item.setId(_tmpId);
        final int _tmpManagerId;
        _tmpManagerId = _cursor.getInt(_cursorIndexOfManagerId);
        _item.setManagerId(_tmpManagerId);
        final int _tmpCustomerId;
        _tmpCustomerId = _cursor.getInt(_cursorIndexOfCustomerId);
        _item.setCustomerId(_tmpCustomerId);
        final int _tmpPitchId;
        _tmpPitchId = _cursor.getInt(_cursorIndexOfPitchId);
        _item.setPitchId(_tmpPitchId);
        final String _tmpDateCreate;
        if (_cursor.isNull(_cursorIndexOfDateCreate)) {
          _tmpDateCreate = null;
        } else {
          _tmpDateCreate = _cursor.getString(_cursorIndexOfDateCreate);
        }
        _item.setDateCreate(_tmpDateCreate);
        final String _tmpDatePlay;
        if (_cursor.isNull(_cursorIndexOfDatePlay)) {
          _tmpDatePlay = null;
        } else {
          _tmpDatePlay = _cursor.getString(_cursorIndexOfDatePlay);
        }
        _item.setDatePlay(_tmpDatePlay);
        final int _tmpTotalPitchMoney;
        _tmpTotalPitchMoney = _cursor.getInt(_cursorIndexOfTotalPitchMoney);
        _item.setTotalPitchMoney(_tmpTotalPitchMoney);
        final int _tmpTotalServiceMoney;
        _tmpTotalServiceMoney = _cursor.getInt(_cursorIndexOfTotalServiceMoney);
        _item.setTotalServiceMoney(_tmpTotalServiceMoney);
        final int _tmpChiPhiKhac;
        _tmpChiPhiKhac = _cursor.getInt(_cursorIndexOfChiPhiKhac);
        _item.setChiPhiKhac(_tmpChiPhiKhac);
        final int _tmpTotal;
        _tmpTotal = _cursor.getInt(_cursorIndexOfTotal);
        _item.setTotal(_tmpTotal);
        final int _tmpStatus;
        _tmpStatus = _cursor.getInt(_cursorIndexOfStatus);
        _item.setStatus(_tmpStatus);
        final int _tmpSoCa;
        _tmpSoCa = _cursor.getInt(_cursorIndexOfSoCa);
        _item.setSoCa(_tmpSoCa);
        final int _tmpSoLanCapNhat;
        _tmpSoLanCapNhat = _cursor.getInt(_cursorIndexOfSoLanCapNhat);
        _item.setSoLanCapNhat(_tmpSoLanCapNhat);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<Order> getOrderWithPitchAndDate(final int pitchId, final String date) {
    final String _sql = "SELECT * FROM ORDERS WHERE pitchId = ? AND datePlay = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 2);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, pitchId);
    _argIndex = 2;
    if (date == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, date);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfManagerId = CursorUtil.getColumnIndexOrThrow(_cursor, "managerId");
      final int _cursorIndexOfCustomerId = CursorUtil.getColumnIndexOrThrow(_cursor, "customerId");
      final int _cursorIndexOfPitchId = CursorUtil.getColumnIndexOrThrow(_cursor, "pitchId");
      final int _cursorIndexOfDateCreate = CursorUtil.getColumnIndexOrThrow(_cursor, "dateCreate");
      final int _cursorIndexOfDatePlay = CursorUtil.getColumnIndexOrThrow(_cursor, "datePlay");
      final int _cursorIndexOfTotalPitchMoney = CursorUtil.getColumnIndexOrThrow(_cursor, "totalPitchMoney");
      final int _cursorIndexOfTotalServiceMoney = CursorUtil.getColumnIndexOrThrow(_cursor, "totalServiceMoney");
      final int _cursorIndexOfChiPhiKhac = CursorUtil.getColumnIndexOrThrow(_cursor, "chiPhiKhac");
      final int _cursorIndexOfTotal = CursorUtil.getColumnIndexOrThrow(_cursor, "total");
      final int _cursorIndexOfStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "status");
      final int _cursorIndexOfSoCa = CursorUtil.getColumnIndexOrThrow(_cursor, "soCa");
      final int _cursorIndexOfSoLanCapNhat = CursorUtil.getColumnIndexOrThrow(_cursor, "soLanCapNhat");
      final List<Order> _result = new ArrayList<Order>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Order _item;
        _item = new Order();
        final int _tmpId;
        _tmpId = _cursor.getInt(_cursorIndexOfId);
        _item.setId(_tmpId);
        final int _tmpManagerId;
        _tmpManagerId = _cursor.getInt(_cursorIndexOfManagerId);
        _item.setManagerId(_tmpManagerId);
        final int _tmpCustomerId;
        _tmpCustomerId = _cursor.getInt(_cursorIndexOfCustomerId);
        _item.setCustomerId(_tmpCustomerId);
        final int _tmpPitchId;
        _tmpPitchId = _cursor.getInt(_cursorIndexOfPitchId);
        _item.setPitchId(_tmpPitchId);
        final String _tmpDateCreate;
        if (_cursor.isNull(_cursorIndexOfDateCreate)) {
          _tmpDateCreate = null;
        } else {
          _tmpDateCreate = _cursor.getString(_cursorIndexOfDateCreate);
        }
        _item.setDateCreate(_tmpDateCreate);
        final String _tmpDatePlay;
        if (_cursor.isNull(_cursorIndexOfDatePlay)) {
          _tmpDatePlay = null;
        } else {
          _tmpDatePlay = _cursor.getString(_cursorIndexOfDatePlay);
        }
        _item.setDatePlay(_tmpDatePlay);
        final int _tmpTotalPitchMoney;
        _tmpTotalPitchMoney = _cursor.getInt(_cursorIndexOfTotalPitchMoney);
        _item.setTotalPitchMoney(_tmpTotalPitchMoney);
        final int _tmpTotalServiceMoney;
        _tmpTotalServiceMoney = _cursor.getInt(_cursorIndexOfTotalServiceMoney);
        _item.setTotalServiceMoney(_tmpTotalServiceMoney);
        final int _tmpChiPhiKhac;
        _tmpChiPhiKhac = _cursor.getInt(_cursorIndexOfChiPhiKhac);
        _item.setChiPhiKhac(_tmpChiPhiKhac);
        final int _tmpTotal;
        _tmpTotal = _cursor.getInt(_cursorIndexOfTotal);
        _item.setTotal(_tmpTotal);
        final int _tmpStatus;
        _tmpStatus = _cursor.getInt(_cursorIndexOfStatus);
        _item.setStatus(_tmpStatus);
        final int _tmpSoCa;
        _tmpSoCa = _cursor.getInt(_cursorIndexOfSoCa);
        _item.setSoCa(_tmpSoCa);
        final int _tmpSoLanCapNhat;
        _tmpSoLanCapNhat = _cursor.getInt(_cursorIndexOfSoLanCapNhat);
        _item.setSoLanCapNhat(_tmpSoLanCapNhat);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public int getIdMax() {
    final String _sql = "SELECT MAX(id) FROM ORDERS";
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

  @Override
  public List<Order> getOrderWithID(final int id) {
    final String _sql = "SELECT * FROM ORDERS WHERE ID = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, id);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfManagerId = CursorUtil.getColumnIndexOrThrow(_cursor, "managerId");
      final int _cursorIndexOfCustomerId = CursorUtil.getColumnIndexOrThrow(_cursor, "customerId");
      final int _cursorIndexOfPitchId = CursorUtil.getColumnIndexOrThrow(_cursor, "pitchId");
      final int _cursorIndexOfDateCreate = CursorUtil.getColumnIndexOrThrow(_cursor, "dateCreate");
      final int _cursorIndexOfDatePlay = CursorUtil.getColumnIndexOrThrow(_cursor, "datePlay");
      final int _cursorIndexOfTotalPitchMoney = CursorUtil.getColumnIndexOrThrow(_cursor, "totalPitchMoney");
      final int _cursorIndexOfTotalServiceMoney = CursorUtil.getColumnIndexOrThrow(_cursor, "totalServiceMoney");
      final int _cursorIndexOfChiPhiKhac = CursorUtil.getColumnIndexOrThrow(_cursor, "chiPhiKhac");
      final int _cursorIndexOfTotal = CursorUtil.getColumnIndexOrThrow(_cursor, "total");
      final int _cursorIndexOfStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "status");
      final int _cursorIndexOfSoCa = CursorUtil.getColumnIndexOrThrow(_cursor, "soCa");
      final int _cursorIndexOfSoLanCapNhat = CursorUtil.getColumnIndexOrThrow(_cursor, "soLanCapNhat");
      final List<Order> _result = new ArrayList<Order>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Order _item;
        _item = new Order();
        final int _tmpId;
        _tmpId = _cursor.getInt(_cursorIndexOfId);
        _item.setId(_tmpId);
        final int _tmpManagerId;
        _tmpManagerId = _cursor.getInt(_cursorIndexOfManagerId);
        _item.setManagerId(_tmpManagerId);
        final int _tmpCustomerId;
        _tmpCustomerId = _cursor.getInt(_cursorIndexOfCustomerId);
        _item.setCustomerId(_tmpCustomerId);
        final int _tmpPitchId;
        _tmpPitchId = _cursor.getInt(_cursorIndexOfPitchId);
        _item.setPitchId(_tmpPitchId);
        final String _tmpDateCreate;
        if (_cursor.isNull(_cursorIndexOfDateCreate)) {
          _tmpDateCreate = null;
        } else {
          _tmpDateCreate = _cursor.getString(_cursorIndexOfDateCreate);
        }
        _item.setDateCreate(_tmpDateCreate);
        final String _tmpDatePlay;
        if (_cursor.isNull(_cursorIndexOfDatePlay)) {
          _tmpDatePlay = null;
        } else {
          _tmpDatePlay = _cursor.getString(_cursorIndexOfDatePlay);
        }
        _item.setDatePlay(_tmpDatePlay);
        final int _tmpTotalPitchMoney;
        _tmpTotalPitchMoney = _cursor.getInt(_cursorIndexOfTotalPitchMoney);
        _item.setTotalPitchMoney(_tmpTotalPitchMoney);
        final int _tmpTotalServiceMoney;
        _tmpTotalServiceMoney = _cursor.getInt(_cursorIndexOfTotalServiceMoney);
        _item.setTotalServiceMoney(_tmpTotalServiceMoney);
        final int _tmpChiPhiKhac;
        _tmpChiPhiKhac = _cursor.getInt(_cursorIndexOfChiPhiKhac);
        _item.setChiPhiKhac(_tmpChiPhiKhac);
        final int _tmpTotal;
        _tmpTotal = _cursor.getInt(_cursorIndexOfTotal);
        _item.setTotal(_tmpTotal);
        final int _tmpStatus;
        _tmpStatus = _cursor.getInt(_cursorIndexOfStatus);
        _item.setStatus(_tmpStatus);
        final int _tmpSoCa;
        _tmpSoCa = _cursor.getInt(_cursorIndexOfSoCa);
        _item.setSoCa(_tmpSoCa);
        final int _tmpSoLanCapNhat;
        _tmpSoLanCapNhat = _cursor.getInt(_cursorIndexOfSoLanCapNhat);
        _item.setSoLanCapNhat(_tmpSoLanCapNhat);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public int getDoanhThuWithDate(final String date) {
    final String _sql = "SELECT SUM(total) FROM ORDERS WHERE dateCreate LIKE ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (date == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, date);
    }
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

  @Override
  public Cursor getDoanhThuPitch(final String date) {
    final String _sql = "SELECT PITCH.name,SUM(ORDERS.totalPitchMoney) FROM PITCH INNER JOIN ORDERS ON PITCH.id = ORDERS.pitchId WHERE ORDERS.dateCreate LIKE ? GROUP BY ORDERS.pitchId";
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

  @Override
  public Cursor getPopularPitch(final String date) {
    final String _sql = "SELECT PITCH.name,COUNT(ORDERS.pitchId) FROM PITCH INNER JOIN ORDERS ON PITCH.id = ORDERS.pitchId WHERE ORDERS.dateCreate LIKE ? GROUP BY ORDERS.pitchId";
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

  @Override
  public List<Order> getOrderWithCustomerId(final int customerId) {
    final String _sql = "SELECT * FROM ORDERS WHERE customerId == ? ORDER BY id DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, customerId);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfManagerId = CursorUtil.getColumnIndexOrThrow(_cursor, "managerId");
      final int _cursorIndexOfCustomerId = CursorUtil.getColumnIndexOrThrow(_cursor, "customerId");
      final int _cursorIndexOfPitchId = CursorUtil.getColumnIndexOrThrow(_cursor, "pitchId");
      final int _cursorIndexOfDateCreate = CursorUtil.getColumnIndexOrThrow(_cursor, "dateCreate");
      final int _cursorIndexOfDatePlay = CursorUtil.getColumnIndexOrThrow(_cursor, "datePlay");
      final int _cursorIndexOfTotalPitchMoney = CursorUtil.getColumnIndexOrThrow(_cursor, "totalPitchMoney");
      final int _cursorIndexOfTotalServiceMoney = CursorUtil.getColumnIndexOrThrow(_cursor, "totalServiceMoney");
      final int _cursorIndexOfChiPhiKhac = CursorUtil.getColumnIndexOrThrow(_cursor, "chiPhiKhac");
      final int _cursorIndexOfTotal = CursorUtil.getColumnIndexOrThrow(_cursor, "total");
      final int _cursorIndexOfStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "status");
      final int _cursorIndexOfSoCa = CursorUtil.getColumnIndexOrThrow(_cursor, "soCa");
      final int _cursorIndexOfSoLanCapNhat = CursorUtil.getColumnIndexOrThrow(_cursor, "soLanCapNhat");
      final List<Order> _result = new ArrayList<Order>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Order _item;
        _item = new Order();
        final int _tmpId;
        _tmpId = _cursor.getInt(_cursorIndexOfId);
        _item.setId(_tmpId);
        final int _tmpManagerId;
        _tmpManagerId = _cursor.getInt(_cursorIndexOfManagerId);
        _item.setManagerId(_tmpManagerId);
        final int _tmpCustomerId;
        _tmpCustomerId = _cursor.getInt(_cursorIndexOfCustomerId);
        _item.setCustomerId(_tmpCustomerId);
        final int _tmpPitchId;
        _tmpPitchId = _cursor.getInt(_cursorIndexOfPitchId);
        _item.setPitchId(_tmpPitchId);
        final String _tmpDateCreate;
        if (_cursor.isNull(_cursorIndexOfDateCreate)) {
          _tmpDateCreate = null;
        } else {
          _tmpDateCreate = _cursor.getString(_cursorIndexOfDateCreate);
        }
        _item.setDateCreate(_tmpDateCreate);
        final String _tmpDatePlay;
        if (_cursor.isNull(_cursorIndexOfDatePlay)) {
          _tmpDatePlay = null;
        } else {
          _tmpDatePlay = _cursor.getString(_cursorIndexOfDatePlay);
        }
        _item.setDatePlay(_tmpDatePlay);
        final int _tmpTotalPitchMoney;
        _tmpTotalPitchMoney = _cursor.getInt(_cursorIndexOfTotalPitchMoney);
        _item.setTotalPitchMoney(_tmpTotalPitchMoney);
        final int _tmpTotalServiceMoney;
        _tmpTotalServiceMoney = _cursor.getInt(_cursorIndexOfTotalServiceMoney);
        _item.setTotalServiceMoney(_tmpTotalServiceMoney);
        final int _tmpChiPhiKhac;
        _tmpChiPhiKhac = _cursor.getInt(_cursorIndexOfChiPhiKhac);
        _item.setChiPhiKhac(_tmpChiPhiKhac);
        final int _tmpTotal;
        _tmpTotal = _cursor.getInt(_cursorIndexOfTotal);
        _item.setTotal(_tmpTotal);
        final int _tmpStatus;
        _tmpStatus = _cursor.getInt(_cursorIndexOfStatus);
        _item.setStatus(_tmpStatus);
        final int _tmpSoCa;
        _tmpSoCa = _cursor.getInt(_cursorIndexOfSoCa);
        _item.setSoCa(_tmpSoCa);
        final int _tmpSoLanCapNhat;
        _tmpSoLanCapNhat = _cursor.getInt(_cursorIndexOfSoLanCapNhat);
        _item.setSoLanCapNhat(_tmpSoLanCapNhat);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<Order> getOrderWithCustomerIdAndStatus(final int id, final int status) {
    final String _sql = "SELECT * FROM ORDERS WHERE customerId == ? AND status =? ORDER BY id DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 2);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, id);
    _argIndex = 2;
    _statement.bindLong(_argIndex, status);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfManagerId = CursorUtil.getColumnIndexOrThrow(_cursor, "managerId");
      final int _cursorIndexOfCustomerId = CursorUtil.getColumnIndexOrThrow(_cursor, "customerId");
      final int _cursorIndexOfPitchId = CursorUtil.getColumnIndexOrThrow(_cursor, "pitchId");
      final int _cursorIndexOfDateCreate = CursorUtil.getColumnIndexOrThrow(_cursor, "dateCreate");
      final int _cursorIndexOfDatePlay = CursorUtil.getColumnIndexOrThrow(_cursor, "datePlay");
      final int _cursorIndexOfTotalPitchMoney = CursorUtil.getColumnIndexOrThrow(_cursor, "totalPitchMoney");
      final int _cursorIndexOfTotalServiceMoney = CursorUtil.getColumnIndexOrThrow(_cursor, "totalServiceMoney");
      final int _cursorIndexOfChiPhiKhac = CursorUtil.getColumnIndexOrThrow(_cursor, "chiPhiKhac");
      final int _cursorIndexOfTotal = CursorUtil.getColumnIndexOrThrow(_cursor, "total");
      final int _cursorIndexOfStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "status");
      final int _cursorIndexOfSoCa = CursorUtil.getColumnIndexOrThrow(_cursor, "soCa");
      final int _cursorIndexOfSoLanCapNhat = CursorUtil.getColumnIndexOrThrow(_cursor, "soLanCapNhat");
      final List<Order> _result = new ArrayList<Order>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Order _item;
        _item = new Order();
        final int _tmpId;
        _tmpId = _cursor.getInt(_cursorIndexOfId);
        _item.setId(_tmpId);
        final int _tmpManagerId;
        _tmpManagerId = _cursor.getInt(_cursorIndexOfManagerId);
        _item.setManagerId(_tmpManagerId);
        final int _tmpCustomerId;
        _tmpCustomerId = _cursor.getInt(_cursorIndexOfCustomerId);
        _item.setCustomerId(_tmpCustomerId);
        final int _tmpPitchId;
        _tmpPitchId = _cursor.getInt(_cursorIndexOfPitchId);
        _item.setPitchId(_tmpPitchId);
        final String _tmpDateCreate;
        if (_cursor.isNull(_cursorIndexOfDateCreate)) {
          _tmpDateCreate = null;
        } else {
          _tmpDateCreate = _cursor.getString(_cursorIndexOfDateCreate);
        }
        _item.setDateCreate(_tmpDateCreate);
        final String _tmpDatePlay;
        if (_cursor.isNull(_cursorIndexOfDatePlay)) {
          _tmpDatePlay = null;
        } else {
          _tmpDatePlay = _cursor.getString(_cursorIndexOfDatePlay);
        }
        _item.setDatePlay(_tmpDatePlay);
        final int _tmpTotalPitchMoney;
        _tmpTotalPitchMoney = _cursor.getInt(_cursorIndexOfTotalPitchMoney);
        _item.setTotalPitchMoney(_tmpTotalPitchMoney);
        final int _tmpTotalServiceMoney;
        _tmpTotalServiceMoney = _cursor.getInt(_cursorIndexOfTotalServiceMoney);
        _item.setTotalServiceMoney(_tmpTotalServiceMoney);
        final int _tmpChiPhiKhac;
        _tmpChiPhiKhac = _cursor.getInt(_cursorIndexOfChiPhiKhac);
        _item.setChiPhiKhac(_tmpChiPhiKhac);
        final int _tmpTotal;
        _tmpTotal = _cursor.getInt(_cursorIndexOfTotal);
        _item.setTotal(_tmpTotal);
        final int _tmpStatus;
        _tmpStatus = _cursor.getInt(_cursorIndexOfStatus);
        _item.setStatus(_tmpStatus);
        final int _tmpSoCa;
        _tmpSoCa = _cursor.getInt(_cursorIndexOfSoCa);
        _item.setSoCa(_tmpSoCa);
        final int _tmpSoLanCapNhat;
        _tmpSoLanCapNhat = _cursor.getInt(_cursorIndexOfSoLanCapNhat);
        _item.setSoLanCapNhat(_tmpSoLanCapNhat);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<Order> getOrderWithManagerId(final int id, final String date, final int status) {
    final String _sql = "SELECT * FROM ORDERS WHERE managerId == ? AND dateCreate LIKE ? AND ORDERS.status != ? ORDER BY ORDERS.id DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 3);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, id);
    _argIndex = 2;
    if (date == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, date);
    }
    _argIndex = 3;
    _statement.bindLong(_argIndex, status);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfManagerId = CursorUtil.getColumnIndexOrThrow(_cursor, "managerId");
      final int _cursorIndexOfCustomerId = CursorUtil.getColumnIndexOrThrow(_cursor, "customerId");
      final int _cursorIndexOfPitchId = CursorUtil.getColumnIndexOrThrow(_cursor, "pitchId");
      final int _cursorIndexOfDateCreate = CursorUtil.getColumnIndexOrThrow(_cursor, "dateCreate");
      final int _cursorIndexOfDatePlay = CursorUtil.getColumnIndexOrThrow(_cursor, "datePlay");
      final int _cursorIndexOfTotalPitchMoney = CursorUtil.getColumnIndexOrThrow(_cursor, "totalPitchMoney");
      final int _cursorIndexOfTotalServiceMoney = CursorUtil.getColumnIndexOrThrow(_cursor, "totalServiceMoney");
      final int _cursorIndexOfChiPhiKhac = CursorUtil.getColumnIndexOrThrow(_cursor, "chiPhiKhac");
      final int _cursorIndexOfTotal = CursorUtil.getColumnIndexOrThrow(_cursor, "total");
      final int _cursorIndexOfStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "status");
      final int _cursorIndexOfSoCa = CursorUtil.getColumnIndexOrThrow(_cursor, "soCa");
      final int _cursorIndexOfSoLanCapNhat = CursorUtil.getColumnIndexOrThrow(_cursor, "soLanCapNhat");
      final List<Order> _result = new ArrayList<Order>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Order _item;
        _item = new Order();
        final int _tmpId;
        _tmpId = _cursor.getInt(_cursorIndexOfId);
        _item.setId(_tmpId);
        final int _tmpManagerId;
        _tmpManagerId = _cursor.getInt(_cursorIndexOfManagerId);
        _item.setManagerId(_tmpManagerId);
        final int _tmpCustomerId;
        _tmpCustomerId = _cursor.getInt(_cursorIndexOfCustomerId);
        _item.setCustomerId(_tmpCustomerId);
        final int _tmpPitchId;
        _tmpPitchId = _cursor.getInt(_cursorIndexOfPitchId);
        _item.setPitchId(_tmpPitchId);
        final String _tmpDateCreate;
        if (_cursor.isNull(_cursorIndexOfDateCreate)) {
          _tmpDateCreate = null;
        } else {
          _tmpDateCreate = _cursor.getString(_cursorIndexOfDateCreate);
        }
        _item.setDateCreate(_tmpDateCreate);
        final String _tmpDatePlay;
        if (_cursor.isNull(_cursorIndexOfDatePlay)) {
          _tmpDatePlay = null;
        } else {
          _tmpDatePlay = _cursor.getString(_cursorIndexOfDatePlay);
        }
        _item.setDatePlay(_tmpDatePlay);
        final int _tmpTotalPitchMoney;
        _tmpTotalPitchMoney = _cursor.getInt(_cursorIndexOfTotalPitchMoney);
        _item.setTotalPitchMoney(_tmpTotalPitchMoney);
        final int _tmpTotalServiceMoney;
        _tmpTotalServiceMoney = _cursor.getInt(_cursorIndexOfTotalServiceMoney);
        _item.setTotalServiceMoney(_tmpTotalServiceMoney);
        final int _tmpChiPhiKhac;
        _tmpChiPhiKhac = _cursor.getInt(_cursorIndexOfChiPhiKhac);
        _item.setChiPhiKhac(_tmpChiPhiKhac);
        final int _tmpTotal;
        _tmpTotal = _cursor.getInt(_cursorIndexOfTotal);
        _item.setTotal(_tmpTotal);
        final int _tmpStatus;
        _tmpStatus = _cursor.getInt(_cursorIndexOfStatus);
        _item.setStatus(_tmpStatus);
        final int _tmpSoCa;
        _tmpSoCa = _cursor.getInt(_cursorIndexOfSoCa);
        _item.setSoCa(_tmpSoCa);
        final int _tmpSoLanCapNhat;
        _tmpSoLanCapNhat = _cursor.getInt(_cursorIndexOfSoLanCapNhat);
        _item.setSoLanCapNhat(_tmpSoLanCapNhat);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public Cursor getDoanhThuStaff(final String s, final String account, final int status) {
    final String _sql = "SELECT ORDERS.managerId,(SUM(ORDERS.total)/100)*3 FROM ORDERS INNER JOIN MANAGER ON ORDERS.managerId = MANAGER.id WHERE dateCreate LIKE ? AND MANAGER.phone != ? AND ORDERS.status != ? GROUP BY ORDERS.managerId ORDER BY ORDERS.id DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 3);
    int _argIndex = 1;
    if (s == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, s);
    }
    _argIndex = 2;
    if (account == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, account);
    }
    _argIndex = 3;
    _statement.bindLong(_argIndex, status);
    final Cursor _tmpResult = __db.query(_statement);
    return _tmpResult;
  }

  @Override
  public Cursor getDoanhThuService(final String s, final int status) {
    final String _sql = "SELECT SUM(totalServiceMoney) FROM ORDERS WHERE dateCreate LIKE ? AND ORDERS.status != ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 2);
    int _argIndex = 1;
    if (s == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, s);
    }
    _argIndex = 2;
    _statement.bindLong(_argIndex, status);
    final Cursor _tmpResult = __db.query(_statement);
    return _tmpResult;
  }

  @Override
  public Cursor getDoanhThuSanBong(final String s, final int status) {
    final String _sql = "SELECT SUM(totalPitchMoney)+SUM(chiPhiKhac) FROM ORDERS WHERE dateCreate LIKE ? AND ORDERS.status != ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 2);
    int _argIndex = 1;
    if (s == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, s);
    }
    _argIndex = 2;
    _statement.bindLong(_argIndex, status);
    final Cursor _tmpResult = __db.query(_statement);
    return _tmpResult;
  }

  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}

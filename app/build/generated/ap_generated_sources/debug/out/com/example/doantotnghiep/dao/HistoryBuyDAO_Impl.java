package com.example.doantotnghiep.dao;

import android.database.Cursor;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.example.doantotnghiep.model.HistoryBuy;
import java.lang.Class;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@SuppressWarnings({"unchecked", "deprecation"})
public final class HistoryBuyDAO_Impl implements HistoryBuyDAO {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<HistoryBuy> __insertionAdapterOfHistoryBuy;

  private final EntityDeletionOrUpdateAdapter<HistoryBuy> __deletionAdapterOfHistoryBuy;

  private final EntityDeletionOrUpdateAdapter<HistoryBuy> __updateAdapterOfHistoryBuy;

  public HistoryBuyDAO_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfHistoryBuy = new EntityInsertionAdapter<HistoryBuy>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `HistoryBuy` (`id`,`idCustomer`,`money`,`status`,`date`) VALUES (nullif(?, 0),?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, HistoryBuy value) {
        stmt.bindLong(1, value.getId());
        stmt.bindLong(2, value.getIdCustomer());
        stmt.bindLong(3, value.getMoney());
        stmt.bindLong(4, value.getStatus());
        if (value.getDate() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getDate());
        }
      }
    };
    this.__deletionAdapterOfHistoryBuy = new EntityDeletionOrUpdateAdapter<HistoryBuy>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `HistoryBuy` WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, HistoryBuy value) {
        stmt.bindLong(1, value.getId());
      }
    };
    this.__updateAdapterOfHistoryBuy = new EntityDeletionOrUpdateAdapter<HistoryBuy>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `HistoryBuy` SET `id` = ?,`idCustomer` = ?,`money` = ?,`status` = ?,`date` = ? WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, HistoryBuy value) {
        stmt.bindLong(1, value.getId());
        stmt.bindLong(2, value.getIdCustomer());
        stmt.bindLong(3, value.getMoney());
        stmt.bindLong(4, value.getStatus());
        if (value.getDate() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getDate());
        }
        stmt.bindLong(6, value.getId());
      }
    };
  }

  @Override
  public void insert(final HistoryBuy historyBuy) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfHistoryBuy.insert(historyBuy);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void delete(final HistoryBuy historyBuy) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __deletionAdapterOfHistoryBuy.handle(historyBuy);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void update(final HistoryBuy historyBuy) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __updateAdapterOfHistoryBuy.handle(historyBuy);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public List<HistoryBuy> getAll() {
    final String _sql = "SELECT * FROM HISTORYBUY";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfIdCustomer = CursorUtil.getColumnIndexOrThrow(_cursor, "idCustomer");
      final int _cursorIndexOfMoney = CursorUtil.getColumnIndexOrThrow(_cursor, "money");
      final int _cursorIndexOfStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "status");
      final int _cursorIndexOfDate = CursorUtil.getColumnIndexOrThrow(_cursor, "date");
      final List<HistoryBuy> _result = new ArrayList<HistoryBuy>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final HistoryBuy _item;
        _item = new HistoryBuy();
        final int _tmpId;
        _tmpId = _cursor.getInt(_cursorIndexOfId);
        _item.setId(_tmpId);
        final int _tmpIdCustomer;
        _tmpIdCustomer = _cursor.getInt(_cursorIndexOfIdCustomer);
        _item.setIdCustomer(_tmpIdCustomer);
        final int _tmpMoney;
        _tmpMoney = _cursor.getInt(_cursorIndexOfMoney);
        _item.setMoney(_tmpMoney);
        final int _tmpStatus;
        _tmpStatus = _cursor.getInt(_cursorIndexOfStatus);
        _item.setStatus(_tmpStatus);
        final String _tmpDate;
        if (_cursor.isNull(_cursorIndexOfDate)) {
          _tmpDate = null;
        } else {
          _tmpDate = _cursor.getString(_cursorIndexOfDate);
        }
        _item.setDate(_tmpDate);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<HistoryBuy> getALlWithId(final int id) {
    final String _sql = "SELECT * FROM HISTORYBUY WHERE idCustomer = ? ORDER BY id DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, id);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfIdCustomer = CursorUtil.getColumnIndexOrThrow(_cursor, "idCustomer");
      final int _cursorIndexOfMoney = CursorUtil.getColumnIndexOrThrow(_cursor, "money");
      final int _cursorIndexOfStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "status");
      final int _cursorIndexOfDate = CursorUtil.getColumnIndexOrThrow(_cursor, "date");
      final List<HistoryBuy> _result = new ArrayList<HistoryBuy>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final HistoryBuy _item;
        _item = new HistoryBuy();
        final int _tmpId;
        _tmpId = _cursor.getInt(_cursorIndexOfId);
        _item.setId(_tmpId);
        final int _tmpIdCustomer;
        _tmpIdCustomer = _cursor.getInt(_cursorIndexOfIdCustomer);
        _item.setIdCustomer(_tmpIdCustomer);
        final int _tmpMoney;
        _tmpMoney = _cursor.getInt(_cursorIndexOfMoney);
        _item.setMoney(_tmpMoney);
        final int _tmpStatus;
        _tmpStatus = _cursor.getInt(_cursorIndexOfStatus);
        _item.setStatus(_tmpStatus);
        final String _tmpDate;
        if (_cursor.isNull(_cursorIndexOfDate)) {
          _tmpDate = null;
        } else {
          _tmpDate = _cursor.getString(_cursorIndexOfDate);
        }
        _item.setDate(_tmpDate);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<HistoryBuy> getAllWithStatus(final int status) {
    final String _sql = "SELECT * FROM HISTORYBUY WHERE status = ? ORDER BY id DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, status);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfIdCustomer = CursorUtil.getColumnIndexOrThrow(_cursor, "idCustomer");
      final int _cursorIndexOfMoney = CursorUtil.getColumnIndexOrThrow(_cursor, "money");
      final int _cursorIndexOfStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "status");
      final int _cursorIndexOfDate = CursorUtil.getColumnIndexOrThrow(_cursor, "date");
      final List<HistoryBuy> _result = new ArrayList<HistoryBuy>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final HistoryBuy _item;
        _item = new HistoryBuy();
        final int _tmpId;
        _tmpId = _cursor.getInt(_cursorIndexOfId);
        _item.setId(_tmpId);
        final int _tmpIdCustomer;
        _tmpIdCustomer = _cursor.getInt(_cursorIndexOfIdCustomer);
        _item.setIdCustomer(_tmpIdCustomer);
        final int _tmpMoney;
        _tmpMoney = _cursor.getInt(_cursorIndexOfMoney);
        _item.setMoney(_tmpMoney);
        final int _tmpStatus;
        _tmpStatus = _cursor.getInt(_cursorIndexOfStatus);
        _item.setStatus(_tmpStatus);
        final String _tmpDate;
        if (_cursor.isNull(_cursorIndexOfDate)) {
          _tmpDate = null;
        } else {
          _tmpDate = _cursor.getString(_cursorIndexOfDate);
        }
        _item.setDate(_tmpDate);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<HistoryBuy> getAllWithCustommer(final String s, final int status) {
    final String _sql = "SELECT * FROM HISTORYBUY INNER JOIN CUSTOMER ON HISTORYBUY.idCustomer = CUSTOMER.id WHERE status = ? and CUSTOMER.name LIKE ? ORDER BY id DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 2);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, status);
    _argIndex = 2;
    if (s == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, s);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfIdCustomer = CursorUtil.getColumnIndexOrThrow(_cursor, "idCustomer");
      final int _cursorIndexOfMoney = CursorUtil.getColumnIndexOrThrow(_cursor, "money");
      final int _cursorIndexOfStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "status");
      final int _cursorIndexOfDate = CursorUtil.getColumnIndexOrThrow(_cursor, "date");
      final int _cursorIndexOfId_1 = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final List<HistoryBuy> _result = new ArrayList<HistoryBuy>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final HistoryBuy _item;
        _item = new HistoryBuy();
        final int _tmpId;
        _tmpId = _cursor.getInt(_cursorIndexOfId);
        _item.setId(_tmpId);
        final int _tmpIdCustomer;
        _tmpIdCustomer = _cursor.getInt(_cursorIndexOfIdCustomer);
        _item.setIdCustomer(_tmpIdCustomer);
        final int _tmpMoney;
        _tmpMoney = _cursor.getInt(_cursorIndexOfMoney);
        _item.setMoney(_tmpMoney);
        final int _tmpStatus;
        _tmpStatus = _cursor.getInt(_cursorIndexOfStatus);
        _item.setStatus(_tmpStatus);
        final String _tmpDate;
        if (_cursor.isNull(_cursorIndexOfDate)) {
          _tmpDate = null;
        } else {
          _tmpDate = _cursor.getString(_cursorIndexOfDate);
        }
        _item.setDate(_tmpDate);
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

  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}

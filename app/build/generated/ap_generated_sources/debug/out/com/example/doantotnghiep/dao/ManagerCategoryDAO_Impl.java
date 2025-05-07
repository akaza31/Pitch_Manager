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
import com.example.doantotnghiep.model.ManagerCategory;
import java.lang.Class;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@SuppressWarnings({"unchecked", "deprecation"})
public final class ManagerCategoryDAO_Impl implements ManagerCategoryDAO {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<ManagerCategory> __insertionAdapterOfManagerCategory;

  private final EntityDeletionOrUpdateAdapter<ManagerCategory> __deletionAdapterOfManagerCategory;

  private final EntityDeletionOrUpdateAdapter<ManagerCategory> __updateAdapterOfManagerCategory;

  private final SharedSQLiteStatement __preparedStmtOfDeleteAll;

  public ManagerCategoryDAO_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfManagerCategory = new EntityInsertionAdapter<ManagerCategory>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `MANAGER_CATEGORY` (`id`,`name`) VALUES (nullif(?, 0),?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, ManagerCategory value) {
        stmt.bindLong(1, value.getId());
        if (value.getName() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getName());
        }
      }
    };
    this.__deletionAdapterOfManagerCategory = new EntityDeletionOrUpdateAdapter<ManagerCategory>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `MANAGER_CATEGORY` WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, ManagerCategory value) {
        stmt.bindLong(1, value.getId());
      }
    };
    this.__updateAdapterOfManagerCategory = new EntityDeletionOrUpdateAdapter<ManagerCategory>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `MANAGER_CATEGORY` SET `id` = ?,`name` = ? WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, ManagerCategory value) {
        stmt.bindLong(1, value.getId());
        if (value.getName() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getName());
        }
        stmt.bindLong(3, value.getId());
      }
    };
    this.__preparedStmtOfDeleteAll = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM MANAGER_CATEGORY";
        return _query;
      }
    };
  }

  @Override
  public void insert(final ManagerCategory managerCategory) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfManagerCategory.insert(managerCategory);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void delete(final ManagerCategory managerCategory) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __deletionAdapterOfManagerCategory.handle(managerCategory);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void update(final ManagerCategory managerCategory) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __updateAdapterOfManagerCategory.handle(managerCategory);
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
  public List<ManagerCategory> getAll() {
    final String _sql = "SELECT * FROM MANAGER_CATEGORY";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
      final List<ManagerCategory> _result = new ArrayList<ManagerCategory>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final ManagerCategory _item;
        _item = new ManagerCategory();
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
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<ManagerCategory> getAllStaff() {
    final String _sql = "SELECT * FROM MANAGER_CATEGORY WHERE NAME != 'Admin'";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
      final List<ManagerCategory> _result = new ArrayList<ManagerCategory>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final ManagerCategory _item;
        _item = new ManagerCategory();
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
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<ManagerCategory> getCategoryWithID(final int id) {
    final String _sql = "SELECT * FROM MANAGER_CATEGORY WHERE ID = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, id);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
      final List<ManagerCategory> _result = new ArrayList<ManagerCategory>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final ManagerCategory _item;
        _item = new ManagerCategory();
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
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<ManagerCategory> getIdAdmin(final String s) {
    final String _sql = "SELECT * FROM MANAGER_CATEGORY WHERE NAME = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (s == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, s);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
      final List<ManagerCategory> _result = new ArrayList<ManagerCategory>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final ManagerCategory _item;
        _item = new ManagerCategory();
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

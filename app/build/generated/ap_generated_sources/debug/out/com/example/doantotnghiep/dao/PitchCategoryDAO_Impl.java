package com.example.doantotnghiep.dao;

import android.database.Cursor;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.example.doantotnghiep.model.PithCategory;
import java.lang.Class;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@SuppressWarnings({"unchecked", "deprecation"})
public final class PitchCategoryDAO_Impl implements PitchCategoryDAO {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<PithCategory> __insertionAdapterOfPithCategory;

  private final EntityDeletionOrUpdateAdapter<PithCategory> __deletionAdapterOfPithCategory;

  private final EntityDeletionOrUpdateAdapter<PithCategory> __updateAdapterOfPithCategory;

  public PitchCategoryDAO_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfPithCategory = new EntityInsertionAdapter<PithCategory>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `PITCH_CATEGORY` (`id`,`name`,`money`) VALUES (?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, PithCategory value) {
        stmt.bindLong(1, value.getId());
        if (value.getName() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getName());
        }
        stmt.bindLong(3, value.getMoney());
      }
    };
    this.__deletionAdapterOfPithCategory = new EntityDeletionOrUpdateAdapter<PithCategory>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `PITCH_CATEGORY` WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, PithCategory value) {
        stmt.bindLong(1, value.getId());
      }
    };
    this.__updateAdapterOfPithCategory = new EntityDeletionOrUpdateAdapter<PithCategory>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `PITCH_CATEGORY` SET `id` = ?,`name` = ?,`money` = ? WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, PithCategory value) {
        stmt.bindLong(1, value.getId());
        if (value.getName() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getName());
        }
        stmt.bindLong(3, value.getMoney());
        stmt.bindLong(4, value.getId());
      }
    };
  }

  @Override
  public void insert(final PithCategory category) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfPithCategory.insert(category);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void delete(final PithCategory category) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __deletionAdapterOfPithCategory.handle(category);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void update(final PithCategory category) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __updateAdapterOfPithCategory.handle(category);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public List<PithCategory> getAll() {
    final String _sql = "SELECT * FROM PITCH_CATEGORY";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
      final int _cursorIndexOfMoney = CursorUtil.getColumnIndexOrThrow(_cursor, "money");
      final List<PithCategory> _result = new ArrayList<PithCategory>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final PithCategory _item;
        _item = new PithCategory();
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
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<PithCategory> getCategoryPitchWithId(final int id) {
    final String _sql = "SELECT * FROM PITCH_CATEGORY WHERE id = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, id);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
      final int _cursorIndexOfMoney = CursorUtil.getColumnIndexOrThrow(_cursor, "money");
      final List<PithCategory> _result = new ArrayList<PithCategory>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final PithCategory _item;
        _item = new PithCategory();
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
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public Cursor getPitchCategoryWithTime(final String date) {
    final String _sql = "SELECT PITCH_CATEGORY.NAME,COUNT(PITCH_CATEGORY.id) FROM PITCH_CATEGORY INNER JOIN PITCH ON PITCH_CATEGORY.id = PITCH.categoryId INNER JOIN ORDERS ON ORDERS.pitchId = PITCH.id WHERE ORDERS.dateCreate LIKE ? GROUP BY PITCH_CATEGORY.id";
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

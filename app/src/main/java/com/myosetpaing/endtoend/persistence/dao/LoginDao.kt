package com.myosetpaing.endtoend.persistence.dao

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import com.myosetpaing.endtoend.data.vos.LoginUserVO

@Dao
interface LoginDao{

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertLoginUser(loginUser: LoginUserVO): Long

    @Query("select count(*) from login_user")
    fun getUserCount(): Int

    @Query("select * from login_user")
    fun getUserInformation(): LoginUserVO

}
package com.advnmpproj.adv160818008midterm.model

import androidx.room.*

@Dao
interface UserDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(vararg users:Users?)

    @Query("SELECT * FROM users")
    suspend fun getAllUser():List<Users>

    @Query("SELECT * FROM users WHERE username=:uname")
    suspend fun findUser(uname:String?):Users

    @Query("UPDATE users SET username=:uname, email=:email, password=:pass WHERE id=:uid")
    suspend fun editUser(uname:String, email:String, pass:String, uid:Int)

    @Delete
    suspend fun deleteRec(users:Users)
}
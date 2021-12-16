package com.advnmpproj.adv160818008midterm.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Users(
        @ColumnInfo(name="username")
        var username:String?,
        @ColumnInfo(name="email")
        var email:String?,
        @ColumnInfo(name="password")
        var password:String?
        ){
    @PrimaryKey(autoGenerate = true)
    var id:Int = 0
}

@Entity
data class Recipes(
    @ColumnInfo(name="recipeName")
    var recipeName:String,
    @ColumnInfo(name="description")
    var description:String,
    @ColumnInfo(name="moreDetail")
    var moreDetail:String,
    @ColumnInfo(name="imgUrl")
    var imgUrl:String
    ){
    @PrimaryKey(autoGenerate = true)
    var id:Int = 0
}
package com.advnmpproj.adv160818008midterm.model

data class Users(val username:String?, var email:String?, val password:String?)
data class Recipes(val id:Int, val recipeName:String?, val description:String?, val moreDetail:String?, val imgUrl:String?)
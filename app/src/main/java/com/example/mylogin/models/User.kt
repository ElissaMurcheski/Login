package com.example.mylogin.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class User(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val username: String = "",
    val password: String = "",
    val email: String = "",
) {
    fun isEmpty(): Boolean {
        return id == 0L && username.isEmpty() && email.isEmpty() && password.isEmpty();
    }
}

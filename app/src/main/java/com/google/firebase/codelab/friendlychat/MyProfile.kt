package com.google.firebase.codelab.friendlychat

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class MyProfile : AppCompatActivity() {
    // Firebase instance variables
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        auth = Firebase.auth
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_profile)

        val name = getUserName();
        val mTextView: TextView = findViewById<View>(R.id.profile_name) as TextView
        mTextView.text = name;
    }

    private fun getUserName(): String? {
        val user = auth.currentUser
        return if (user != null) {
            user.displayName
        } else MainActivity.ANONYMOUS
    }
}
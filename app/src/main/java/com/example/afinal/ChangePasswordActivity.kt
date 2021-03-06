package com.example.afinal

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import org.w3c.dom.Text

class ChangePasswordActivity : AppCompatActivity() {

    private lateinit var NewPasswordEditText: EditText
    private lateinit var NewPasswordSubmit: Button

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_change_password)

        auth = FirebaseAuth.getInstance()

        NewPasswordEditText = findViewById(R.id.NewPasswordEditText)
        NewPasswordSubmit = findViewById(R.id.NewPasswordSubmit)

        NewPasswordSubmit.setOnClickListener {
            val NewPassword = NewPasswordEditText.text.toString()
            auth.currentUser?.updatePassword(NewPassword)?.addOnCompleteListener {task ->
                if (task.isSuccessful){
                    Toast.makeText(this, "success", Toast.LENGTH_LONG).show()
                } else{
                    Toast.makeText(this, "Error!", Toast.LENGTH_LONG).show()
                }

            }

        }

    }
}
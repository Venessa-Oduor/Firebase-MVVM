package com.venessa.firebasemvvm.data

import android.content.Context
import android.widget.Toast
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import com.venessa.firebasemvvm.model.User
import com.venessa.firebasemvvm.navigation.ROUTE_HOME
import com.venessa.firebasemvvm.navigation.ROUTE_LOGIN
import com.venessa.firebasemvvm.navigation.ROUTE_REGISTER

class AuthViewModel(var navController: NavHostController, var context:Context) {

    var mAuth:FirebaseAuth
    init {
        mAuth=FirebaseAuth.getInstance()
    }
    fun signup(name:String,email:String,pass:String,confirmpass:String){
        if (name.isBlank() || email.isBlank() ||pass.isBlank() || confirmpass.isBlank()) {
            Toast.makeText(context, "Please input all fields", Toast.LENGTH_LONG).show()
        } else if (pass !=confirmpass){
            Toast.makeText(context,"Password do not match",Toast.LENGTH_LONG).show()
        }
        else {
            mAuth.createUserWithEmailAndPassword(email, pass).addOnCompleteListener {
                if (it.isSuccessful){
                    val userdata= User(name,email,pass,confirmpass,mAuth.currentUser!!.uid)
                    val regRef= FirebaseDatabase.getInstance().getReference()
                        .child("Users/"+mAuth.currentUser!!.uid)
                    regRef.setValue(userdata).addOnCompleteListener {

                        if (it.isSuccessful){
                            Toast.makeText(context,"Registered Successfully",Toast.LENGTH_LONG).show()
                            navController.navigate(ROUTE_LOGIN)

                        }else{
                            Toast.makeText(context,"${it.exception!!.message}",Toast.LENGTH_LONG).show()
                            navController.navigate(ROUTE_LOGIN)
                        }
                    }
                }else{
                    navController.navigate(ROUTE_REGISTER)
                }

            } }

    }
    fun login(email: String,pass: String){

        mAuth.signInWithEmailAndPassword(email,pass).addOnCompleteListener {

            if (it.isSuccessful){
                Toast.makeText(context,"Succeffully Logged in",Toast.LENGTH_LONG).show()
                navController.navigate(ROUTE_HOME)
//                navController.navigate(ROUTE_REGISTER)TO TAKE YOU TO A DIIFFERNT PAGE
            }else{
                Toast.makeText(context,"${it.exception!!.message}",Toast.LENGTH_LONG).show()
                navController.navigate(ROUTE_LOGIN)
            }
        }

    }
    fun logout(){
        mAuth.signOut()
        navController.navigate(ROUTE_LOGIN)
    }
    fun isloggedin():Boolean{
        return mAuth.currentUser !=null
    }

}





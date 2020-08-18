package com.example.todoapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.todoapp.di.DaggerAppComponent
import com.example.todoapp.presentation.ViewModelFactory
import com.example.todoapp.presentation.user.UserViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.*
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject lateinit var retrofit: Retrofit
    @Inject lateinit var viewModelFactory: ViewModelFactory
        @Inject lateinit var userViewModel: UserViewModel

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_main)
            DaggerAppComponent
            .builder()
            .application(application)
            .build()
            .inject(this)

        userViewModel = ViewModelProvider(this, viewModelFactory).get(userViewModel::class.java)


        CoroutineScope(Dispatchers.Main).launch {
//            withContext(Dispatchers.IO){
//                UserDataSourceRoom(getRoomDatabase()).add(User(
//                    1,
//                    "Leanne Graham",
//                    "",
//                    "Bret",
//                    "Sincere@april.biz",
//                    Address (
//                        "Kulas Light", "Apt. 556",
//                        "Gwenborough",
//                        "92998-3874",
//                        Geo (
//                            "-37.3159",
//                            "81.1496"
//                        )
//                    ),
//                    "1-770-736-8031 x56442",
//                    "hildegard.org",
//                    Company(
//                        "Romaguera-Crona",
//                        "Multi-layered client-server neural-net",
//                        "harness real-time e-markets"
//                    )
//                ))
//
//            }
            withContext(Dispatchers.IO){
//                var user = UserDataSourceRoom(roomBase).list()
//                user?.size
            }
        }
    }
}

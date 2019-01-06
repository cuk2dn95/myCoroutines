package com.example.pc.mycoroutine.feature

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.feature1.BlankFragment
import com.example.pc.mycoroutine.R
import com.example.pc.mycoroutine.dagger.Injectable
import com.example.pc.mycoroutine.feature.post.MainPostFragment
import com.example.pc.mycoroutine.util.extension.replaceFragment
import kotlinx.android.synthetic.main.activity_main.view.*

class MainActivity : AppCompatActivity(), Injectable {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}

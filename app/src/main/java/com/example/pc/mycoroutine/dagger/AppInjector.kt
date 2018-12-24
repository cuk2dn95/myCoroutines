package com.example.pc.mycoroutine.dagger

import android.app.Activity
import android.app.Application
import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import com.example.pc.mycoroutine.MainApplication
import com.example.pc.mycoroutine.util.impl.ActivityLifeCycleCallbackImpl
import com.example.pc.mycoroutine.util.impl.FragmentLifeCycleCallbackImpl
import dagger.android.AndroidInjection
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjection

object AppInjector {
    fun inject(application: MainApplication): AndroidInjector<MainApplication> {
        val androidInjector = reset(application)
        application.registerActivityLifecycleCallbacks(object : ActivityLifeCycleCallbackImpl() {
            override fun onActivityCreated(activity: Activity?, savedInstanceState: Bundle?) {
                if (activity is FragmentActivity && activity is Injectable) {
                    AndroidInjection.inject(activity)
                    injectFragment(activity)
                }
            }
        })
        return androidInjector
    }

    private fun injectFragment(activity: FragmentActivity) {
        activity.supportFragmentManager.registerFragmentLifecycleCallbacks(object : FragmentLifeCycleCallbackImpl() {
            override fun onFragmentAttached(fm: FragmentManager, f: Fragment, context: Context) {
                if (f is Injectable) AndroidSupportInjection.inject(f)
            }
        }, true)
    }

    fun reset(application: MainApplication): AndroidInjector<MainApplication> {
        return DaggerAppComponent.builder().application(application).build().apply { inject(application) }
    }
}
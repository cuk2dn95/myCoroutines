package com.example.pc.mycoroutine

import androidx.fragment.app.Fragment
import com.example.pc.mycoroutine.dagger.AppInjector
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.HasSupportFragmentInjector
import javax.inject.Inject

class MainApplication : DaggerApplication(), HasSupportFragmentInjector {
    @Inject lateinit var dispatchFragmentInjector : DispatchingAndroidInjector<Fragment>
    private  var androidInjector: AndroidInjector<MainApplication> = AppInjector.inject(this)

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return androidInjector
    }

    override fun supportFragmentInjector(): AndroidInjector<Fragment> {
        return dispatchFragmentInjector
    }

    /*
         * Call to reset graph dagger
         */
    fun resetAppComponent() {
        AppInjector.reset(this)
    }
}
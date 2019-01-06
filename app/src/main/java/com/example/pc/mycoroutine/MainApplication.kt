package com.example.pc.mycoroutine

import androidx.fragment.app.Fragment
import com.example.pc.mycoroutine.dagger.AppInjector
import com.example.shareddependency.DaggerShareComponent
import com.example.shareddependency.ProvideShareComponent
import com.example.shareddependency.ShareComponent
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.HasSupportFragmentInjector
import javax.inject.Inject

class MainApplication : DaggerApplication(), HasSupportFragmentInjector, ProvideShareComponent {
    @Inject lateinit var dispatchFragmentInjector : DispatchingAndroidInjector<Fragment>
    private  var androidInjector: AndroidInjector<MainApplication> = AppInjector.inject(this)

    lateinit var shareComponent: ShareComponent
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

    override fun provideShareComponent(): ShareComponent {
       return if (!::shareComponent.isInitialized) {
             DaggerShareComponent.builder().build()
        } else shareComponent
    }
}
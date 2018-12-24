package com.example.pc.mycoroutine.util.extension

import androidx.annotation.IdRes
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction

inline fun FragmentManager.transact(block: FragmentTransaction.() -> Unit) {
    beginTransaction().apply {
        block()
    }.commit()
}

fun FragmentManager.replaceFragment(@IdRes container: Int, fragment: Fragment, tag: String? = null) {
    transact {
        replace(container, fragment, tag)
    }
}
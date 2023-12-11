package com.willis.base.utils

import android.app.Activity
import android.app.Application
import android.os.Bundle
import java.util.Deque
import java.util.LinkedList

/**
 * description: Activity 工具类
 * @author willis.yan.ws@gmail.com
 * @date: 2023/12/11
 */
object ActivityUtils {
    private val activityStack: Deque<Activity> = LinkedList()

    fun init(application: Application) {
        application.registerActivityLifecycleCallbacks(object : Application.ActivityLifecycleCallbacks {
            override fun onActivityCreated(activity: Activity, savedInstanceState: Bundle?) {
                activityStack.remove(activity)
                activityStack.push(activity)
            }

            override fun onActivityStarted(activity: Activity) {

            }

            override fun onActivityResumed(activity: Activity) {

            }

            override fun onActivityPaused(activity: Activity) {

            }

            override fun onActivityStopped(activity: Activity) {

            }

            override fun onActivitySaveInstanceState(activity: Activity, outState: Bundle) {

            }

            override fun onActivityDestroyed(activity: Activity) {
                activityStack.remove(activity)
            }
        })
    }

    val currentActivity: Activity? get() = activityStack.peek()

    val currentActivityName: String? get() = currentActivity?.componentName?.className
}
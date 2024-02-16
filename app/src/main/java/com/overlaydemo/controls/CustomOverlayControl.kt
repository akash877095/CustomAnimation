package com.overlaydemo.controls

import android.app.Activity
import android.view.View
import androidx.recyclerview.widget.ItemTouchHelper
import com.overlaydemo.utils.showcaseViews.MaterialShowcaseSequence
import com.overlaydemo.utils.showcaseViews.MaterialShowcaseView
import com.overlaydemo.utils.showcaseViews.ShowcaseConfig
import kotlin.collections.List

class CustomOverlayControl {
    companion object {
        val randomNumber = (0..100).random().toString()

        fun showOverlayViews(activity: Activity, dataList: List<DataModel>, vararg views: View) {
            val config = ShowcaseConfig().apply {
                mDelay = 300
            }
            val sequence = MaterialShowcaseSequence(activity, randomNumber).apply {
                setConfig(config)
            }
            val size = dataList.size
            for (index in 0 until size) {
                val numberText = "${index + 1} of ${dataList.size}"
                val nextButtonText = dataList[index].nextText
                val dummyView = View(activity).apply {
                    visibility = View.INVISIBLE
                }
                if (index + 1 == dataList.size) {
                    val showcaseView = MaterialShowcaseView.Builder(activity)
                        .setTarget(dummyView)
                        .setNumberText(numberText)
                        .setNextButtonText(nextButtonText)
                        .setSkipText("")
                        .setTitleText(dataList[index].title)
                        .setContentText(dataList[index].description)
                        .setOverlayLayoutPadding(
                            ItemTouchHelper.Callback.DEFAULT_DRAG_ANIMATION_DURATION,
                            0,
                            50,
                            50
                        )
                        .withRectangleShape()
                        .build()
                    sequence.addSequenceItem(showcaseView)
                } else {
                    val showcaseView = MaterialShowcaseView.Builder(activity)
                        .setTarget(views[index])
                        .setNumberText(numberText)
                        .setNextButtonText(nextButtonText)
                        .setTitleText(dataList[index].title)
                        .setContentText(dataList[index].description)
                        .withRectangleShape()
                        .build()
                    sequence.addSequenceItem(showcaseView)
                }
            }
            sequence.start()
        }
    }
}

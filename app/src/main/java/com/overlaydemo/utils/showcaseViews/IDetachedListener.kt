package com.overlaydemo.utils.showcaseViews

import com.overlaydemo.utils.showcaseViews.MaterialShowcaseView

interface IDetachedListener {

   fun onShowcaseDetached(
        showcaseView: MaterialShowcaseView?,
        wasDismissed: Boolean,
        wasSkipped: Boolean
    )

}
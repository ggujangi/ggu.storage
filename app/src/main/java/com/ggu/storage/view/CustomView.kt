package com.ggu.storage.view

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import com.ggu.storage.R

class CustomView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : LinearLayout(context, attrs, defStyleAttr) {

    private lateinit var titleView: TextView
    private lateinit var iconView: ImageView

    private var text: String? = null
    private var layoutId: Int = R.layout.label_view
    private var repeatCount: Int = 0;


    init {

        context.theme.obtainStyledAttributes(
            attrs,
            R.styleable.CustomView,
            0, 0
        ).run {
            try {
                text = getString(R.styleable.CustomView_text)
                layoutId = getResourceId(R.styleable.CustomView_layout_id, layoutId)
                repeatCount = getInteger(R.styleable.CustomView_repeat_count, repeatCount)

            } finally {
                recycle()
            }
        }

        inflateView(context)

        titleView.text = text?.repeat(repeatCount)
    }


    private fun inflateView(context: Context) {
        LayoutInflater.from(context).inflate(layoutId, this);

        titleView = findViewById(R.id.title)
        iconView = findViewById(R.id.icon)
    }
}
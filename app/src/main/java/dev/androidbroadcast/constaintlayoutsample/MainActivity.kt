@file:Suppress("unused")

package dev.androidbroadcast.constaintlayoutsample

import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintSet
import androidx.core.view.isVisible
import by.kirich1409.viewbindingdelegate.viewBinding
import dev.androidbroadcast.constaintlayoutsample.databinding.ActivityMainFinalBinding

class MainActivity : AppCompatActivity(R.layout.activity_main_final) {

    private val viewBinding by viewBinding(ActivityMainFinalBinding::bind)

    private val actionsView by lazy(LazyThreadSafetyMode.NONE) {
        with(viewBinding) {
            listOf(like, watch, share)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        val cs1 = ConstraintSet().apply {
            clone(viewBinding.constraintLayout)
        }
        cs1.setRotation(R.id.poster, 0.5F)
        cs1.setVisibility(R.id.banner, View.GONE)
        viewBinding.constraintLayout.setConstraintSet(cs1)
    }

    private fun setActionsVisible(visible: Boolean) {
        actionsView.forEach { view -> view.isVisible = visible }
    }
}
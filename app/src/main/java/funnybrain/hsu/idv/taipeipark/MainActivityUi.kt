package funnybrain.hsu.idv.taipeipark

import android.support.constraint.ConstraintSet
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import org.jetbrains.anko.AnkoComponent
import org.jetbrains.anko.AnkoContext
import org.jetbrains.anko.constraint.layout.ConstraintSetBuilder
import org.jetbrains.anko.constraint.layout.applyConstraintSet
import org.jetbrains.anko.constraint.layout.constraintLayout
import org.jetbrains.anko.matchParent
import org.jetbrains.anko.recyclerview.v7.recyclerView

class MainActivityUi : AnkoComponent<MainActivity> {
    lateinit var list: RecyclerView

    override fun createView(ui: AnkoContext<MainActivity>) = with(ui) {
        constraintLayout {
            lparams(width = matchParent, height = matchParent)

            list = recyclerView {
                id = R.id.list
                val lm = LinearLayoutManager(ctx, LinearLayoutManager.VERTICAL, false)
                lm.isSmoothScrollbarEnabled = true
                layoutManager = lm
                setHasFixedSize(true)
                isVerticalScrollBarEnabled = true
                adapter
            }.lparams(0, 0)

            applyConstraintSet {
                list {
                    connect(
                            ConstraintSetBuilder.Side.LEFT to ConstraintSetBuilder.Side.LEFT of ConstraintSet.PARENT_ID,
                            ConstraintSetBuilder.Side.TOP to ConstraintSetBuilder.Side.TOP of ConstraintSet.PARENT_ID,
                            ConstraintSetBuilder.Side.RIGHT to ConstraintSetBuilder.Side.RIGHT of ConstraintSet.PARENT_ID,
                            ConstraintSetBuilder.Side.BOTTOM to ConstraintSetBuilder.Side.BOTTOM of ConstraintSet.PARENT_ID
                    )
                }
            }
        }
    }
}
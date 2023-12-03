package com.bit.lake.gdx

import com.bit.lake.gdx.types.Vec2
import java.awt.Toolkit

sealed class Position {
    data object Centered : Position()
    data class Custom(val position: Vec2) : Position()
}

data class Configuration(
    val size: Vec2,
    val title: String,
    private val position: Position = Position.Centered,
    val foregroundFPS: Int = 60,
    private val screenSize: Vec2 = Vec2.ZERO,
) {
    val positionAsVec2: Vec2
        get() = when (position) {
            is Position.Centered -> {
                val screenSize = screenSize()
                screenSize / 2f - size / 2f
            }

            is Position.Custom -> position.position
        }

    private fun screenSize(): Vec2 =
        if (screenSize != Vec2.ZERO) screenSize
        else {
            with(Toolkit.getDefaultToolkit().screenSize) {
                Vec2(width.toFloat(), height.toFloat())
            }
        }
}

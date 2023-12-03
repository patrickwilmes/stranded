package com.bit.lake.gdx.graphics

import com.badlogic.gdx.graphics.OrthographicCamera
import com.badlogic.gdx.math.Matrix4

object Camera {
    private lateinit var camera: OrthographicCamera

    fun initialize(yDown: Boolean, viewportWidth: Float, viewportHeight: Float) {
        camera = OrthographicCamera().apply {
            setToOrtho(yDown, viewportWidth, viewportHeight)
        }
    }

    fun update() {
        camera.update()
    }

    fun combined(): Matrix4 {
        return camera.combined
    }
}

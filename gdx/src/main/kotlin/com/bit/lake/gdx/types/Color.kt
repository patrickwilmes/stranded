package com.bit.lake.gdx.types

data class Color(val r: Float, val g: Float, val b: Float, val a: Float = 1f) {
    companion object {
        val BLACK = Color(0f, 0f, 0f)
    }
}

internal fun Color.toLibgdxColor(): com.badlogic.gdx.graphics.Color =
    com.badlogic.gdx.graphics.Color(r, g, b, a)


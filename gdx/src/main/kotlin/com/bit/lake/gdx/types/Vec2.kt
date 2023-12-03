package com.bit.lake.gdx.types

data class Vec2(
    val x: Float,
    val y: Float,
) {
    operator fun div(scalar: Float): Vec2 =
        if (scalar == 0f) {
            throw IllegalArgumentException("Cannot divide by 0")
        } else {
            Vec2(x / scalar, y / scalar)
        }

    operator fun minus(other: Vec2): Vec2 =
        Vec2(x - other.x, y - other.y)

    companion object {
        val ZERO = Vec2(0f, 0f)
    }
}

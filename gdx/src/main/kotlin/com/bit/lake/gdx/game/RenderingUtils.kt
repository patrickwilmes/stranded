package com.bit.lake.gdx.game

import com.badlogic.gdx.utils.ScreenUtils
import com.bit.lake.gdx.types.Color
import com.bit.lake.gdx.types.toLibgdxColor

fun clearScreen(clearColor: Color = Color.BLACK) {
    ScreenUtils.clear(clearColor.toLibgdxColor())
}

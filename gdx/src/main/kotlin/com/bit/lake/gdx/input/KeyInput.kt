package com.bit.lake.gdx.input

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.Input

enum class Key(val keyCode: Int) {
    UP(Input.Keys.UP),
    DOWN(Input.Keys.DOWN),
    LEFT(Input.Keys.LEFT),
    RIGHT(Input.Keys.RIGHT),
    SPACE(Input.Keys.SPACE),
    ESCAPE(Input.Keys.ESCAPE),
    ENTER(Input.Keys.ENTER),
    UNKNOWN(Input.Keys.UNKNOWN),
}

fun Key.ifKeyPressed(func: () -> Unit) {
    if (Gdx.input.isKeyPressed(this.keyCode)) {
        func()
    }
}

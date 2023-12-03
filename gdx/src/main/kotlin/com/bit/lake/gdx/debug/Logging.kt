package com.bit.lake.gdx.debug

import com.badlogic.gdx.Gdx

fun info(clazz: Class<*>, message: String) {
    Gdx.app.log(clazz.simpleName, message)
}

fun error(clazz: Class<*>, message: String) {
    Gdx.app.error(clazz.simpleName, message)
}

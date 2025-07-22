package io.github.kevinah95

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform
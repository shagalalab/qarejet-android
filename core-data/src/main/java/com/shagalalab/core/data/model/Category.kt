package com.shagalalab.core.data.model

data class Category(
    val id: Long,
    val title: String,
    val icon: String,
    val color: String,
    val type: Int
) {
    override fun toString() = title
}

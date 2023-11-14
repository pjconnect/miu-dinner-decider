package com.pjone.assignment5.quizapp

import com.pjone.dinnerdecider.R

data class ElItems(var id: Int, val img: Int, val name: String, val description: String, val price: Float)

fun ItemRepository(): List<ElItems> {
    val items = listOf(
        ElItems(1, R.drawable.desktop, "Monitor", "Apple Pro Display XDR", 4999.0f),
        ElItems(2, R.drawable.ipad, "iPad", "iPad Air (4th generation)", 599.0f),
        ElItems(3, R.drawable.keyboard, "Magic Keyboard", "Magic Keyboard for iPad Pro 12.9-inch", 349.0f),
        ElItems(4, R.drawable.mouse, "Magic Mouse", "Magic Mouse 2", 79.0f),
        ElItems(5, R.drawable.iphone, "iPhone", "iPhone 13 Pro Max", 1099.0f),
        ElItems(6, R.drawable.laptop, "MacBook", "MacBook Air (M2, 2022)", 999.0f),
        ElItems(7, R.drawable.watch, "Apple Watch", "Apple Watch Series 7", 399.0f),
        ElItems(8, R.drawable.airpods, "AirPods", "AirPods Pro", 249.0f),
        ElItems(9, R.drawable.apple_tv, "Apple TV", "Apple TV 4K", 179.0f),
        ElItems(10, R.drawable.homepod, "HomePod", "HomePod mini", 99.0f),
    )

    return items
}
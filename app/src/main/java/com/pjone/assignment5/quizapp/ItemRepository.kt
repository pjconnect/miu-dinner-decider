package com.pjone.assignment5.quizapp

import com.pjone.dinnerdecider.R

data class ElItems(var id: Int, val img: Int, val name: String, val description: String, val price: Float)

fun ItemRepository(): List<ElItems> {
    var items = listOf(
        ElItems(1, R.drawable.desktop, "Monitor", "Apple Monitor 4K 24-inc", 400.0f),
        ElItems(2, R.drawable.ipad, "Ipad", "Apple Monitor 4K 24-inc", 400.0f),
        ElItems(3, R.drawable.keyboard, "Magic Keyboard", "Apple Monitor 4K 24-inc", 400.0f),
        ElItems(4, R.drawable.mouse, "Magic Mouse", "Apple Monitor 4K 24-inc", 400.0f),
        ElItems(5, R.drawable.iphone, "IPhone", "Apple Monitor 4K 24-inc", 400.0f),
        ElItems(6, R.drawable.laptop, "Apple Mac", "Apple Monitor 4K 24-inc", 400.0f,),
    )

    return items
}
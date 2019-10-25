package com.example.tiki.models

class Tiki(
    var category: MutableList<Category>,
    var service: MutableList<Service>
) {
    companion object {
        fun mock() = Tiki(
            Category.mocks(),
            Service.mocks()
        )
    }
}

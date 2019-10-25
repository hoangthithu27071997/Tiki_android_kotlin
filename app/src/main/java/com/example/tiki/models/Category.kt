package com.example.tiki.models

class Category(var category: String){

    companion object{
        fun mocks():MutableList<Category>{
            return mutableListOf(
                Category("Mẹ và bé"),
                Category("Sức khỏe"),
                Category("Điện da dụng"),
                Category("Dịch vụ"),
                Category("Thời trang"),
                Category("Hàng quốc tế"),
                Category("Bách hóa Online"))
        }
    }
}
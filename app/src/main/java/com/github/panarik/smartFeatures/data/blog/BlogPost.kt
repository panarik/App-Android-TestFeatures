package com.github.panarik.smartFeatures.data.blog

data class BlogPost(
        //создаём поля
        val title: String,
        val body: String,
        val image: String, //изображения будут в виде ссылок
        val username: String) {


}
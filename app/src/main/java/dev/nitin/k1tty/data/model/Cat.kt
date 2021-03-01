package dev.nitin.k1tty.data.model

data class Cat(
    val id: Int,
    val name: String,
    val age: Double,
    val gender: String,
    val friendly: Boolean,
    val clean: String,
    val verified : Boolean,
    val location: String,
    val image: Int,
    val summary: String,
)
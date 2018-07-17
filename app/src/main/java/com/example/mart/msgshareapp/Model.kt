package com.example.mart.msgshareapp

data class Hobby(var title: String)

object Supplier {
    val hobbies = listOf<Hobby>(
            Hobby("Basketball"),
            Hobby("Programming"),
            Hobby("Baseball"),
            Hobby("Football"),
            Hobby("Swimming"),
            Hobby("Diving"),
            Hobby("Running"),
            Hobby("Farming"),
            Hobby("Gaming"),
            Hobby("Walking"),
            Hobby("Reading"),
            Hobby("Sleeping"),
            Hobby("Riding")
    )
}
package com.example.movieapp.models

import java.io.Serializable

data class User(var name: String, var actor: String, var date: String, var info: String) :
    Serializable
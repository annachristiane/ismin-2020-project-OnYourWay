package com.ismin.projectapp

import java.io.Serializable

data class Line(
        val status: String,
        val transportmode: String,
        val name_line: String,
        val shortname_groupoflines: String,
        val networkname: String,
        val operatorname: String,
        val accessibility: String
): Serializable

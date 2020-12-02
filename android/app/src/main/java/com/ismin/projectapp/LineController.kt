package com.ismin.projectapp

import java.io.Serializable

class LineController: Serializable {
    private val storage = HashMap<String, Line>()

    fun getAllLines():List<Line>{
        return ArrayList(this.storage.values).sortedBy { line -> line.name_line }
    }

//    fun getLine(name_line: String): Line?{
//        return this.storage[name_line]
//    }

//    fun getTotalNumberOfLines():Int{
//        return this.storage.size
//    }
}

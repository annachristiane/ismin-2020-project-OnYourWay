package com.ismin.projectapp

import java.io.Serializable

class LineController: Serializable {
    private val storage = HashMap<String, Line>()

    fun getLine(name_line: String): Line?{
        return this.storage[name_line]
    }

    fun getAllLines():List<Line>{
        return ArrayList(this.storage.values).sortedBy { line -> line.name_line }
    }

    fun getFavoriteLines(bool: Boolean):List<Line>{
        val filtered = this.storage.filter{ it.value.favorite == bool }
        return ArrayList(filtered.values).sortedBy { line -> line.name_line }
    }

    fun getTotalNumberOfLines():Int{
        return this.storage.size
    }
}
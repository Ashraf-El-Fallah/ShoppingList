package com.af.shoppinglist.data.db.entites

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "shopping_items")
data class ShoppingItem(

    @ColumnInfo(name = "item_amount")
    var itemAmount: Int,
    @ColumnInfo(name = "item_name")
    var itemName: String

) {
    @PrimaryKey(autoGenerate = true)
    var taskId: Int? = null
}
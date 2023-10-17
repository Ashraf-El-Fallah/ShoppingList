package com.af.shoppinglist.data.repositories

import com.af.shoppinglist.data.db.ShoppingDao
import com.af.shoppinglist.data.db.ShoppingDataBase
import com.af.shoppinglist.data.db.entites.ShoppingItem
import org.kodein.di.KodeinProperty

class ShoppingRepository(
    private val db:ShoppingDataBase
) {
    suspend fun upsert(item: ShoppingItem) = db.getShoppingDao().upsert(item)

    suspend fun delete(item: ShoppingItem) = db.getShoppingDao().delete(item)

    fun getAllShoppingItems() = db.getShoppingDao().getAllShoppingItems()
}
package com.af.shoppinglist.ui.shoppinglist

import com.af.shoppinglist.data.db.entites.ShoppingItem

interface AddDialogListener {
    fun onAddButtonClicked(item: ShoppingItem)
}
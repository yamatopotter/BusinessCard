package com.br.matheus.businesscard

import android.app.Application
import com.br.matheus.businesscard.data.AppDatabase
import com.br.matheus.businesscard.data.BusinessCardRepository

class App:Application() {
    val database by lazy { AppDatabase.getDatabase(this) }
    val respository by lazy { BusinessCardRepository(database.businessDao()) }


}
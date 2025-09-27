package com.r2b.mynotes

import android.app.Application
import com.r2b.mynotes.db.Graph

class NoteApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        Graph.provide(this)
    }

}
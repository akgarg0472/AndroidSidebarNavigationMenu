package com.akgarg.sidebarnavigation.activities

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.res.ResourcesCompat
import com.akgarg.sidebarnavigation.R

class ContactActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contact)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "Contact"
        supportActionBar?.setBackgroundDrawable(
            ResourcesCompat.getDrawable(
                resources,
                R.color.teal_700,
                theme
            )
        )

        window.navigationBarColor = resources.getColor(R.color.teal_700, theme)
        window.statusBarColor = resources.getColor(R.color.teal_700, theme)
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            finish()
            return true
        }

        return super.onOptionsItemSelected(item)
    }

}
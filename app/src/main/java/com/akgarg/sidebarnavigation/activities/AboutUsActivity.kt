package com.akgarg.sidebarnavigation.activities

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.res.ResourcesCompat
import com.akgarg.sidebarnavigation.R

class AboutUsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about_us)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "About"
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
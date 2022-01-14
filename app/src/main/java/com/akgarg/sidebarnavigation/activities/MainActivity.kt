package com.akgarg.sidebarnavigation.activities

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.akgarg.sidebarnavigation.R
import com.akgarg.sidebarnavigation.fragments.HomeFragment
import com.akgarg.sidebarnavigation.fragments.PasswordFragment
import com.akgarg.sidebarnavigation.fragments.ProfileFragment
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    private lateinit var drawerLayout: DrawerLayout
    private lateinit var toolbar: Toolbar
    private lateinit var toggle: ActionBarDrawerToggle
    private lateinit var navigationView: NavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        drawerLayout = findViewById(R.id.navigation_drawer)
        toolbar = findViewById(R.id.toolbar)
        navigationView = findViewById(R.id.navigation_view)

        // changes the color of status bar and bottom navigation bar
        window.statusBarColor = resources.getColor(R.color.teal_700, theme)
        // window.navigationBarColor = resources.getColor(R.color.teal_200, theme)

        // hamburger menu toggle icon
        toggle = ActionBarDrawerToggle(
            this,
            drawerLayout,
            toolbar,
            R.string.nav_draw_open,
            R.string.nav_draw_close
        )

        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()
        navigationView.setNavigationItemSelectedListener(this)

        // set Home Fragment as default fragment
        supportFragmentManager.beginTransaction().replace(R.id.fragment_container, HomeFragment())
            .commit()
    }


    // handles the back button press, if nav bar is opened then only close it
    // otherwise close the activity
    override fun onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }


    // handles the click of navigation menu item
    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.menu_home -> {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.fragment_container, HomeFragment()).commit()
            }

            R.id.menu_profile -> {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.fragment_container, ProfileFragment()).commit()
            }

            R.id.menu_password -> {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.fragment_container, PasswordFragment()).commit()
            }

            R.id.menu_logout -> {
                val builder = AlertDialog.Builder(this)
                builder.setTitle("Confirm?")
                builder.setMessage("Are you sure want to logout?")
                builder.setPositiveButton("Yes") { _, _ ->
                    finish()
                }
                builder.setNegativeButton("No") { dialog, _ ->
                    dialog.dismiss()
                }

                val alertDialog = builder.create()
                alertDialog.window?.setBackgroundDrawableResource(R.color.teal_700)
                alertDialog.setOnShowListener {
                    alertDialog.getButton(AlertDialog.BUTTON_POSITIVE)
                        .setTextColor(resources.getColor(R.color.white, theme))
                    alertDialog.getButton(AlertDialog.BUTTON_NEGATIVE)
                        .setTextColor(resources.getColor(R.color.white, theme))
                }
                alertDialog.show()
            }

            R.id.menu_contact -> {
                val contactActivityIntent = Intent(this, ContactActivity::class.java)
                startActivity(contactActivityIntent)
            }

            R.id.menu_about -> {
                val aboutActivityIntent = Intent(this, AboutUsActivity::class.java)
                startActivity(aboutActivityIntent)
            }
        }

        drawerLayout.closeDrawer(GravityCompat.START)
        return true
    }

}
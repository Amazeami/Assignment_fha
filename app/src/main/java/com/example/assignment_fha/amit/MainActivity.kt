package com.example.assignment_fha.amit

import android.content.Context
import android.os.Bundle
import android.view.Gravity
import android.view.MenuItem
import android.view.View
import android.widget.ImageButton
import android.widget.PopupMenu
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.onNavDestinationSelected
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.myapplication.R
import com.google.android.material.bottomappbar.BottomAppBar


class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var image1: ImageButton
    private lateinit var image2: ImageButton
    private lateinit var image3: ImageButton
    private lateinit var image4: ImageButton
    private lateinit var image5:ImageButton
    private lateinit var popupMenu:PopupMenu
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()
        setListners()
    }

    private fun initView() {

        val navView: BottomAppBar = findViewById(R.id.bar)

        navController = findNavController(R.id.nav_host_fragment)

        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications
            )
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView!!.setupWithNavController(navController)

        navView!!.setOnMenuItemClickListener {  menuItem ->
            menuItem.onNavDestinationSelected(navController)
        }


        image1 = findViewById(R.id.element_1)
        image2 = findViewById(R.id.element_2)
        image3 = findViewById(R.id.element_3)
        image4 = findViewById(R.id.element_4)
        image5=  findViewById(R.id.imagebutton_3)

        getSupportActionBar()!!.run {
            setDisplayHomeAsUpEnabled(true)
            setHomeAsUpIndicator(R.drawable.ic_keyboard_arrow_left_black_24dp)
        }
    }

    private fun setListners() {

        image1.setOnClickListener(this)
        image2.setOnClickListener(this)
        image3.setOnClickListener(this)
        image4.setOnClickListener(this)
        image5.setOnClickListener(this)
    }

    override fun onClick(view: View?) {

        deslectOtherView()

        when (view!!.id) {

            R.id.element_1 -> {
                view.setBackgroundResource(R.drawable.rounded_image_selected)
                toast(getString(R.string.title_info))
            }
            R.id.element_2 -> {
                view.setBackgroundResource(R.drawable.rounded_image_selected)
                toast(getString(R.string.title_you))
            }
            R.id.element_3 -> {
                view.setBackgroundResource(R.drawable.rounded_image_selected)
                toast(getString(R.string.title_risk))
            }
            R.id.element_4 -> {
                view.setBackgroundResource(R.drawable.rounded_image_selected)
                toast(getString(R.string.title_family))
            }

            R.id.imagebutton_3 -> {
              showPopUp(view)
            }


        }
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> finish()
        }
        return true
    }

    private fun deslectOtherView() {
        image1.setBackgroundResource(R.drawable.rounded_image)
        image2.setBackgroundResource(R.drawable.rounded_image)
        image3.setBackgroundResource(R.drawable.rounded_image)
        image4.setBackgroundResource(R.drawable.rounded_image)
    }

    fun Context.toast(message: CharSequence) {
        val toast = Toast.makeText(this, message, Toast.LENGTH_SHORT)
        toast.setGravity(Gravity.BOTTOM, 0, 325)
        toast.show()
    }

    fun showPopUp(view: View) {
        popupMenu = PopupMenu(this, view)
        val inflater = popupMenu.menuInflater
        inflater.inflate(R.menu.bottom_nav_menu, popupMenu.menu)
        popupMenu.show()

        popupMenu.setOnMenuItemClickListener {  menuItem ->
            menuItem.onNavDestinationSelected(navController)
        }
    }


}

package com.example.hondanaoyuki.ourmenu

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main, menu)
        return true
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item?.itemId) {
            R.id.soba1 -> {
                menuImage.setImageResource(R.drawable.bukkakesoba)
                menuText.text = getString(R.string.soba1_text)
                return true
            }
            R.id.soba2 -> {
                menuImage.setImageResource(R.drawable.oroshisoba)
                menuText.text = getString(R.string.soba2_text)
                return true
            }
            R.id.ramen1 -> {
                menuImage.setImageResource(R.drawable.ramen)
                menuText.text = getString(R.string.ramen1_text)
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }
}
package com.example.hondanaoyuki.ourmenu

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ContextMenu
import android.view.Menu
import android.view.MenuItem
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        registerForContextMenu(menuImage)
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

    override fun onCreateContextMenu(menu: ContextMenu?, v: View?, menuInfo: ContextMenu.ContextMenuInfo?) {
        super.onCreateContextMenu(menu, v, menuInfo)
        if (menuText.text.isNotEmpty()) {
            menuInflater.inflate(R.menu.context, menu)
        }
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {
        when (item?.itemId) {
            R.id.mail -> {
                val subject = getString(R.string.app_name)
                val text = "${menuText.text}が食べたい"
                val uri = Uri.fromParts("mailto", "test@gmail", null)
                val intent = Intent(Intent.ACTION_SENDTO, uri)
                intent.putExtra(Intent.EXTRA_SUBJECT, subject)
                intent.putExtra(Intent.EXTRA_TEXT, text)
                if (intent.resolveActivity(packageManager) != null) {
                    startActivity(intent)
                }
                return true
            }
            R.id.sms -> {
                val text = "${menuText.text}が食べたい"
                val uri = Uri.fromParts("smsto", "99900001111", null)
                val intent = Intent(Intent.ACTION_SENDTO, uri)
                intent.putExtra("smsbody", uri)
                if (intent.resolveActivity(packageManager) != null) {
                    startActivity(intent)
                }
                return true
            }
        }
        return super.onContextItemSelected(item)
    }

}
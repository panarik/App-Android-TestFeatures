package com.github.panarik.smartFeatures.activity.mainMenu

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.github.panarik.smartFeatures.R
import com.github.panarik.smartFeatures.activity.SignInActivity
import com.github.panarik.smartFeatures.activity.mainMenu.model.MenuHolder.getRecyclerViewItems
import com.github.panarik.smartFeatures.activity.mainMenu.model.MenuHolder.menu
import com.github.panarik.smartFeatures.activity.mainMenu.model.RecyclerViewAdapter
import com.github.panarik.smartFeatures.activity.mainMenu.model.RecyclerViewAdapter.RecyclerItemListener
import com.google.firebase.auth.FirebaseAuth

class MainActivity : AppCompatActivity(), RecyclerItemListener {
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: RecyclerView.Adapter<*>
    private lateinit var layoutManager: RecyclerView.LayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.setHasFixedSize(true)
        adapter = RecyclerViewAdapter(getRecyclerViewItems(), this)
        layoutManager = LinearLayoutManager(this)
        recyclerView.setAdapter(adapter)
        recyclerView.setLayoutManager(layoutManager)
    }

    override fun recycler_onItemClick(position: Int) {
        Log.d("onItemClick", "onNoteClick: clicked")
        startActivity(Intent(this, menu[position].activity.javaClass))
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.main_sign_out -> {
                FirebaseAuth.getInstance().signOut()
                startActivity(Intent(this, SignInActivity::class.java))
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}
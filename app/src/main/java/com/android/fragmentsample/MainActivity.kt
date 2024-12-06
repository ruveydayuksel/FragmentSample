package com.android.fragmentsample

import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment

class MainActivity : AppCompatActivity() {

    private var isFragmentAVisible = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        loadFragment(FragmentA())

        val switchButton = findViewById<Button>(R.id.switchButton)
        switchButton.setOnClickListener {
            if (isFragmentAVisible) {
                loadFragment(FragmentB())
            } else {
                loadFragment(FragmentA())
            }
            isFragmentAVisible = !isFragmentAVisible
        }
    }

    private fun loadFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainer, fragment)
            .apply {
                if (!isFragmentAVisible) addToBackStack(null)
            }
            .commit()
    }
}
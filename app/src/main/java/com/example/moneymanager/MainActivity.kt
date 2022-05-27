package com.example.moneymanager

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentController
import androidx.fragment.app.FragmentManager
import com.example.moneymanager.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        replaceFragment(Spending())

        binding.bottomNavigationView.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.Spending -> {
                    replaceFragment(Spending())
                    true
                }
                R.id.Income -> {
                    replaceFragment(Income())
                    true
                }
                R.id.Budget -> {
                    replaceFragment(Budget())
                    true
                }
                R.id.MoneyFlow -> {
                    replaceFragment(MoneyFlow())
                    true
                }
                else -> false
            }
        }
    }

    private fun replaceFragment(fragment: Fragment) {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(binding.frameLayout.id,fragment)
        fragmentTransaction.commit()
    }
}
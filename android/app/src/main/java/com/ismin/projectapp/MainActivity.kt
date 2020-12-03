package com.ismin.projectapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.fragment.app.FragmentTransaction
import androidx.viewpager.widget.ViewPager
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.fragment_info.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.Serializable

class MainActivity : AppCompatActivity(), LineListFragment.OnFragmentInteractionListener,
InfoFragment.OnFragmentInteractionListener{
    private val linecontroller = LineController()
    private lateinit var lineService: LineService

    private var lineListFragment: LineListFragment = LineListFragment()
    private var infoFragment: InfoFragment = InfoFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        actionBar?.setDisplayHomeAsUpEnabled(true)
        val tabLayout: TabLayout = findViewById(R.id.a_main_tab_layout)
        tabLayout.tabGravity = TabLayout.GRAVITY_FILL

        val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("https://lignes-ack.cleverapps.io/")
                .build()

        lineService = retrofit.create(LineService::class.java)
        lineService.getAllLines().enqueue(object : Callback<ArrayList<Line>> {
            override fun onResponse(
                call: Call<ArrayList<Line>>,
                response: Response<ArrayList<Line>>
            ){displayList()}
            override fun onFailure(call: Call<ArrayList<Line>>, t: Throwable) {
                displayErrorToast(t)
            }
        })

        val viewPager: ViewPager = findViewById(R.id.a_main_view_pager)
        val adapter = PagerAdapter(supportFragmentManager,tabLayout.tabCount)

        adapter.addFragment(lineListFragment, "Liste")
        adapter.addFragment(infoFragment, "Infos")
        viewPager.adapter = adapter
        tabLayout.setupWithViewPager(viewPager)
        viewPager.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(tabLayout))

        tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                viewPager.currentItem = tab.position
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {
            }
        })
    }

    private fun displayErrorToast(t: Throwable) {
        Toast.makeText(
                applicationContext,
                "Network error ${t.localizedMessage}",
                Toast.LENGTH_LONG
        ).show()
    }

    private fun displayList() {
        val lineListFragment = LineListFragment.newInstance(linecontroller.getAllLines())

        supportFragmentManager.beginTransaction()
                .replace(R.id.a_main_root_layout, lineListFragment)
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                .commit()
    }

    fun closeInfoFragment(){
        displayList()
        f_info_button.visibility = View.GONE
    }

    private fun displayInfo(){
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        val infoFragment = InfoFragment()
        fragmentTransaction.replace(R.id.a_main_root_layout, infoFragment)
        fragmentTransaction.commit()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onItemClicked(line: Line){
        val lineIntent = Intent(this, LineActivity::class.java)
        lineIntent.putExtra("line_infos", line as Serializable)
        this.startActivity(lineIntent)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_information -> {
                displayInfo()
                true
            }
            R.id.action_refresh -> {
                Toast.makeText(baseContext, "Data refreshed !", Toast.LENGTH_SHORT).show()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

}

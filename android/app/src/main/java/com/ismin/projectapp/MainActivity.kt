package com.ismin.projectapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.fragment.app.FragmentTransaction
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_info.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity(), LineCreator {
    private val linecontroller = LineController()
    private lateinit var lineService: LineService

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("https://lignes-ack.cleverapps.io/")
                .build()

        lineService = retrofit.create(LineService::class.java)

        lineService.getAllLines().enqueue(object : Callback<ArrayList<Line>> {
            override fun onResponse(
                    call: Call<ArrayList<Line>>,
                    response: Response<ArrayList<Line>>
            ) {
                val allLines = response.body()
                allLines?.forEach {
                    linecontroller.addLine(it)
                }
                displayList()
            }

            override fun onFailure(call: Call<ArrayList<Line>>, t: Throwable) {
                displayErrorToast(t)
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
                .replace(R.id.a_main_lyt_container, lineListFragment)
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                .commit()
    }

    fun closeInfoFragment(view: View){
        displayList()

        a_main_btn_creation.visibility = View.VISIBLE
        f_info_button.visibility = View.GONE
    }

    fun goToCreation(view: View) {
        val createLineFragment = CreateLineFragment()

        supportFragmentManager.beginTransaction()
                .add(R.id.a_main_lyt_container, createLineFragment)
                .addToBackStack("createLineFragment")
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                .commit()

        a_main_btn_creation.visibility = View.GONE
    }

    fun displayInfo(){
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        val infoFragment = InfoFragment()

        fragmentTransaction.replace(R.id.a_main_lyt_container, infoFragment)
        fragmentTransaction.commit()

        a_main_btn_creation.visibility = View.GONE
    }

    override fun onLineCreated(line: Line) {
        lineService.createLines(line).enqueue{
            onResponse = {
                linecontroller.addLine(it.body()!!)
                closeCreateFragment()
            }
            onFailure = {
                if (it!=null)
                    displayErrorToast(it)
            }
        }
    }


    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return super.onCreateOptionsMenu(menu)
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

    override fun closeCreateFragment() {
        displayList();
        a_main_btn_creation.visibility = View.VISIBLE
    }
}

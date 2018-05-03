package com.example.user.kotvolleyapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonArrayRequest
import com.android.volley.toolbox.Volley
import kotlinx.android.synthetic.main.activity_jar.*

class JARAct : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_jar)

        val url = "http://www.sdkas.com/get_categories.php"
        val list = ArrayList<String>()

        val rq = Volley.newRequestQueue(this)
        val jar = JsonArrayRequest(Request.Method.GET, url, null
                , Response.Listener { response ->
            (0 until response.length()).mapTo(list) { response.getJSONObject(it).getString("name") }

            val adp = ArrayAdapter(this, android.R.layout.simple_list_item_1, list)
            lv.adapter = adp
        }, Response.ErrorListener {
        })

        rq.add(jar)
    }
}

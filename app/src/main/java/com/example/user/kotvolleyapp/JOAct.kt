package com.example.user.kotvolleyapp

import android.app.ProgressDialog
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.RequestFuture
import com.android.volley.toolbox.Volley
import kotlinx.android.synthetic.main.activity_jo.*

class JOAct : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_jo)

        button2.setOnClickListener {

            var url = "http://pioneersacademyproject.com/find_item.php?id=3"

            var pd = ProgressDialog(this)
            pd.setMessage("Please Wait...")
            pd.setProgressStyle(ProgressDialog.STYLE_SPINNER)
            pd.show()

            var rq = Volley.newRequestQueue(this)
            var jor = JsonObjectRequest(Request.Method.GET, url, null,
                    Response.Listener { response ->
                        pd.hide()
                        textView2.text = response.getString("name")
                        textView3.text = response.getString("price")
                    }, Response.ErrorListener { error ->
                pd.hide()
                textView2.text = error.message
            })

            rq.add(jor)

        }
    }
}

package com.example.user.kotvolleyapp

import android.app.ProgressDialog
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener {

            var url = "http://sdkas.com/greeting.php"

            var pd = ProgressDialog(this)
            pd.setMessage("Please Wait...")
            pd.setProgressStyle(ProgressDialog.STYLE_SPINNER)
            pd.show()

            var rq = Volley.newRequestQueue(this)
            var sr = StringRequest(Request.Method.GET, url,
                    Response.Listener { response ->
                        pd.hide()
                        textView.text = response
                    }, Response.ErrorListener { error ->
                pd.hide()
                textView.text = error.message
            })

            rq.add(sr)
        }
    }
}

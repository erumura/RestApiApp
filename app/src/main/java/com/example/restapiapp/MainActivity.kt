package com.example.restapiapp

import android.R
import android.app.ProgressDialog
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivity : AppCompatActivity() {
    lateinit var RecyclerView: RecyclerView
    val items: MutableLiveData<List<Post>> = MutableLiveData()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_item)


        items
    }


    private val mutableLiveData:

            Unit
        private get() {
            // display a progress dialog
            val progressDialog = ProgressDialog(this@MainActivity)



            progressDialog.setCancelable(false)
            progressDialog.setMessage("Please Wait")
            progressDialog.show()
            RestApi.postStudent().enqueue(object : Callback<List<Post>> {
                override fun onResponse(
                    call: Call<List<Post>>,
                    response: Response<List<Post>>
                ) {

                }

                override fun onFailure(call: Call<List<Post>>, t: Throwable) {

                    Toast.makeText(this@MainActivity, t.toString(), Toast.LENGTH_LONG).show()
                    progressDialog.dismiss()
                }
            })
        }

    private fun setDataInRecyclerView() {

        val linearLayoutManager = LinearLayoutManager(this@MainActivity)

        RecyclerView!!.layoutManager = linearLayoutManager

        val usersAdapter = UsersAdapter(
            this@MainActivity, error(Any())
        )
        RecyclerView!!.adapter = usersAdapter
    }
}
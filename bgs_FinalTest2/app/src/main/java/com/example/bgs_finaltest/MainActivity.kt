package com.example.bgs_finaltest

import android.content.Context
import android.graphics.Movie
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.appcompat.app.AlertDialog

class MainActivity : AppCompatActivity() {
    lateinit var lv : ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_two)
        title = "기말고사"

        var gall = findViewById<Gallery>(R.id.gallery1) as Gallery
        var gAdapter = MyGridAdapter(this)
        gall.adapter = gAdapter

        var movie = arrayOf("겟아웃","라라랜드","아저씨","기생충","위플래시")

        var list = findViewById<View>(R.id.lv1) as ListView

        var adapter : ArrayAdapter<String> = ArrayAdapter(this,android.R.layout.simple_list_item_1,movie)
        list.adapter = adapter

        list.setOnItemClickListener { parent, view, position, id ->
            Toast.makeText(applicationContext,movie[position],Toast.LENGTH_SHORT).show() // 토스트 사용
        }

        lv = findViewById<ListView>(R.id.lv1)
    }
    inner class MyGridAdapter(var context: Context) : BaseAdapter(){
        var posterID = arrayOf(
            R.drawable.getout,R.drawable.lalaland,R.drawable.mister,R.drawable.parasite,R.drawable.whiplash)

        override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
        var iv = ImageView(context)
            iv.layoutParams = ViewGroup.LayoutParams(200,300)
            iv.scaleType = ImageView.ScaleType.FIT_CENTER
            iv.setPadding(5,5,5,5)
            iv.setImageResource(posterID[p0])
            iv.setOnClickListener{
                var dialogView = View.inflate(this@MainActivity, R.layout.dialog,null)
                var dlg = AlertDialog.Builder(this@MainActivity)
                var ivPoster = dialogView.findViewById<ImageView>(R.id.ivPoster)
                ivPoster.setImageResource(posterID[p0])
                dlg.setTitle("큰 포스터")
                dlg.setIcon(R.drawable.ic_launcher_background)
                dlg.setView(dialogView)
                dlg.setNegativeButton("닫기",null)
                dlg.show()
            }
            return iv
        }
        override fun getItem(p0: Int): Any {
            return 0
        }
        override fun getItemId(p0: Int): Long {
            return 0
        }
        override fun getCount(): Int {
            return posterID.size
        }
    }
}
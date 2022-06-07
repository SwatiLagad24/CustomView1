package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.CompoundButton
import androidx.core.view.marginLeft

class MainActivity : AppCompatActivity() {
    private lateinit var taskView: TaskView
    private lateinit var chkStatus:CheckBox

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        taskView=findViewById(R.id.taskView)
        chkStatus=findViewById(R.id.chkStatus)
        chkStatus.setOnCheckedChangeListener(
            object :CompoundButton.OnCheckedChangeListener
            {
                override fun onCheckedChanged(buttonView: CompoundButton?, isChecked: Boolean) {
         taskView.isExitable=isChecked
           /*        if(isChecked)
                   {
                       taskView.isExitable=true
                   }
                    else
                   {
                       taskView.isExitable=false
                   }*/
                }
            }
        )

       /* taskView=TaskView(this)

        taskView.layoutParams= ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT)
        taskView.text="Exit App"
        setContentView(taskView)*/
         }
}
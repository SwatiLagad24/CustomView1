package com.example.myapplication

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.content.Context
import android.content.DialogInterface
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.util.Log
import android.view.View
import android.widget.Button

@SuppressLint("AppCompatCustomView")
class TaskView(
    context: Context,
    attributeSet: AttributeSet?
) : Button(context, attributeSet) {
    var isExitable=false

    init {//we are in Button class so no need to write Button.setOnCliclListener
        setOnClickListener(
            object: View.OnClickListener{//createing object of Button
                override fun onClick(v: View?) {
                if(!isExitable)
                {
                    return
                }
                    var builder=AlertDialog.Builder(context)
                builder.setTitle("Custom Views")
                builder.setMessage("Are you sure? You want to exit app..")
                builder.setPositiveButton(
                    "Yes",object :DialogInterface.OnClickListener{
                        override fun onClick(dialog: DialogInterface?, which: Int) {
                            System.exit(0)
                        }
                    }
                )

                builder.setNegativeButton(

                    "No",object :DialogInterface.OnClickListener{
                        override fun onClick(dialog: DialogInterface?, which: Int) {
                           // dialog!!.dismiss()// !! it means it will not be null
                            dialog?.dismiss()//? means if dialogue ref is not null then only then execute dismiss

                        }
                    }
                )

                builder.create().show()//creating object of builder

                //          System.exit(0)//same as java
                }
            }
        )

    }
    constructor(context: Context):this(context,null)

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        var paint=Paint()
        paint.color=Color.RED
        paint.strokeWidth=10F
        canvas!!.drawLine(50F,0F,50F,height.toFloat(),paint)
        canvas!!.drawLine(80F,0F,80F,height.toFloat(),paint)

    }
}
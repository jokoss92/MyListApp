package id.ac.mercubuana.joko_ss.mylistapp

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.Button
import android.widget.ImageView

class SplashActivity : Activity(), View.OnClickListener {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
//        //adding handler delay
//        Handler().postDelayed(Runnable {
//            gotoMainActivity()
//        }, 2000)
        //onclick button
        val buttonLanjut: Button = findViewById(R.id.buttonLanjut)
        val imageSplash : ImageView = findViewById(R.id.imageSplash)

        //click listener with conventional callback
//        buttonLanjut.setOnClickListener(object : View.OnClickListener{
//            override fun onClick(v: View?) {
//                gotoMainActivity()
//            }
//        })
        //click listener with kotlin lambda
//        buttonLanjut.setOnClickListener {
//            gotoMainActivity()
//        }

        //click listener with THIS CLASS as listener by implementing View.OnClickListener
        buttonLanjut.setOnClickListener(this)
        imageSplash.setOnClickListener(this)

    }

    /**
     * callback of set on click listener from View.OnClickListener implementation on this class
     */
    override fun onClick(view: View?) {
        if (view !=null ){
            when(view.id){
                R.id.buttonLanjut -> gotoMainActivity()
                R.id.imageSplash -> gotoMainActivity()
            }
        }
    }

    fun gotoMainActivity() {
        var intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }


    /**
     * this method is intended to receive signal from xml onclick attributes
     */
    fun gotoMainActivity(view : View){
        gotoMainActivity()
    }
}

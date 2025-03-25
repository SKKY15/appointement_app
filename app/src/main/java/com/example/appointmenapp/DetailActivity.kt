package com.example.appointmenapp

import android.annotation.SuppressLint
import android.app.ActivityOptions
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.marginRight
import com.example.appointmenapp.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {
    lateinit var binding : ActivityDetailBinding
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if(intent.extras != null) {
            val name = intent.getStringExtra("name")
            val img = intent.getIntExtra("image", 0)
            val bio = intent.getStringExtra("bio")
            val rating = intent.getStringExtra("rating")
            val street = intent.getStringExtra("street")
            val speciality = intent.getStringExtra("speciality")
            val startWork = intent.getStringExtra("startWork")
            val endWork = intent.getStringExtra("endWork")
            val dayWork = intent.getStringExtra("dayWork")
            val monthWork = intent.getStringExtra("monthWork")
            val dayonnumberWork = intent.getStringExtra("dayonnumberWork")
            val patiens = intent.getStringExtra("patiens")
            val phone = intent.getStringExtra("phone")
            val timezone = intent.getStringExtra("timezone")
            val exp = intent.getStringExtra("exp")

            binding.dcimg.setImageResource(img)
            binding.fulltimedata.text = "$dayWork $dayonnumberWork $monthWork"
            binding.fulltime.text = "$startWork - $endWork $timezone"
            binding.bio.text = "$bio"
            binding.patiens.text = "$patiens"
            binding.exps.text = "$exp"
            binding.rating.text = "$rating"
            binding.street.text = "$street"
            binding.namedct.text = "$name"
            val params = binding.arrrr.layoutParams as ViewGroup.MarginLayoutParams
            params.rightMargin = (24 * resources.displayMetrics.density).toInt()
            binding.arrrr.layoutParams = params

            binding.call.setOnClickListener {
                val i = Intent(Intent.ACTION_DIAL)
                i.data = Uri.parse("tel:$phone")
                startActivity(i)
            }
            binding.sms.setOnClickListener {
                val i = Intent(Intent.ACTION_VIEW)
                i.data = Uri.parse("smsto:$phone")
                i.putExtra("sms_body","Hey $name, I'm Sick i need help, reply for me!")
                startActivity(i)
            }
            binding.share.setOnClickListener {
                val i = Intent(Intent.ACTION_SEND)
                i.type = "text/plain"
                i.putExtra(Intent.EXTRA_TEXT, "Doctor $name , phone number $phone , is on $street")
                startActivity(Intent.createChooser(i,"Share via"))
            }
            binding.direction.setOnClickListener {
                val gmmIntentUri = Uri.parse("google.navigation:q=Santiago+Bernabéu+Stadium, Madrid")
                val i = Intent(Intent.ACTION_VIEW, gmmIntentUri)
                i.setPackage("com.google.android.apps.maps")
                startActivity(i)
            }

            binding.website.setOnClickListener {
                val url = "https://instagram.com/skky_dev"
                val i = Intent(Intent.ACTION_VIEW, Uri.parse(url))
                startActivity(i)
            }
        }





        binding.call.setOnClickListener {
            val i = Intent(Intent.ACTION_DIAL)
            i.data = Uri.parse("tel:00123456789")
            startActivity(i)
        }
        binding.sms.setOnClickListener {
            val i = Intent(Intent.ACTION_VIEW)
            i.data = Uri.parse("smsto:00123456789")
            i.putExtra("sms_body","Hey Dr.Sara Anderson, I'm Sick i need help, reply for me!")
            startActivity(i)
        }
        binding.share.setOnClickListener {
            val i = Intent(Intent.ACTION_SEND)
            i.type = "text/plain"
            i.putExtra(Intent.EXTRA_TEXT, "Doctor Dr.Sara Anderson , phone number 00123456789 , is on 8502 Preston Rd, Inglewood, Maine 98380")
            startActivity(Intent.createChooser(i,"Share via"))
        }
        binding.direction.setOnClickListener {
            val gmmIntentUri = Uri.parse("google.navigation:q=Santiago+Bernabéu+Stadium, Madrid")
            val i = Intent(Intent.ACTION_VIEW, gmmIntentUri)
            i.setPackage("com.google.android.apps.maps")
            startActivity(i)
        }

        binding.website.setOnClickListener {
            val url = "https://instagram.com/skky_dev"
            val i = Intent(Intent.ACTION_VIEW, Uri.parse(url))
            startActivity(i)
        }






        binding.return1.setOnClickListener {
            startActivity(Intent(this@DetailActivity, HomeActivity::class.java), ActivityOptions.makeCustomAnimation(this, android.R.anim.slide_in_left,android.R.anim.fade_out).toBundle())
            finish()
        }
    }
}
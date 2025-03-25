xpackage com.example.appointmenapp

import android.app.ActivityOptions
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.ViewTreeObserver
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.appointmenapp.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {
    lateinit var binding : ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.dctr.setOnClickListener {
            val i = Intent(this@HomeActivity, DetailActivity::class.java)
            val options = ActivityOptions.makeCustomAnimation(this, android.R.anim.fade_in,android.R.anim.fade_out)
            startActivity(i,options.toBundle())
        }
        binding.exploreIcon.setOnClickListener {
            Toast.makeText(this, "Explore Clicked!", Toast.LENGTH_SHORT).show()
        }


        val doctors = ArrayList<Doctor>()

        doctors.add(Doctor("Dr. Jessica Wyne","A board-certified with over 3 years of experience,  specializing in heart conditions such as coronary artery  disease and arrhythmias. Known for patient-centered care  and a commitment to the latest medical advancements","Radiology Specialist","00123456789",R.drawable.dr_jessica_wyne,"500+","4,1","3 Years +","05:00","07:00","PM","Sun","29","Jun","$40/hr","8502 Preston Rd, Inglewood, Maine 98380"))
        doctors.add(Doctor("Dr. David Johnson","A board-certified with over 15 years of experience,  specializing in heart conditions such as coronary artery  disease and arrhythmias. Known for patient-centered care  and a commitment to the latest medical advancements","Neurology Specialist","00123456789",R.drawable.dr_david_johnson,"500+","4,2","6 Years +","05:00","07:00","PM","Sun","27","Jun","$22/hr","8502 Preston Rd, Inglewood, Maine 98380"))
        doctors.add(Doctor("Dr. Michael Roberts","A board-certified with over 25 years of experience,  specializing in heart conditions such as coronary artery  disease and arrhythmias. Known for patient-centered care  and a commitment to the latest medical advancements","Orthopedics Specialist","00123456789",R.drawable.dr_michael_roberts,"1200+","4,2","20 Years +","05:00","07:00","PM","Sun","29","Jun","$24/hr","8502 Preston Rd, Inglewood, Maine 98380"))
        doctors.add(Doctor("Dr. Sarah Thompson","A board-certified with over 15 years of experience,  specializing in heart conditions such as coronary artery  disease and arrhythmias. Known for patient-centered care  and a commitment to the latest medical advancements","Cardiology Specialist","00123456789",R.drawable.dr_sarah_thompson,"500+","4,5","4 Years +","05:00","07:00","PM","Sun","27","Jun","$20/hr","8502 Preston Rd, Inglewood, Maine 98380"))
        doctors.add(Doctor("Dr. Richard Lee","A board-certified with over 20 years of experience,  specializing in heart conditions such as coronary artery  disease and arrhythmias. Known for patient-centered care  and a commitment to the latest medical advancements","Dentistry Specialist","00123456789",R.drawable.dr_richard_lee,"500+","4,5","20 Years +","05:00","07:00","PM","Sun","27","Jun","$43/hr","8502 Preston Rd, Inglewood, Maine 98380"))

        val adapter = DoctorAdapter(this, doctors)

        binding.recycle.adapter = adapter
        val manager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        binding.recycle.layoutManager = manager
        adapter.onItemClick = {
            val i = Intent(this@HomeActivity, DetailActivity::class.java)
            i.putExtra("name", it.name)
            i.putExtra("image",it.imagedctr)
            i.putExtra("bio", it.bio)
            i.putExtra("rating", it.rating)
            i.putExtra("street", it.street)
            i.putExtra("speciality", it.speciality)
            i.putExtra("startWork", it.startWork)
            i.putExtra("endWork", it.endWork)
            i.putExtra("dayWork", it.daywork)
            i.putExtra("dayonnumberWork", it.dayonnumberwork)
            i.putExtra("monthWork", it.monthwork)
            i.putExtra("patiens",it.patiens)
            i.putExtra("phone", it.phone)
            i.putExtra("timezone", it.timezone)
            i.putExtra("exp" , it.experience)
            val options = ActivityOptions.makeCustomAnimation(this, android.R.anim.fade_in,android.R.anim.fade_out)
            startActivity(i, options.toBundle())
        }
    }
}
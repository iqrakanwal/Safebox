package com.example.safebox.fragment

import android.content.Context
import android.os.Bundle
import android.os.CountDownTimer
import android.view.*
import android.view.View.OnClickListener
import android.widget.*
import androidx.core.content.res.ResourcesCompat
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.test.core.app.ApplicationProvider
import com.example.safebox.MainViewModel
import com.example.safebox.R
import ir.samanjafari.easycountdowntimer.EasyCountDownTextview
import kotlinx.android.synthetic.main.fragment_second_screen.*
import org.koin.androidx.viewmodel.ext.android.sharedViewModel
import java.util.*
import java.util.concurrent.TimeUnit


class SecondScreenFragment : Fragment(), OnClickListener {
    private val mainViewModel: MainViewModel by sharedViewModel()
/*    private var timeCountInMilliSeconds = (1 * 60000).toLong()

    private var timerStatus = TimerStatus.STOPPED

    private var progressBarCircle: ProgressBar? = null
    private var editTextMinute: EditText? = null
    private var textViewTime: TextView? = null
    private var imageViewReset: ImageView? = null
    private var imageViewStartStop: ImageView? = null*/
    private var easyCountDownTextview: EasyCountDownTextview? = null
/*
    private var countDownTimer: CountDownTimer? = null
*/
    private enum class TimerStatus {
        STARTED, STOPPED
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_second_screen, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        name_of_safe.text = mainViewModel.name
        status.text = mainViewModel.status
        // method call to initialize the views
       // initViews();
/*        progressBarCircle = view.findViewById(R.id.progressBarCircle) as ProgressBar
        editTextMinute = view.findViewById(R.id.editTextMinute) as EditText
        textViewTime = view.findViewById(R.id.textViewTime) as TextView
        imageViewReset = view.findViewById(R.id.imageViewReset) as ImageView
        imageViewStartStop = view.findViewById(R.id.imageViewStartStop) as ImageView*/


        easyCountDownTextview = view.findViewById<EasyCountDownTextview>(R.id.easyCountDownTextview)
        val calendar = Calendar.getInstance()
        calendar.add(Calendar.DAY_OF_MONTH, 12)
        easyCountDownTextview?.startTimer(calendar)
        // method call to initialize the listeners
   //     initListeners();


    }

    private fun initViews() {

    }

    /**
     * method to initialize the click listeners
     */
/*    private fun initListeners() {
        imageViewReset!!.setOnClickListener(this)
        imageViewStartStop!!.setOnClickListener(this)
    }*/

    /**
     * implemented method to listen clicks
     *
     * @param view
     */
    override fun onClick(view: View) {
        when (view.id) {
           // R.id.imageViewReset -> reset()
           // R.id.imageViewStartStop -> startStop()
        }
    }

    /**
     * method to reset count down timer
     */
    private fun reset() {
       // stopCountDownTimer()
        //startCountDownTimer()
    }


/*
    */
/**
     * method to start and stop count down timer
     *//*

    private fun startStop() {
        if (timerStatus === TimerStatus.STOPPED) {

            // call to initialize the timer values
            setTimerValues()
            // call to initialize the progress bar values
            setProgressBarValues()
            // showing the reset icon
            imageViewReset!!.visibility = View.VISIBLE
            // changing play icon to stop icon
            imageViewStartStop!!.setImageResource(R.drawable.location)
            // making edit text not editable
            editTextMinute!!.isEnabled = false
            // changing the timer status to started
            timerStatus = TimerStatus.STARTED
            // call to start the count down timer
            startCountDownTimer()
        } else {

            // hiding the reset icon
            imageViewReset!!.visibility = View.GONE
            // changing stop icon to start icon
            imageViewStartStop!!.setImageResource(R.drawable.location)
            // making edit text editable
            editTextMinute!!.isEnabled = true
            // changing the timer status to stopped
            timerStatus = TimerStatus.STOPPED
            stopCountDownTimer()
        }
    }

    */
/**
     * method to initialize the values for count down timer
     *//*

    private fun setTimerValues() {
        var time = 0
        if (!editTextMinute!!.text.toString().isEmpty()) {
            // fetching value from edit text and type cast to integer
            time = editTextMinute!!.text.toString().trim { it <= ' ' }.toInt()
        } else {
            // toast message to fill edit text
            Toast.makeText(
                ApplicationProvider.getApplicationContext<Context>(),
                getString(R.string.message_minutes),
                Toast.LENGTH_LONG
            ).show()
        }
        // assigning values after converting to milliseconds


        if((time%24)==0){
            timeCountInMilliSeconds = (time * 60 * 1000).toLong()


        }

    }

    */
/**
     * method to start count down timer
     *//*

    private fun startCountDownTimer() {
        countDownTimer = object : CountDownTimer(timeCountInMilliSeconds, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                textViewTime!!.text = hmsTimeFormatter(millisUntilFinished)
                progressBarCircle!!.progress = (millisUntilFinished / 1000).toInt()
            }

            override fun onFinish() {
                textViewTime!!.text = hmsTimeFormatter(timeCountInMilliSeconds)
                // call to initialize the progress bar values
                setProgressBarValues()
                // hiding the reset icon
                imageViewReset!!.visibility = View.GONE
                // changing stop icon to start icon
                imageViewStartStop!!.setImageResource(R.drawable.location)
                // making edit text editable
                editTextMinute!!.isEnabled = true
                // changing the timer status to stopped
                timerStatus = TimerStatus.STOPPED
            }
        }.start()
        countDownTimer?.start()
    }

    */
/**
     * method to stop count down timer
     *//*

    private fun stopCountDownTimer() {
        countDownTimer!!.cancel()
    }

    */
/**
     * method to set circular progress bar values
     *//*

    private fun setProgressBarValues() {
        progressBarCircle!!.max = timeCountInMilliSeconds.toInt() / 1000
        progressBarCircle!!.progress = timeCountInMilliSeconds.toInt() / 1000
    }
*/


    /**
     * method to convert millisecond to time format
     *
     * @param milliSeconds
     * @return HH:mm:ss time formatted string
     */
    private fun hmsTimeFormatter(milliSeconds: Long): String? {
        return java.lang.String.format(
            "%02d:%02d:%02d",
            TimeUnit.MILLISECONDS.toHours(milliSeconds),
            TimeUnit.MILLISECONDS.toMinutes(milliSeconds) - TimeUnit.HOURS.toMinutes(
                TimeUnit.MILLISECONDS.toHours(
                    milliSeconds
                )
            ),
            TimeUnit.MILLISECONDS.toSeconds(milliSeconds) - TimeUnit.MINUTES.toSeconds(
                TimeUnit.MILLISECONDS.toMinutes(
                    milliSeconds
                )
            )
        )
    }



    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.main_menu_again, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.mainscree1 -> {
                findNavController().navigate(R.id.action_secondScreenFragment_to_mainscreen)
                true
            }
            R.id.signout -> {
                true
            }   R.id.connect -> {
                findNavController().navigate(R.id.action_secondScreenFragment_to_connectScreenFragment)

                true
            }   R.id.managelist -> {
                findNavController().navigate(R.id.action_secondScreenFragment_to_listFragment)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

}
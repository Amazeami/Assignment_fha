package com.example.assignment_fha.amit.ui.home

import android.app.DatePickerDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.example.myapplication.R
import java.util.*

class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        homeViewModel =
            ViewModelProviders.of(this).get(HomeViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_home, container, false)
        val edittext: EditText = root.findViewById(R.id.et2)
        val textView: Button = root.findViewById(R.id.button)

        textView.setOnClickListener{
            Toast.makeText(context,"Data has been saved",Toast.LENGTH_SHORT).show()
        }
        edittext.setOnClickListener {
            val c= Calendar.getInstance()
            val year= c.get(Calendar.YEAR)
            val month = c.get(Calendar.MONTH)
            val day = c.get(Calendar.DAY_OF_MONTH)
            var dpd = DatePickerDialog(context!!,
                DatePickerDialog.OnDateSetListener { view, mYear, mMonth, mDay ->
                val mmMonth = mMonth+1
                val date = "$mDay/$mmMonth/$mYear"
                    edittext.setText(date)
            },year,month,day)
            dpd.show()
        }
        return root
    }
}
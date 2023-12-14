package edu.iu.mbarrant.bonusproject

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController

class EditReminderFragment : Fragment() {

    private lateinit var backButton : ImageButton

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        val view = inflater.inflate(R.layout.edit_reminder, container, false)
        backButton = view.findViewById(R.id.backButton)

        back()
        return view
    }

    // Other methods and logic for the fragment
    // ...

    private fun back(){
        backButton.setOnClickListener{
            navigateToReminderFragment()
        }
    }


    private fun navigateToReminderFragment() {
        val navController = findNavController()
        navController.navigate(R.id.backToList)
    }

}
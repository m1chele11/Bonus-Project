package edu.iu.mbarrant.bonusproject

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.PopupMenu
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController

class MainFragment : Fragment(){

    private lateinit var menuButton : ImageButton

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.reminderslist, container, false)
        menuButton = view.findViewById(R.id.MenuButton)
        setupMenu()
        return view
    }

    private fun setupMenu() {
        menuButton.setOnClickListener {
            val popupMenu = PopupMenu(requireContext(), menuButton)
            popupMenu.inflate(R.menu.popup_menu)

            popupMenu.setOnMenuItemClickListener { menuItem ->
                when (menuItem.itemId) {
                    R.id.menu_feedback -> {
                        openFeedbackEmail()
                        true
                    }
                    R.id.menu_about -> {
                        openWebPage()
                        true
                    }
                    R.id.menu_new_reminder -> {
                        navigateToReminderFragment()
                        true
                    }
                    else -> false
                }
            }

            popupMenu.show()
        }
    }

    private fun openFeedbackEmail() {
        val intent = Intent(Intent.ACTION_SENDTO)
        intent.data = Uri.parse("michelebarrantes@gmail.com")
        intent.putExtra(Intent.EXTRA_SUBJECT, "Feedback")
        if (intent.resolveActivity(requireActivity().packageManager) != null) {
            startActivity(intent)
        }
    }

    private fun openWebPage() {
        val url = "https://luddy.indiana.edu/"
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
        if (intent.resolveActivity(requireActivity().packageManager) != null) {
            startActivity(intent)
        }
    }


    private fun navigateToReminderFragment() {
        val navController = findNavController()
        navController.navigate(R.id.action_current_to_reminder)
    }


}
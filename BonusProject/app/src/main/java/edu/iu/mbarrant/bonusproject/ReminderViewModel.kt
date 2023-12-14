package edu.iu.mbarrant.bonusproject

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ReminderViewModel : ViewModel() {


    var remindId:String = ""


    //reminders
    var reminder = MutableLiveData<Reminder>()
    private val _reminders: MutableLiveData<MutableList<Reminder>> = MutableLiveData()
    val reminders: LiveData<List<Reminder>>
        get() = _reminders as LiveData<List<Reminder>>

    //navigation for reminders
    private val _navigateToReminder = MutableLiveData<String?>()
    val navigateToReminder: LiveData<String?>
        get() = _navigateToReminder
    //error
    private val _errorHappened = MutableLiveData<String?>()
    val errorHappened: LiveData<String?>
        get() = _errorHappened



    //initialize
    init {
        if (remindId.trim() == "")
            reminder.value = Reminder()
        _reminders.value = mutableListOf<Reminder>()
    }

}
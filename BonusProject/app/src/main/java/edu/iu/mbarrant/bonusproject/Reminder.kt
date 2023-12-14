package edu.iu.mbarrant.bonusproject



data class Reminder(
    //@get:Exclude
    var taskId: String = "",
    var taskName: String = "",
    var taskDescription: String = "",
    var time: String = "",
    var date: String = "",
    var taskDone: Boolean = false
)

package org.lifetrack.ltapp.presenter

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import org.lifetrack.ltapp.model.data.dclass.MenuItemData
import org.lifetrack.ltapp.model.data.dclass.menuListItems
import org.lifetrack.ltapp.model.data.dclass.notificationListItemData

class UserPresenter: ViewModel() {

    var userName by mutableStateOf("Dr. Najma")
        private set
    var userEmail by mutableStateOf( "najma@lifetrack.org")
        private set
    var userInitials = userName.split(" ").map { it.first() }.joinToString("")
        private set
    var notificationItemData by mutableStateOf(notificationListItemData)
        private set
    var notificationToggleState by mutableStateOf(false)
        private set
    val menuItems = mutableStateListOf<MenuItemData>()

    init {
        menuItems.addAll(menuListItems)
    }

    fun onMenuItemAction(navController: NavController, route: String){
        navController.navigate(route) {
            launchSingleTop = true
        }
    }

    fun onUserNotificationsUpdate(){
        notificationToggleState != notificationToggleState
        println("***********************:: $notificationToggleState  ::*************************\n ${notificationItemData.toString()}")
    }
}
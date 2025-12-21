package org.lifetrack.ltapp.presenter

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import org.lifetrack.ltapp.model.data.dclass.MenuItemData
import org.lifetrack.ltapp.model.data.dclass.menuListItems

class SettingsPresenter: ViewModel() {
    var appNotificationToggleState by mutableStateOf(false)
        private set
    var emailNotificationToggleState by mutableStateOf(false)
        private set
    var patientInfoConsentToggleState by mutableStateOf(false)
        private set

    val menuItems = mutableStateListOf<MenuItemData>()

    init {
        menuItems.addAll(menuListItems)
    }

    fun onUserNotificationsUpdate() {
        appNotificationToggleState = !appNotificationToggleState
    }
    fun onEmailNotificationsUpdate() {
        emailNotificationToggleState = !emailNotificationToggleState
    }
    fun onPatientInfoConsentUpdate() {
        patientInfoConsentToggleState = !patientInfoConsentToggleState
    }

}
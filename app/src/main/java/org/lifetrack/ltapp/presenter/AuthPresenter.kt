package org.lifetrack.ltapp.presenter

import androidx.lifecycle.ViewModel
import org.lifetrack.ltapp.model.repository.AuthRepository

class AuthPresenter(
    val authRepository: AuthRepository
): ViewModel() {

    suspend fun getTokenId(): String{
        return  authRepository.getTokenId()
    }

    suspend fun logout() {
        authRepository.logout()
    }


}
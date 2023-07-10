package com.priyanshub.boruteapp.data.repository

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.emptyPreferences
import androidx.datastore.preferences.preferencesDataStore
import com.priyanshub.boruteapp.domain.repository.DataStoreOperations
import com.priyanshub.boruteapp.utils.Constants.PREFERENCE_KEY
import com.priyanshub.boruteapp.utils.Constants.PREFERENCE_NAME
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import java.io.IOException

val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = PREFERENCE_NAME)

class DataStoreOperationsImpl(
    context: Context
): DataStoreOperations {

    private object PreferencesKey{
        val onboardingKey = booleanPreferencesKey(name = PREFERENCE_KEY)
    }

    private val datastore =  context.dataStore
    override suspend fun saveOnboardingState(completed: Boolean) {
        datastore.edit {preferences ->
            preferences[PreferencesKey.onboardingKey] = completed
        }
    }

    override fun readOnboardingState(): Flow<Boolean> {
            return datastore.data
                .catch { exception ->
                    if (exception is IOException){
                        emit(emptyPreferences())
                    }
                    else{
                        throw exception
                    }
                }
                .map {preferences ->
                    val onboardingState = preferences[PreferencesKey.onboardingKey] ?: false
                    onboardingState
                }
    }
}
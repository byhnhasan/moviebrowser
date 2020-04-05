package com.hsnbyhn.moviebrowser.settings

import android.util.Log
import android.widget.RadioGroup
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.hsnbyhn.moviebrowser.R
import java.lang.IllegalArgumentException

/**
 * Created by hasanbayhan on 28.03.2020
 * Copyright © 2020 hasanbayhan. All rights reserved.
 **/

class SettingsViewModel : ViewModel(), RadioGroup.OnCheckedChangeListener, LifecycleObserver {

    val radioButtonChecked = MutableLiveData<Int>()

    //val changeToEnglish = SingleLiveEvent<Any>()
    //val changeToTurkish = LiveEvent<Any>()

    override fun onCheckedChanged(group: RadioGroup?, checkedId: Int) {
        when (checkedId) {
            R.id.language_radiobutton_english_button -> Log.d("English:   ", "selected")//changeToEnglish.call()
            R.id.language_radiobutton_turkish_button -> Log.d("turkce:  ", "secildi")//changeToTurkish.call()
            else -> throw IllegalArgumentException("Invalid Button")
        }
    }

    fun checkLanguage(isLanguageTurkish: Boolean) {
        if (isLanguageTurkish) {
            radioButtonChecked.value = R.id.language_radiobutton_turkish_button
        } else {
            radioButtonChecked.value = R.id.language_radiobutton_english_button
        }
    }
}
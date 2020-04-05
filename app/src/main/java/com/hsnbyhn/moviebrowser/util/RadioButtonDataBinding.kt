

package com.hsnbyhn.moviebrowser.util

import android.widget.RadioGroup
import androidx.databinding.BindingAdapter

/**
 * Created by hasanbayhan on 28.03.2020
 * Copyright © 2020 hasanbayhan. All rights reserved.
 **/

@BindingAdapter("app:checkedButtonAttrChanged")
fun setRadioButtonListener(radioGroup: RadioGroup, listener : RadioGroup.OnCheckedChangeListener) {

        radioGroup.setOnCheckedChangeListener { group, checkedId -> listener.onCheckedChanged(group , checkedId) }

}


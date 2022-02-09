package com.google.codelabs.mdc.kotlin.shrine

import android.os.Bundle
import android.text.Editable
import android.view.KeyEvent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import kotlinx.android.synthetic.main.shr_login_fragment.view.*

/**
 * Fragment representing the login screen for Shrine.
 */
class LoginFragment : Fragment() {

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment

        // Snippet from "Navigate to the next Fragment" section goes here.

        val view = inflater.inflate(R.layout.shr_login_fragment, container, false)
        val password_edit_text = view.findViewById<TextInputEditText>(R.id.tie_password)
        val password_til = view.findViewById<TextInputLayout>(R.id.til_password)
        view.next_button.setOnClickListener{
            if(!isPasswordValid(password_edit_text.editableText)){
                password_til.error = getString(R.string.shr_error_password)
            }else{
                //Clear the error
                password_til.error = null
                //Navigate to next Fragment
                (activity as NavigationHost).navigateTo(ProductGridFragment(),false)
            }
        }

        view.tie_password.setOnKeyListener(object : View.OnKeyListener{
            override fun onKey(p0: View?, p1: Int, p2: KeyEvent?): Boolean {
                if(isPasswordValid(password_edit_text.text)){
                    //Clear the error.
                    password_til.error = null
                }
                return false
            }

        })

        return view
    }

    // "isPasswordValid" from "Navigate to the next Fragment" section method goes here
    private fun isPasswordValid(text: Editable?): Boolean {
        return text != null && text.length >= 8
    }
}



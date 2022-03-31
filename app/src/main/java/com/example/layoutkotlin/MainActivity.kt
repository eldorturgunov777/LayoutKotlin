package com.example.layoutkotlin

import android.graphics.Color
import android.os.Bundle
import android.text.Editable
import android.text.Spannable
import android.text.SpannableString
import android.text.TextWatcher
import android.text.style.ForegroundColorSpan
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import java.util.regex.Matcher
import java.util.regex.Pattern


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //task3
        et_edit.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                tv_edit.text = s
            }

            override fun afterTextChanged(s: Editable?) {
            }

        })
        //task4
        errorEditText.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }

            override fun afterTextChanged(s: Editable?) {
                if (s!!.length > errorErrorLayout.counterMaxLength) {
                    errorErrorLayout.error =
                        "Error: Max length " + errorErrorLayout.counterMaxLength
                } else {
                    errorErrorLayout.error = null
                }
            }
        })
        customErrorEditText.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }

            override fun afterTextChanged(s: Editable?) {
                if (s!!.length > customErrorLayout.counterMaxLength) {
                    customErrorLayout.error =
                        "Error: Max length " + customErrorLayout.counterMaxLength
                } else {
                    customErrorLayout.error = null
                }
            }

        })
        //task5
        val text = "I would #like to do #something similar to the #twitter app"
        val span: Spannable = SpannableString(text)
        val matcher: Matcher = Pattern.compile("#([A-Za-z0-9_-]+)").matcher(text)
        while (matcher.find()) {
            span.setSpan( ForegroundColorSpan(Color.BLUE), matcher.start(), matcher.end(), 0)
        }
       // span.setSpan(ForegroundColorSpan(Color.BLUE), 0, 5, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
        tv_five.text = span
        //task 6
        val webUrl = "I would like to do something similar to the https://twitter.com app, www.google.com"
        val spanUrl: Spannable=SpannableString(webUrl)
        val matcherUrl: Matcher =Pattern.compile("((http?|https|ftp|file)://)?(([Ww]){3}.)?[a-zA-Z0-9]+\\.[a-zA-Z]+").matcher(spanUrl)
        while (matcherUrl.find()){
            spanUrl.setSpan(ForegroundColorSpan(Color.GREEN), matcherUrl.start(), matcherUrl.end(), 0)
        }
        tv_webUrl.text=spanUrl

    }
}
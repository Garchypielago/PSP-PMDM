package com.example.finalproject

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import androidx.fragment.app.Fragment

private const val ARG_PARAM1 = "url"

class WebFragment : Fragment() {
    private var url: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            url = it.getString(ARG_PARAM1)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val myView: View = inflater.inflate(R.layout.fragment_web, container, false)

        val myWebView: WebView = myView.findViewById<WebView>(R.id.webView)
        myWebView.loadUrl(url!!)

        return myView
    }

    companion object {
        @JvmStatic
        fun newInstance(url: String) =
            WebFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, url)
                }
            }
    }
}
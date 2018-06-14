package com.example.npimpalkhar.bmun_guide_android

import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.app.Fragment
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_del_guide.*
import java.io.File


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class DelGuideFragment : android.support.v4.app.Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_del_guide, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        pdf_viewer.setBackgroundColor(Color.LTGRAY);
        pdf_viewer.fromFile(File("BMUNGuideAndroid/assets/Caucus.pdf"))
    }
    companion object {
        const val TAG = "DelGuideFragment"
    }
}

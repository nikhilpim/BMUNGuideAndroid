package com.example.npimpalkhar.bmun_guide_android

import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_del_guide_menu.*


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
class DelGuideMenuFragment : android.support.v4.app.Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_del_guide_menu, container, false)
    }

    override fun onStart() {
        super.onStart()
        research_cardview.setBackgroundResource(R.drawable.abc_cab_background_top_mtrl_alpha)

    }

    companion object {
        const val TAG = "DelGuideMenuFragment"
    }
}

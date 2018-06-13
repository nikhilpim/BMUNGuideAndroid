package com.example.npimpalkhar.bmun_guide_android

import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [ExampleFragment.OnFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [ExampleFragment.newInstance] factory method to
 * create an instance of this fragment.
 *
 */
class ExampleFragment : android.support.v4.app.Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        println("ET")
        return inflater.inflate(R.layout.fragment_example, container, false)
    }

    companion object {
        const val TAG = "ExampleFragment"
    }
}

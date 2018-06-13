package com.example.npimpalkhar.bmun_guide_android

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import android.support.v4.app.FragmentTransaction
import android.support.v4.view.PagerAdapter
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_dguide.*
import android.support.v4.view.ViewPager
import android.view.MenuItem
import kotlinx.android.synthetic.*


/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [DGuideFragment.OnFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [DGuideFragment.newInstance] factory method to
 * create an instance of this fragment.
 *
 */
class DGuideFragment : Fragment() {
    private val example1
        get() = childFragmentManager.findFragmentByTag(ExampleFragment.TAG) as ExampleFragment? ?: ExampleFragment()
    private val example2
        get() = childFragmentManager.findFragmentByTag(DelGuideFragment.TAG) as DelGuideFragment? ?: DelGuideFragment()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_dguide, container, false)

        id
        main_pager.adapter = myPagerAdapter()

        bottom_nav.setOnNavigationItemSelectedListener { item: MenuItem ->
            when (item.itemId) {
                R.id.guide -> main_pager.currentItem = 0
                R.id.about -> main_pager.currentItem = 1
                R.id.cards -> main_pager.currentItem = 2
                R.id.information -> main_pager.currentItem = 3
                R.id.connect -> main_pager.currentItem = 4
            }
            true
        }

        return view
    }

    private inner class myPagerAdapter : PagerAdapter() {
        private var currTransaction: FragmentTransaction? = null
        private var currPrimaryItem : Fragment? = example1

        private fun beginTransaction() : FragmentTransaction {
            return childFragmentManager.beginTransaction()
        }
        override fun startUpdate(container: ViewGroup) {}

        override fun instantiateItem(container: ViewGroup, position: Int): Any {
            val fragment: Fragment = when (position) {
                0 -> example1
                1 -> example1
                2 -> example2
                else -> example2
            }
            val txn: FragmentTransaction = currTransaction ?: beginTransaction()
            if (currTransaction == null) {
                currTransaction = txn
            }
            txn.attach(fragment)

            if (fragment != currPrimaryItem) {
                fragment.setMenuVisibility(false)
                fragment.userVisibleHint = false
            }
            return fragment
        }

        override fun destroyItem(container: ViewGroup, position: Int, item: Any) {
            val txn: FragmentTransaction = currTransaction ?: beginTransaction()
            if (currTransaction == null) {
                currTransaction = txn
            }
            txn.detach(item as Fragment)
        }

        override fun setPrimaryItem(container: ViewGroup, position: Int, item: Any) {
            if (item !== currPrimaryItem) {
                if (currPrimaryItem != null) {
                    currPrimaryItem?.setMenuVisibility(false)
                    currPrimaryItem?.userVisibleHint = false
                }

                if (item is Fragment) {
                    item.setMenuVisibility(true)
                    item.userVisibleHint = true
                    currPrimaryItem = item
                }

                activity?.currentFocus?.clearFocus()
            }

        }

        override fun finishUpdate(container: ViewGroup) {
            currTransaction?.commitAllowingStateLoss()
            currTransaction = null
            childFragmentManager.executePendingTransactions()
        }

        override fun getCount(): Int = 5

        override fun getPageTitle(position: Int): CharSequence =
                when (position) {
                    0 -> resources.getString(R.string.test)
                    1 -> resources.getString(R.string.test2)
                    else -> "Error"
                }

        override fun isViewFromObject(view: View, obj: Any): Boolean = (obj as Fragment).view === view

    }

}

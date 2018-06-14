package com.example.npimpalkhar.bmun_guide_android

import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.app.Fragment
import android.graphics.Color
import android.graphics.pdf.PdfDocument
import android.support.v4.view.ViewPager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.npimpalkhar.bmun_guide_android.R.id.pdf_viewer
import com.github.barteksc.pdfviewer.listener.OnLoadCompleteListener
import com.github.barteksc.pdfviewer.listener.OnPageChangeListener
import com.github.barteksc.pdfviewer.listener.OnPageErrorListener
import com.github.barteksc.pdfviewer.scroll.DefaultScrollHandle
import kotlinx.android.synthetic.main.fragment_del_guide.*
import java.io.File
import android.util.Log
import com.shockwave.pdfium.PdfDocument.Meta
import com.shockwave.pdfium.PdfDocument.Bookmark






// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class DelGuideFragment : android.support.v4.app.Fragment(), OnPageChangeListener, OnLoadCompleteListener, OnPageErrorListener {

    private var pageNumber: Int = 0

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_del_guide, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



    }

    override fun onStart() {
        super.onStart()
//        println("I am started!")
//        pdf_viewer.setBackgroundColor(Color.LTGRAY)
//        var testFile: File = File("/Users/npimpalkhar/Documents/GitHub/BMUNGuideAndroid/app/src/main/assets/Caucus.pdf")
//        pdf_viewer.fromFile(testFile)
//        pdf_viewer.loadPages()

        pdf_viewer.fromAsset("Caucus.pdf")
                .defaultPage(pageNumber)
                .onPageChange(this)
                .enableAnnotationRendering(true)
                .onLoad(this)
                .scrollHandle(DefaultScrollHandle(context))
                .spacing(10) // in dp
                .onPageError(this)
                .load()
    }

    override fun onPageChanged(page: Int, pageCount: Int) {
        pageNumber = page;
    }

    override fun loadComplete(nbPages: Int) {
        val meta = pdf_viewer.getDocumentMeta()
        Log.e(TAG, "title = " + meta.getTitle())
        Log.e(TAG, "author = " + meta.getAuthor())
        Log.e(TAG, "subject = " + meta.getSubject())
        Log.e(TAG, "keywords = " + meta.getKeywords())
        Log.e(TAG, "creator = " + meta.getCreator())
        Log.e(TAG, "producer = " + meta.getProducer())
        Log.e(TAG, "creationDate = " + meta.getCreationDate())
        Log.e(TAG, "modDate = " + meta.getModDate())
    }

    override fun onPageError(page: Int, t: Throwable?) {
        Log.e(TAG, "Cannot load page " + page);
    }

    companion object {
        const val TAG = "DelGuideFragment"
    }
}

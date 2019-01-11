package com.pulsehrm.hanumanchalisaalarm

import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.VideoView


class videoActivity : AppCompatActivity() {

    private  var mediaControler : android.widget.MediaController? = null

    private lateinit var videoview : VideoView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_video)

         videoview = findViewById(R.id.videoView)

        val uri = Uri.parse("android.resource://"+packageName+"/"+R.raw.hanuman_chalisa_final)

        videoview.setVideoURI(uri)

        mediaControler = android.widget.MediaController(this)

        mediaControler?.setAnchorView(videoview)

        videoview.requestFocus()

        videoview.setMediaController(mediaControler)

        videoview.start()
    }
}

package com.unsoed.responsi1mobileh1d023096

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.unsoed.responsi1mobileh1d023096.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initLayout()
        initListener()
    }
    private fun initLayout() {
        binding.layoutSejarah.let {
            it.imgIcon.setImageResource(R.drawable.ic_bola)
            it.tvLayout.setText(R.string.sejarah)
        }

        binding.layoutPelatih.let {
            it.imgIcon.setImageResource(R.drawable.ic_pelatih)
            it.tvLayout.setText(R.string.pelatih)
        }

        binding.layoutTim.let {
            it.imgIcon.setImageResource(R.drawable.ic_tim)
            it.tvLayout.setText(R.string.tim)
        }
    }

    private fun initListener() {
        binding.layoutSejarah.root.setOnClickListener  {
            startActivity(Intent(this, SejarahActivity::class.java))
        }
        binding.layoutPelatih.root.setOnClickListener  {
            startActivity(Intent(this, PelatihActivity::class.java))
        }
        binding.layoutTim.root.setOnClickListener  {
            startActivity(Intent(this, DaftarPemainActivity::class.java))
        }

    }
}
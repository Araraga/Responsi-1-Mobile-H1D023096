package com.unsoed.responsi1mobileh1d023096

import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.unsoed.responsi1mobileh1d023096.data.model.Player
import com.unsoed.responsi1mobileh1d023096.databinding.ActivityDaftarPemainBinding
import com.unsoed.responsi1mobileh1d023096.ui.adapter.OnPemainClickListener
import com.unsoed.responsi1mobileh1d023096.ui.adapter.PemainAdapter
import com.unsoed.responsi1mobileh1d023096.ui.fragment.PemainDetailFragment
import com.unsoed.responsi1mobileh1d023096.viewmodel.MainViewModel

class DaftarPemainActivity : AppCompatActivity(), OnPemainClickListener {

    private lateinit var binding: ActivityDaftarPemainBinding
    private val viewModel: MainViewModel by viewModels()
    private val pemainAdapter = PemainAdapter(emptyList(), this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDaftarPemainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.recyclerViewPemain.layoutManager = LinearLayoutManager(this)
        binding.recyclerViewPemain.adapter = pemainAdapter

        viewModel.squad.observe(this) { players ->
            pemainAdapter.setData(players)
        }

        viewModel.isLoading.observe(this) { isLoading ->
            binding.progressBar.visibility = if (isLoading) View.VISIBLE else View.GONE
        }

        viewModel.fetchTeamDetails()
    }

    override fun onPemainClick(player: Player) {
        PemainDetailFragment(
            name = player.name,
            dateOfBirth = player.dateOfBirth,
            nationality = player.nationality,
            position = player.position ?: "N/A"
        ).show(supportFragmentManager, PemainDetailFragment::class.java.simpleName)
    }
}

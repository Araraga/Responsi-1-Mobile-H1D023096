package com.unsoed.responsi1mobileh1d023096

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.unsoed.responsi1mobileh1d023096.data.model.TeamResponse
import com.unsoed.responsi1mobileh1d023096.databinding.ActivityCoachBinding
import com.unsoed.responsi1mobileh1d023096.viewmodel.MainViewModel


class PelatihActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCoachBinding
    private val viewModel: MainViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCoachBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.imgCoachOrCrest.setImageResource(R.drawable.pelatih)

        viewModel.teamData.observe(this) { team ->
            if (team != null) {
                showCoachDetail(team)
            }
        }
        viewModel.fetchTeamDetails()
    }

    private fun showCoachDetail(team: TeamResponse) {
        val coach = team.coach
        binding.tvCoachName.text = coach.name
        binding.tvDateOfBirth.text = coach.dateOfBirth
        binding.tvNationality.text = coach.nationality
    }
}
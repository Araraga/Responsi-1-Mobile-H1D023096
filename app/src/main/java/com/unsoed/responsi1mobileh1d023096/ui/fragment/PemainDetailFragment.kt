package com.unsoed.responsi1mobileh1d023096.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.unsoed.responsi1mobileh1d023096.R
import com.unsoed.responsi1mobileh1d023096.databinding.FragmentPemainDetailBinding

class PemainDetailFragment(
    private val name: String,
    private val dateOfBirth: String,
    private val nationality: String,
    private val position: String
) : BottomSheetDialogFragment() {

    private var _binding: FragmentPemainDetailBinding? = null
    private val binding get() = _binding!!

    override fun getTheme(): Int = R.style.ThemeOverlay_App_BottomSheetDialog

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPemainDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        loadData()
    }
    private fun loadData() {
        binding.tvPlayerName.text = name
        binding.tvDateOfBirth.text = dateOfBirth
        binding.tvNationality.text = nationality
        binding.tvPosition.text = position
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

package com.unsoed.responsi1mobileh1d023096.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.unsoed.responsi1mobileh1d023096.R
import com.unsoed.responsi1mobileh1d023096.data.model.Player
import com.unsoed.responsi1mobileh1d023096.databinding.ItemPemainBinding

class PemainAdapter(
    private var playerList: List<Player>,
    private val clickListener: OnPemainClickListener
) : RecyclerView.Adapter<PemainAdapter.PemainViewHolder>() {

    inner class PemainViewHolder(val binding: ItemPemainBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(player: Player, listener: OnPemainClickListener) {
            binding.tvPlayerName.text = player.name
            binding.tvPlayerNationality.text = player.nationality

            val colorRes = when (player.position) {
                "Goalkeeper" -> R.color.pos_goalkeeper
                "Defender", "Centre-Back", "Right-Back", "Left-Back", "Defence"-> R.color.pos_defender
                "Midfielder", "Defensive Midfield", "Central Midfield", "Attacking Midfield","Midfield","Left Midfield", "Right Midfield" -> R.color.pos_midfielder
                "Forward", "Centre-Forward", "Second Striker", "Left Winger", "Right Winger", "Offence" -> R.color.pos_forward
                else -> R.color.pos_default
            }
            binding.layoutBackground.setBackgroundColor(
                ContextCompat.getColor(binding.root.context, colorRes)
            )
            binding.root.setOnClickListener {
                listener.onPemainClick(player)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PemainViewHolder {
        val binding = ItemPemainBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return PemainViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PemainViewHolder, position: Int) {
        holder.bind(playerList[position], clickListener)
    }

    override fun getItemCount(): Int = playerList.size

    fun setData(newPlayerList: List<Player>) {
        this.playerList = newPlayerList
        notifyDataSetChanged()
    }
}

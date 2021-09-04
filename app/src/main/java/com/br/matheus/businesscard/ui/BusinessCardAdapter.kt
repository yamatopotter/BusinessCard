package com.br.matheus.businesscard.ui

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.br.matheus.businesscard.data.BusinessCard
import com.br.matheus.businesscard.databinding.ItemBusinessCardBinding


class BusinessCardAdapter:ListAdapter<BusinessCard, BusinessCardAdapter.ViewHolder>(DiffCalbalck()) {

    var listenerShare: (View) -> Unit = {}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemBusinessCardBinding.inflate(inflater, parent, false)

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class ViewHolder(
        private val binding: ItemBusinessCardBinding
    ): RecyclerView.ViewHolder(binding.root){
        fun bind(item:BusinessCard){
            binding.tvNome.text = item.nome
            binding.tvEmail.text = item.email
            binding.tvNomeEmpresa.text = item.empresa
            binding.tvTelefone.text = item.telefone
            binding.mcvContent.setCardBackgroundColor(Color.parseColor(item.background))
            binding.btnShare.setOnClickListener{
                listenerShare(binding.mcvContent)
            }

            binding.btnDelete.setOnClickListener{

            }
        }
    }

}

class DiffCalbalck: DiffUtil.ItemCallback<BusinessCard>(){
    override fun areItemsTheSame(oldItem: BusinessCard, newItem: BusinessCard) = oldItem == newItem
    override fun areContentsTheSame(oldItem: BusinessCard, newItem: BusinessCard) = oldItem.id == newItem.id
}
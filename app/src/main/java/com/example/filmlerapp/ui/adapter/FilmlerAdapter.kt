package com.example.filmlerapp.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.navigation.R
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.filmlerapp.data.entity.Filmler
import com.example.filmlerapp.databinding.CardTasarimBinding
import com.example.filmlerapp.ui.fragment.AnasayfaFragmentDirections
import com.google.android.material.snackbar.Snackbar

class FilmlerAdapter(var mContext:Context,var filmlerListesi:List<Filmler>):RecyclerView.Adapter<FilmlerAdapter.CardTasarimTutucu>() {

    inner class CardTasarimTutucu(var tasarim:CardTasarimBinding):RecyclerView.ViewHolder(tasarim.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardTasarimTutucu {

        val binding:CardTasarimBinding = DataBindingUtil.inflate(LayoutInflater.from(mContext),com.example.filmlerapp.R.layout.card_tasarim, parent,false)
        return CardTasarimTutucu(binding)

    }



    override fun onBindViewHolder(holder: CardTasarimTutucu, position: Int) {

        val film = filmlerListesi.get(position)
        val t = holder.tasarim


        val url = "http://kasimadalan.pe.hu/filmler_yeni/resimler/${film.resim}"
        Glide.with(mContext).load(url).override(500,750).into(t.imageViewFilm)

        t.filmNesnesi = film

        t.cardViewFilm.setOnClickListener {

            val gecis = AnasayfaFragmentDirections.detayGecis(film = film)
            Navigation.findNavController(it).navigate(gecis)

        }

        t.buttonSepet.setOnClickListener {
            Snackbar.make(it,"${film.ad} sepete eklendi", Snackbar.LENGTH_SHORT)
        }

    }

    override fun getItemCount(): Int {

        return filmlerListesi.size

    }


}
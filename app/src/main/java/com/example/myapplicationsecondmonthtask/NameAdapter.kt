package com.example.myapplicationaboutrecyclerview10_18

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

//es aris adapteri klasi romelic akavshirebs informacias viewhodertan
//daatas igebs wyarodan, am proeqtis shemtxvevashi gvaqvs listi mainActivityshi
//da awvdis am datas viewholders, romelic tavsimxriv anaxlebs viewvs

class NameAdapter(private val namesList: MutableList<String>):
    RecyclerView.Adapter<NameAdapter.NameViewHolder>() {

    //es aris klasi romelci titoeul viewvs, romelic recyclershia, shesaxeb informacias inaxavs
    //recycleri  qmnis imden veiwholders ramdenic itemi aqvs + ramdenime cacheshi

    class NameViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView) {


        private val flowerTextView: TextView =
            itemView.findViewById(R.id.flower_text)
        fun bind (S: String) {
            flowerTextView.text = S
        }
    }

    //es metodi gamoidzaxeba roca viewholderi iqmneba
    //shesabamisi viewvs inflateic aq unda moxdes
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NameViewHolder {

        val view = LayoutInflater.from(parent.context).
        inflate(R.layout.name_item,parent,false)

        return NameViewHolder(view)
    }

    //aq gvibrundeba pozicia romelic aqvs konkretul items listshi romelic axla
    //dgas. am pozicias gamoviyenebt rata mivigot am poziciis shesabamisi
    // data da mivawodot is viewHolders rata miabas es data im holderis UI-s

    override fun onBindViewHolder(holder: NameViewHolder, position: Int) {
        holder.bind(namesList[position])
    }

    //radganac recycleri warmoadgens lists, man unda icodes ramdeni nivtia
    // listshi, shesabamisad im datalistis zoma unda daabrunos

    override fun getItemCount(): Int {
        return namesList.size
    }
}
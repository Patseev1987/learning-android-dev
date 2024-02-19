package com.example.rings.recycleview

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.rings.R
import com.example.rings.model.Ring

class RingAdapter:ListAdapter<Ring,RingAdapter.RingHolder>(RingDiffItemCallback()) {

    class RingHolder(rootView: ViewGroup):RecyclerView.ViewHolder(rootView){


        val diameterValueText = rootView.findViewById<TextView>(R.id.ring_diameter_value)
        val innerDiameterValueText = rootView.findViewById<TextView>(R.id.inner_diameter_value)
        val outsideDiameterValueText = rootView.findViewById<TextView>(R.id.outside_diameter_value)
        val typeRingText = rootView.findViewById<TextView>(R.id.type_of_ring)
        val deepText = rootView.findViewById<TextView>(R.id.deep_value)
        val thicknessText = rootView.findViewById<TextView>(R.id.thickness_value)

        fun bind(ring: Ring) {
            diameterValueText.text = ring.diameter.toString()
            innerDiameterValueText.text = ring.innerDiameter.toString()
            outsideDiameterValueText.text = ring.outsideDiameter.toString()
            typeRingText.text = ring.typeRing
            deepText.text = ring.deep.toString()
            thicknessText.text =ring.thickness.toString()
        }

        companion object{
            fun inflateFrom(p0: ViewGroup): RingHolder {
                val layoutInflater = LayoutInflater.from(p0.context)
                val view = layoutInflater.inflate(R.layout.fragment_ring,p0,false) as ViewGroup
                return RingHolder(view)
            }

        }

    }

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): RingHolder = RingHolder.inflateFrom(p0)

    override fun onBindViewHolder(p0: RingHolder, p1: Int) {
        val ring = getItem(p1)

        p0.bind(ring)
    }

}
package com.example.rings.recycleview

import androidx.recyclerview.widget.DiffUtil
import com.example.rings.model.Ring

class RingDiffItemCallback:DiffUtil.ItemCallback<Ring>() {
    override fun areItemsTheSame(p0: Ring, p1: Ring): Boolean =
        (p0.idRing == p1.idRing)


    override fun areContentsTheSame(p0: Ring, p1: Ring): Boolean =
        (p0 == p1)
}
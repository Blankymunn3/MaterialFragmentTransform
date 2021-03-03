package com.blankymunn3.materialfragmenttransform.model

import com.blankymunn3.materialfragmenttransform.R

data class BTSModel(
    var uId: Int,


    var res: Int
)

var btsList = listOf(
    BTSModel(0, R.drawable.bts_1),
    BTSModel(1, R.drawable.bts_2),
    BTSModel(2, R.drawable.bts_3),
    BTSModel(3, R.drawable.bts_4),
    BTSModel(4, R.drawable.bts_5),
    BTSModel(5, R.drawable.bts_6)
)
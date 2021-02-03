package eu.tutorials.bakery.model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import eu.tutorials.bakery.R
import java.text.NumberFormat

class BakeryViewModel : ViewModel() {
    private var _image = MutableLiveData<Int>()
    val image: LiveData<Int> get() = _image

    private var _dessertSold = MutableLiveData<Int>()
    val dessertSold: LiveData<Int> get() = _dessertSold

    private var _total = MutableLiveData<Int>()
    val total: LiveData<String> = Transformations.map(_total) { NumberFormat.getCurrencyInstance().format(it) }

    private var _count = 0
    private var _quantity = 0

    private var dessertMenu = mutableListOf(
        Dessert(image = R.drawable.cupcake, price = 5, quantity = 5),
        Dessert(image = R.drawable.donut, price = 2, quantity = 5),
        Dessert(image = R.drawable.eclair, price = 4, quantity = 5),
        Dessert(image = R.drawable.froyo, price = 5, quantity = 5),
        Dessert(image = R.drawable.gingerbread, price = 5, quantity = 5),
        Dessert(image = R.drawable.honeycomb, price = 5, quantity = 5),
        Dessert(image = R.drawable.icecreamsandwich, price = 5, quantity = 5),
        Dessert(image = R.drawable.jellybean, price = 5, quantity = 5),
        Dessert(image = R.drawable.kitkat, price = 5, quantity = 5),
        Dessert(image = R.drawable.lollipop, price = 5, quantity = 5),
        Dessert(image = R.drawable.marshmallow, price = 5, quantity = 5),
        Dessert(image = R.drawable.nougat, price = 5, quantity = 5),
        Dessert(image = R.drawable.oreo, price = 5, quantity = 5)
    )

    init {
        _image.value = dessertMenu[_count].image
        _dessertSold.value = 0
        _total.value = 0
    }

    fun setDessert() : Boolean {
        if(_count < dessertMenu.size) {
            _image.value = dessertMenu[_count].image
            _dessertSold.value = _dessertSold.value?.inc()
            _total.value = _total.value?.plus(dessertMenu[_count].price)
            _quantity++

            if ((_quantity == dessertMenu[_count].quantity)) {
                _count++
                _quantity = 0
            }
            return true
        }
        return false
    }
}
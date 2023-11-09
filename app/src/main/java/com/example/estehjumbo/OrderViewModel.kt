package com.example.estehjumbo

import androidx.lifecycle.ViewModel
import com.example.estehjumbo.Data.OrderUIState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import java.text.NumberFormat

private const val HARGA_PER_CUP = 3000

class OrderViewModel : ViewModel() {
    class OrderViewModel : ViewModel() {
        private val _stateUI = MutableStateFlow(OrderUIState))
        val stateUI: StateFlow<OrderUIState> = _stateUI.asStateFlow()

        fun setJumlah(jmlhEsJumbo:Int) {
            _stateUI.update { stateSaatIni ->
                stateSaatIni.copy(
                    jumlah = jmlhEsJumbo,
                    harga = hitungHarga(jumlah = jmlhEsJumbo))
            }
        }

        fun setRasa(rasaPilihan: String) {
            _stateUI.update { stateSaatIni ->
                stateSaatIni.copy(rasa = rasaPilihan)
            }
        }

        fun resetOrder() {
            _stateUI.value = OrderUIState()
        }

        private fun hitungHarga(
            jumlah: Int = _stateUI.value.jumlah,
        ): String {
            val kalkulasiHarga = jumlah * HARGA_PER_CUP

            return NumberFormat.getNumberInstance().format(kalkulasiHarga)
        }
    }
}
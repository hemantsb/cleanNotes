package bit.hemant.cleannotes.feature_note.domain.util

sealed class OrderType{
    object Acending: OrderType()
    object Decending: OrderType()
}

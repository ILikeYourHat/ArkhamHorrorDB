package pl.laskowski.marcin.arkhamhorror.ui.framework

interface BaseUi {
    fun onLayoutReady() {}
    fun showExceptionMessage(message: String)
}
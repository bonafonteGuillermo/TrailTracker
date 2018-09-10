package app.demo.example.com.trailtracker.app

import app.demo.example.com.trailtracker.repository.IRepository
/**
 * Created by Guillermo Bonafonte Criado
 */
interface BasePresenter {

    var repository: IRepository

    fun onCreate()
    fun onDestroy()
}
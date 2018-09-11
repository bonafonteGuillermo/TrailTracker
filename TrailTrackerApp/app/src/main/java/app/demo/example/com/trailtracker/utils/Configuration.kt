package app.demo.example.com.trailtracker.utils

import app.demo.example.com.trailtracker.BuildConfig

/**
 *
 * Provides the configuration that depends on the build variant
 *
 */
const val FLAVOR_MOCK: String = "cjMock"
const val FLAVOR_QA: String = "cjQa"
const val FLAVOR_PRODUCTION: String = "cjProduction"

class Configuration {

    enum class Variant {
        MOCK, QA, PRODUCTION;
    }

    val Environment : Variant
        get() {
            when (BuildConfig.FLAVOR) {
                FLAVOR_MOCK -> return Variant.MOCK
                FLAVOR_QA -> return Variant.QA
                else -> return Variant.PRODUCTION
            }
        }

    val BaseUrl : String
        get() {
            return when (BuildConfig.FLAVOR) {
                FLAVOR_MOCK -> "https://www.example.com"
                FLAVOR_QA -> "https://www.example.com"
                else -> "https://www.example.com"
            }
        }

}
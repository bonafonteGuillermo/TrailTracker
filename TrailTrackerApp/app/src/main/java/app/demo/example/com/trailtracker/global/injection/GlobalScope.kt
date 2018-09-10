package app.demo.example.com.trailtracker.global.injection

import java.lang.annotation.Retention
import java.lang.annotation.RetentionPolicy
import javax.inject.Scope

/**
 *
 * Scope for Splash activity
 *
 * Created by Guillermo Bonafonte Criado
 */
@Scope
@Retention(RetentionPolicy.CLASS)
annotation class GlobalScope

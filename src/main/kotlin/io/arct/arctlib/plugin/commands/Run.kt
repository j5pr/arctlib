package io.arct.arctlib.plugin.commands

@Retention(AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.FUNCTION)
@MustBeDocumented
annotation class Run(vararg val target: CommandTarget)
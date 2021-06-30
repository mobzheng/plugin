package com.github.mobzheng.plugin.runner

import com.intellij.debugger.impl.GenericDebuggerRunner
import com.intellij.execution.configurations.*
import com.intellij.execution.runners.ExecutionEnvironment
import com.intellij.execution.ui.RunContentDescriptor
import com.jetbrains.rd.util.string.print

class MainRunner : GenericDebuggerRunner() {
    override fun patch(
        javaParameters: JavaParameters,
        settings: RunnerSettings?,
        runProfile: RunProfile,
        beforeExecution: Boolean
    ) {
        super.patch(javaParameters, settings, runProfile, beforeExecution)
    }

    override fun execute(environment: ExecutionEnvironment) {
        val configuration = environment.runnerAndConfigurationSettings?.configuration
        val getVMParameters = configuration!!::class.java.getDeclaredMethod("getVMParameters")
        val setVMParameters = configuration!!::class.java.getDeclaredMethod("setVMParameters", String::class.java)
        val vmparam = getVMParameters.invoke(configuration).toString()
        setVMParameters.invoke(configuration, vmparam + " " + "-XX:+TraceClassLoading")
        super.execute(environment)
    }

    override fun attachVirtualMachine(
        state: RunProfileState?,
        env: ExecutionEnvironment,
        connection: RemoteConnection?,
        pollConnection: Boolean
    ): RunContentDescriptor? {
        return super.attachVirtualMachine(state, env, connection, pollConnection)
    }


    //    override fun createConfigurationData(settingsProvider: ConfigurationInfoProvider): RunnerSettings? {
//        var configuration = settingsProvider.configuration
//        var getVMParameters = configuration::class.java.getDeclaredMethod("getVMParameters")
//        var setVMParameters = configuration::class.java.getDeclaredMethod("setVMParameters", String::class.java)
//        var vmParameter = getVMParameters.invoke(configuration).toString()
//        setVMParameters.invoke(configuration, vmParameter +" " +"-XX:+TraceClassLoading")
//        return super.createConfigurationData(settingsProvider)
//    }


    //
//    override fun getRunnerId(): String {
//        println("getRunnerId")
//        return super.getRunnerId()
//    }
//
//    override fun canRun(executorId: String, profile: RunProfile): Boolean {
//        println("canRun")
//        return super.canRun(executorId, profile)
//    }
//
//    override fun execute(environment: ExecutionEnvironment) {
//        println("execute")
//        super.execute(environment)
//    }
//
//    override fun patch(
//
//        javaParameters: com.intellij.execution.configurations.JavaParameters,
//        settings: RunnerSettings?,
//        runProfile: RunProfile,
//        beforeExecution: Boolean
//    ) {
//        println("patch")
//        super.patch(javaParameters, settings, runProfile, beforeExecution)
//    }
//
//    override fun doExecute(state: RunProfileState, env: ExecutionEnvironment): RunContentDescriptor {
//        println("doExecute")
//        return super.doExecute(state, env)
//    }
//
//
//    override fun execute(environment: ExecutionEnvironment, callback: ProgramRunner.Callback?) {
//        println("execute")
//        super.execute(environment, callback)
//    }
//
//    override fun createConfigurationData(settingsProvider: ConfigurationInfoProvider): RunnerSettings? {
//        println("createConfigurationData")
//        return super.createConfigurationData(settingsProvider)
//    }
//
//    override fun checkConfiguration(
//        settings: RunnerSettings?,
//        configurationPerRunnerSettings: ConfigurationPerRunnerSettings?
//    ) {
//        println("checkConfiguration")
//        super.checkConfiguration(settings, configurationPerRunnerSettings)
//    }
//
//    override fun onProcessStarted(settings: RunnerSettings?, executionResult: ExecutionResult?) {
//        println("onProcessStarted")
//        super.onProcessStarted(settings, executionResult)
//    }
//
//    override fun getSettingsEditor(
//        executor: Executor?,
//        configuration: RunConfiguration?
//    ): SettingsEditor<RunnerSettings>? {
//        println("getSettingsEditor")
//        return super.getSettingsEditor(executor, configuration)
//    }
}

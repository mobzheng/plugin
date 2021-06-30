package com.github.mobzheng.plugin.listeners

import com.github.mobzheng.plugin.services.MyProjectService
import com.intellij.execution.RunManager
import com.intellij.openapi.components.service
import com.intellij.openapi.project.Project
import com.intellij.openapi.project.ProjectManagerListener
import com.intellij.util.castSafelyTo

internal class MyProjectManagerListener : ProjectManagerListener {

    override fun projectOpened(project: Project) {
        var configuration = RunManager.getInstance(project).selectedConfiguration!!.configuration
        var setVMParameters = configuration::class.java.getDeclaredMethod("setVMParameters", String::class.java)
        var getVMParameters = configuration::class.java.getDeclaredMethod("getVMParameters")
        project.service<MyProjectService>()
    }
}

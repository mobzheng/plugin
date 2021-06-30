package com.github.mobzheng.plugin.listeners

import com.intellij.openapi.wm.ToolWindowManager
import com.intellij.openapi.wm.ex.ToolWindowManagerListener

class ToolListener:ToolWindowManagerListener {

    override fun toolWindowRegistered(id: String) {
        println("id = $id")
    }

    override fun stateChanged(toolWindowManager: ToolWindowManager) {

    }
}

package org.revolutionrobotics.blockly.view.dialogHandlers.instances

import android.webkit.JsPromptResult
import org.json.JSONObject
import org.revolutionrobotics.blockly.view.DialogFactory
import org.revolutionrobotics.blockly.view.dialogHandlers.JsPromptHandler
import org.revolutionrobotics.blockly.view.dialogHandlers.defaultInput
import org.revolutionrobotics.blockly.view.result.DonutResult

class SingleDonutSelectorHandler : JsPromptHandler {

    override fun canHandleRequest(message: String) = message.startsWith("block_set_led")

    override fun handleRequest(request: JSONObject, dialogFactory: DialogFactory, result: JsPromptResult) {
        dialogFactory.showDonutSelector(request.defaultInput(), false,
            DonutResult(result)
        )
    }
}

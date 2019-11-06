package org.revolutionrobotics.robotcontroller.blockly

import android.content.Context
import android.widget.Toast
import org.revolutionrobotics.blockly.android.BlocklyOption
import org.revolutionrobotics.blockly.android.BlocklyVariable
import org.revolutionrobotics.blockly.android.view.DialogFactory
import org.revolutionrobotics.blockly.android.view.result.*

class ToastDialogFactory(private val context: Context) : DialogFactory {

    override fun showAlertDialog(message: String, result: ConfirmResult) {
        showToastMessage("Show alert: $message")
    }

    override fun showConfirmationDialog(message: String, result: ConfirmResult) {
        showToastMessage("Show confirmation dialog: $message")
        result.confirm()
    }

    override fun showDirectionSelectorDialog(defaultValue: String, result: DirectionResult) {
        showToastMessage("Show direction selector! Default: $defaultValue")
        result.confirmForward()
    }

    override fun showSlider(title: String, maxValue: Int, defaultValue: Int, result: SliderResult) {
        showToastMessage("Show slider! Default: $defaultValue Max: $maxValue Title: $title")
        result.confirm(3)
    }

    override fun showDialpad(defaultValue: Double, result: DialpadResult) {
        showToastMessage("Show dial pad! Default: $defaultValue")
        result.confirm(1.0)
    }

    override fun showColorPicker(title: String, colors: List<String>, defaultValue: String, result: ColorResult) {
        showToastMessage("Show color picker! Colors: $colors Default: $defaultValue")
        result.confirm(colors.first())
    }

    override fun showSoundPicker(title: String, defaultValue: String?, result: SoundResult) {
        showToastMessage("Show sound picker! Title: $title defaultValue: $defaultValue")
        result.confirm("siren")
    }

    override fun showBlockOptionsDialog(title: String, comment: String, result: BlockOptionResult) {
        showToastMessage("Show blockly options dialog! Title: $title comment: $comment")
        result.confirmComment("Comment")
    }

    override fun showTextInput(title: String, subtitle: String?, defaultValue: String?, result: TextResult) {
        showToastMessage("Show text input! Title: $title defaultValue $defaultValue")
        result.confirm("Text")
    }

    override fun showMotorSelector(title: String, subtitle: String?, defaultValue: String?, result: TextResult) {
        showToastMessage("Show motor selector")
        result.confirm(defaultValue ?: "")
    }

    override fun showUltrasonicSensorSelector(title: String, subtitle: String?, defaultValue: String?, result: TextResult) {
        showToastMessage("Show ultrasonic selector")
        result.confirm(defaultValue ?: "")
    }

    override fun showBumperSelector(title: String, subtitle: String?, defaultValue: String?, result: TextResult) {
        showToastMessage("Show bumper selector")
        result.confirm(defaultValue ?: "")
    }

    override fun showDonutSelector(defaultValue: String, isMultiSelection: Boolean, result: DonutResult) {
        showToastMessage("Show donut selector! Default: $defaultValue IsMulti: $isMultiSelection")
        result.confirm(1)
    }

    override fun showOptionSelector(
        title: String,
        showLabels: Boolean,
        blocklyOptions: List<BlocklyOption>,
        defaultValue: BlocklyOption?,
        result: OptionResult

    ) {
        showToastMessage("Show option selector! Title: $title options: $blocklyOptions default: $defaultValue")
        result.confirm(blocklyOptions.first().key)
    }

    override fun showVariableOptionsDialog(
        title: String,
        defaultValue: BlocklyVariable?,
        variables: List<BlocklyVariable>,
        result: VariableResult
    ) {
        showToastMessage("Sow variable options! Title: $title Default: $defaultValue Variables: $variables")
        result.confirmChangeVariable(variables.first())
    }

    private fun showToastMessage(message: String) {
        Toast.makeText(context, message, Toast.LENGTH_LONG).show()
    }
}
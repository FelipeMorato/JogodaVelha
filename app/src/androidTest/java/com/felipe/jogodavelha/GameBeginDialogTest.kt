package com.felipe.jogodavelha

import com.felipe.jogodavelha.models.Player
import com.schibsted.spain.barista.assertion.BaristaVisibilityAssertions.assertDisplayed
import com.schibsted.spain.barista.assertion.BaristaVisibilityAssertions.assertNotExist
import com.schibsted.spain.barista.interaction.BaristaDialogInteractions.clickDialogPositiveButton
import com.schibsted.spain.barista.interaction.BaristaEditTextInteractions.writeTo
import org.junit.Rule
import org.junit.Test

@Test
@Throws(Exception::class)
fun display_same_names_message_if_names_same() {
    writeTo(R.id.et_player1, "Felipe")
    writeTo(R.id.et_player2, "Cesar")
    clickDialogPositiveButton()
    assertDisplayed(R.string.game_dialog_same_names)
}

@Test
@Throws(Exception::class)
fun display_empty_name_message_if_one_name_empty() {
    writeTo(R.id.et_player1, "")
    writeTo(R.id.et_player2, "William")
    clickDialogPositiveButton()
    assertDisplayed(R.string.game_dialog_empty_name)
}

@Test
@Throws(Exception::class)
fun close_dialog_after_names_valid() {
    writeTo(R.id.et_player1, "Felipe 1")
    writeTo(R.id.et_player2, "Cesar")
    clickDialogPositiveButton()
    assertNotExist(R.id.player1Layout)
}
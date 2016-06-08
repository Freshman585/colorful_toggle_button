package com.tutao.lib.view;

/**
 * Created by M on 16/6/7.
 */
public class ToggleButtonGroup {

    private ColorfulToggleButton currentSelected;

    public void onSelectChanged(ColorfulToggleButton toggleButton) {
        if (currentSelected != null) {
            currentSelected.setBorderVisible(false);
        }
        currentSelected = toggleButton;
        currentSelected.setBorderVisible(true);
    }

}

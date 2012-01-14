package com.cyanogenmod.IyokanParts;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.preference.ListPreference;
import android.preference.Preference;
import android.preference.PreferenceActivity;

public class IyokanParts extends PreferenceActivity  implements Preference.OnPreferenceChangeListener
{

    private ListPreference keyboardLayout;

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.preferences);
        keyboardLayout = (ListPreference) getPreferenceScreen().findPreference("keyboard_layout");
        keyboardLayout.setOnPreferenceChangeListener(this);
    }

    public boolean onPreferenceChange(Preference preference, Object value) {
        if (preference.equals(keyboardLayout)){
            final String newLanguage = (String) value;
                    
            AlertDialog dialog = new AlertDialog.Builder(this)
            .setTitle(R.string.warning)
            .setMessage(R.string.caution_keyboard_layout)
            .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {

                @Override
                public void onClick(DialogInterface dialog, int which) {
                    setNewKeyboardLanguage(newLanguage);
                }
            })
            .setNegativeButton(android.R.string.no, null)
            .create();

            dialog.show();
        }
        return false;
    }
    
    
    private void setNewKeyboardLanguage(String language){

    }
}
